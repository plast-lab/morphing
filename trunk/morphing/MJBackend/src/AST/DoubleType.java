
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class DoubleType extends FloatingPointType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        typeDescriptor_computed = false;
        typeDescriptor_value = null;
        boxed_computed = false;
        boxed_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        DoubleType node = (DoubleType)super.clone();
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
          DoubleType node = (DoubleType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        DoubleType res = (DoubleType)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Attributes.jrag at line 57

  public int addConstant(ConstantPool p, Constant c)   { return p.addConstant(c.doubleValue()); }

    // Declared in CodeGeneration.jrag at line 473

  public void emitPushConstant(CodeGeneration gen, int value) {
    if(value == 0)
      gen.emit(Bytecode.DCONST_0);
    else if(value == 1)
      gen.emit(Bytecode.DCONST_1);
    else {
      int index = gen.constantPool().addConstant((double)value);
      gen.emit(Bytecode.LDC2_W).add2(index);
    }
  }

    // Declared in CodeGeneration.jrag at line 574

  public void emitReturn(CodeGeneration gen)    { gen.emit(Bytecode.DRETURN);}

    // Declared in CodeGeneration.jrag at line 619

  public void emitLoadLocal(CodeGeneration gen, int pos) {
    gen.maxLocals = Math.max(gen.maxLocals, pos+2);
    if(pos == 0) gen.emit(Bytecode.DLOAD_0);
    else if(pos == 1) gen.emit(Bytecode.DLOAD_1);
    else if(pos == 2) gen.emit(Bytecode.DLOAD_2);
    else if(pos == 3) gen.emit(Bytecode.DLOAD_3);
    else if(pos < 256) gen.emit(Bytecode.DLOAD).add(pos);
    else gen.emit(Bytecode.WIDE).emit(Bytecode.DLOAD).add2(pos);
  }

    // Declared in CodeGeneration.jrag at line 732

  public void emitStoreLocal(CodeGeneration gen, int pos) {
    gen.maxLocals = Math.max(gen.maxLocals, pos+2);
    if(pos == 0) gen.emit(Bytecode.DSTORE_0);
    else if(pos == 1) gen.emit(Bytecode.DSTORE_1);
    else if(pos == 2) gen.emit(Bytecode.DSTORE_2);
    else if(pos == 3) gen.emit(Bytecode.DSTORE_3);
    else if(pos < 256) gen.emit(Bytecode.DSTORE).add(pos);
    else gen.emit(Bytecode.WIDE).emit(Bytecode.DSTORE).add2(pos);
  }

    // Declared in CodeGeneration.jrag at line 803

  public void emitDup(CodeGeneration gen)    { gen.emit(Bytecode.DUP2); }

    // Declared in CodeGeneration.jrag at line 808

  public void emitDup_x1(CodeGeneration gen) { gen.emit(Bytecode.DUP2_X1); }

    // Declared in CodeGeneration.jrag at line 813

  public void emitDup_x2(CodeGeneration gen) { gen.emit(Bytecode.DUP2_X2); }

    // Declared in CodeGeneration.jrag at line 818

  public void emitPop(CodeGeneration gen)    { gen.emit(Bytecode.POP2); }

    // Declared in CodeGeneration.jrag at line 905

  void emitCastTo(CodeGeneration gen, TypeDecl type)   { type.doubleToThis(gen); }

    // Declared in CodeGeneration.jrag at line 917

  void intToThis(CodeGeneration gen) { gen.emit(Bytecode.I2D); }

    // Declared in CodeGeneration.jrag at line 929

  void floatToThis(CodeGeneration gen) { gen.emit(Bytecode.F2D); }

    // Declared in CodeGeneration.jrag at line 938

  void doubleToThis(CodeGeneration gen) { }

    // Declared in CodeGeneration.jrag at line 947

  void longToThis(CodeGeneration gen) { gen.emit(Bytecode.L2D); }

    // Declared in CodeGeneration.jrag at line 954

  void byteToThis(CodeGeneration gen)   { gen.emit(Bytecode.I2D);}

    // Declared in CodeGeneration.jrag at line 962

  void charToThis(CodeGeneration gen)   { gen.emit(Bytecode.I2D);}

    // Declared in CodeGeneration.jrag at line 970

  void shortToThis(CodeGeneration gen)   { gen.emit(Bytecode.I2D); }

    // Declared in CodeGeneration.jrag at line 1001

  void neg(CodeGeneration gen)   { gen.emit(Bytecode.DNEG); }

    // Declared in CodeGeneration.jrag at line 1013

  void add(CodeGeneration gen) {gen.emit(Bytecode.DADD);}

    // Declared in CodeGeneration.jrag at line 1019

  void sub(CodeGeneration gen) {gen.emit(Bytecode.DSUB);}

    // Declared in CodeGeneration.jrag at line 1025

  void mul(CodeGeneration gen) {gen.emit(Bytecode.DMUL);}

    // Declared in CodeGeneration.jrag at line 1031

  void div(CodeGeneration gen) {gen.emit(Bytecode.DDIV);}

    // Declared in CodeGeneration.jrag at line 1037

  void rem(CodeGeneration gen) {gen.emit(Bytecode.DREM);}

    // Declared in CodeGeneration.jrag at line 1070

  public void branchLT(CodeGeneration gen, int label)   { gen.emit(Bytecode.DCMPG).emitCompare(Bytecode.IFLT, label); }

    // Declared in CodeGeneration.jrag at line 1076

  public void branchLE(CodeGeneration gen, int label)   { gen.emit(Bytecode.DCMPG).emitCompare(Bytecode.IFLE, label); }

    // Declared in CodeGeneration.jrag at line 1082

  public void branchGE(CodeGeneration gen, int label)   { gen.emit(Bytecode.DCMPL).emitCompare(Bytecode.IFGE, label); }

    // Declared in CodeGeneration.jrag at line 1088

  public void branchGT(CodeGeneration gen, int label)   { gen.emit(Bytecode.DCMPL).emitCompare(Bytecode.IFGT, label); }

    // Declared in CodeGeneration.jrag at line 1094

  public void branchEQ(CodeGeneration gen, int label)    { gen.emit(Bytecode.DCMPL).emitCompare(Bytecode.IFEQ, label); }

    // Declared in CodeGeneration.jrag at line 1103

  public void branchNE(CodeGeneration gen, int label)    { gen.emit(Bytecode.DCMPL).emitCompare(Bytecode.IFNE, label); }

    // Declared in java.ast at line 3
    // Declared in java.ast line 59

    public DoubleType() {
        super();

        setChild(null, 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 59
    public DoubleType(Modifiers p0, String p1, Opt p2, List p3) {
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

    // Declared in ConstantExpression.jrag at line 283
    public Constant cast(Constant c) {
        Constant cast_Constant_value = cast_compute(c);
        return cast_Constant_value;
    }

    private Constant cast_compute(Constant c) {  return  Constant.create(c.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 294
    public Constant plus(Constant c) {
        Constant plus_Constant_value = plus_compute(c);
        return plus_Constant_value;
    }

    private Constant plus_compute(Constant c) {  return  c;  }

    // Declared in ConstantExpression.jrag at line 303
    public Constant minus(Constant c) {
        Constant minus_Constant_value = minus_compute(c);
        return minus_Constant_value;
    }

    private Constant minus_compute(Constant c) {  return  Constant.create(-c.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 319
    public Constant mul(Constant c1, Constant c2) {
        Constant mul_Constant_Constant_value = mul_compute(c1, c2);
        return mul_Constant_Constant_value;
    }

    private Constant mul_compute(Constant c1, Constant c2) {  return  Constant.create(c1.doubleValue() * c2.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 328
    public Constant div(Constant c1, Constant c2) {
        Constant div_Constant_Constant_value = div_compute(c1, c2);
        return div_Constant_Constant_value;
    }

    private Constant div_compute(Constant c1, Constant c2) {  return  Constant.create(c1.doubleValue() / c2.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 337
    public Constant mod(Constant c1, Constant c2) {
        Constant mod_Constant_Constant_value = mod_compute(c1, c2);
        return mod_Constant_Constant_value;
    }

    private Constant mod_compute(Constant c1, Constant c2) {  return  Constant.create(c1.doubleValue() % c2.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 346
    public Constant add(Constant c1, Constant c2) {
        Constant add_Constant_Constant_value = add_compute(c1, c2);
        return add_Constant_Constant_value;
    }

    private Constant add_compute(Constant c1, Constant c2) {  return  Constant.create(c1.doubleValue() + c2.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 356
    public Constant sub(Constant c1, Constant c2) {
        Constant sub_Constant_Constant_value = sub_compute(c1, c2);
        return sub_Constant_Constant_value;
    }

    private Constant sub_compute(Constant c1, Constant c2) {  return  Constant.create(c1.doubleValue() - c2.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 410
    public Constant questionColon(Constant cond, Constant c1, Constant c2) {
        Constant questionColon_Constant_Constant_Constant_value = questionColon_compute(cond, c1, c2);
        return questionColon_Constant_Constant_Constant_value;
    }

    private Constant questionColon_compute(Constant cond, Constant c1, Constant c2) {  return  Constant.create(cond.booleanValue() ? c1.doubleValue() : c2.doubleValue());  }

    // Declared in ConstantExpression.jrag at line 514
    public boolean eqIsTrue(Expr left, Expr right) {
        boolean eqIsTrue_Expr_Expr_value = eqIsTrue_compute(left, right);
        return eqIsTrue_Expr_Expr_value;
    }

    private boolean eqIsTrue_compute(Expr left, Expr right) {  return  left.constant().doubleValue() == right.constant().doubleValue();  }

    // Declared in ConstantExpression.jrag at line 522
    public boolean ltIsTrue(Expr left, Expr right) {
        boolean ltIsTrue_Expr_Expr_value = ltIsTrue_compute(left, right);
        return ltIsTrue_Expr_Expr_value;
    }

    private boolean ltIsTrue_compute(Expr left, Expr right) {  return  left.constant().doubleValue() < right.constant().doubleValue();  }

    // Declared in ConstantExpression.jrag at line 528
    public boolean leIsTrue(Expr left, Expr right) {
        boolean leIsTrue_Expr_Expr_value = leIsTrue_compute(left, right);
        return leIsTrue_Expr_Expr_value;
    }

    private boolean leIsTrue_compute(Expr left, Expr right) {  return  left.constant().doubleValue() <= right.constant().doubleValue();  }

    // Declared in TypeAnalysis.jrag at line 191
    public boolean isDouble() {
        boolean isDouble_value = isDouble_compute();
        return isDouble_value;
    }

    private boolean isDouble_compute() {  return  true;  }

    // Declared in CodeGeneration.jrag at line 585
    public byte arrayLoad() {
        byte arrayLoad_value = arrayLoad_compute();
        return arrayLoad_value;
    }

    private byte arrayLoad_compute() {  return  Bytecode.DALOAD;  }

    // Declared in CodeGeneration.jrag at line 687
    public byte arrayStore() {
        byte arrayStore_value = arrayStore_compute();
        return arrayStore_value;
    }

    private byte arrayStore_compute() {  return  Bytecode.DASTORE;  }

    // Declared in ConstantPoolNames.jrag at line 15
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

    private String typeDescriptor_compute() {  return  "D";  }

    // Declared in CreateBCode.jrag at line 884
    public int arrayPrimitiveTypeDescriptor() {
        int arrayPrimitiveTypeDescriptor_value = arrayPrimitiveTypeDescriptor_compute();
        return arrayPrimitiveTypeDescriptor_value;
    }

    private int arrayPrimitiveTypeDescriptor_compute() {  return  7;  }

    // Declared in Java2Rewrites.jrag at line 14
    public String primitiveClassName() {
        String primitiveClassName_value = primitiveClassName_compute();
        return primitiveClassName_value;
    }

    private String primitiveClassName_compute() {  return  "Double";  }

    // Declared in LocalNum.jrag at line 115
    public int variableSize() {
        int variableSize_value = variableSize_compute();
        return variableSize_value;
    }

    private int variableSize_compute() {  return  2;  }

    // Declared in AutoBoxing.jrag at line 34
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

    private TypeDecl boxed_compute() {  return  lookupType("java.lang", "Double");  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
