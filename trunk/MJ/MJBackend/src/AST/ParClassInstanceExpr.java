
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// parameterized object instantiation
public class ParClassInstanceExpr extends ClassInstanceExpr implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        ParClassInstanceExpr node = (ParClassInstanceExpr)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ParClassInstanceExpr node = (ParClassInstanceExpr)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ParClassInstanceExpr res = (ParClassInstanceExpr)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 13

    public ParClassInstanceExpr() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new Opt(), 2);
        setChild(new List(), 3);

    }

    // Declared in Generics.ast at line 14


    // Declared in Generics.ast line 13
    public ParClassInstanceExpr(Access p0, List p1, Opt p2, List p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
    }

    // Declared in Generics.ast at line 21


  protected int numChildren() {
    return 4;
  }

    // Declared in Generics.ast at line 24

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 33
    public void setAccess(Access node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Access getAccess() {
        return (Access)getChild(0);
    }

    // Declared in java.ast at line 9


    public Access getAccessNoTransform() {
        return (Access)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 33
    public void setArgList(List list) {
        setChild(list, 1);
    }

    // Declared in java.ast at line 6


    public int getNumArg() {
        return getArgList().getNumChild();
    }

    // Declared in java.ast at line 10


    public Expr getArg(int i) {
        return (Expr)getArgList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addArg(Expr node) {
        List list = getArgList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setArg(Expr node, int i) {
        List list = getArgList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getArgList() {
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getArgListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 33
    public void setTypeDeclOpt(Opt opt) {
        setChild(opt, 2);
    }

    // Declared in java.ast at line 6


    public boolean hasTypeDecl() {
        return getTypeDeclOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public TypeDecl getTypeDecl() {
        return (TypeDecl)getTypeDeclOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setTypeDecl(TypeDecl node) {
        getTypeDeclOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getTypeDeclOpt() {
        return (Opt)getChild(2);
    }

    // Declared in java.ast at line 21


    public Opt getTypeDeclOptNoTransform() {
        return (Opt)getChildNoTransform(2);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 13
    public void setTypeArgumentList(List list) {
        setChild(list, 3);
    }

    // Declared in Generics.ast at line 6


    public int getNumTypeArgument() {
        return getTypeArgumentList().getNumChild();
    }

    // Declared in Generics.ast at line 10


    public Access getTypeArgument(int i) {
        return (Access)getTypeArgumentList().getChild(i);
    }

    // Declared in Generics.ast at line 14


    public void addTypeArgument(Access node) {
        List list = getTypeArgumentList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Generics.ast at line 19


    public void setTypeArgument(Access node, int i) {
        List list = getTypeArgumentList();
        list.setChild(node, i);
    }

    // Declared in Generics.ast at line 23

    public List getTypeArgumentList() {
        return (List)getChild(3);
    }

    // Declared in Generics.ast at line 27


    public List getTypeArgumentListNoTransform() {
        return (List)getChildNoTransform(3);
    }

    // Declared in GenericMethods.jrag at line 81
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeArgumentListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        return super.Define_NameType_nameType(caller, child);
    }

    // Declared in GenericMethods.jrag at line 82
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(caller == getTypeArgumentListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  unqualifiedScope().lookupType(name);
        }
        return super.Define_SimpleSet_lookupType(caller, child, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
