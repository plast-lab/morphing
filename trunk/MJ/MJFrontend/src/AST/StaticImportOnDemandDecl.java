
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class StaticImportOnDemandDecl extends StaticImportDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        StaticImportOnDemandDecl node = (StaticImportOnDemandDecl)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          StaticImportOnDemandDecl node = (StaticImportOnDemandDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        StaticImportOnDemandDecl res = (StaticImportOnDemandDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in StaticImports.jrag at line 190

  public void toString(StringBuffer s) {
    s.append("import ");
    getAccess().toString(s);
    s.append(".*;\n");
  }

    // Declared in StaticImports.ast at line 3
    // Declared in StaticImports.ast line 4

    public StaticImportOnDemandDecl() {
        super();

        setChild(null, 0);

    }

    // Declared in StaticImports.ast at line 11


    // Declared in StaticImports.ast line 4
    public StaticImportOnDemandDecl(Access p0) {
        setChild(p0, 0);
    }

    // Declared in StaticImports.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in StaticImports.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 7
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

    // Declared in StaticImports.jrag at line 46
    public TypeDecl type() {
        TypeDecl type_value = type_compute();
        return type_value;
    }

    private TypeDecl type_compute() {  return  getAccess().type();  }

    // Declared in StaticImports.jrag at line 49
    public boolean isOnDemand() {
        boolean isOnDemand_value = isOnDemand_compute();
        return isOnDemand_value;
    }

    private boolean isOnDemand_compute() {  return  true;  }

    // Declared in StaticImports.jrag at line 181
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getAccessNoTransform()) {
            return  NameType.TYPE_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
