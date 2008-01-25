
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;



public class ConditionalExpr extends Expr implements Cloneable {
    public void flushCache() {
        super.flushCache();
        booleanOperator_computed = false;
        type_computed = false;
        type_value = null;
        else_branch_label_computed = false;
        then_branch_label_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        ConditionalExpr node = (ConditionalExpr)super.clone();
        node.booleanOperator_computed = false;
        node.type_computed = false;
        node.type_value = null;
        node.else_branch_label_computed = false;
        node.then_branch_label_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ConditionalExpr node = (ConditionalExpr)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ConditionalExpr res = (ConditionalExpr)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in PrettyPrint.jadd at line 584


  public void toString(StringBuffer s) {
    getCondition().toString(s);
    s.append(" ? ");
    getTrueExpr().toString(s);
    s.append(" : ");
    getFalseExpr().toString(s);
  }

    // Declared in TypeCheck.jrag at line 547


  // 15.25
  public void typeCheck() {
    if(!getCondition().type().isBoolean())
      error("*** First expression must be a boolean in conditional operator");
    if(type().isUnknown() && !getTrueExpr().type().isUnknown() && !getFalseExpr().type().isUnknown()) {
      error("*** Operands in conditional operator does not match"); 
    }
  }

    // Declared in CreateBCode.jrag at line 1106


  public void createBCode(CodeGeneration gen) {
    if(type().isBoolean())
      emitBooleanCondition(gen);
    else {
      int endBranch = hostType().constantPool().newLabel();
      getCondition().emitEvalBranch(gen);
      if(getCondition().canBeTrue()) {
        gen.addLabel(then_branch_label());
        getTrueExpr().createBCode(gen);
        getTrueExpr().type().emitCastTo(gen, type());
        if(getCondition().canBeFalse()) {
          gen.changeStackDepth(-type().variableSize());
          gen.emitGoto(endBranch);
        }
      }
      if(getCondition().canBeFalse()) {
        gen.addLabel(else_branch_label());
        getFalseExpr().createBCode(gen);
        getFalseExpr().type().emitCastTo(gen, type());
      }
      gen.addLabel(endBranch);
    }
  }

    // Declared in CreateBCode.jrag at line 1172

  
  public void emitEvalBranch(CodeGeneration gen) {
    int endBranch = hostType().constantPool().newLabel();
    getCondition().emitEvalBranch(gen);
    gen.addLabel(then_branch_label());
    if(getCondition().canBeTrue()) {
      getTrueExpr().emitEvalBranch(gen);
      gen.emitGoto(true_label());
    }  
    gen.addLabel(else_branch_label());
    if(getCondition().canBeFalse()) {
      getFalseExpr().emitEvalBranch(gen);
      gen.emitGoto(true_label());
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 192

    public ConditionalExpr() {
        super();

        setChild(null, 0);
        setChild(null, 1);
        setChild(null, 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 192
    public ConditionalExpr(Expr p0, Expr p1, Expr p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in java.ast at line 19


  protected int numChildren() {
    return 3;
  }

    // Declared in java.ast at line 22

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 192
    public void setCondition(Expr node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Expr getCondition() {
        return (Expr)getChild(0);
    }

    // Declared in java.ast at line 9


    public Expr getConditionNoTransform() {
        return (Expr)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 192
    public void setTrueExpr(Expr node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Expr getTrueExpr() {
        return (Expr)getChild(1);
    }

    // Declared in java.ast at line 9


    public Expr getTrueExprNoTransform() {
        return (Expr)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 192
    public void setFalseExpr(Expr node) {
        setChild(node, 2);
    }

    // Declared in java.ast at line 5

    public Expr getFalseExpr() {
        return (Expr)getChild(2);
    }

    // Declared in java.ast at line 9


    public Expr getFalseExprNoTransform() {
        return (Expr)getChildNoTransform(2);
    }

    // Declared in TypeAnalysis.jrag at line 362
private TypeDecl refined_TypeAnalysis_type()
 {
    TypeDecl trueType = getTrueExpr().type();
    TypeDecl falseType = getFalseExpr().type();
    
    if(trueType == falseType) return trueType;
    
    if(trueType.isNumericType() && falseType.isNumericType()) {
      if(trueType.isByte() && falseType.isShort()) return falseType;
      if(trueType.isShort() && falseType.isByte()) return trueType;
      if((trueType.isByte() || trueType.isShort() || trueType.isChar()) && 
         falseType.isInt() && getFalseExpr().isConstant() && getFalseExpr().representableIn(trueType))
        return trueType;
      if((falseType.isByte() || falseType.isShort() || falseType.isChar()) && 
         trueType.isInt() && getTrueExpr().isConstant() && getTrueExpr().representableIn(falseType))
        return falseType;
      return trueType.binaryNumericPromotion(falseType);
    }
    else if(trueType.isBoolean() && falseType.isBoolean()) {
      return trueType;
    }
    else if(trueType.isReferenceType() && falseType.isNull()) {
      return trueType;
    }
    else if(trueType.isNull() && falseType.isReferenceType()) {
      return falseType;
    }
    else if(trueType.isReferenceType() && falseType.isReferenceType()) {
      if(trueType.assignConversionTo(falseType, null))
        return falseType;
      if(falseType.assignConversionTo(trueType, null))
        return trueType;
      return unknownType();
    }
    else
      return unknownType();
  }

    // Declared in ConstantExpression.jrag at line 115
    public Constant constant() {
        Constant constant_value = constant_compute();
        return constant_value;
    }

    private Constant constant_compute() {  return  type().questionColon(getCondition().constant(), getTrueExpr().constant(),getFalseExpr().constant());  }

    // Declared in ConstantExpression.jrag at line 460
    public boolean isConstant() {
        boolean isConstant_value = isConstant_compute();
        return isConstant_value;
    }

    private boolean isConstant_compute() {  return  getCondition().isConstant() && getTrueExpr().isConstant() && getFalseExpr().isConstant();  }

    protected boolean booleanOperator_computed = false;
    protected boolean booleanOperator_value;
    // Declared in DefiniteAssignment.jrag at line 221
    public boolean booleanOperator() {
        if(booleanOperator_computed)
            return booleanOperator_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        booleanOperator_value = booleanOperator_compute();
        if(isFinal && num == boundariesCrossed)
            booleanOperator_computed = true;
        return booleanOperator_value;
    }

    private boolean booleanOperator_compute() {  return  getTrueExpr().type().isBoolean() && getFalseExpr().type().isBoolean();  }

    // Declared in DefiniteAssignment.jrag at line 369
    public boolean isDAafterTrue(Variable v) {
        boolean isDAafterTrue_Variable_value = isDAafterTrue_compute(v);
        return isDAafterTrue_Variable_value;
    }

    private boolean isDAafterTrue_compute(Variable v) {  return  (getTrueExpr().isDAafterTrue(v) && getFalseExpr().isDAafterTrue(v)) || isFalse();  }

    // Declared in DefiniteAssignment.jrag at line 370
    public boolean isDAafterFalse(Variable v) {
        boolean isDAafterFalse_Variable_value = isDAafterFalse_compute(v);
        return isDAafterFalse_Variable_value;
    }

    private boolean isDAafterFalse_compute(Variable v) {  return  (getTrueExpr().isDAafterFalse(v) && getFalseExpr().isDAafterFalse(v)) || isTrue();  }

    // Declared in DefiniteAssignment.jrag at line 374
    public boolean isDAafter(Variable v) {
        boolean isDAafter_Variable_value = isDAafter_compute(v);
        return isDAafter_Variable_value;
    }

    private boolean isDAafter_compute(Variable v) {  return  booleanOperator() ? isDAafterTrue(v) && isDAafterFalse(v) : getTrueExpr().isDAafter(v) && getFalseExpr().isDAafter(v);  }

    // Declared in DefiniteAssignment.jrag at line 813
    public boolean isDUafterTrue(Variable v) {
        boolean isDUafterTrue_Variable_value = isDUafterTrue_compute(v);
        return isDUafterTrue_Variable_value;
    }

    private boolean isDUafterTrue_compute(Variable v) {  return  getTrueExpr().isDUafterTrue(v) && getFalseExpr().isDUafterTrue(v);  }

    // Declared in DefiniteAssignment.jrag at line 814
    public boolean isDUafterFalse(Variable v) {
        boolean isDUafterFalse_Variable_value = isDUafterFalse_compute(v);
        return isDUafterFalse_Variable_value;
    }

    private boolean isDUafterFalse_compute(Variable v) {  return  getTrueExpr().isDUafterFalse(v) && getFalseExpr().isDUafterFalse(v);  }

    // Declared in DefiniteAssignment.jrag at line 818
    public boolean isDUafter(Variable v) {
        boolean isDUafter_Variable_value = isDUafter_compute(v);
        return isDUafter_Variable_value;
    }

    private boolean isDUafter_compute(Variable v) {  return  booleanOperator() ? isDUafterTrue(v) && isDUafterFalse(v) : getTrueExpr().isDUafter(v) && getFalseExpr().isDUafter(v);  }

    protected boolean type_computed = false;
    protected TypeDecl type_value;
    // Declared in Generics.jrag at line 42
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
    TypeDecl type = refined_TypeAnalysis_type();
    TypeDecl trueType = getTrueExpr().type();
    TypeDecl falseType = getFalseExpr().type();

    if(type.isUnknown() && trueType.isReferenceType() && falseType.isReferenceType()) {
      ArrayList list = new ArrayList();
      list.add(trueType);
      list.add(falseType);
      return type.lookupLUBType(list);
    }
    return type;
  }

    // Declared in CreateBCode.jrag at line 1017
    public boolean definesLabel() {
        boolean definesLabel_value = definesLabel_compute();
        return definesLabel_value;
    }

    private boolean definesLabel_compute() {  return  true;  }

    // Declared in CreateBCode.jrag at line 1076
    public boolean canBeTrue() {
        boolean canBeTrue_value = canBeTrue_compute();
        return canBeTrue_value;
    }

    private boolean canBeTrue_compute() {  return  type().isBoolean() && (getTrueExpr().canBeTrue() && getFalseExpr().canBeTrue() 
    || getCondition().isTrue() && getTrueExpr().canBeTrue()
    || getCondition().isFalse() && getFalseExpr().canBeTrue());  }

    // Declared in CreateBCode.jrag at line 1086
    public boolean canBeFalse() {
        boolean canBeFalse_value = canBeFalse_compute();
        return canBeFalse_value;
    }

    private boolean canBeFalse_compute() {  return  type().isBoolean() && (getTrueExpr().canBeFalse() && getFalseExpr().canBeFalse() 
    || getCondition().isTrue() && getTrueExpr().canBeFalse()
    || getCondition().isFalse() && getFalseExpr().canBeFalse());  }

    protected boolean else_branch_label_computed = false;
    protected int else_branch_label_value;
    // Declared in CreateBCode.jrag at line 1129
    public int else_branch_label() {
        if(else_branch_label_computed)
            return else_branch_label_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        else_branch_label_value = else_branch_label_compute();
        if(isFinal && num == boundariesCrossed)
            else_branch_label_computed = true;
        return else_branch_label_value;
    }

    private int else_branch_label_compute() {  return  hostType().constantPool().newLabel();  }

    protected boolean then_branch_label_computed = false;
    protected int then_branch_label_value;
    // Declared in CreateBCode.jrag at line 1130
    public int then_branch_label() {
        if(then_branch_label_computed)
            return then_branch_label_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        then_branch_label_value = then_branch_label_compute();
        if(isFinal && num == boundariesCrossed)
            then_branch_label_computed = true;
        return then_branch_label_value;
    }

    private int then_branch_label_compute() {  return  hostType().constantPool().newLabel();  }

    // Declared in CreateBCode.jrag at line 1054
    public int Define_int_condition_true_label(ASTNode caller, ASTNode child) {
        if(caller == getFalseExprNoTransform()) {
            return  true_label();
        }
        if(caller == getTrueExprNoTransform()) {
            return  true_label();
        }
        if(caller == getConditionNoTransform()) {
            return  then_branch_label();
        }
        return getParent().Define_int_condition_true_label(this, caller);
    }

    // Declared in CreateBCode.jrag at line 1053
    public int Define_int_condition_false_label(ASTNode caller, ASTNode child) {
        if(caller == getFalseExprNoTransform()) {
            return  false_label();
        }
        if(caller == getTrueExprNoTransform()) {
            return  false_label();
        }
        if(caller == getConditionNoTransform()) {
            return  else_branch_label();
        }
        return getParent().Define_int_condition_false_label(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 373
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getFalseExprNoTransform()) {
            return  getCondition().isDAafterFalse(v);
        }
        if(caller == getTrueExprNoTransform()) {
            return  getCondition().isDAafterTrue(v);
        }
        if(caller == getConditionNoTransform()) {
            return  isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in DefiniteAssignment.jrag at line 817
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getFalseExprNoTransform()) {
            return  getCondition().isDUafterFalse(v);
        }
        if(caller == getTrueExprNoTransform()) {
            return  getCondition().isDUafterTrue(v);
        }
        if(caller == getConditionNoTransform()) {
            return  isDUbefore(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
