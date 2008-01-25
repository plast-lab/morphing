
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class DoStmt extends BranchTargetStmt implements Cloneable {
    public void flushCache() {
        super.flushCache();
        targetOf_ContinueStmt_values = null;
        targetOf_BreakStmt_values = null;
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
        canCompleteNormally_computed = false;
        begin_label_computed = false;
        cond_label_computed = false;
        end_label_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        DoStmt node = (DoStmt)super.clone();
        node.targetOf_ContinueStmt_values = null;
        node.targetOf_BreakStmt_values = null;
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.canCompleteNormally_computed = false;
        node.begin_label_computed = false;
        node.cond_label_computed = false;
        node.end_label_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          DoStmt node = (DoStmt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        DoStmt res = (DoStmt)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in DefiniteAssignment.jrag at line 1088

  private boolean conditionVisited;

    // Declared in PrettyPrint.jadd at line 752


  public void toString(StringBuffer s) {
    super.toString(s);
    s.append("do ");
    getStmt().toString(s);
    s.append("while(");
    getCondition().toString(s);
    s.append(");\n");
  }

    // Declared in TypeCheck.jrag at line 317

  public void typeCheck() {
    TypeDecl cond = getCondition().type();
    if(!cond.isBoolean()) {
      error("the type of \"" + getCondition() + "\" is " + cond.name() + " which is not boolean");
    }
  }

    // Declared in CreateBCode.jrag at line 1427


  public void createBCode(CodeGeneration gen) {
    super.createBCode(gen);
    gen.addLabel(begin_label());
    getStmt().createBCode(gen);
    gen.addLabel(cond_label());
    getCondition().emitEvalBranch(gen);
    gen.addLabel(end_label());
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 213

    public DoStmt() {
        super();

        setChild(null, 0);
        setChild(null, 1);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 213
    public DoStmt(Stmt p0, Expr p1) {
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
    // Declared in java.ast line 213
    public void setStmt(Stmt node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Stmt getStmt() {
        return (Stmt)getChild(0);
    }

    // Declared in java.ast at line 9


    public Stmt getStmtNoTransform() {
        return (Stmt)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 213
    public void setCondition(Expr node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Expr getCondition() {
        return (Expr)getChild(1);
    }

    // Declared in java.ast at line 9


    public Expr getConditionNoTransform() {
        return (Expr)getChildNoTransform(1);
    }

    protected java.util.Map targetOf_ContinueStmt_values;
    // Declared in BranchTarget.jrag at line 62
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
    // Declared in BranchTarget.jrag at line 70
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

    // Declared in DefiniteAssignment.jrag at line 583
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

    // Declared in DefiniteAssignment.jrag at line 1077
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

    // Declared in NameCheck.jrag at line 394
    public boolean continueLabel() {
        boolean continueLabel_value = continueLabel_compute();
        return continueLabel_value;
    }

    private boolean continueLabel_compute() {  return  true;  }

    // Declared in UnreachableStatements.jrag at line 79
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

    private boolean canCompleteNormally_compute() {  return  getStmt().canCompleteNormally() && (!getCondition().isConstant() || !getCondition().isTrue())
    || reachableContinue() && (!getCondition().isConstant() || !getCondition().isTrue()) || reachableBreak();  }

    // Declared in CreateBCode.jrag at line 1023
    public boolean definesLabel() {
        boolean definesLabel_value = definesLabel_compute();
        return definesLabel_value;
    }

    private boolean definesLabel_compute() {  return  true;  }

    protected boolean begin_label_computed = false;
    protected int begin_label_value;
    // Declared in CreateBCode.jrag at line 1423
    public int begin_label() {
        if(begin_label_computed)
            return begin_label_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        begin_label_value = begin_label_compute();
        if(isFinal && num == boundariesCrossed)
            begin_label_computed = true;
        return begin_label_value;
    }

    private int begin_label_compute() {  return  hostType().constantPool().newLabel();  }

    protected boolean cond_label_computed = false;
    protected int cond_label_value;
    // Declared in CreateBCode.jrag at line 1424
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
    // Declared in CreateBCode.jrag at line 1425
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

    // Declared in CreateBCode.jrag at line 1467
    public int break_label() {
        int break_label_value = break_label_compute();
        return break_label_value;
    }

    private int break_label_compute() {  return  end_label();  }

    // Declared in CreateBCode.jrag at line 1486
    public int continue_label() {
        int continue_label_value = continue_label_compute();
        return continue_label_value;
    }

    private int continue_label_compute() {  return  cond_label();  }

    // Declared in NameCheck.jrag at line 362
    public boolean Define_boolean_insideLoop(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_insideLoop(this, caller);
    }

    // Declared in CreateBCode.jrag at line 1032
    public int Define_int_condition_true_label(ASTNode caller, ASTNode child) {
        if(caller == getConditionNoTransform()) {
            return  begin_label();
        }
        return getParent().Define_int_condition_true_label(this, caller);
    }

    // Declared in CreateBCode.jrag at line 1031
    public int Define_int_condition_false_label(ASTNode caller, ASTNode child) {
        if(caller == getConditionNoTransform()) {
            return  end_label();
        }
        return getParent().Define_int_condition_false_label(this, caller);
    }

    // Declared in UnreachableStatements.jrag at line 141
    public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  reachable();
        }
        return getParent().Define_boolean_reportUnreachable(this, caller);
    }

    // Declared in UnreachableStatements.jrag at line 91
    public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  reachable();
        }
        return getParent().Define_boolean_reachable(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 594
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getConditionNoTransform()) {
    if(!getStmt().isDAafter(v))
      return false;
    for(Iterator iter = targetContinues().iterator(); iter.hasNext(); ) {
      ContinueStmt stmt = (ContinueStmt)iter.next();
      if(!stmt.isDAafterReachedFinallyBlocks(v))
        return false;
    }
    return true;
  }
        if(caller == getStmtNoTransform()) {
            return  isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in DefiniteAssignment.jrag at line 1089
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getConditionNoTransform()) {
    if(conditionVisited)
      return true;
    conditionVisited = true;
    boolean result = true;
    if(!getStmt().isDUafter(v))
      result = false;
    else {
      for(Iterator iter = targetContinues().iterator(); iter.hasNext(); ) {
        ContinueStmt stmt = (ContinueStmt)iter.next();
        if(!stmt.isDUafterReachedFinallyBlocks(v))
          result = false;
      }
    }
    conditionVisited = false;
    return result;
  }
        if(caller == getStmtNoTransform()) {
            return  isDUbefore(v) && getCondition().isDUafterTrue(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
