
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public abstract class ElementValue extends ASTNode implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        ElementValue node = (ElementValue)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in AnnotationsCodegen.jrag at line 161


  // 4.8.15.1
  public void appendAsAttributeTo(Attribute buf) {
    throw new Error(getClass().getName() + " does not support appendAsAttributeTo(Attribute buf)");
  }

    // Declared in Annotations.ast at line 3
    // Declared in Annotations.ast line 10

    public ElementValue() {
        super();


    }

    // Declared in Annotations.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in Annotations.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    // Declared in Annotations.jrag at line 46
    public boolean validTarget(Annotation a) {
        boolean validTarget_Annotation_value = validTarget_compute(a);
        return validTarget_Annotation_value;
    }

    private boolean validTarget_compute(Annotation a) {  return  false;  }

    // Declared in Annotations.jrag at line 169
    public ElementValue definesElementTypeValue(String name) {
        ElementValue definesElementTypeValue_String_value = definesElementTypeValue_compute(name);
        return definesElementTypeValue_String_value;
    }

    private ElementValue definesElementTypeValue_compute(String name) {  return  null;  }

    // Declared in Annotations.jrag at line 291
    public boolean hasValue(String s) {
        boolean hasValue_String_value = hasValue_compute(s);
        return hasValue_String_value;
    }

    private boolean hasValue_compute(String s) {  return  false;  }

    // Declared in Annotations.jrag at line 469
    public boolean commensurateWithTypeDecl(TypeDecl type) {
        boolean commensurateWithTypeDecl_TypeDecl_value = commensurateWithTypeDecl_compute(type);
        return commensurateWithTypeDecl_TypeDecl_value;
    }

    private boolean commensurateWithTypeDecl_compute(TypeDecl type) {  return  false;  }

    // Declared in Annotations.jrag at line 489
    public boolean commensurateWithArrayDecl(ArrayDecl type) {
        boolean commensurateWithArrayDecl_ArrayDecl_value = commensurateWithArrayDecl_compute(type);
        return commensurateWithArrayDecl_ArrayDecl_value;
    }

    private boolean commensurateWithArrayDecl_compute(ArrayDecl type) {  return  
    type.componentType().commensurateWith(this);  }

    // Declared in Annotations.jrag at line 502
    public TypeDecl type() {
        TypeDecl type_value = type_compute();
        return type_value;
    }

    private TypeDecl type_compute() {  return  unknownType();  }

    // Declared in Annotations.jrag at line 455
    public TypeDecl enclosingAnnotationDecl() {
        TypeDecl enclosingAnnotationDecl_value = getParent().Define_TypeDecl_enclosingAnnotationDecl(this, null);
        return enclosingAnnotationDecl_value;
    }

    // Declared in Annotations.jrag at line 507
    public TypeDecl unknownType() {
        TypeDecl unknownType_value = getParent().Define_TypeDecl_unknownType(this, null);
        return unknownType_value;
    }

    // Declared in AnnotationsCodegen.jrag at line 198
    public TypeDecl hostType() {
        TypeDecl hostType_value = getParent().Define_TypeDecl_hostType(this, null);
        return hostType_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
