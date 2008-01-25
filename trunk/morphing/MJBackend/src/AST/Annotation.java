
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// 9.7 Annotations
public class Annotation extends Modifier implements Cloneable {
    public void flushCache() {
        super.flushCache();
        decl_computed = false;
        decl_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        Annotation node = (Annotation)super.clone();
        node.decl_computed = false;
        node.decl_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          Annotation node = (Annotation)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Annotation res = (Annotation)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Annotations.jrag at line 32


  // 9.6 Annotation Types
  
  /* The Identifier in an annotation type declaration specifies the name of the
  annotation type. A compile-time error occurs if an annotation type has the same
  simple name as any of its enclosing classes or interfaces.
  Comment: This is common for all type declarations and need thus no specific
  implementation. */

  // 9.6.1.1

  /* If an annotation a on an annotation declaration corresponds to an
  annotation type T, and T has a (meta-)annotation m that corresponds to
  annotation.Target, then m must have either an element whose matches the 
  annotated declaration, or a compile-time error occurs.*/
  public void checkModifiers() {
    super.checkModifiers();
    if(decl() instanceof AnnotationDecl) {
      AnnotationDecl T = (AnnotationDecl)decl();
      Annotation m = T.annotation("java.lang.annotation", "Target");
      if(m != null && m.getNumElementValuePair() == 1 && m.getElementValuePair(0).getName().equals("value")) {
        ElementValue v = m.getElementValuePair(0).getElementValue();
        //System.out.println("ElementValue: \n" + v.dumpTree());
        //System.out.println("Annotation: \n" + dumpTree());
        if(!v.validTarget(this))
          error("annotation type " + T.typeName() + " is not applicable to this kind of declaration");
      }
    }
  }

    // Declared in Annotations.jrag at line 215

  public Annotation searchAnnotation(String name) {
    return type().fullName().equals(name) ? this : super.searchAnnotation(name);
  }

    // Declared in Annotations.jrag at line 237


  // 9.6.1.4 Override
  public void checkOverride() {
    if(decl().fullName().equals("java.lang.Override") && enclosingBodyDecl() instanceof MethodDecl) {
      MethodDecl m = (MethodDecl)enclosingBodyDecl();
      if(!m.hostType().isClassDecl())
        error("override annotation not valid for interface methods");
      else {
        boolean found = false;
        for(Iterator iter = m.hostType().ancestorMethods(m.signature()).iterator(); iter.hasNext(); ) {
          MethodDecl decl = (MethodDecl)iter.next();
          if(m.overrides(decl) && decl.hostType().isClassDecl())
            found = true;
        }
        if(!found)
          error("method does not override a method from its superclass");
      }
    }
  }

    // Declared in Annotations.jrag at line 379


  // 9.7 Annotations

  public void typeCheck() {
    if(!decl().isAnnotationDecl()) {
      /* TypeName names the annotation type corresponding to the annotation. It is a
      compile-time error if TypeName does not name an annotation type.*/
      if(!decl().isUnknown())
        error(decl().typeName() + " is not an annotation type");
    } else {
      TypeDecl typeDecl = decl();
      /* It is a compile-time error if a declaration is annotated with more than one
      annotation for a given annotation type.*/
      if(lookupAnnotation(typeDecl) != this)
        error("duplicate annotation " + typeDecl.typeName());
      /* Annotations must contain an element-value pair for every element of the
      corresponding annotation type, except for those elements with default
      values, or a compile-time error occurs. Annotations may, but are not
      required to, contain element-value pairs for elements with default values.*/
      for(int i = 0; i < typeDecl.getNumBodyDecl(); i++) {
        if(typeDecl.getBodyDecl(i) instanceof MethodDecl) {
          MethodDecl decl = (MethodDecl)typeDecl.getBodyDecl(i);
          if(elementValueFor(decl.name()) == null && (!(decl instanceof AnnotationMethodDecl) || !((AnnotationMethodDecl)decl).hasDefaultValue()))
            error("missing value for " + decl.name());
        }
      }
      /* The Identifier in an ElementValuePair must be the simple name of one of the
      elements of the annotation type identified by TypeName in the containing
      annotation. Otherwise, a compile-time error occurs. (In other words, the
      identifier in an element-value pair must also be a method name in the interface
      identified by TypeName.) */
      for(int i = 0; i < getNumElementValuePair(); i++) {
        ElementValuePair pair = getElementValuePair(i);
        if(typeDecl.memberMethods(pair.getName()).isEmpty())
          error("can not find element named " + pair.getName() + " in " + typeDecl.typeName());
      }
    }
    checkOverride();
  }

    // Declared in AnnotationsCodegen.jrag at line 148


  // 4.8.15
  public void appendAsAttributeTo(Attribute buf) {
    ConstantPool cp = hostType().constantPool();
    int type_index = cp.addUtf8(decl().typeDescriptor());
    buf.u2(type_index);
    buf.u2(getNumElementValuePair());
    for(int i = 0; i < getNumElementValuePair(); i++) {
      int name_index = cp.addUtf8(getElementValuePair(i).getName());
      buf.u2(name_index);
      getElementValuePair(i).getElementValue().appendAsAttributeTo(buf);
    }
  }

    // Declared in Annotations.ast at line 3
    // Declared in Annotations.ast line 6

    public Annotation() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);

    }

    // Declared in Annotations.ast at line 12


    // Declared in Annotations.ast line 6
    public Annotation(String p0, Access p1, List p2) {
        setID(p0);
        setChild(p1, 0);
        setChild(p2, 1);
    }

    // Declared in Annotations.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in Annotations.ast at line 21

  public boolean mayHaveRewrite() { return false; }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 6
    private String tokenString_ID;

    // Declared in Annotations.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in Annotations.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 6
    public void setAccess(Access node) {
        setChild(node, 0);
    }

    // Declared in Annotations.ast at line 5

    public Access getAccess() {
        return (Access)getChild(0);
    }

    // Declared in Annotations.ast at line 9


    public Access getAccessNoTransform() {
        return (Access)getChildNoTransform(0);
    }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 6
    public void setElementValuePairList(List list) {
        setChild(list, 1);
    }

    // Declared in Annotations.ast at line 6


    public int getNumElementValuePair() {
        return getElementValuePairList().getNumChild();
    }

    // Declared in Annotations.ast at line 10


    public ElementValuePair getElementValuePair(int i) {
        return (ElementValuePair)getElementValuePairList().getChild(i);
    }

    // Declared in Annotations.ast at line 14


    public void addElementValuePair(ElementValuePair node) {
        List list = getElementValuePairList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Annotations.ast at line 19


    public void setElementValuePair(ElementValuePair node, int i) {
        List list = getElementValuePairList();
        list.setChild(node, i);
    }

    // Declared in Annotations.ast at line 23

    public List getElementValuePairList() {
        return (List)getChild(1);
    }

    // Declared in Annotations.ast at line 27


    public List getElementValuePairListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    protected boolean decl_computed = false;
    protected TypeDecl decl_value;
    // Declared in Annotations.jrag at line 416
    public TypeDecl decl() {
        if(decl_computed)
            return decl_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        decl_value = decl_compute();
        if(isFinal && num == boundariesCrossed)
            decl_computed = true;
        return decl_value;
    }

    private TypeDecl decl_compute() {  return  getAccess().type();  }

    // Declared in Annotations.jrag at line 428
    public ElementValue elementValueFor(String name) {
        ElementValue elementValueFor_String_value = elementValueFor_compute(name);
        return elementValueFor_String_value;
    }

    private ElementValue elementValueFor_compute(String name)  {
    for(int i = 0; i < getNumElementValuePair(); i++) {
      ElementValuePair pair = getElementValuePair(i);
      if(pair.getName().equals(name))
        return pair.getElementValue();
    }
    return null;
  }

    // Declared in Annotations.jrag at line 506
    public TypeDecl type() {
        TypeDecl type_value = type_compute();
        return type_value;
    }

    private TypeDecl type_compute() {  return  getAccess().type();  }

    // Declared in Annotations.jrag at line 535
    public boolean isMetaAnnotation() {
        boolean isMetaAnnotation_value = isMetaAnnotation_compute();
        return isMetaAnnotation_value;
    }

    private boolean isMetaAnnotation_compute() {  return  hostType().isAnnotationDecl();  }

    // Declared in AnnotationsCodegen.jrag at line 58
    public boolean isRuntimeVisible() {
        boolean isRuntimeVisible_value = isRuntimeVisible_compute();
        return isRuntimeVisible_value;
    }

    private boolean isRuntimeVisible_compute()  {
    Annotation a = decl().annotation("java.lang.annotation", "Retention");
    if(a == null) return false;
    ElementConstantValue value = (ElementConstantValue)a.getElementValuePair(0).getElementValue();
    Variable v = value.getExpr().varDecl();
    return v != null && v.name().equals("RUNTIME");
  }

    // Declared in AnnotationsCodegen.jrag at line 68
    public boolean isRuntimeInvisible() {
        boolean isRuntimeInvisible_value = isRuntimeInvisible_compute();
        return isRuntimeInvisible_value;
    }

    private boolean isRuntimeInvisible_compute()  {
    Annotation a = decl().annotation("java.lang.annotation", "Retention");
    if(a == null) return true; // default bahavior if not annotated
    ElementConstantValue value = (ElementConstantValue)a.getElementValuePair(0).getElementValue();
    Variable v = value.getExpr().varDecl();
    return v != null &&  v.name().equals("CLASS");
  }

    // Declared in Annotations.jrag at line 58
    public boolean mayUseAnnotationTarget(String name) {
        boolean mayUseAnnotationTarget_String_value = getParent().Define_boolean_mayUseAnnotationTarget(this, null, name);
        return mayUseAnnotationTarget_String_value;
    }

    // Declared in Annotations.jrag at line 254
    public BodyDecl enclosingBodyDecl() {
        BodyDecl enclosingBodyDecl_value = getParent().Define_BodyDecl_enclosingBodyDecl(this, null);
        return enclosingBodyDecl_value;
    }

    // Declared in Annotations.jrag at line 418
    public Annotation lookupAnnotation(TypeDecl typeDecl) {
        Annotation lookupAnnotation_TypeDecl_value = getParent().Define_Annotation_lookupAnnotation(this, null, typeDecl);
        return lookupAnnotation_TypeDecl_value;
    }

    // Declared in Annotations.jrag at line 536
    public TypeDecl hostType() {
        TypeDecl hostType_value = getParent().Define_TypeDecl_hostType(this, null);
        return hostType_value;
    }

    // Declared in Annotations.jrag at line 456
    public TypeDecl Define_TypeDecl_enclosingAnnotationDecl(ASTNode caller, ASTNode child) {
        if(caller == getElementValuePairListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  decl();
        }
        return getParent().Define_TypeDecl_enclosingAnnotationDecl(this, caller);
    }

    // Declared in Annotations.jrag at line 541
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
