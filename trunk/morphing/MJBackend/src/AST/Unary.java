
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public abstract class Unary extends Expr implements Cloneable {
    public void flushCache() {
        super.flushCache();
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        Unary node = (Unary)super.clone();
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in PrettyPrint.jadd at line 437


  // Pre and post operations for unary expression
  
  public void toString(StringBuffer s) {
    printPreOp(s);
    getOperand().toString(s);
    printPostOp(s);
  }

    // Declared in PrettyPrint.jadd at line 443


  public void printPreOp(StringBuffer s) {
  }

    // Declared in PrettyPrint.jadd at line 446


  public void printPostOp(StringBuffer s) {
  }

    // Declared in CreateBCode.jrag at line 890
 // T_LONG

  public void createBCode(CodeGeneration gen) {   
    super.createBCode(gen);
    emitOperation(gen);
  }

    // Declared in CreateBCode.jrag at line 902


  // TODO: consider using IINC or WIDE,IINC

  public void refined_CreateBCode_emitPostfix(CodeGeneration gen, int constant) {
    Expr operand = getOperand();
    while(operand instanceof ParExpr)
      operand = ((ParExpr)operand).getExpr();
    Access access = ((Access)operand).lastAccess();
    access.createAssignLoadDest(gen);
    if(needsPush())
      access.createPushAssignmentResult(gen);
    TypeDecl type = access.type().binaryNumericPromotion(typeInt());
    type.emitPushConstant(gen, constant);
    type.add(gen);
    type.emitCastTo(gen, access.type());
    access.emitStore(gen);
  }

    // Declared in CreateBCode.jrag at line 919


  public void refined_CreateBCode_emitPrefix(CodeGeneration gen, int constant) {
    Expr operand = getOperand();
    while(operand instanceof ParExpr)
      operand = ((ParExpr)operand).getExpr();
    Access access = ((Access)operand).lastAccess();
    access.createAssignLoadDest(gen);
    TypeDecl type = access.type().binaryNumericPromotion(typeInt());
    type.emitPushConstant(gen, constant);
    type.add(gen);
    type.emitCastTo(gen, access.type());
    if(needsPush())
      access.createPushAssignmentResult(gen);
    access.emitStore(gen);
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 140

    public Unary() {
        super();

        setChild(null, 0);

    }

    // Declared in java.ast at line 11


    // Declared in java.ast line 140
    public Unary(Expr p0) {
        setChild(p0, 0);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 140
    public void setOperand(Expr node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Expr getOperand() {
        return (Expr)getChild(0);
    }

    // Declared in java.ast at line 9


    public Expr getOperandNoTransform() {
        return (Expr)getChildNoTransform(0);
    }

    // Declared in AutoBoxingCodegen.jrag at line 122



  // 14.11 Switch

  // 15.12.2 Determine Method Signature

 
  // 15.14.2 Postix Increment Operator ++
  // 15.14.3 Postix Decrement Operator --
    public void emitPostfix(CodeGeneration gen, int constant) {
    Expr operand = getOperand();
    while(operand instanceof ParExpr)
      operand = ((ParExpr)operand).getExpr();
    Access access = ((Access)operand).lastAccess();
    access.createAssignLoadDest(gen);
    if(needsPush())
      access.createPushAssignmentResult(gen);
    TypeDecl type = access.type().binaryNumericPromotion(typeInt());
    access.type().emitCastTo(gen, type); // Added for AutoBoxing
    type.emitPushConstant(gen, constant);
    type.add(gen);
    type.emitCastTo(gen, access.type());
    access.emitStore(gen);
  }

    // Declared in AutoBoxingCodegen.jrag at line 140


  // 15.15.1 Prefix Increment Operator ++
  // 15.15.2 Prefix Decrement Operator --
    public void emitPrefix(CodeGeneration gen, int constant) {
    Expr operand = getOperand();
    while(operand instanceof ParExpr)
      operand = ((ParExpr)operand).getExpr();
    Access access = ((Access)operand).lastAccess();
    access.createAssignLoadDest(gen);
    TypeDecl type = access.type().binaryNumericPromotion(typeInt());
    access.type().emitCastTo(gen, type); // Added for AutoBoxing
    type.emitPushConstant(gen, constant);
    type.add(gen);
    type.emitCastTo(gen, access.type());
    if(needsPush())
      access.createPushAssignmentResult(gen);
    access.emitStore(gen);
  }

    // Declared in DefiniteAssignment.jrag at line 384
    public boolean isDAafter(Variable v) {
        boolean isDAafter_Variable_value = isDAafter_compute(v);
        return isDAafter_Variable_value;
    }

    private boolean isDAafter_compute(Variable v) {  return  getOperand().isDAafter(v);  }

    // Declared in DefiniteAssignment.jrag at line 836
    public boolean isDUafter(Variable v) {
        boolean isDUafter_Variable_value = isDUafter_compute(v);
        return isDUafter_Variable_value;
    }

    private boolean isDUafter_compute(Variable v) {  return  getOperand().isDUafter(v);  }

    protected boolean type_computed = false;
    protected TypeDecl type_value;
    // Declared in TypeAnalysis.jrag at line 312
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

    private TypeDecl type_compute() {  return  getOperand().type();  }

    // Declared in DefiniteAssignment.jrag at line 33
    public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
        if(caller == getOperandNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_isSource(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
