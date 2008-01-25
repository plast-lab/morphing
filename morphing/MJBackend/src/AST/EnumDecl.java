
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;
public class EnumDecl extends ClassDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        isStatic_computed = false;
        getSuperClassAccessOpt_computed = false;
        getSuperClassAccessOpt_value = null;
        enumConstants_computed = false;
        enumConstants_value = null;
        flags_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        EnumDecl node = (EnumDecl)super.clone();
        node.isStatic_computed = false;
        node.getSuperClassAccessOpt_computed = false;
        node.getSuperClassAccessOpt_value = null;
        node.enumConstants_computed = false;
        node.enumConstants_value = null;
        node.flags_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          EnumDecl node = (EnumDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        EnumDecl res = (EnumDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Enums.jrag at line 39

  
  /*
    12) It is a compile-time error for an enum to declare a finalizer. An instance of
    an enum may never be finalized.
  */
  public void typeCheck() {
    super.typeCheck();
    for(Iterator iter = memberMethods("finalize").iterator(); iter.hasNext(); ) {
      MethodDecl m = (MethodDecl)iter.next();
      if(m.getNumParameter() == 0 && m.hostType() == this)
        error("an enum may not declare a finalizer");
    }
    checkEnum(this);
  }

    // Declared in Enums.jrag at line 74


  private boolean done = false;

    // Declared in Enums.jrag at line 75

  private boolean done() {
    if(done) return true;
    done = true;
    return false;
  }

    // Declared in Enums.jrag at line 255


  /*
    13) In addition, if E is the name of an enum type, then that type has the
    following implicitly declared static methods:
      public static E[] values();
      public static E valueOf(String name);
  */

  private void addValues() {
    int numConstants = enumConstants().size();
    List initValues = new List();
    for(Iterator iter = enumConstants().iterator(); iter.hasNext(); ) {
      EnumConstant c = (EnumConstant)iter.next();
      initValues.add(c.createBoundFieldAccess());
    }
    FieldDeclaration values = new FieldDeclaration(
      new Modifiers(new List().add(
        new Modifier("private")).add(
        new Modifier("static")).add(
        new Modifier("final"))
      ),
      arrayType().createQualifiedAccess(),
      "$VALUES",
      new Opt(
          new ArrayCreationExpr(
            createQualifiedAccess(),
            new List().add(
              new Dims(
                new Opt(
                  new IntegerLiteral(Integer.toString(enumConstants().size()))
                )
              )
            ),
            new Opt(
              new ArrayInit(
                initValues
              )
            )
          )
      )
    );
    addBodyDecl(values);
    // public static final Test[] values() { return (Test[])$VALUES.clone(); }
    addBodyDecl(
      new MethodDecl(
        new Modifiers(new List().add(
          new Modifier("public")).add(
          new Modifier("static")).add(
          new Modifier("final"))
        ),
        arrayType().createQualifiedAccess(),
        "values",
        new List(),
        new List(),
        new List(),
        new Opt(
          new Block(
            new List().add(
              new ReturnStmt(
                new Opt(
                  new CastExpr(
                    arrayType().createQualifiedAccess(),
                    values.createBoundFieldAccess().qualifiesAccess(
                      new MethodAccess(
                        "clone",
                        new List()
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    );
    // public static Test valueOf(String s) { return (Test)java.lang.Enum.valueOf(Test.class, s); }
    addBodyDecl(
      new MethodDecl(
        new Modifiers(new List().add(
          new Modifier("public")).add(
          new Modifier("static"))
        ),
        createQualifiedAccess(),
        "valueOf",
        new List().add(
          new ParameterDeclaration(
            new Modifiers(new List()),
            typeString().createQualifiedAccess(),
            "s"
          )
        ),
        new List(),
        new List(),
        new Opt(
          new Block(
            new List().add(
              new ReturnStmt(
                new Opt(
                  new CastExpr(
                    createQualifiedAccess(),
                    lookupType("java.lang", "Enum").createQualifiedAccess().qualifiesAccess(
                      new MethodAccess(
                        "valueOf",
                        new List().add(
                          createQualifiedAccess().qualifiesAccess(new ClassAccess())
                        ).add(
                          new VarAccess(
                            "s"
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    );
  }

    // Declared in Enums.jrag at line 402

  protected void checkEnum(EnumDecl enumDecl) {
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof ConstructorDecl)
        getBodyDecl(i).checkEnum(enumDecl);
      else if(getBodyDecl(i) instanceof InstanceInitializer)
        getBodyDecl(i).checkEnum(enumDecl);
      else if(getBodyDecl(i) instanceof FieldDeclaration) {
        FieldDeclaration f = (FieldDeclaration)getBodyDecl(i);
        if(!f.isStatic() && f.hasInit())
          f.checkEnum(enumDecl);
      }
    }
  }

    // Declared in Enums.ast at line 3
    // Declared in Enums.ast line 1

    public EnumDecl() {
        super();
        setChild(new Opt(), 0);

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);
        setChild(new Opt(), 3);

    }

    // Declared in Enums.ast at line 15


    // Declared in Enums.ast line 1
    public EnumDecl(Modifiers p0, String p1, List p2, List p3) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(new Opt(), 3);
    }

    // Declared in Enums.ast at line 23


  protected int numChildren() {
    return 3;
  }

    // Declared in Enums.ast at line 26

  public boolean mayHaveRewrite() { return true; }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 1
    public void setModifiers(Modifiers node) {
        setChild(node, 0);
    }

    // Declared in Enums.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(0);
    }

    // Declared in Enums.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(0);
    }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 1
    private String tokenString_ID;

    // Declared in Enums.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in Enums.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 1
    public void setImplementsList(List list) {
        setChild(list, 1);
    }

    // Declared in Enums.ast at line 6


    public int getNumImplements() {
        return getImplementsList().getNumChild();
    }

    // Declared in Enums.ast at line 10


    public Access getImplements(int i) {
        return (Access)getImplementsList().getChild(i);
    }

    // Declared in Enums.ast at line 14


    public void addImplements(Access node) {
        List list = getImplementsList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Enums.ast at line 19


    public void setImplements(Access node, int i) {
        List list = getImplementsList();
        list.setChild(node, i);
    }

    // Declared in Enums.ast at line 23

    public List getImplementsList() {
        return (List)getChild(1);
    }

    // Declared in Enums.ast at line 27


    public List getImplementsListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 1
    public void setBodyDeclList(List list) {
        setChild(list, 2);
    }

    // Declared in Enums.ast at line 6


    public int getNumBodyDecl() {
        return getBodyDeclList().getNumChild();
    }

    // Declared in Enums.ast at line 10


    public BodyDecl getBodyDecl(int i) {
        return (BodyDecl)getBodyDeclList().getChild(i);
    }

    // Declared in Enums.ast at line 14


    public void addBodyDecl(BodyDecl node) {
        List list = getBodyDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Enums.ast at line 19


    public void setBodyDecl(BodyDecl node, int i) {
        List list = getBodyDeclList();
        list.setChild(node, i);
    }

    // Declared in Enums.ast at line 23

    public List getBodyDeclList() {
        return (List)getChild(2);
    }

    // Declared in Enums.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 1
    public void setSuperClassAccessOpt(Opt opt) {
        setChild(opt, 3);
    }

    // Declared in Enums.ast at line 6


    public boolean hasSuperClassAccess() {
        return getSuperClassAccessOpt().getNumChild() != 0;
    }

    // Declared in Enums.ast at line 10


    public Access getSuperClassAccess() {
        return (Access)getSuperClassAccessOpt().getChild(0);
    }

    // Declared in Enums.ast at line 14


    public void setSuperClassAccess(Access node) {
        getSuperClassAccessOpt().setChild(node, 0);
    }

    // Declared in Enums.ast at line 17

    public Opt getSuperClassAccessOptNoTransform() {
        return (Opt)getChildNoTransform(3);
    }

    // Declared in Enums.ast at line 21


    protected int getSuperClassAccessOptChildPosition() {
        return 3;
    }

    // Declared in Annotations.jrag at line 120
    public boolean isValidAnnotationMethodReturnType() {
        boolean isValidAnnotationMethodReturnType_value = isValidAnnotationMethodReturnType_compute();
        return isValidAnnotationMethodReturnType_value;
    }

    private boolean isValidAnnotationMethodReturnType_compute() {  return  true;  }

    // Declared in Enums.jrag at line 8
    public boolean isEnumDecl() {
        boolean isEnumDecl_value = isEnumDecl_compute();
        return isEnumDecl_value;
    }

    private boolean isEnumDecl_compute() {  return  true;  }

    // Declared in Enums.jrag at line 32
    public boolean isStatic() {
        if(isStatic_computed)
            return isStatic_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isStatic_value = isStatic_compute();
        if(isFinal && num == boundariesCrossed)
            isStatic_computed = true;
        return isStatic_value;
    }

    private boolean isStatic_compute() {  return  isNestedType();  }

    protected boolean getSuperClassAccessOpt_computed = false;
    protected Opt getSuperClassAccessOpt_value;
    // Declared in Enums.jrag at line 53
    public Opt getSuperClassAccessOpt() {
        if(getSuperClassAccessOpt_computed)
            return (Opt)ASTNode.getChild(this, getSuperClassAccessOptChildPosition());
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        getSuperClassAccessOpt_value = getSuperClassAccessOpt_compute();
        setSuperClassAccessOpt(getSuperClassAccessOpt_value);
        if(isFinal && num == boundariesCrossed)
            getSuperClassAccessOpt_computed = true;
        return (Opt)ASTNode.getChild(this, getSuperClassAccessOptChildPosition());
    }

    private Opt getSuperClassAccessOpt_compute()  {
    return new Opt(
      new ParTypeAccess(
        new TypeAccess(
          "java.lang",
          "Enum"
        ),
        new List().add(createQualifiedAccess())
      )
    );
  }

    // Declared in Enums.jrag at line 229
    public boolean isFinal() {
        boolean isFinal_value = isFinal_compute();
        return isFinal_value;
    }

    private boolean isFinal_compute()  {
    for(Iterator iter = enumConstants().iterator(); iter.hasNext(); ) {
      EnumConstant c = (EnumConstant)iter.next();
      ClassInstanceExpr e = (ClassInstanceExpr)c.getInit();
      if(e.hasTypeDecl())
        return false;
    }
    return true;
  }

    protected boolean enumConstants_computed = false;
    protected ArrayList enumConstants_value;
    // Declared in Enums.jrag at line 240
    public ArrayList enumConstants() {
        if(enumConstants_computed)
            return enumConstants_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        enumConstants_value = enumConstants_compute();
        if(isFinal && num == boundariesCrossed)
            enumConstants_computed = true;
        return enumConstants_value;
    }

    private ArrayList enumConstants_compute()  {
    ArrayList list = new ArrayList();
    for(int i = 0; i < getNumBodyDecl(); i++)
      if(getBodyDecl(i).isEnumConstant())
        list.add(getBodyDecl(i));
    return list;
  }

    // Declared in Enums.jrag at line 380
    public boolean isAbstract() {
        boolean isAbstract_value = isAbstract_compute();
        return isAbstract_value;
    }

    private boolean isAbstract_compute()  {
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof MethodDecl) {
        MethodDecl m = (MethodDecl)getBodyDecl(i);
        if(m.isAbstract())
          return true;
      }
    }
    return false;
  }

    // Declared in EnumsCodegen.jrag at line 4
    public int flags() {
        if(flags_computed)
            return flags_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        flags_value = flags_compute();
        if(isFinal && num == boundariesCrossed)
            flags_computed = true;
        return flags_value;
    }

    private int flags_compute() {  return  super.flags() | Modifiers.ACC_ENUM;  }

    // Declared in Enums.jrag at line 370
    public TypeDecl typeString() {
        TypeDecl typeString_value = getParent().Define_TypeDecl_typeString(this, null);
        return typeString_value;
    }

    // Declared in Enums.jrag at line 26
    public boolean Define_boolean_mayBeAbstract(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  false;
        }
        return super.Define_boolean_mayBeAbstract(caller, child);
    }

    // Declared in Enums.jrag at line 238
    public boolean Define_boolean_mayBeFinal(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  false;
        }
        return super.Define_boolean_mayBeFinal(caller, child);
    }

    // Declared in Enums.jrag at line 33
    public boolean Define_boolean_mayBeStatic(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  isNestedType();
        }
        return super.Define_boolean_mayBeStatic(caller, child);
    }

public ASTNode rewriteTo() {
    // Declared in Enums.jrag at line 81
    if(!done()) {
        duringEnums++;
        ASTNode result = rewriteRule0();
        duringEnums--;
        return result;
    }

    return super.rewriteTo();
}

    // Declared in Enums.jrag at line 81
    private EnumDecl rewriteRule0() {
      if(noConstructor()) {
        List parameterList = new List();
        parameterList.add(
          new ParameterDeclaration(new TypeAccess("java.lang", "String"), "p0")
        );
        parameterList.add(
          new ParameterDeclaration(new TypeAccess("int"), "p1")
        );
        addBodyDecl(
          new ConstructorDecl(
            new Modifiers(new List().add(new Modifier("private"))),
            name(),
            parameterList,
            new List(),
            new Opt(
              new ExprStmt(
                new SuperConstructorAccess(
                  "super",
                  new List().add(
                    new VarAccess("p0")
                  ).add(
                    new VarAccess("p1")
                  )
                )
              )
            ),
            new Block(new List())
          )
        );
      }
      else {
        transformEnumConstructors();
      }
      addValues(); // Add the values() and getValue(String s) methods
      return this;
    }
}
