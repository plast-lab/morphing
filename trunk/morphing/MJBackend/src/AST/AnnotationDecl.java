
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;
// 9.6 Annotation Types
public class AnnotationDecl extends InterfaceDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        getSuperInterfaceIdList_computed = false;
        getSuperInterfaceIdList_value = null;
        flags_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        AnnotationDecl node = (AnnotationDecl)super.clone();
        node.getSuperInterfaceIdList_computed = false;
        node.getSuperInterfaceIdList_value = null;
        node.flags_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          AnnotationDecl node = (AnnotationDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        AnnotationDecl res = (AnnotationDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Annotations.jrag at line 91


  public void typeCheck() {
    super.typeCheck();
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof MethodDecl) {
        MethodDecl m = (MethodDecl)getBodyDecl(i);
        if(!m.type().isValidAnnotationMethodReturnType())
          m.error("invalid type for annotation member");
        if(m.annotationMethodOverride())
          m.error("annotation method overrides " + m.signature());
      }
    }
    if(containsElementOf(this))
      error("cyclic annotation element type");
  }

    // Declared in Annotations.ast at line 3
    // Declared in Annotations.ast line 2

    public AnnotationDecl() {
        super();
        setChild(null, 0);

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);

    }

    // Declared in Annotations.ast at line 14


    // Declared in Annotations.ast line 2
    public AnnotationDecl(Modifiers p0, String p1, List p2) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(new List(), 2);
    }

    // Declared in Annotations.ast at line 21


  protected int numChildren() {
    return 2;
  }

    // Declared in Annotations.ast at line 24

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 63
    public void setModifiers(Modifiers node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(0);
    }

    // Declared in java.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 63
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
    // Declared in java.ast line 63
    public void setBodyDeclList(List list) {
        setChild(list, 1);
    }

    // Declared in java.ast at line 6


    public int getNumBodyDecl() {
        return getBodyDeclList().getNumChild();
    }

    // Declared in java.ast at line 10


    public BodyDecl getBodyDecl(int i) {
        return (BodyDecl)getBodyDeclList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addBodyDecl(BodyDecl node) {
        List list = getBodyDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setBodyDecl(BodyDecl node, int i) {
        List list = getBodyDeclList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getBodyDeclList() {
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 2
    public void setSuperInterfaceIdList(List list) {
        setChild(list, 2);
    }

    // Declared in Annotations.ast at line 6


    public int getNumSuperInterfaceId() {
        return getSuperInterfaceIdList().getNumChild();
    }

    // Declared in Annotations.ast at line 10


    public Access getSuperInterfaceId(int i) {
        return (Access)getSuperInterfaceIdList().getChild(i);
    }

    // Declared in Annotations.ast at line 14


    public void addSuperInterfaceId(Access node) {
        List list = getSuperInterfaceIdList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Annotations.ast at line 19


    public void setSuperInterfaceId(Access node, int i) {
        List list = getSuperInterfaceIdList();
        list.setChild(node, i);
    }

    // Declared in Annotations.ast at line 23

    public List getSuperInterfaceIdListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in Annotations.ast at line 27


    protected int getSuperInterfaceIdListChildPosition() {
        return 2;
    }

    protected boolean getSuperInterfaceIdList_computed = false;
    protected List getSuperInterfaceIdList_value;
    // Declared in Annotations.jrag at line 87
    public List getSuperInterfaceIdList() {
        if(getSuperInterfaceIdList_computed)
            return (List)ASTNode.getChild(this, getSuperInterfaceIdListChildPosition());
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        getSuperInterfaceIdList_value = getSuperInterfaceIdList_compute();
        setSuperInterfaceIdList(getSuperInterfaceIdList_value);
        if(isFinal && num == boundariesCrossed)
            getSuperInterfaceIdList_computed = true;
        return (List)ASTNode.getChild(this, getSuperInterfaceIdListChildPosition());
    }

    private List getSuperInterfaceIdList_compute()  {
    return new List().add(new TypeAccess("java.lang.annotation", "Annotation"));
  }

    // Declared in Annotations.jrag at line 122
    public boolean isValidAnnotationMethodReturnType() {
        boolean isValidAnnotationMethodReturnType_value = isValidAnnotationMethodReturnType_compute();
        return isValidAnnotationMethodReturnType_value;
    }

    private boolean isValidAnnotationMethodReturnType_compute() {  return  true;  }

    protected java.util.Set containsElementOf_TypeDecl_visited;
    protected java.util.Set containsElementOf_TypeDecl_computed = new java.util.HashSet(4);
    protected java.util.Set containsElementOf_TypeDecl_initialized = new java.util.HashSet(4);
    protected java.util.Map containsElementOf_TypeDecl_values = new java.util.HashMap(4);
    public boolean containsElementOf(TypeDecl typeDecl) {
        Object _parameters = typeDecl;
if(containsElementOf_TypeDecl_visited == null) containsElementOf_TypeDecl_visited = new java.util.HashSet(4);
if(containsElementOf_TypeDecl_values == null) containsElementOf_TypeDecl_values = new java.util.HashMap(4);
        if(containsElementOf_TypeDecl_computed.contains(_parameters))
            return ((Boolean)containsElementOf_TypeDecl_values.get(_parameters)).booleanValue();
        if (!containsElementOf_TypeDecl_initialized.contains(_parameters)) {
            containsElementOf_TypeDecl_initialized.add(_parameters);
            containsElementOf_TypeDecl_values.put(_parameters, Boolean.valueOf(false));
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            containsElementOf_TypeDecl_visited.add(_parameters);
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            boolean new_containsElementOf_TypeDecl_value;
            do {
                CHANGE = false;
                new_containsElementOf_TypeDecl_value = containsElementOf_compute(typeDecl);
                if (new_containsElementOf_TypeDecl_value!=((Boolean)containsElementOf_TypeDecl_values.get(_parameters)).booleanValue())
                    CHANGE = true;
                containsElementOf_TypeDecl_values.put(_parameters, Boolean.valueOf(new_containsElementOf_TypeDecl_value));
            } while (CHANGE);
            containsElementOf_TypeDecl_visited.remove(_parameters);
            if(isFinal && num == boundariesCrossed)
{
            containsElementOf_TypeDecl_computed.add(_parameters);
            }
            else {
            RESET_CYCLE = true;
            containsElementOf_compute(typeDecl);
            RESET_CYCLE = false;
            containsElementOf_TypeDecl_computed.remove(_parameters);
            containsElementOf_TypeDecl_initialized.remove(_parameters);
            }
            IN_CIRCLE = false; 
            return new_containsElementOf_TypeDecl_value;
        }
        if(!containsElementOf_TypeDecl_visited.contains(_parameters)) {
            if (RESET_CYCLE) {
                containsElementOf_TypeDecl_computed.remove(_parameters);
                containsElementOf_TypeDecl_initialized.remove(_parameters);
                return ((Boolean)containsElementOf_TypeDecl_values.get(_parameters)).booleanValue();
            }
            containsElementOf_TypeDecl_visited.add(_parameters);
            boolean new_containsElementOf_TypeDecl_value = containsElementOf_compute(typeDecl);
            if (new_containsElementOf_TypeDecl_value!=((Boolean)containsElementOf_TypeDecl_values.get(_parameters)).booleanValue())
                CHANGE = true;
            containsElementOf_TypeDecl_values.put(_parameters, Boolean.valueOf(new_containsElementOf_TypeDecl_value));
            containsElementOf_TypeDecl_visited.remove(_parameters);
            return new_containsElementOf_TypeDecl_value;
        }
        return ((Boolean)containsElementOf_TypeDecl_values.get(_parameters)).booleanValue();
    }

    private boolean containsElementOf_compute(TypeDecl typeDecl)  {
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof MethodDecl) {
        MethodDecl m = (MethodDecl)getBodyDecl(i);
        if(m.type() == typeDecl)
          return true;
        if(m.type() instanceof AnnotationDecl && ((AnnotationDecl)m.type()).containsElementOf(typeDecl))
          return true;
      }
    }
    return false;
  }

    // Declared in Annotations.jrag at line 538
    public boolean isAnnotationDecl() {
        boolean isAnnotationDecl_value = isAnnotationDecl_compute();
        return isAnnotationDecl_value;
    }

    private boolean isAnnotationDecl_compute() {  return  true;  }

    // Declared in AnnotationsCodegen.jrag at line 134
    public int flags() {
        if(flags_computed)
            return flags_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        flags_value = flags_compute();
        if(isFinal && num == boundariesCrossed)
            flags_computed = true;
        return flags_value;
    }

    private int flags_compute() {  return  super.flags() | Modifiers.ACC_ANNOTATION;  }

    // Declared in Annotations.jrag at line 66
    public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
        if(caller == getModifiersNoTransform()) {
            return 
    name.equals("ANNOTATION_TYPE") || name.equals("TYPE");
        }
        return super.Define_boolean_mayUseAnnotationTarget(caller, child, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
