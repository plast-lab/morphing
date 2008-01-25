
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;
public class GenericMethodDecl extends MethodDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        lookupParMethodDecl_ArrayList_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        GenericMethodDecl node = (GenericMethodDecl)super.clone();
        node.lookupParMethodDecl_ArrayList_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          GenericMethodDecl node = (GenericMethodDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        GenericMethodDecl res = (GenericMethodDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in GenericMethods.jrag at line 23


  public ParMethodDecl p(ArrayList typeArguments) {
    ParMethodDecl methodDecl = new ParMethodDecl();
    addParMethodDecl(methodDecl);
    List list = new List();
    for(Iterator iter = typeArguments.iterator(); iter.hasNext(); )
      list.add(((TypeDecl)iter.next()).createBoundAccess());
    methodDecl.setTypeArgumentList(list);

    methodDecl.setModifiers((Modifiers)getModifiers().fullCopy());
    methodDecl.setTypeAccess(getTypeAccess().type().substituteReturnType(methodDecl));
    methodDecl.setID(getID());
    methodDecl.setParameterList(getParameterList().substitute(methodDecl));
    methodDecl.setExceptionList(getExceptionList().substitute(methodDecl));
    return methodDecl;
  }

    // Declared in GenericMethods.jrag at line 109


  public void toString(StringBuffer s) {
    s.append(indent());
    getModifiers().toString(s);
    
    s.append(" <");
    for(int i = 0; i < getNumTypeParameter(); i++) {
      if(i != 0) s.append(", ");
      original().getTypeParameter(i).toString(s);
    }
    s.append("> ");
    
    getTypeAccess().toString(s);
    s.append(" " + getID());
    s.append("(");
    if(getNumParameter() > 0) {
      getParameter(0).toString(s);
      for(int i = 1; i < getNumParameter(); i++) {
        s.append(", ");
        getParameter(i).toString(s);
      }
    }
    s.append(")");
    for(int i = 0; i < getNumEmptyBracket(); i++) {
      s.append("[]");
    }
    if(getNumException() > 0) {
      s.append(" throws ");
      getException(0).toString(s);
      for(int i = 1; i < getNumException(); i++) {
        s.append(", ");
        getException(i).toString(s);
      }
    }
    if(hasBlock()) {
      s.append(" ");
      getBlock().toString(s);
    }
    else {
      s.append(";\n");
    }
  }

    // Declared in Generics.jrag at line 865


  public BodyDecl p(ParTypeDecl parTypeDecl) {
    //System.out.println("Begin substituting generic " + signature() + " in " + hostType().typeName() + " with " + parTypeDecl.typeSignature());
    GenericMethodDecl m = new GenericMethodDecl(
      (Modifiers)getModifiers().fullCopy(),
      getTypeAccess().type().substituteReturnType(parTypeDecl),
      getID(),
      getParameterList().substitute(parTypeDecl),
      new List(),
      getExceptionList().substitute(parTypeDecl),
      new Opt(),
      (List)getTypeParameterList().fullCopy(),
      new List()
    );
    m.original = this;
    //System.out.println("End substituting generic " + signature());
    return m;
  }

    // Declared in Generics.jrag at line 883

  public GenericMethodDecl original;

    // Declared in GenericMethods.ast at line 3
    // Declared in GenericMethods.ast line 1

    public GenericMethodDecl() {
        super();

        setChild(null, 0);
        setChild(null, 1);
        setChild(new List(), 2);
        setChild(new List(), 3);
        setChild(new List(), 4);
        setChild(new Opt(), 5);
        setChild(new List(), 6);
        setChild(new List(), 7);

    }

    // Declared in GenericMethods.ast at line 18


    // Declared in GenericMethods.ast line 1
    public GenericMethodDecl(Modifiers p0, Access p1, String p2, List p3, List p4, List p5, Opt p6, List p7, List p8) {
        setChild(p0, 0);
        setChild(p1, 1);
        setID(p2);
        setChild(p3, 2);
        setChild(p4, 3);
        setChild(p5, 4);
        setChild(p6, 5);
        setChild(p7, 6);
        setChild(p8, 7);
    }

    // Declared in GenericMethods.ast at line 30


  protected int numChildren() {
    return 8;
  }

    // Declared in GenericMethods.ast at line 33

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setModifiers(Modifiers node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(0);
    }

    // Declared in java.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setTypeAccess(Access node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Access getTypeAccess() {
        return (Access)getChild(1);
    }

    // Declared in java.ast at line 9


    public Access getTypeAccessNoTransform() {
        return (Access)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    private String tokenString_ID;

    // Declared in java.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in java.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setParameterList(List list) {
        setChild(list, 2);
    }

    // Declared in java.ast at line 6


    public int getNumParameter() {
        return getParameterList().getNumChild();
    }

    // Declared in java.ast at line 10


    public ParameterDeclaration getParameter(int i) {
        return (ParameterDeclaration)getParameterList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addParameter(ParameterDeclaration node) {
        List list = getParameterList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setParameter(ParameterDeclaration node, int i) {
        List list = getParameterList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getParameterList() {
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getParameterListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setEmptyBracketList(List list) {
        setChild(list, 3);
    }

    // Declared in java.ast at line 6


    public int getNumEmptyBracket() {
        return getEmptyBracketList().getNumChild();
    }

    // Declared in java.ast at line 10


    public EmptyBracket getEmptyBracket(int i) {
        return (EmptyBracket)getEmptyBracketList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addEmptyBracket(EmptyBracket node) {
        List list = getEmptyBracketList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setEmptyBracket(EmptyBracket node, int i) {
        List list = getEmptyBracketList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getEmptyBracketList() {
        return (List)getChild(3);
    }

    // Declared in java.ast at line 27


    public List getEmptyBracketListNoTransform() {
        return (List)getChildNoTransform(3);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setExceptionList(List list) {
        setChild(list, 4);
    }

    // Declared in java.ast at line 6


    public int getNumException() {
        return getExceptionList().getNumChild();
    }

    // Declared in java.ast at line 10


    public Access getException(int i) {
        return (Access)getExceptionList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addException(Access node) {
        List list = getExceptionList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setException(Access node, int i) {
        List list = getExceptionList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getExceptionList() {
        return (List)getChild(4);
    }

    // Declared in java.ast at line 27


    public List getExceptionListNoTransform() {
        return (List)getChildNoTransform(4);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setBlockOpt(Opt opt) {
        setChild(opt, 5);
    }

    // Declared in java.ast at line 6


    public boolean hasBlock() {
        return getBlockOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Block getBlock() {
        return (Block)getBlockOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setBlock(Block node) {
        getBlockOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getBlockOpt() {
        return (Opt)getChild(5);
    }

    // Declared in java.ast at line 21


    public Opt getBlockOptNoTransform() {
        return (Opt)getChildNoTransform(5);
    }

    // Declared in GenericMethods.ast at line 2
    // Declared in GenericMethods.ast line 1
    public void setTypeParameterList(List list) {
        setChild(list, 6);
    }

    // Declared in GenericMethods.ast at line 6


    public int getNumTypeParameter() {
        return getTypeParameterList().getNumChild();
    }

    // Declared in GenericMethods.ast at line 10


    public TypeVariable getTypeParameter(int i) {
        return (TypeVariable)getTypeParameterList().getChild(i);
    }

    // Declared in GenericMethods.ast at line 14


    public void addTypeParameter(TypeVariable node) {
        List list = getTypeParameterList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in GenericMethods.ast at line 19


    public void setTypeParameter(TypeVariable node, int i) {
        List list = getTypeParameterList();
        list.setChild(node, i);
    }

    // Declared in GenericMethods.ast at line 23

    public List getTypeParameterList() {
        return (List)getChild(6);
    }

    // Declared in GenericMethods.ast at line 27


    public List getTypeParameterListNoTransform() {
        return (List)getChildNoTransform(6);
    }

    // Declared in GenericMethods.ast at line 2
    // Declared in GenericMethods.ast line 1
    public void setParMethodDeclList(List list) {
        setChild(list, 7);
    }

    // Declared in GenericMethods.ast at line 6


    public int getNumParMethodDecl() {
        return getParMethodDeclList().getNumChild();
    }

    // Declared in GenericMethods.ast at line 10


    public ParMethodDecl getParMethodDecl(int i) {
        return (ParMethodDecl)getParMethodDeclList().getChild(i);
    }

    // Declared in GenericMethods.ast at line 14


    public void addParMethodDecl(ParMethodDecl node) {
        List list = getParMethodDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in GenericMethods.ast at line 19


    public void setParMethodDecl(ParMethodDecl node, int i) {
        List list = getParMethodDeclList();
        list.setChild(node, i);
    }

    // Declared in GenericMethods.ast at line 23

    public List getParMethodDeclList() {
        return (List)getChild(7);
    }

    // Declared in GenericMethods.ast at line 27


    public List getParMethodDeclListNoTransform() {
        return (List)getChildNoTransform(7);
    }

    protected java.util.Map lookupParMethodDecl_ArrayList_values;
    // Declared in GenericMethods.jrag at line 10
    public MethodDecl lookupParMethodDecl(ArrayList typeArguments) {
        Object _parameters = typeArguments;
if(lookupParMethodDecl_ArrayList_values == null) lookupParMethodDecl_ArrayList_values = new java.util.HashMap(4);
        if(lookupParMethodDecl_ArrayList_values.containsKey(_parameters))
            return (MethodDecl)lookupParMethodDecl_ArrayList_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        MethodDecl lookupParMethodDecl_ArrayList_value = lookupParMethodDecl_compute(typeArguments);
        if(isFinal && num == boundariesCrossed)
            lookupParMethodDecl_ArrayList_values.put(_parameters, lookupParMethodDecl_ArrayList_value);
        return lookupParMethodDecl_ArrayList_value;
    }

    private MethodDecl lookupParMethodDecl_compute(ArrayList typeArguments)  {
    l: for(int i = 0; i < getNumParMethodDecl(); i++) {
      ParMethodDecl decl = getParMethodDecl(i);
      if(decl.getNumTypeArgument() == typeArguments.size()) {
        for(int j = 0; j < decl.getNumTypeArgument(); j++)
          if(decl.getTypeArgument(j).type() != typeArguments.get(j))
            continue l;
        return decl;
      }
    }
    return p(typeArguments);
  }

    // Declared in GenericMethods.jrag at line 56
    public SimpleSet localLookupType(String name) {
        SimpleSet localLookupType_String_value = localLookupType_compute(name);
        return localLookupType_String_value;
    }

    private SimpleSet localLookupType_compute(String name)  {
    for(int i = 0; i < getNumTypeParameter(); i++) {
      if(original().getTypeParameter(i).name().equals(name))
        return SimpleSet.emptySet.add(original().getTypeParameter(i));
    }
    return SimpleSet.emptySet;
  }

    // Declared in Generics.jrag at line 882
    public GenericMethodDecl original() {
        GenericMethodDecl original_value = original_compute();
        return original_value;
    }

    private GenericMethodDecl original_compute() {  return  original != null ? original : this;  }

    // Declared in GenericsCodegen.jrag at line 333
    public boolean needsSignatureAttribute() {
        boolean needsSignatureAttribute_value = needsSignatureAttribute_compute();
        return needsSignatureAttribute_value;
    }

    private boolean needsSignatureAttribute_compute() {  return  true;  }

    // Declared in GenericsCodegen.jrag at line 453
    public String methodTypeSignature() {
        String methodTypeSignature_value = methodTypeSignature_compute();
        return methodTypeSignature_value;
    }

    private String methodTypeSignature_compute()  {
    StringBuffer buf = new StringBuffer();
    buf.append("<");
    for(int i = 0; i < getNumTypeParameter(); i++)
      buf.append(getTypeParameter(i).fieldTypeSignature());
    buf.append(">");
    buf.append(super.methodTypeSignature());
    return buf.toString();
  }

    // Declared in GenericMethods.jrag at line 55
    public SimpleSet lookupType(String name) {
        SimpleSet lookupType_String_value = getParent().Define_SimpleSet_lookupType(this, null, name);
        return lookupType_String_value;
    }

    // Declared in GenericMethods.jrag at line 4
    public GenericMethodDecl Define_GenericMethodDecl_genericMethodDecl(ASTNode caller, ASTNode child) {
        if(caller == getParMethodDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  this;
        }
        return getParent().Define_GenericMethodDecl_genericMethodDecl(this, caller);
    }

    // Declared in GenericMethods.jrag at line 53
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        return super.Define_NameType_nameType(caller, child);
    }

    // Declared in GenericMethods.jrag at line 63
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  localLookupType(name).isEmpty() ? lookupType(name) : localLookupType(name);
        }
        return getParent().Define_SimpleSet_lookupType(this, caller, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
