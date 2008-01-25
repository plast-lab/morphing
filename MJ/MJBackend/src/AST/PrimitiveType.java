
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class PrimitiveType extends TypeDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        narrowingConversionTo_TypeDecl_values = null;
        instanceOf_TypeDecl_values = null;
        fieldTypeSignature_computed = false;
        fieldTypeSignature_value = null;
        classTypeSignature_computed = false;
        classTypeSignature_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        PrimitiveType node = (PrimitiveType)super.clone();
        node.narrowingConversionTo_TypeDecl_values = null;
        node.instanceOf_TypeDecl_values = null;
        node.fieldTypeSignature_computed = false;
        node.fieldTypeSignature_value = null;
        node.classTypeSignature_computed = false;
        node.classTypeSignature_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          PrimitiveType node = (PrimitiveType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        PrimitiveType res = (PrimitiveType)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in QualifiedNames.jrag at line 99


  public Access createQualifiedAccess() {
    return new PrimitiveTypeAccess(name());
  }

    // Declared in TypeAnalysis.jrag at line 606

  
  public boolean hasSuperclass() {
    return !isObject();
  }

    // Declared in CodeGeneration.jrag at line 571

  public void emitReturn(CodeGeneration gen) { gen.emit(Bytecode.IRETURN);}

    // Declared in CodeGeneration.jrag at line 592

  public void emitLoadLocal(CodeGeneration gen, int pos) {
    gen.maxLocals = Math.max(gen.maxLocals, pos+1);
    if(pos == 0) gen.emit(Bytecode.ILOAD_0);
    else if(pos == 1) gen.emit(Bytecode.ILOAD_1);
    else if(pos == 2) gen.emit(Bytecode.ILOAD_2);
    else if(pos == 3) gen.emit(Bytecode.ILOAD_3);
    else if(pos < 256) gen.emit(Bytecode.ILOAD).add(pos);
    else gen.emit(Bytecode.WIDE).emit(Bytecode.ILOAD).add2(pos);
  }

    // Declared in CodeGeneration.jrag at line 705

  public void emitStoreLocal(CodeGeneration gen, int pos) {
    gen.maxLocals = Math.max(gen.maxLocals, pos+1);
    if(pos == 0) gen.emit(Bytecode.ISTORE_0);
    else if(pos == 1) gen.emit(Bytecode.ISTORE_1);
    else if(pos == 2) gen.emit(Bytecode.ISTORE_2);
    else if(pos == 3) gen.emit(Bytecode.ISTORE_3);
    else if(pos < 256) gen.emit(Bytecode.ISTORE).add(pos);
    else gen.emit(Bytecode.WIDE).emit(Bytecode.ISTORE).add2(pos);
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 41

    public PrimitiveType() {
        super();

        setChild(null, 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 41
    public PrimitiveType(Modifiers p0, String p1, Opt p2, List p3) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
    }

    // Declared in java.ast at line 20


  protected int numChildren() {
    return 3;
  }

    // Declared in java.ast at line 23

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 41
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
    // Declared in java.ast line 41
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
    // Declared in java.ast line 41
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
    // Declared in java.ast line 41
    public void setBodyDeclList(List list) {
        setChild(list, 2);
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
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in TypeAnalysis.jrag at line 410
private boolean refined_TypeAnalysis_instanceOf_TypeDecl(TypeDecl type)
{ return  type.isSupertypeOfPrimitiveType(this); }

    // Declared in TypeAnalysis.jrag at line 12
    public boolean wideningConversionTo(TypeDecl type) {
        boolean wideningConversionTo_TypeDecl_value = wideningConversionTo_compute(type);
        return wideningConversionTo_TypeDecl_value;
    }

    private boolean wideningConversionTo_compute(TypeDecl type) {  return  instanceOf(type);  }

    // Declared in TypeAnalysis.jrag at line 18
    public boolean narrowingConversionTo(TypeDecl type) {
        Object _parameters = type;
if(narrowingConversionTo_TypeDecl_values == null) narrowingConversionTo_TypeDecl_values = new java.util.HashMap(4);
        if(narrowingConversionTo_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)narrowingConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean narrowingConversionTo_TypeDecl_value = narrowingConversionTo_compute(type);
        if(isFinal && num == boundariesCrossed)
            narrowingConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(narrowingConversionTo_TypeDecl_value));
        return narrowingConversionTo_TypeDecl_value;
    }

    private boolean narrowingConversionTo_compute(TypeDecl type) {  return  type.instanceOf(this);  }

    // Declared in TypeAnalysis.jrag at line 160
    public boolean isPrimitiveType() {
        boolean isPrimitiveType_value = isPrimitiveType_compute();
        return isPrimitiveType_value;
    }

    private boolean isPrimitiveType_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 213
    public boolean isPrimitive() {
        boolean isPrimitive_value = isPrimitive_compute();
        return isPrimitive_value;
    }

    private boolean isPrimitive_compute() {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 211
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

    // Declared in TypeAnalysis.jrag at line 474
    public boolean isSupertypeOfPrimitiveType(PrimitiveType type) {
        boolean isSupertypeOfPrimitiveType_PrimitiveType_value = isSupertypeOfPrimitiveType_compute(type);
        return isSupertypeOfPrimitiveType_PrimitiveType_value;
    }

    private boolean isSupertypeOfPrimitiveType_compute(PrimitiveType type)  {
    if(super.isSupertypeOfPrimitiveType(type))
      return true;
    return type.hasSuperclass() && type.superclass().isPrimitive() && type.superclass().instanceOf(this);
  }

    // Declared in TypeAnalysis.jrag at line 610
    public TypeDecl superclass() {
        TypeDecl superclass_value = superclass_compute();
        return superclass_value;
    }

    private TypeDecl superclass_compute() {  return  getSuperClassAccess().type();  }

    // Declared in LocalNum.jrag at line 113
    public int variableSize() {
        int variableSize_value = variableSize_compute();
        return variableSize_value;
    }

    private int variableSize_compute() {  return  1;  }

    // Declared in Annotations.jrag at line 110
    public boolean isValidAnnotationMethodReturnType() {
        boolean isValidAnnotationMethodReturnType_value = isValidAnnotationMethodReturnType_compute();
        return isValidAnnotationMethodReturnType_value;
    }

    private boolean isValidAnnotationMethodReturnType_compute() {  return  true;  }

    // Declared in AutoBoxing.jrag at line 23
    public boolean boxingConversionTo(TypeDecl typeDecl) {
        boolean boxingConversionTo_TypeDecl_value = boxingConversionTo_compute(typeDecl);
        return boxingConversionTo_TypeDecl_value;
    }

    private boolean boxingConversionTo_compute(TypeDecl typeDecl) {  return  boxed() == typeDecl;  }

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

    private boolean subtype_compute(TypeDecl type) {  return  type.supertypePrimitiveType(this);  }

    // Declared in GenericsSubtype.jrag at line 294
    public boolean supertypePrimitiveType(PrimitiveType type) {
        boolean supertypePrimitiveType_PrimitiveType_value = supertypePrimitiveType_compute(type);
        return supertypePrimitiveType_PrimitiveType_value;
    }

    private boolean supertypePrimitiveType_compute(PrimitiveType type)  {
    if(super.supertypePrimitiveType(type))
      return true;
    return type.hasSuperclass() && type.superclass().isPrimitive() && type.superclass().subtype(this);
  }

    // Declared in GenericsCodegen.jrag at line 410
    public String fieldTypeSignature() {
        if(fieldTypeSignature_computed)
            return fieldTypeSignature_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        fieldTypeSignature_value = fieldTypeSignature_compute();
        if(isFinal && num == boundariesCrossed)
            fieldTypeSignature_computed = true;
        return fieldTypeSignature_value;
    }

    private String fieldTypeSignature_compute() {  return  classTypeSignature();  }

    // Declared in GenericsCodegen.jrag at line 415
    public String classTypeSignature() {
        if(classTypeSignature_computed)
            return classTypeSignature_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        classTypeSignature_value = classTypeSignature_compute();
        if(isFinal && num == boundariesCrossed)
            classTypeSignature_computed = true;
        return classTypeSignature_value;
    }

    private String classTypeSignature_compute() {  return  typeDescriptor();  }

    // Declared in TypeAnalysis.jrag at line 566
    public TypeDecl Define_TypeDecl_hostType(ASTNode caller, ASTNode child) {
        if(caller == getSuperClassAccessOptNoTransform()) {
            return  hostType();
        }
        return super.Define_TypeDecl_hostType(caller, child);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
