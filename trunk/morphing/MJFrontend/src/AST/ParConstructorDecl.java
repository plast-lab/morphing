
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class ParConstructorDecl extends ConstructorDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        genericConstructorDecl_computed = false;
        genericConstructorDecl_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ParConstructorDecl node = (ParConstructorDecl)super.clone();
        node.genericConstructorDecl_computed = false;
        node.genericConstructorDecl_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ParConstructorDecl node = (ParConstructorDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ParConstructorDecl res = (ParConstructorDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in GenericMethods.ast at line 3
    // Declared in GenericMethods.ast line 5

    public ParConstructorDecl() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);
        setChild(new Opt(), 3);
        setChild(null, 4);
        setChild(new List(), 5);

    }

    // Declared in GenericMethods.ast at line 16


    // Declared in GenericMethods.ast line 5
    public ParConstructorDecl(Modifiers p0, String p1, List p2, List p3, Opt p4, Block p5, List p6) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
        setChild(p5, 4);
        setChild(p6, 5);
    }

    // Declared in GenericMethods.ast at line 26


  protected int numChildren() {
    return 6;
  }

    // Declared in GenericMethods.ast at line 29

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
    // Declared in GenericMethods.ast line 5
    public void setTypeArgumentList(List list) {
        setChild(list, 5);
    }

    // Declared in GenericMethods.ast at line 6


    public int getNumTypeArgument() {
        return getTypeArgumentList().getNumChild();
    }

    // Declared in GenericMethods.ast at line 10


    public Access getTypeArgument(int i) {
        return (Access)getTypeArgumentList().getChild(i);
    }

    // Declared in GenericMethods.ast at line 14


    public void addTypeArgument(Access node) {
        List list = getTypeArgumentList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in GenericMethods.ast at line 19


    public void setTypeArgument(Access node, int i) {
        List list = getTypeArgumentList();
        list.setChild(node, i);
    }

    // Declared in GenericMethods.ast at line 23

    public List getTypeArgumentList() {
        return (List)getChild(5);
    }

    // Declared in GenericMethods.ast at line 27


    public List getTypeArgumentListNoTransform() {
        return (List)getChildNoTransform(5);
    }

    protected boolean genericConstructorDecl_computed = false;
    protected GenericConstructorDecl genericConstructorDecl_value;
    // Declared in GenericMethods.jrag at line 6
    public GenericConstructorDecl genericConstructorDecl() {
        if(genericConstructorDecl_computed)
            return genericConstructorDecl_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        genericConstructorDecl_value = getParent().Define_GenericConstructorDecl_genericConstructorDecl(this, null);
        if(isFinal && num == boundariesCrossed)
            genericConstructorDecl_computed = true;
        return genericConstructorDecl_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
