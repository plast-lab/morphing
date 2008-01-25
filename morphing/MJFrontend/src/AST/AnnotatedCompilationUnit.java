
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// 7.4.1.1 Package Annotations
public class AnnotatedCompilationUnit extends CompilationUnit implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        AnnotatedCompilationUnit node = (AnnotatedCompilationUnit)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          AnnotatedCompilationUnit node = (AnnotatedCompilationUnit)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        AnnotatedCompilationUnit res = (AnnotatedCompilationUnit)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Annotations.jrag at line 12

  // 7.4.1.1 Package Annotations

  /* Annotations may be used on package declarations, with the restriction that
  at most one annotated package declaration is permitted for a given package.
  The manner in which this restriction is enforced must, of necessity, vary
  from implementation to implementation. The following scheme is strongly
  recommended for file-system-based implementations: The sole annotated
  package declaration, if it exists, is placed in a source file called
  package-info.java in the directory containing the source files for the
  package. */
  public void nameCheck() {
    super.nameCheck();
    if(!relativeName().endsWith("package-info.java"))
      error("package annotations should be in a file package-info.java");
  }

    // Declared in Annotations.ast at line 3
    // Declared in Annotations.ast line 16

    public AnnotatedCompilationUnit() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 1);
        setChild(null, 2);

    }

    // Declared in Annotations.ast at line 13


    // Declared in Annotations.ast line 16
    public AnnotatedCompilationUnit(String p0, List p1, List p2, Modifiers p3) {
        setPackageDecl(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setChild(p3, 2);
    }

    // Declared in Annotations.ast at line 20


  protected int numChildren() {
    return 3;
  }

    // Declared in Annotations.ast at line 23

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 4
    private String tokenString_PackageDecl;

    // Declared in java.ast at line 3

    public void setPackageDecl(String value) {
        tokenString_PackageDecl = value;
    }

    // Declared in java.ast at line 6

    public String getPackageDecl() {
        return tokenString_PackageDecl;
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 4
    public void setImportDeclList(List list) {
        setChild(list, 0);
    }

    // Declared in java.ast at line 6


    public int getNumImportDecl() {
        return getImportDeclList().getNumChild();
    }

    // Declared in java.ast at line 10


    public ImportDecl getImportDecl(int i) {
        return (ImportDecl)getImportDeclList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addImportDecl(ImportDecl node) {
        List list = getImportDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setImportDecl(ImportDecl node, int i) {
        List list = getImportDeclList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getImportDeclList() {
        return (List)getChild(0);
    }

    // Declared in java.ast at line 27


    public List getImportDeclListNoTransform() {
        return (List)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 4
    public void setTypeDeclList(List list) {
        setChild(list, 1);
    }

    // Declared in java.ast at line 6


    public int getNumTypeDecl() {
        return getTypeDeclList().getNumChild();
    }

    // Declared in java.ast at line 10


    public TypeDecl getTypeDecl(int i) {
        return (TypeDecl)getTypeDeclList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addTypeDecl(TypeDecl node) {
        List list = getTypeDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setTypeDecl(TypeDecl node, int i) {
        List list = getTypeDeclList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getTypeDeclList() {
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getTypeDeclListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 16
    public void setModifiers(Modifiers node) {
        setChild(node, 2);
    }

    // Declared in Annotations.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(2);
    }

    // Declared in Annotations.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(2);
    }

    // Declared in Annotations.jrag at line 544
    public String Define_String_hostPackage(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  packageName();
        }
        return super.Define_String_hostPackage(caller, child);
    }

    // Declared in Annotations.jrag at line 545
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(caller == getModifiersNoTransform()) {
    SimpleSet set = SimpleSet.emptySet;
    for(Iterator iter = localLookupType(name).iterator(); iter.hasNext(); ) {
      TypeDecl t = (TypeDecl)iter.next();
      if(t.accessibleFromPackage(packageName()))
        set = set.add(t);
    }
    return set;
  }
        return super.Define_SimpleSet_lookupType(caller, child, name);
    }

    // Declared in Annotations.jrag at line 60
    public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
        if(caller == getModifiersNoTransform()) {
            return 
    name.equals("PACKAGE");
        }
        return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
