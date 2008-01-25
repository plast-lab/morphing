
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// parameterized type access
public class ParTypeAccess extends Access implements Cloneable {
    public void flushCache() {
        super.flushCache();
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ParTypeAccess node = (ParTypeAccess)super.clone();
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ParTypeAccess node = (ParTypeAccess)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ParTypeAccess res = (ParTypeAccess)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.jrag at line 205

  public boolean isRaw() {
    return false;
  }

    // Declared in Generics.jrag at line 306


  public void typeCheck() {
    super.typeCheck();
    if(!genericDecl().isGenericType()) {
      error(genericDecl().typeName() + " is not a generic type but used as one in " + this);
    }
    else {
      GenericTypeDecl decl = (GenericTypeDecl)genericDecl();
      if(decl.original().getNumTypeParameter() != getNumTypeArgument()) {
        error(decl.typeName() + " takes " + decl.original().getNumTypeParameter() + " type parameters, not " + getNumTypeArgument() + " as used in " + this);
      }
      else {
        ParTypeDecl typeDecl = (ParTypeDecl)type();
        for(int i = 0; i < getNumTypeArgument(); i++) {
          if(!getTypeArgument(i).type().instanceOf(decl.original().getTypeParameter(i))) {
            error("type argument " + i + " is of type " + getTypeArgument(i).type().typeName() 
              + " which is not a subtype of " + decl.original().getTypeParameter(i).typeName());
          }
        }
      }
    }
  }

    // Declared in GenericsPrettyPrint.jrag at line 14


  public void toString(StringBuffer s) {
    getTypeAccess().toString(s);
    s.append("<");
    for(int i = 0; i < getNumTypeArgument(); i++) {
      if(i != 0)
        s.append(", ");
      getTypeArgument(i).toString(s);
    }
    s.append(">");
  }

    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 16

    public ParTypeAccess() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);

    }

    // Declared in Generics.ast at line 12


    // Declared in Generics.ast line 16
    public ParTypeAccess(Access p0, List p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in Generics.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in Generics.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 16
    public void setTypeAccess(Access node) {
        setChild(node, 0);
    }

    // Declared in Generics.ast at line 5

    public Access getTypeAccess() {
        return (Access)getChild(0);
    }

    // Declared in Generics.ast at line 9


    public Access getTypeAccessNoTransform() {
        return (Access)getChildNoTransform(0);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 16
    public void setTypeArgumentList(List list) {
        setChild(list, 1);
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
        return (List)getChild(1);
    }

    // Declared in Generics.ast at line 27


    public List getTypeArgumentListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Generics.jrag at line 168
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

    private TypeDecl type_compute()  {
    TypeDecl typeDecl = genericDecl();
    if(typeDecl instanceof GenericTypeDecl) {
      // use signature in lookup for types that are used in extends and implements clauses
      if(unqualifiedScope().getParent().getParent() instanceof TypeDecl)
        return ((GenericTypeDecl)typeDecl).lookupParTypeDecl(this);
      ArrayList args = new ArrayList();
      for(int i = 0; i < getNumTypeArgument(); i++)
        args.add(getTypeArgument(i).type());
      return ((GenericTypeDecl)typeDecl).lookupParTypeDecl(args);
    }
    return typeDecl;
  }

    // Declared in Generics.jrag at line 181
    public TypeDecl genericDecl() {
        TypeDecl genericDecl_value = genericDecl_compute();
        return genericDecl_value;
    }

    private TypeDecl genericDecl_compute() {  return  getTypeAccess().type();  }

    // Declared in Generics.jrag at line 182
    public boolean isTypeAccess() {
        boolean isTypeAccess_value = isTypeAccess_compute();
        return isTypeAccess_value;
    }

    private boolean isTypeAccess_compute() {  return  true;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
