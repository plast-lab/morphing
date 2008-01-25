
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class WildcardSuper extends AbstractWildcard implements Cloneable {
    public void flushCache() {
        super.flushCache();
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        WildcardSuper node = (WildcardSuper)super.clone();
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          WildcardSuper node = (WildcardSuper)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        WildcardSuper res = (WildcardSuper)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in GenericsPrettyPrint.jrag at line 167

  public void toString(StringBuffer s) {
    super.toString(s);
    s.append(" super ");
    getAccess().toString(s);
  }

    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 23

    public WildcardSuper() {
        super();

        setChild(null, 0);

    }

    // Declared in Generics.ast at line 11


    // Declared in Generics.ast line 23
    public WildcardSuper(Access p0) {
        setChild(p0, 0);
    }

    // Declared in Generics.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in Generics.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 23
    public void setAccess(Access node) {
        setChild(node, 0);
    }

    // Declared in Generics.ast at line 5

    public Access getAccess() {
        return (Access)getChild(0);
    }

    // Declared in Generics.ast at line 9


    public Access getAccessNoTransform() {
        return (Access)getChildNoTransform(0);
    }

    // Declared in Generics.jrag at line 975
    public TypeDecl type() {
        if(type_computed)
            return type_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        type_value = type_compute();
        if(isFinal && num == boundariesCrossed)
            type_computed = true;
        return type_value;
    }

    private TypeDecl type_compute() {  return  lookupWildcardSuper(getAccess().type());  }

    // Declared in Generics.jrag at line 976
    public TypeDecl lookupWildcardSuper(TypeDecl bound) {
        TypeDecl lookupWildcardSuper_TypeDecl_value = getParent().Define_TypeDecl_lookupWildcardSuper(this, null, bound);
        return lookupWildcardSuper_TypeDecl_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
