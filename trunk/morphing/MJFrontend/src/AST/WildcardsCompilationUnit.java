
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class WildcardsCompilationUnit extends CompilationUnit implements Cloneable {
    public void flushCache() {
        super.flushCache();
        typeWildcard_computed = false;
        typeWildcard_value = null;
        lookupWildcardExtends_TypeDecl_values = null;
        lookupWildcardSuper_TypeDecl_values = null;
        lookupLUBType_ArrayList_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        WildcardsCompilationUnit node = (WildcardsCompilationUnit)super.clone();
        node.typeWildcard_computed = false;
        node.typeWildcard_value = null;
        node.lookupWildcardExtends_TypeDecl_values = null;
        node.lookupWildcardSuper_TypeDecl_values = null;
        node.lookupLUBType_ArrayList_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          WildcardsCompilationUnit node = (WildcardsCompilationUnit)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        WildcardsCompilationUnit res = (WildcardsCompilationUnit)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 35

    public WildcardsCompilationUnit() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 1);

    }

    // Declared in Generics.ast at line 12


    // Declared in Generics.ast line 35
    public WildcardsCompilationUnit(String p0, List p1, List p2) {
        setPackageDecl(p0);
        setChild(p1, 0);
        setChild(p2, 1);
    }

    // Declared in Generics.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in Generics.ast at line 21

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

    protected boolean typeWildcard_computed = false;
    protected TypeDecl typeWildcard_value;
    // Declared in Generics.jrag at line 980
    public TypeDecl typeWildcard() {
        if(typeWildcard_computed)
            return typeWildcard_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeWildcard_value = typeWildcard_compute();
        typeWildcard_value.setParent(this);
        typeWildcard_value.is$Final = true;
        if(true)
            typeWildcard_computed = true;
        return typeWildcard_value;
    }

    private TypeDecl typeWildcard_compute()  {
    TypeDecl decl = new WildcardType(
      new Modifiers(new List().add(new Modifier("public"))),
      "?",
      new List()
    );
    return decl;
  }

    protected java.util.Map lookupWildcardExtends_TypeDecl_values;
    protected List lookupWildcardExtends_TypeDecl_list;
    // Declared in Generics.jrag at line 991
    public TypeDecl lookupWildcardExtends(TypeDecl bound) {
        Object _parameters = bound;
if(lookupWildcardExtends_TypeDecl_values == null) lookupWildcardExtends_TypeDecl_values = new java.util.HashMap(4);
        if(lookupWildcardExtends_TypeDecl_values.containsKey(_parameters))
            return (TypeDecl)lookupWildcardExtends_TypeDecl_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        TypeDecl lookupWildcardExtends_TypeDecl_value = lookupWildcardExtends_compute(bound);
        if(lookupWildcardExtends_TypeDecl_list == null) {
            lookupWildcardExtends_TypeDecl_list = new List();
            lookupWildcardExtends_TypeDecl_list.is$Final = true;
            lookupWildcardExtends_TypeDecl_list.setParent(this);
        }
        lookupWildcardExtends_TypeDecl_list.add(lookupWildcardExtends_TypeDecl_value);
        lookupWildcardExtends_TypeDecl_value.is$Final = true;
        if(true)
            lookupWildcardExtends_TypeDecl_values.put(_parameters, lookupWildcardExtends_TypeDecl_value);
        return lookupWildcardExtends_TypeDecl_value;
    }

    private TypeDecl lookupWildcardExtends_compute(TypeDecl bound)  {
    TypeDecl decl = new WildcardExtendsType(
      new Modifiers(new List().add(new Modifier("public"))),
      "? extends " + bound.fullName(),
      new List(),
      bound.createBoundAccess()
    );
    return decl;
  }

    protected java.util.Map lookupWildcardSuper_TypeDecl_values;
    protected List lookupWildcardSuper_TypeDecl_list;
    // Declared in Generics.jrag at line 1004
    public TypeDecl lookupWildcardSuper(TypeDecl bound) {
        Object _parameters = bound;
if(lookupWildcardSuper_TypeDecl_values == null) lookupWildcardSuper_TypeDecl_values = new java.util.HashMap(4);
        if(lookupWildcardSuper_TypeDecl_values.containsKey(_parameters))
            return (TypeDecl)lookupWildcardSuper_TypeDecl_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        TypeDecl lookupWildcardSuper_TypeDecl_value = lookupWildcardSuper_compute(bound);
        if(lookupWildcardSuper_TypeDecl_list == null) {
            lookupWildcardSuper_TypeDecl_list = new List();
            lookupWildcardSuper_TypeDecl_list.is$Final = true;
            lookupWildcardSuper_TypeDecl_list.setParent(this);
        }
        lookupWildcardSuper_TypeDecl_list.add(lookupWildcardSuper_TypeDecl_value);
        lookupWildcardSuper_TypeDecl_value.is$Final = true;
        if(true)
            lookupWildcardSuper_TypeDecl_values.put(_parameters, lookupWildcardSuper_TypeDecl_value);
        return lookupWildcardSuper_TypeDecl_value;
    }

    private TypeDecl lookupWildcardSuper_compute(TypeDecl bound)  {
    TypeDecl decl = new WildcardSuperType(
      new Modifiers(new List().add(new Modifier("public"))),
      "? super " + bound.fullName(),
      new List(),
      bound.createBoundAccess()
    );
    return decl;
  }

    protected java.util.Map lookupLUBType_ArrayList_values;
    protected List lookupLUBType_ArrayList_list;
    // Declared in Generics.jrag at line 1017
    public LUBType lookupLUBType(ArrayList bounds) {
        Object _parameters = bounds;
if(lookupLUBType_ArrayList_values == null) lookupLUBType_ArrayList_values = new java.util.HashMap(4);
        if(lookupLUBType_ArrayList_values.containsKey(_parameters))
            return (LUBType)lookupLUBType_ArrayList_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        LUBType lookupLUBType_ArrayList_value = lookupLUBType_compute(bounds);
        if(lookupLUBType_ArrayList_list == null) {
            lookupLUBType_ArrayList_list = new List();
            lookupLUBType_ArrayList_list.is$Final = true;
            lookupLUBType_ArrayList_list.setParent(this);
        }
        lookupLUBType_ArrayList_list.add(lookupLUBType_ArrayList_value);
        lookupLUBType_ArrayList_value.is$Final = true;
        if(true)
            lookupLUBType_ArrayList_values.put(_parameters, lookupLUBType_ArrayList_value);
        return lookupLUBType_ArrayList_value;
    }

    private LUBType lookupLUBType_compute(ArrayList bounds)  {
    List boundList = new List();
    StringBuffer name = new StringBuffer();
    for(Iterator iter = bounds.iterator(); iter.hasNext(); ) {
      TypeDecl typeDecl = (TypeDecl)iter.next();
      boundList.add(typeDecl.createBoundAccess());
      name.append("& " + typeDecl.typeName());
    }
    LUBType decl = new LUBType(
      new Modifiers(new List().add(new Modifier("public"))),
      name.toString(),
      new List(),
      boundList
    );
    return decl;
  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
