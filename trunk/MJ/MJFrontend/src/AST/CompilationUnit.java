
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// 7.3 Compilation Units
public class CompilationUnit extends ASTNode implements Cloneable {
    public void flushCache() {
        super.flushCache();
        localLookupType_String_values = null;
        packageName_computed = false;
        packageName_value = null;
        lookupType_String_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        CompilationUnit node = (CompilationUnit)super.clone();
        node.localLookupType_String_values = null;
        node.packageName_computed = false;
        node.packageName_value = null;
        node.lookupType_String_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          CompilationUnit node = (CompilationUnit)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        CompilationUnit res = (CompilationUnit)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ClassPath.jrag at line 125


  private String relativeName;

    // Declared in ClassPath.jrag at line 126

  private String pathName;

    // Declared in ClassPath.jrag at line 127

  private boolean fromSource;

    // Declared in ClassPath.jrag at line 129


  public void setRelativeName(String name) {
    relativeName = name;
  }

    // Declared in ClassPath.jrag at line 132

  public void setPathName(String name) {
    pathName = name;
  }

    // Declared in ClassPath.jrag at line 135

  public void setFromSource(boolean value) {
    fromSource = value;
  }

    // Declared in ErrorCheck.jrag at line 63


  protected java.util.ArrayList errors = new java.util.ArrayList();

    // Declared in ErrorCheck.jrag at line 64

  protected java.util.ArrayList warnings = new java.util.ArrayList();

    // Declared in ErrorCheck.jrag at line 66


  public Collection parseErrors() { return parseErrors; }

    // Declared in ErrorCheck.jrag at line 67

  public void addParseError(Problem msg) { parseErrors.add(msg); }

    // Declared in ErrorCheck.jrag at line 68

  protected Collection parseErrors = new ArrayList();

    // Declared in ErrorCheck.jrag at line 226


  public void errorCheck(Collection collection) {
    collectErrors();
    collection.addAll(errors);
  }

    // Declared in ErrorCheck.jrag at line 230

  public void errorCheck(Collection err, Collection warn) {
    collectErrors();
    err.addAll(errors);
    warn.addAll(warnings);
  }

    // Declared in NameCheck.jrag at line 23


  public void refined_NameCheck_nameCheck() {
    for(int i = 0; i < getNumImportDecl(); i++) {
      ImportDecl decl = getImportDecl(i);
      if(decl instanceof SingleTypeImportDecl) {
        if(!localLookupType(decl.getAccess().type().name()).contains(decl.getAccess().type()))
          error("" + decl + " is conflicting with visible type");
      }
    }
  }

    // Declared in PrettyPrint.jadd at line 34

        
  public void toString(StringBuffer s) {
    try {
      if(!getPackageDecl().equals("")) {
        s.append("package " + getPackageDecl() + ";\n");
      }
      for(int i = 0; i < getNumImportDecl(); i++) {
        getImportDecl(i).toString(s);
        s.append("\n");
      }
      for(int i = 0; i < getNumTypeDecl(); i++) {
        getTypeDecl(i).toString(s);
        s.append("\n");
      }
    } catch (NullPointerException e) {
      System.out.print("Error in compilation unit hosting " + getTypeDecl(0).typeName());
      throw e;
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 4

    public CompilationUnit() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 1);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 4
    public CompilationUnit(String p0, List p1, List p2) {
        setPackageDecl(p0);
        setChild(p1, 0);
        setChild(p2, 1);
    }

    // Declared in java.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in java.ast at line 21

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

    // Declared in StaticImports.jrag at line 158


  /* A single-static-import declaration d in a compilation unit c of package p that
  imports a type named n shadows the declarations of:
    * any static type named n imported by a static-import-on-demand declaration in c.
    * any top level type (\ufffd7.6) named n declared in another compilation unit (\ufffd7.3) of p.
    * any type named n imported by a type-import-on-demand declaration (\ufffd7.5.2) in c. 
  throughout c.
  Comment: already implemented by original type lookup
  */

  /* Note that it is permissable for one single-static-import declaration to import
  several fields or types with the same name, or several methods with the same
  name and signature.
  Comment: Name analysis already deals with sets*/

  /* If a compilation unit contains both a single-static-import (\ufffd7.5.3) declaration
  that imports a type whose simple name is n, and a single-type-import
  declaration (\ufffd7.5.1) that imports a type whose simple name is n, a compile-time
  error occurs.
  Comment: javac6 interprets this as "another" type whose simple name is n. Then
  nothing needs to be done.
  */

  /* If a single-static-import declaration imports a type whose simple name is n,
  and the compilation unit also declares a top level type (\ufffd7.6) whose simple
  name is n, a compile-time error occurs.*/
    public void nameCheck() {
    refined_NameCheck_nameCheck();
    for(int i = 0; i < getNumImportDecl(); i++) {
      if(getImportDecl(i) instanceof SingleStaticImportDecl) {
        SingleStaticImportDecl decl = (SingleStaticImportDecl)getImportDecl(i);
        String name = decl.name();
        if(!decl.importedTypes(name).isEmpty()) {
          TypeDecl type = (TypeDecl)decl.importedTypes(name).iterator().next();
          if(!localLookupType(name).contains(type))
            decl.error(packageName() + "." + name + " is already defined in this compilation unit");
        }
      }
    }
  }

    // Declared in LookupType.jrag at line 181
private SimpleSet refined_LookupType_TypeDecl_lookupType_String(int childIndex, String name)
 {
    SimpleSet set = SimpleSet.emptySet;
    for(Iterator iter = localLookupType(name).iterator(); iter.hasNext(); ) {
      TypeDecl t = (TypeDecl)iter.next();
      if(t.accessibleFromPackage(packageName()))
        set = set.add(t);
    }
    return set;
  }

    // Declared in ClassPath.jrag at line 18
    public String relativeName() {
        String relativeName_value = relativeName_compute();
        return relativeName_value;
    }

    private String relativeName_compute() {  return  relativeName;  }

    // Declared in ClassPath.jrag at line 19
    public String pathName() {
        String pathName_value = pathName_compute();
        return pathName_value;
    }

    private String pathName_compute() {  return  pathName;  }

    // Declared in ClassPath.jrag at line 20
    public boolean fromSource() {
        boolean fromSource_value = fromSource_compute();
        return fromSource_value;
    }

    private boolean fromSource_compute() {  return  fromSource;  }

    protected java.util.Map localLookupType_String_values;
    // Declared in LookupType.jrag at line 388
    public SimpleSet localLookupType(String name) {
        Object _parameters = name;
if(localLookupType_String_values == null) localLookupType_String_values = new java.util.HashMap(4);
        if(localLookupType_String_values.containsKey(_parameters))
            return (SimpleSet)localLookupType_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet localLookupType_String_value = localLookupType_compute(name);
        if(isFinal && num == boundariesCrossed)
            localLookupType_String_values.put(_parameters, localLookupType_String_value);
        return localLookupType_String_value;
    }

    private SimpleSet localLookupType_compute(String name)  {
    for(int i = 0; i < getNumTypeDecl(); i++) {
      if(getTypeDecl(i).name().equals(name))
        return SimpleSet.emptySet.add(getTypeDecl(i));
    }
  
    SimpleSet set = SimpleSet.emptySet;
    // The scope of a type imported by a single-type-import declaration
    for(int i = 0; i < getNumImportDecl(); i++) {
      if(!getImportDecl(i).isOnDemand())
        for(Iterator iter = getImportDecl(i).importedTypes(name).iterator(); iter.hasNext(); )
          set = set.add(iter.next());
    }
    if(!set.isEmpty()) return set;
    
    TypeDecl result = lookupType(packageName(), name);
    if(result != null)
      return SimpleSet.emptySet.add(result);
    
    // The scope of a type imported by a type-import-on-demand declaration
    for(int i = 0; i < getNumImportDecl(); i++) {
      if(getImportDecl(i).isOnDemand())
        for(Iterator iter = getImportDecl(i).importedTypes(name).iterator(); iter.hasNext(); )
          set = set.add(iter.next());
    }
    if(!set.isEmpty()) return set;
    
    result = lookupType(PRIMITIVE_PACKAGE_NAME, name);
    if(result != null) {
      set = set.add(result);
      //throw new Error("Found an unexpected lookup for primitive type " + name);
      return set;
    }
    
    // 7.5.5 Automatic Imports
    result = lookupType("java.lang", name);
    if(result != null) {
      set = set.add(result);
      return set;
    }
    return set;
  }

    // Declared in PrettyPrint.jadd at line 936
    public String dumpString() {
        String dumpString_value = dumpString_compute();
        return dumpString_value;
    }

    private String dumpString_compute() {  return  getClass().getName() + " [" + getPackageDecl() + "]";  }

    protected boolean packageName_computed = false;
    protected String packageName_value;
    // Declared in QualifiedNames.jrag at line 83
    public String packageName() {
        if(packageName_computed)
            return packageName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        packageName_value = packageName_compute();
        if(isFinal && num == boundariesCrossed)
            packageName_computed = true;
        return packageName_value;
    }

    private String packageName_compute() {  return  getPackageDecl();  }

    // Declared in LookupType.jrag at line 89
    public TypeDecl lookupType(String packageName, String typeName) {
        TypeDecl lookupType_String_String_value = getParent().Define_TypeDecl_lookupType(this, null, packageName, typeName);
        return lookupType_String_String_value;
    }

    protected java.util.Map lookupType_String_values;
    // Declared in LookupType.jrag at line 172
    public SimpleSet lookupType(String name) {
        Object _parameters = name;
if(lookupType_String_values == null) lookupType_String_values = new java.util.HashMap(4);
        if(lookupType_String_values.containsKey(_parameters))
            return (SimpleSet)lookupType_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet lookupType_String_value = getParent().Define_SimpleSet_lookupType(this, null, name);
        if(isFinal && num == boundariesCrossed)
            lookupType_String_values.put(_parameters, lookupType_String_value);
        return lookupType_String_value;
    }

    // Declared in StaticImports.jrag at line 111
    public SimpleSet lookupVariable(String name) {
        SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);
        return lookupVariable_String_value;
    }

    // Declared in StaticImports.jrag at line 131
    public Collection lookupMethod(String name) {
        Collection lookupMethod_String_value = getParent().Define_Collection_lookupMethod(this, null, name);
        return lookupMethod_String_value;
    }

    // Declared in StaticImports.jrag at line 117
    public Collection Define_Collection_lookupMethod(ASTNode caller, ASTNode child, String name) {
        if(caller == getTypeDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    Collection list = new ArrayList();
    for(int i = 0; i < getNumImportDecl(); i++)
      if(!getImportDecl(i).isOnDemand())
        list.addAll(getImportDecl(i).importedMethods(name));
    if(!list.isEmpty()) 
      return list;
    for(int i = 0; i < getNumImportDecl(); i++)
      if(getImportDecl(i).isOnDemand())
        list.addAll(getImportDecl(i).importedMethods(name));
    if(!list.isEmpty())
      return list;
    return lookupMethod(name);
  }
}
        return getParent().Define_Collection_lookupMethod(this, caller, name);
    }

    // Declared in TypeAnalysis.jrag at line 491
    public TypeDecl Define_TypeDecl_enclosingType(ASTNode caller, ASTNode child) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  null;
        }
        return getParent().Define_TypeDecl_enclosingType(this, caller);
    }

    // Declared in StaticImports.jrag at line 95
    public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
        if(caller == getTypeDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    SimpleSet set = SimpleSet.emptySet;
    for(int i = 0; i < getNumImportDecl(); i++)
      if(!getImportDecl(i).isOnDemand())
        for(Iterator iter = getImportDecl(i).importedFields(name).iterator(); iter.hasNext(); )
          set = set.add(iter.next());
    if(!set.isEmpty())
      return set;
    for(int i = 0; i < getNumImportDecl(); i++)
      if(getImportDecl(i).isOnDemand())
        for(Iterator iter = getImportDecl(i).importedFields(name).iterator(); iter.hasNext(); )
          set = set.add(iter.next());
    if(!set.isEmpty())
      return set;
    return lookupVariable(name);
  }
}
        return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }

    // Declared in StaticImports.jrag at line 175
    public boolean Define_boolean_handlesException(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
        if(caller == getImportDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    return !exceptionType.isUncheckedException();
  }
}
        if(caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return 
    !exceptionType.isUncheckedException();
        }
        return getParent().Define_boolean_handlesException(this, caller, exceptionType);
    }

    // Declared in TypeAnalysis.jrag at line 556
    public String Define_String_hostPackage(ASTNode caller, ASTNode child) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  packageName();
        }
        return getParent().Define_String_hostPackage(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 572
    public TypeDecl Define_TypeDecl_hostType(ASTNode caller, ASTNode child) {
        if(caller == getImportDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  null;
        }
        return getParent().Define_TypeDecl_hostType(this, caller);
    }

    // Declared in LookupType.jrag at line 203
    public SimpleSet Define_SimpleSet_lookupImport(ASTNode caller, ASTNode child, String name) {
        if(caller == getImportDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    for(int i = 0; i < getNumImportDecl(); i++)
      if(!getImportDecl(i).isOnDemand())
        for(Iterator iter = getImportDecl(i).importedTypes(name).iterator(); iter.hasNext(); )
          return SimpleSet.emptySet.add(iter.next());
    return SimpleSet.emptySet;
  }
}
        return getParent().Define_SimpleSet_lookupImport(this, caller, name);
    }

    // Declared in QualifiedNames.jrag at line 81
    public String Define_String_packageName(ASTNode caller, ASTNode child) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  packageName();
        }
        return getParent().Define_String_packageName(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 522
    public boolean Define_boolean_isMemberType(ASTNode caller, ASTNode child) {
        if(caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isMemberType(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 40
    public boolean Define_boolean_isIncOrDec(ASTNode caller, ASTNode child) {
        if(caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isIncOrDec(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 534
    public boolean Define_boolean_isLocalClass(ASTNode caller, ASTNode child) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  false;
        }
        return getParent().Define_boolean_isLocalClass(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 512
    public boolean Define_boolean_isNestedType(ASTNode caller, ASTNode child) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  false;
        }
        return getParent().Define_boolean_isNestedType(this, caller);
    }

    // Declared in SyntacticClassification.jrag at line 59
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getImportDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.PACKAGE_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in LookupType.jrag at line 192
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(caller == getImportDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    /*
    for(int i = 0; i < getNumImportDecl(); i++)
      if(!getImportDecl(i).isOnDemand())
        for(Iterator iter = getImportDecl(i).importedTypes(name).iterator(); iter.hasNext(); )
          return SimpleSet.emptySet.add(iter.next());
    */
    return lookupType(name);
  }
}
        if(caller == getTypeDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    SimpleSet result = SimpleSet.emptySet;
    for(Iterator iter = refined_LookupType_TypeDecl_lookupType_String(childIndex, name).iterator(); iter.hasNext(); ) {
      TypeDecl typeDecl = (TypeDecl)iter.next();
      if(typeDecl instanceof ParTypeDecl)
        result = result.add(((ParTypeDecl)typeDecl).genericDecl());
      else
        result = result.add(typeDecl);
    }
    return result;
  }
}
        return getParent().Define_SimpleSet_lookupType(this, caller, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
