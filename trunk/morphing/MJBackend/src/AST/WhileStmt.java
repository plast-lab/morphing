
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class WhileStmt extends BranchTargetStmt implements Cloneable {
    public void flushCache() {
        super.flushCache();
        targetOf_ContinueStmt_values = null;
        targetOf_BreakStmt_values = null;
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
        canCompleteNormally_computed = false;
        cond_label_computed = false;
        end_label_computed = false;
        stmt_label_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        WhileStmt node = (WhileStmt)super.clone();
        node.targetOf_ContinueStmt_values = null;
        node.targetOf_BreakStmt_values = null;
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.canCompleteNormally_computed = false;
        node.cond_label_computed = false;
        node.end_label_computed = false;
        node.stmt_label_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          WhileStmt node = (WhileStmt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        WhileStmt res = (WhileStmt)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in DefiniteAssignment.jrag at line 1050


  // 16.2.10 3rd bullet
  private boolean conditionVisited;

    // Declared in DefiniteAssignment.jrag at line 1051

  private boolean isDUbeforeCondition(Variable v) {
    if(conditionVisited)
      return true;
    conditionVisited = true;
    boolean result = true;
    // 1st
    if(!isDUbefore(v))
      result = false;
    // 
    else if(!getStmt().isDUafter(v))
      result = false;
    else {
      //for(Iterator iter = continueTarget(); iter.hasNext(); ) {
      for(Iterator iter = targetContinues().iterator(); iter.hasNext(); ) {
        ContinueStmt stmt = (ContinueStmt)iter.next();
        if(!stmt.isDUafterReachedFinallyBlocks(v))
          result = false;
      }
    }
    conditionVisited = false;
    return result;
  }

    // Declared in PrettyPrint.jadd at line 744


  public void toString(StringBuffer s) {
    super.toString(s);
    s.append("while(");
    getCondition().toString(s);
    s.append(") ");
    getStmt().toString(s);
  }

    // Declared in TypeCheck.jrag at line 311

  public void typeCheck() {
    TypeDecl cond = getCondition().type();
    if(!cond.isBoolean()) {
      error("the type of \"" + getCondition() + "\" is " + cond.name() + " which is not boolean");
    }
  }

    // Declared in CreateBCode.jrag at line 1410


  public void createBCode(CodeGeneration gen) {
    super.createBCode(gen);
    gen.addLabel(cond_label());
    getCondition().emitEvalBranch(gen);
    gen.addLabel(stmt_label());
    if(getCondition().canBeTrue()) {
      getStmt().createBCode(gen);
      if(getStmt().canCompleteNormally())
        gen.emitGoto(cond_label());
    }
    gen.addLabel(end_label());
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 212

    public WhileStmt() {
        super();

        setChild(null, 0);
        setChild(null, 1);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 212
    public WhileStmt(Expr p0, Stmt p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in java.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in java.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 212
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
    // Declared in java.ast line 212
    public void setStmt(Stmt node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Stmt getStmt() {
        return (Stmt)getChild(1);
    }

    // Declared in java.ast at line 9


    public Stmt getStmtNoTransform() {
        return (Stmt)getChildNoTransform(1);
    }

    protected java.util.Map targetOf_ContinueStmt_values;
    // Declared in BranchTarget.jrag at line 61
    public boolean targetOf(ContinueStmt stmt) {
        Object _parameters = stmt;
if(targetOf_ContinueStmt_values == null) targetOf_ContinueStmt_values = new java.util.HashMap(4);
        if(targetOf_ContinueStmt_values.containsKey(_parameters))
            return ((Boolean)targetOf_ContinueStmt_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean targetOf_ContinueStmt_value = targetOf_compute(stmt);
        if(isFinal && num == boundariesCrossed)
            targetOf_ContinueStmt_values.put(_parameters, Boolean.valueOf(targetOf_ContinueStmt_value));
        return targetOf_ContinueStmt_value;
    }

    private boolean targetOf_compute(ContinueStmt stmt) {  return  !stmt.hasLabel();  }

    protected java.util.Map targetOf_BreakStmt_values;
    // Declared in BranchTarget.jrag at line 69
    public boolean targetOf(BreakStmt stmt) {
        Object _parameters = stmt;
if(targetOf_BreakStmt_values == null) targetOf_BreakStmt_values = new java.util.HashMap(4);
        if(targetOf_BreakStmt_values.containsKey(_parameters))
            return ((Boolean)targetOf_BreakStmt_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean targetOf_BreakStmt_value = targetOf_compute(stmt);
        if(isFinal && num == boundariesCrossed)
            targetOf_BreakStmt_values.put(_parameters, Boolean.valueOf(targetOf_BreakStmt_value));
        return targetOf_BreakStmt_value;
    }

    private boolean targetOf_compute(BreakStmt stmt) {  return  !stmt.hasLabel();  }

    // Declared in DefiniteAssignment.jrag at line 570
    public boolean isDAafter(Variable v) {
        Object _parameters = v;
if(isDAafter_Variable_values == null) isDAafter_Variable_values = new java.util.HashMap(4);
        if(isDAafter_Variable_values.containsKey(_parameters))
            return ((Boolean)isDAafter_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDAafter_Variable_value = isDAafter_compute(v);
        if(isFinal && num == boundariesCrossed)
            isDAafter_Variable_values.put(_parameters, Boolean.valueOf(isDAafter_Variable_value));
        return isDAafter_Variable_value;
    }

    private boolean isDAafter_compute(Variable v)  {
    if(!getCondition().isDAafterFalse(v))
      return false;
    for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
      BreakStmt stmt = (BreakStmt)iter.next();
      if(!stmt.isDAafterReachedFinallyBlocks(v))
        return false;
    }
    return true;
  }

    // Declared in DefiniteAssignment.jrag at line 1035
    public boolean isDUafter(Variable v) {
        Object _parameters = v;
if(isDUafter_Variable_values == null) isDUafter_Variable_values = new java.util.HashMap(4);
        if(isDUafter_Variable_values.containsKey(_parameters))
            return ((Boolean)isDUafter_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDUafter_Variable_value = isDUafter_compute(v);
        if(isFinal && num == boundariesCrossed)
            isDUafter_Variable_values.put(_parameters, Boolean.valueOf(isDUafter_Variable_value));
        return isDUafter_Variable_value;
    }

    private boolean isDUafter_compute(Variable v)  {
    if(!getCondition().isDUafterFalse(v))
      return false;
    for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
      BreakStmt stmt = (BreakStmt)iter.next();
      if(!stmt.isDUafterReachedFinallyBlocks(v))
        return false;
    }
    return true;
  }

    // Declared in NameCheck.jrag at line 393
    public boolean continueLabel() {
        boolean continueLabel_value = continueLabel_compute();
        return continueLabel_value;
    }

    private boolean continueLabel_compute() {  return  true;  }

    // Declared in UnreachableStatements.jrag at line 76
    public boolean canCompleteNormally() {
        if(canCompleteNormally_computed)
            return canCompleteNormally_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        canCompleteNormally_value = canCompleteNormally_compute();
        if(isFinal && num == boundariesCrossed)
            canCompleteNormally_computed = true;
        return canCompleteNormally_value;
    }

    private boolean canCompleteNormally_compute() {  return  reachable() && (!getCondition().isConstant() || !getCondition().isTrue()) || reachableBreak();  }

    // Declared in CreateBCode.jrag at line 1022
    public boolean definesLabel() {
        boolean definesLabel_value = definesLabel_compute();
        return definesLabel_value;
    }

    private boolean definesLabel_compute() {  return  true;  }

    protected boolean cond_label_computed = false;
    protected int cond_label_value;
    // Declared in CreateBCode.jrag at line 1406
    public int cond_label() {
        if(cond_label_computed)
            return cond_label_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        cond_label_value = cond_label_compute();
        if(isFinal && num == boundariesCrossed)
            cond_label_computed = true;
        return cond_label_value;
    }

    private int cond_label_compute() {  return  hostType().constantPool().newLabel();  }

    protected boolean end_label_computed = false;
    protected int end_label_value;
    // Declared in CreateBCode.jrag at line 1407
    public int end_label() {
        if(end_label_computed)
            return end_label_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        end_label_value = end_label_compute();
        if(isFinal && num == boundariesCrossed)
            end_label_computed = true;
        return end_label_value;
    }

    private int end_label_compute() {  return  hostType().constantPool().newLabel();  }

    protected boolean stmt_label_computed = false;
    protected int stmt_label_value;
    // Declared in CreateBCode.jrag at line 1408
    public int stmt_label() {
        if(stmt_label_computed)
            return stmt_label_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        stmt_label_value = stmt_label_compute();
        if(isFinal && num == boundariesCrossed)
            stmt_label_computed = true;
        return stmt_label_value;
    }

    private int stmt_label_compute() {  return  hostType().constantPool().newLabel();  }

    // Declared in CreateBCode.jrag at line 1466
    public int break_label() {
        int break_label_value = break_label_compute();
        return break_label_value;
    }

    private int break_label_compute() {  return  end_label();  }

    // Declared in CreateBCode.jrag at line 1485
    public int continue_label() {
        int continue_label_value = continue_label_compute();
        return continue_label_value;
    }

    private int continue_label_compute() {  return  cond_label();  }

    // Declared in NameCheck.jrag at line 361
    public boolean Define_boolean_insideLoop(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_insideLoop(this, caller);
    }

    // Declared in CreateBCode.jrag at line 1030
    public int Define_int_condition_true_label(ASTNode caller, ASTNode child) {
        if(caller == getConditionNoTransform()) {
            return  stmt_label();
        }
        return getParent().Define_int_condition_true_label(this, caller);
    }

    // Declared in CreateBCode.jrag at line 1029
    public int Define_int_condition_false_label(ASTNode caller, ASTNode child) {
        if(caller == getConditionNoTransform()) {
            return  end_label();
        }
        return getParent().Define_int_condition_false_label(this, caller);
    }

    // Declared in UnreachableStatements.jrag at line 142
    public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  reachable();
        }
        return getParent().Define_boolean_reportUnreachable(this, caller);
    }

    // Declared in UnreachableStatements.jrag at line 77
    public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  reachable() && !getCondition().isFalse();
        }
        return getParent().Define_boolean_reachable(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 581
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getStmtNoTransform()) {
            return  getCondition().isDAafterTrue(v);
        }
        if(caller == getConditionNoTransform()) {
            return  isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in DefiniteAssignment.jrag at line 1075
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getStmtNoTransform()) {
            return  getCondition().isDUafterTrue(v);
        }
        if(caller == getConditionNoTransform()) {
            return  isDUbeforeCondition(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
