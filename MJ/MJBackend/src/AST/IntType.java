
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class IntType extends IntegralType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        typeDescriptor_computed = false;
        typeDescriptor_value = null;
        boxed_computed = false;
        boxed_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        IntType node = (IntType)super.clone();
        node.typeDescriptor_computed = false;
        node.typeDescriptor_value = null;
        node.boxed_computed = false;
        node.boxed_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          IntType node = (IntType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        IntType res = (IntType)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in CodeGeneration.jrag at line 413


  /*************************************************************
   * Emit methods
   *************************************************************/

  // push constants

  public static void push(CodeGeneration gen, int value) {
    switch(value) {
      case -1:
        gen.emit(Bytecode.ICONST_M1);
        break;
      case 0:
        gen.emit(Bytecode.ICONST_0);
        break;
      case 1:
        gen.emit(Bytecode.ICONST_1);
        break;
      case 2:
        gen.emit(Bytecode.ICONST_2);
        break;
      case 3:
        gen.emit(Bytecode.ICONST_3);
        break;
      case 4:
        gen.emit(Bytecode.ICONST_4);
        break;
      case 5:
        gen.emit(Bytecode.ICONST_5);
        break;
      default:
        if(value >= -128 && value <= 127) {
          gen.emit(Bytecode.BIPUSH).add(value);
        }
        else if(value >= -32768 && value <= 32767) {
          gen.emit(Bytecode.SIPUSH).add2(value);
        }
        else {
          int index = gen.constantPool().addConstant(value);
          if(index < 256)
            gen.emit(Bytecode.LDC).add(index);
          else 
            gen.emit(Bytecode.LDC_W).add2(index);
        }
    }
  }

    // Declared in CodeGeneration.jrag at line 903

  void emitCastTo(CodeGeneration gen, TypeDecl type)      { type.intToThis(gen); }

    // Declared in CodeGeneration.jrag at line 914

  void intToThis(CodeGeneration gen)    { }

    // Declared in CodeGeneration.jrag at line 923

  void floatToThis(CodeGeneration gen)    { gen.emit(Bytecode.F2I); }

    // Declared in CodeGeneration.jrag at line 932

  void doubleToThis(CodeGeneration gen)    { gen.emit(Bytecode.D2I); }

    // Declared in CodeGeneration.jrag at line 941

  void longToThis(CodeGeneration gen)    { gen.emit(Bytecode.L2I); }

    // Declared in java.ast at line 3
    // Declared in java.ast line 54

    public IntType() {
        super();

        setChild(null, 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 54
    public IntType(Modifiers p0, String p1, Opt p2, List p3) {
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

    // Declared in TypeAnalysis.jrag at line 183
    public boolean isInt() {
        boolean isInt_value = isInt_compute();
        return isInt_value;
    }

    private boolean isInt_compute() {  return  true;  }

    // Declared in CodeGeneration.jrag at line 582
    public byte arrayLoad() {
        byte arrayLoad_value = arrayLoad_compute();
        return arrayLoad_value;
    }

    private byte arrayLoad_compute() {  return  Bytecode.IALOAD;  }

    // Declared in CodeGeneration.jrag at line 684
    public byte arrayStore() {
        byte arrayStore_value = arrayStore_compute();
        return arrayStore_value;
    }

    private byte arrayStore_compute() {  return  Bytecode.IASTORE;  }

    // Declared in ConstantPoolNames.jrag at line 11
    public String typeDescriptor() {
        if(typeDescriptor_computed)
            return typeDescriptor_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeDescriptor_value = typeDescriptor_compute();
        if(isFinal && num == boundariesCrossed)
            typeDescriptor_computed = true;
        return typeDescriptor_value;
    }

    private String typeDescriptor_compute() {  return  "I";  }

    // Declared in CreateBCode.jrag at line 887
    public int arrayPrimitiveTypeDescriptor() {
        int arrayPrimitiveTypeDescriptor_value = arrayPrimitiveTypeDescriptor_compute();
        return arrayPrimitiveTypeDescriptor_value;
    }

    private int arrayPrimitiveTypeDescriptor_compute() {  return  10;  }

    // Declared in Java2Rewrites.jrag at line 11
    public String primitiveClassName() {
        String primitiveClassName_value = primitiveClassName_compute();
        return primitiveClassName_value;
    }

    private String primitiveClassName_compute() {  return  "Integer";  }

    // Declared in AutoBoxing.jrag at line 31
    public TypeDecl boxed() {
        if(boxed_computed)
            return boxed_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boxed_value = boxed_compute();
        if(isFinal && num == boundariesCrossed)
            boxed_computed = true;
        return boxed_value;
    }

    private TypeDecl boxed_compute() {  return  lookupType("java.lang", "Integer");  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
