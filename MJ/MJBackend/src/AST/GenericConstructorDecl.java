
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class GenericConstructorDecl extends ConstructorDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        GenericConstructorDecl node = (GenericConstructorDecl)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          GenericConstructorDecl node = (GenericConstructorDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        GenericConstructorDecl res = (GenericConstructorDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.jrag at line 886

  public GenericConstructorDecl original;

    // Declared in GenericMethods.ast at line 3
    // Declared in GenericMethods.ast line 2

    public GenericConstructorDecl() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);
        setChild(new Opt(), 3);
        setChild(null, 4);
        setChild(new List(), 5);
        setChild(new List(), 6);

    }

    // Declared in GenericMethods.ast at line 17


    // Declared in GenericMethods.ast line 2
    public GenericConstructorDecl(Modifiers p0, String p1, List p2, List p3, Opt p4, Block p5, List p6, List p7) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
        setChild(p5, 4);
        setChild(p6, 5);
        setChild(p7, 6);
    }

    // Declared in GenericMethods.ast at line 28


  protected int numChildren() {
    return 7;
  }

    // Declared in GenericMethods.ast at line 31

  public boolean mayHaveRewrite() { return true; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
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
    // Declared in java.ast line 71
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
    // Declared in java.ast line 71
    public void setParameterList(List list) {
        setChild(list, 1);
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
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getParameterListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
    public void setExceptionList(List list) {
        setChild(list, 2);
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
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getExceptionListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
    public void setConstructorInvocationOpt(Opt opt) {
        setChild(opt, 3);
    }

    // Declared in java.ast at line 6


    public boolean hasConstructorInvocation() {
        return getConstructorInvocationOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Stmt getConstructorInvocation() {
        return (Stmt)getConstructorInvocationOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setConstructorInvocation(Stmt node) {
        getConstructorInvocationOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getConstructorInvocationOpt() {
        return (Opt)getChild(3);
    }

    // Declared in java.ast at line 21


    public Opt getConstructorInvocationOptNoTransform() {
        return (Opt)getChildNoTransform(3);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
    public void setBlock(Block node) {
        setChild(node, 4);
    }

    // Declared in java.ast at line 5

    public Block getBlock() {
        return (Block)getChild(4);
    }

    // Declared in java.ast at line 9


    public Block getBlockNoTransform() {
        return (Block)getChildNoTransform(4);
    }

    // Declared in GenericMethods.ast at line 2
    // Declared in GenericMethods.ast line 2
    public void setTypeParameterList(List list) {
        setChild(list, 5);
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
        return (List)getChild(5);
    }

    // Declared in GenericMethods.ast at line 27


    public List getTypeParameterListNoTransform() {
        return (List)getChildNoTransform(5);
    }

    // Declared in GenericMethods.ast at line 2
    // Declared in GenericMethods.ast line 2
    public void setParConstructorDeclList(List list) {
        setChild(list, 6);
    }

    // Declared in GenericMethods.ast at line 6


    public int getNumParConstructorDecl() {
        return getParConstructorDeclList().getNumChild();
    }

    // Declared in GenericMethods.ast at line 10


    public ParConstructorDecl getParConstructorDecl(int i) {
        return (ParConstructorDecl)getParConstructorDeclList().getChild(i);
    }

    // Declared in GenericMethods.ast at line 14


    public void addParConstructorDecl(ParConstructorDecl node) {
        List list = getParConstructorDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in GenericMethods.ast at line 19


    public void setParConstructorDecl(ParConstructorDecl node, int i) {
        List list = getParConstructorDeclList();
        list.setChild(node, i);
    }

    // Declared in GenericMethods.ast at line 23

    public List getParConstructorDeclList() {
        return (List)getChild(6);
    }

    // Declared in GenericMethods.ast at line 27


    public List getParConstructorDeclListNoTransform() {
        return (List)getChildNoTransform(6);
    }

    // Declared in GenericMethods.jrag at line 72
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

    // Declared in Generics.jrag at line 885
    public GenericConstructorDecl original() {
        GenericConstructorDecl original_value = original_compute();
        return original_value;
    }

    private GenericConstructorDecl original_compute() {  return  original != null ? original : this;  }

    // Declared in GenericsCodegen.jrag at line 340
    public boolean needsSignatureAttribute() {
        boolean needsSignatureAttribute_value = needsSignatureAttribute_compute();
        return needsSignatureAttribute_value;
    }

    private boolean needsSignatureAttribute_compute() {  return  true;  }

    // Declared in GenericMethods.jrag at line 71
    public SimpleSet lookupType(String name) {
        SimpleSet lookupType_String_value = getParent().Define_SimpleSet_lookupType(this, null, name);
        return lookupType_String_value;
    }

    // Declared in GenericMethods.jrag at line 69
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        return super.Define_NameType_nameType(caller, child);
    }

    // Declared in GenericMethods.jrag at line 79
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  localLookupType(name).isEmpty() ? lookupType(name) : localLookupType(name);
        }
        return getParent().Define_SimpleSet_lookupType(this, caller, name);
    }

    // Declared in GenericMethods.jrag at line 7
    public GenericConstructorDecl Define_GenericConstructorDecl_genericConstructorDecl(ASTNode caller, ASTNode child) {
        if(caller == getParConstructorDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  this;
        }
        return getParent().Define_GenericConstructorDecl_genericConstructorDecl(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
