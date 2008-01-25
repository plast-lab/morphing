
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class EnumConstant extends FieldDeclaration implements Cloneable {
    public void flushCache() {
        super.flushCache();
        getTypeAccess_computed = false;
        getTypeAccess_value = null;
        getInitOpt_computed = false;
        getInitOpt_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        EnumConstant node = (EnumConstant)super.clone();
        node.getTypeAccess_computed = false;
        node.getTypeAccess_value = null;
        node.getInitOpt_computed = false;
        node.getInitOpt_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          EnumConstant node = (EnumConstant)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        EnumConstant res = (EnumConstant)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Enums.jrag at line 184


  /*
    3) An enum constant may be followed by arguments, which are passed to the
    constructor of the enum type when the constant is created during class
    initialization as described later in this section. The constructor to be
    invoked is chosen using the normal overloading rules (\ufffd15.12.2). If the
    arguments are omitted, an empty argument list is assumed. 
  */

  private List createArgumentList() {
    List argList = new List();
    argList.add(new StringLiteral(getID()));
    argList.add(new IntegerLiteral(Integer.toString(((List)getParent()).getIndexOfChild(this))));
    for(int i = 0; i < getNumArg(); i++)
      argList.add(getArg(i).fullCopy());
    return argList;
  }

    // Declared in Enums.jrag at line 202


  /*
    4) The optional class body of an enum constant implicitly defines an anonymous
    class declaration (\ufffd15.9.5) that extends the immediately enclosing enum type.
    The class body is governed by the usual rules of anonymous classes; in
    particular it cannot contain any constructors.

    TODO: work on error messages
  */
  
  private Opt createOptAnonymousDecl() {
    if(getNumBodyDecl() == 0)
      return new Opt();
    List list = getBodyDeclList();
    setBodyDeclList(new List()); // TODO: get rid of this side-effect
    return new Opt(
      new AnonymousDecl(
        new Modifiers(),
        "Anonymous",
        list
      )
    );
  }

    // Declared in Enums.jrag at line 447


  // generic traversal should traverse NTA as well
  // this should be done automatically by the JastAdd
  public int getNumChild() {
    return 5;
  }

    // Declared in Enums.jrag at line 450

  public ASTNode getChild(int i) {
    switch(i) {
      case 3: return getTypeAccess();
      case 4: return getInitOpt();
      default: return ASTNode.getChild(this, i);
    }
  }

    // Declared in Enums.ast at line 3
    // Declared in Enums.ast line 3

    public EnumConstant() {
        super();
        setChild(null, 0);
        setChild(new Opt(), 1);

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);
        setChild(null, 3);
        setChild(new Opt(), 4);

    }

    // Declared in Enums.ast at line 17


    // Declared in Enums.ast line 3
    public EnumConstant(Modifiers p0, String p1, List p2, List p3) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(null, 3);
        setChild(new Opt(), 4);
    }

    // Declared in Enums.ast at line 26


  protected int numChildren() {
    return 3;
  }

    // Declared in Enums.ast at line 29

  public boolean mayHaveRewrite() { return false; }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 3
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
    // Declared in Enums.ast line 3
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
    // Declared in Enums.ast line 3
    public void setArgList(List list) {
        setChild(list, 1);
    }

    // Declared in Enums.ast at line 6


    public int getNumArg() {
        return getArgList().getNumChild();
    }

    // Declared in Enums.ast at line 10


    public Expr getArg(int i) {
        return (Expr)getArgList().getChild(i);
    }

    // Declared in Enums.ast at line 14


    public void addArg(Expr node) {
        List list = getArgList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Enums.ast at line 19


    public void setArg(Expr node, int i) {
        List list = getArgList();
        list.setChild(node, i);
    }

    // Declared in Enums.ast at line 23

    public List getArgList() {
        return (List)getChild(1);
    }

    // Declared in Enums.ast at line 27


    public List getArgListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 3
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
    // Declared in Enums.ast line 3
    public void setTypeAccess(Access node) {
        setChild(node, 3);
    }

    // Declared in Enums.ast at line 5

    public Access getTypeAccessNoTransform() {
        return (Access)getChildNoTransform(3);
    }

    // Declared in Enums.ast at line 9


    protected int getTypeAccessChildPosition() {
        return 3;
    }

    // Declared in Enums.ast at line 2
    // Declared in Enums.ast line 3
    public void setInitOpt(Opt opt) {
        setChild(opt, 4);
    }

    // Declared in Enums.ast at line 6


    public boolean hasInit() {
        return getInitOpt().getNumChild() != 0;
    }

    // Declared in Enums.ast at line 10


    public Expr getInit() {
        return (Expr)getInitOpt().getChild(0);
    }

    // Declared in Enums.ast at line 14


    public void setInit(Expr node) {
        getInitOpt().setChild(node, 0);
    }

    // Declared in Enums.ast at line 17

    public Opt getInitOptNoTransform() {
        return (Opt)getChildNoTransform(4);
    }

    // Declared in Enums.ast at line 21


    protected int getInitOptChildPosition() {
        return 4;
    }

    // Declared in Enums.jrag at line 20
    public boolean isEnumConstant() {
        boolean isEnumConstant_value = isEnumConstant_compute();
        return isEnumConstant_value;
    }

    private boolean isEnumConstant_compute() {  return  true;  }

    // Declared in Enums.jrag at line 158
    public boolean isPublic() {
        boolean isPublic_value = isPublic_compute();
        return isPublic_value;
    }

    private boolean isPublic_compute() {  return  true;  }

    // Declared in Enums.jrag at line 159
    public boolean isStatic() {
        boolean isStatic_value = isStatic_compute();
        return isStatic_value;
    }

    private boolean isStatic_compute() {  return  true;  }

    // Declared in Enums.jrag at line 160
    public boolean isFinal() {
        boolean isFinal_value = isFinal_compute();
        return isFinal_value;
    }

    private boolean isFinal_compute() {  return  true;  }

    protected boolean getTypeAccess_computed = false;
    protected Access getTypeAccess_value;
    // Declared in Enums.jrag at line 162
    public Access getTypeAccess() {
        if(getTypeAccess_computed)
            return (Access)ASTNode.getChild(this, getTypeAccessChildPosition());
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        getTypeAccess_value = getTypeAccess_compute();
            setTypeAccess(getTypeAccess_value);
        if(isFinal && num == boundariesCrossed)
            getTypeAccess_computed = true;
        return (Access)ASTNode.getChild(this, getTypeAccessChildPosition());
    }

    private Access getTypeAccess_compute()  {
    return hostType().createQualifiedAccess();
  }

    protected boolean getInitOpt_computed = false;
    protected Opt getInitOpt_value;
    // Declared in Enums.jrag at line 166
    public Opt getInitOpt() {
        if(getInitOpt_computed)
            return (Opt)ASTNode.getChild(this, getInitOptChildPosition());
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        getInitOpt_value = getInitOpt_compute();
        setInitOpt(getInitOpt_value);
        if(isFinal && num == boundariesCrossed)
            getInitOpt_computed = true;
        return (Opt)ASTNode.getChild(this, getInitOptChildPosition());
    }

    private Opt getInitOpt_compute()  {
    return new Opt(
        new ClassInstanceExpr(
          hostType().createQualifiedAccess(),
          createArgumentList(),
          createOptAnonymousDecl()
        )
    );
  }

    // Declared in Enums.jrag at line 467
    public boolean isConstant() {
        boolean isConstant_value = isConstant_compute();
        return isConstant_value;
    }

    private boolean isConstant_compute() {  return  true;  }

    // Declared in Enums.jrag at line 18
    public BodyDecl Define_BodyDecl_hostBodyDecl(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  this;
        }
        return super.Define_BodyDecl_hostBodyDecl(caller, child);
    }

    // Declared in Enums.jrag at line 443
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeAccessNoTransform()) {
            return  NameType.TYPE_NAME;
        }
        return super.Define_NameType_nameType(caller, child);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
