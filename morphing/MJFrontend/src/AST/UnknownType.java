
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class UnknownType extends ClassDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        instanceOf_TypeDecl_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        UnknownType node = (UnknownType)super.clone();
        node.instanceOf_TypeDecl_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          UnknownType node = (UnknownType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        UnknownType res = (UnknownType)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in java.ast at line 3
    // Declared in java.ast line 46

    public UnknownType() {
        super();

        setChild(null, 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);
        setChild(new List(), 3);

    }

    // Declared in java.ast at line 14


    // Declared in java.ast line 46
    public UnknownType(Modifiers p0, String p1, Opt p2, List p3, List p4) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
    }

    // Declared in java.ast at line 22


  protected int numChildren() {
    return 4;
  }

    // Declared in java.ast at line 25

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 62
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
    // Declared in java.ast line 62
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
    // Declared in java.ast line 62
    public void setSuperClassAccessOpt(Opt opt) {
        setChild(opt, 1);
    }

    // Declared in java.ast at line 6


    public boolean hasSuperClassAccess() {
        return getSuperClassAccessOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Access getSuperClassAccess() {
        return (Access)getSuperClassAccessOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setSuperClassAccess(Access node) {
        getSuperClassAccessOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getSuperClassAccessOpt() {
        return (Opt)getChild(1);
    }

    // Declared in java.ast at line 21


    public Opt getSuperClassAccessOptNoTransform() {
        return (Opt)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 62
    public void setImplementsList(List list) {
        setChild(list, 2);
    }

    // Declared in java.ast at line 6


    public int getNumImplements() {
        return getImplementsList().getNumChild();
    }

    // Declared in java.ast at line 10


    public Access getImplements(int i) {
        return (Access)getImplementsList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addImplements(Access node) {
        List list = getImplementsList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setImplements(Access node, int i) {
        List list = getImplementsList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getImplementsList() {
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getImplementsListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 62
    public void setBodyDeclList(List list) {
        setChild(list, 3);
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
        return (List)getChild(3);
    }

    // Declared in java.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(3);
    }

    // Declared in TypeAnalysis.jrag at line 414
private boolean refined_TypeAnalysis_instanceOf_TypeDecl(TypeDecl type)
{ return  true; }

    // Declared in TypeAnalysis.jrag at line 158
    public boolean isReferenceType() {
        boolean isReferenceType_value = isReferenceType_compute();
        return isReferenceType_value;
    }

    private boolean isReferenceType_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 161
    public boolean isPrimitiveType() {
        boolean isPrimitiveType_value = isPrimitiveType_compute();
        return isPrimitiveType_value;
    }

    private boolean isPrimitiveType_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 166
    public boolean isNumericType() {
        boolean isNumericType_value = isNumericType_compute();
        return isNumericType_value;
    }

    private boolean isNumericType_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 170
    public boolean isIntegralType() {
        boolean isIntegralType_value = isIntegralType_compute();
        return isIntegralType_value;
    }

    private boolean isIntegralType_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 174
    public boolean isBoolean() {
        boolean isBoolean_value = isBoolean_compute();
        return isBoolean_value;
    }

    private boolean isBoolean_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 184
    public boolean isInt() {
        boolean isInt_value = isInt_compute();
        return isInt_value;
    }

    private boolean isInt_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 222
    public boolean isUnknown() {
        boolean isUnknown_value = isUnknown_compute();
        return isUnknown_value;
    }

    private boolean isUnknown_compute() {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 214
    public boolean instanceOf(TypeDecl type) {
        Object _parameters = type;
if(instanceOf_TypeDecl_values == null) instanceOf_TypeDecl_values = new java.util.HashMap(4);
        if(instanceOf_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)instanceOf_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean instanceOf_TypeDecl_value = instanceOf_compute(type);
        if(isFinal && num == boundariesCrossed)
            instanceOf_TypeDecl_values.put(_parameters, Boolean.valueOf(instanceOf_TypeDecl_value));
        return instanceOf_TypeDecl_value;
    }

    private boolean instanceOf_compute(TypeDecl type) {  return  subtype(type);  }

    // Declared in TypeAnalysis.jrag at line 415
    public boolean isSupertypeOfClassDecl(ClassDecl type) {
        boolean isSupertypeOfClassDecl_ClassDecl_value = isSupertypeOfClassDecl_compute(type);
        return isSupertypeOfClassDecl_ClassDecl_value;
    }

    private boolean isSupertypeOfClassDecl_compute(ClassDecl type) {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 416
    public boolean isSupertypeOfInterfaceDecl(InterfaceDecl type) {
        boolean isSupertypeOfInterfaceDecl_InterfaceDecl_value = isSupertypeOfInterfaceDecl_compute(type);
        return isSupertypeOfInterfaceDecl_InterfaceDecl_value;
    }

    private boolean isSupertypeOfInterfaceDecl_compute(InterfaceDecl type) {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 417
    public boolean isSupertypeOfArrayDecl(ArrayDecl type) {
        boolean isSupertypeOfArrayDecl_ArrayDecl_value = isSupertypeOfArrayDecl_compute(type);
        return isSupertypeOfArrayDecl_ArrayDecl_value;
    }

    private boolean isSupertypeOfArrayDecl_compute(ArrayDecl type) {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 418
    public boolean isSupertypeOfPrimitiveType(PrimitiveType type) {
        boolean isSupertypeOfPrimitiveType_PrimitiveType_value = isSupertypeOfPrimitiveType_compute(type);
        return isSupertypeOfPrimitiveType_PrimitiveType_value;
    }

    private boolean isSupertypeOfPrimitiveType_compute(PrimitiveType type) {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 419
    public boolean isSupertypeOfNullType(NullType type) {
        boolean isSupertypeOfNullType_NullType_value = isSupertypeOfNullType_compute(type);
        return isSupertypeOfNullType_NullType_value;
    }

    private boolean isSupertypeOfNullType_compute(NullType type) {  return  true;  }

    protected java.util.Set subtype_TypeDecl_visited;
    protected java.util.Set subtype_TypeDecl_computed = new java.util.HashSet(4);
    protected java.util.Set subtype_TypeDecl_initialized = new java.util.HashSet(4);
    protected java.util.Map subtype_TypeDecl_values = new java.util.HashMap(4);
    public boolean subtype(TypeDecl type) {
        Object _parameters = type;
if(subtype_TypeDecl_visited == null) subtype_TypeDecl_visited = new java.util.HashSet(4);
if(subtype_TypeDecl_values == null) subtype_TypeDecl_values = new java.util.HashMap(4);
        if(subtype_TypeDecl_computed.contains(_parameters))
            return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
        if (!subtype_TypeDecl_initialized.contains(_parameters)) {
            subtype_TypeDecl_initialized.add(_parameters);
            subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(true));
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            subtype_TypeDecl_visited.add(_parameters);
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            boolean new_subtype_TypeDecl_value;
            do {
                CHANGE = false;
                new_subtype_TypeDecl_value = subtype_compute(type);
                if (new_subtype_TypeDecl_value!=((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue())
                    CHANGE = true;
                subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(new_subtype_TypeDecl_value));
            } while (CHANGE);
            subtype_TypeDecl_visited.remove(_parameters);
            if(isFinal && num == boundariesCrossed)
{
            subtype_TypeDecl_computed.add(_parameters);
            }
            else {
            RESET_CYCLE = true;
            subtype_compute(type);
            RESET_CYCLE = false;
            subtype_TypeDecl_computed.remove(_parameters);
            subtype_TypeDecl_initialized.remove(_parameters);
            }
            IN_CIRCLE = false; 
            return new_subtype_TypeDecl_value;
        }
        if(!subtype_TypeDecl_visited.contains(_parameters)) {
            if (RESET_CYCLE) {
                subtype_TypeDecl_computed.remove(_parameters);
                subtype_TypeDecl_initialized.remove(_parameters);
                return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
            }
            subtype_TypeDecl_visited.add(_parameters);
            boolean new_subtype_TypeDecl_value = subtype_compute(type);
            if (new_subtype_TypeDecl_value!=((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue())
                CHANGE = true;
            subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(new_subtype_TypeDecl_value));
            subtype_TypeDecl_visited.remove(_parameters);
            return new_subtype_TypeDecl_value;
        }
        return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
    }

    private boolean subtype_compute(TypeDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 236
    public boolean supertypeClassDecl(ClassDecl type) {
        boolean supertypeClassDecl_ClassDecl_value = supertypeClassDecl_compute(type);
        return supertypeClassDecl_ClassDecl_value;
    }

    private boolean supertypeClassDecl_compute(ClassDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 237
    public boolean supertypeInterfaceDecl(InterfaceDecl type) {
        boolean supertypeInterfaceDecl_InterfaceDecl_value = supertypeInterfaceDecl_compute(type);
        return supertypeInterfaceDecl_InterfaceDecl_value;
    }

    private boolean supertypeInterfaceDecl_compute(InterfaceDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 238
    public boolean supertypeArrayDecl(ArrayDecl type) {
        boolean supertypeArrayDecl_ArrayDecl_value = supertypeArrayDecl_compute(type);
        return supertypeArrayDecl_ArrayDecl_value;
    }

    private boolean supertypeArrayDecl_compute(ArrayDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 239
    public boolean supertypePrimitiveType(PrimitiveType type) {
        boolean supertypePrimitiveType_PrimitiveType_value = supertypePrimitiveType_compute(type);
        return supertypePrimitiveType_PrimitiveType_value;
    }

    private boolean supertypePrimitiveType_compute(PrimitiveType type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 240
    public boolean supertypeNullType(NullType type) {
        boolean supertypeNullType_NullType_value = supertypeNullType_compute(type);
        return supertypeNullType_NullType_value;
    }

    private boolean supertypeNullType_compute(NullType type) {  return  true;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
