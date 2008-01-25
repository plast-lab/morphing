
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class ParSuperConstructorAccess extends SuperConstructorAccess implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        ParSuperConstructorAccess node = (ParSuperConstructorAccess)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ParSuperConstructorAccess node = (ParSuperConstructorAccess)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ParSuperConstructorAccess res = (ParSuperConstructorAccess)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in GenericMethods.ast at line 3
    // Declared in GenericMethods.ast line 10

    public ParSuperConstructorAccess() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 1);

    }

    // Declared in GenericMethods.ast at line 12


    // Declared in GenericMethods.ast line 10
    public ParSuperConstructorAccess(String p0, List p1, List p2) {
        setID(p0);
        setChild(p1, 0);
        setChild(p2, 1);
    }

    // Declared in GenericMethods.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in GenericMethods.ast at line 21

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 18
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
    // Declared in java.ast line 18
    public void setArgList(List list) {
        setChild(list, 0);
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
        return (List)getChild(0);
    }

    // Declared in java.ast at line 27


    public List getArgListNoTransform() {
        return (List)getChildNoTransform(0);
    }

    // Declared in GenericMethods.ast at line 2
    // Declared in GenericMethods.ast line 10
    public void setTypeArgumentList(List list) {
        setChild(list, 1);
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
        return (List)getChild(1);
    }

    // Declared in GenericMethods.ast at line 27


    public List getTypeArgumentListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in GenericMethods.jrag at line 67
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeArgumentListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        return super.Define_NameType_nameType(caller, child);
    }

    // Declared in GenericMethods.jrag at line 68
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
