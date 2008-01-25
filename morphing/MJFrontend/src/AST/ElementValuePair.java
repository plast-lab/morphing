
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class ElementValuePair extends ASTNode implements Cloneable {
    public void flushCache() {
        super.flushCache();
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ElementValuePair node = (ElementValuePair)super.clone();
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ElementValuePair node = (ElementValuePair)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ElementValuePair res = (ElementValuePair)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Annotations.jrag at line 498

  /* It is a compile-time error if the element type is not commensurate with the ElementValue.*/
  public void typeCheck() {
    if(!type().commensurateWith(getElementValue()))
      error(type().typeName() + " is not commensurate with " + getElementValue().type().typeName());
  }

    // Declared in Annotations.ast at line 3
    // Declared in Annotations.ast line 8

    public ElementValuePair() {
        super();

        setChild(null, 0);

    }

    // Declared in Annotations.ast at line 11


    // Declared in Annotations.ast line 8
    public ElementValuePair(String p0, ElementValue p1) {
        setName(p0);
        setChild(p1, 0);
    }

    // Declared in Annotations.ast at line 16


  protected int numChildren() {
    return 1;
  }

    // Declared in Annotations.ast at line 19

  public boolean mayHaveRewrite() { return true; }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 8
    private String tokenString_Name;

    // Declared in Annotations.ast at line 3

    public void setName(String value) {
        tokenString_Name = value;
    }

    // Declared in Annotations.ast at line 6

    public String getName() {
        return tokenString_Name;
    }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 8
    public void setElementValue(ElementValue node) {
        setChild(node, 0);
    }

    // Declared in Annotations.ast at line 5

    public ElementValue getElementValue() {
        return (ElementValue)getChild(0);
    }

    // Declared in Annotations.ast at line 9


    public ElementValue getElementValueNoTransform() {
        return (ElementValue)getChildNoTransform(0);
    }

    protected boolean type_computed = false;
    protected TypeDecl type_value;
    // Declared in Annotations.jrag at line 444
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
    Iterator iter = enclosingAnnotationDecl().memberMethods(getName()).iterator();
    if(iter.hasNext()) {
      MethodDecl m = (MethodDecl)iter.next();
      return m.type();
    }
    return unknownType();
  }

    // Declared in Annotations.jrag at line 452
    public TypeDecl unknownType() {
        TypeDecl unknownType_value = getParent().Define_TypeDecl_unknownType(this, null);
        return unknownType_value;
    }

    // Declared in Annotations.jrag at line 454
    public TypeDecl enclosingAnnotationDecl() {
        TypeDecl enclosingAnnotationDecl_value = getParent().Define_TypeDecl_enclosingAnnotationDecl(this, null);
        return enclosingAnnotationDecl_value;
    }

public ASTNode rewriteTo() {
    // Declared in Annotations.jrag at line 519
    if(type().isArrayDecl() && getElementValue() instanceof ElementConstantValue) {
        duringAnnotations++;
        ASTNode result = rewriteRule0();
        duringAnnotations--;
        return result;
    }

    return super.rewriteTo();
}

    // Declared in Annotations.jrag at line 519
    private ElementValuePair rewriteRule0() {
      setElementValue(new ElementArrayValue(new List().add(getElementValue())));
      return this;
    }
}
