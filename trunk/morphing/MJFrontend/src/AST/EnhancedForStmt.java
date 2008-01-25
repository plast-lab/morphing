
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;
public class EnhancedForStmt extends BranchTargetStmt implements Cloneable,  VariableScope {
    public void flushCache() {
        super.flushCache();
        targetOf_ContinueStmt_values = null;
        targetOf_BreakStmt_values = null;
        canCompleteNormally_computed = false;
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        EnhancedForStmt node = (EnhancedForStmt)super.clone();
        node.targetOf_ContinueStmt_values = null;
        node.targetOf_BreakStmt_values = null;
        node.canCompleteNormally_computed = false;
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          EnhancedForStmt node = (EnhancedForStmt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        EnhancedForStmt res = (EnhancedForStmt)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in EnhancedFor.jrag at line 6

  // type checking
	public void typeCheck() {
		if (!getExpr().type().isArrayDecl() && !getExpr().type().isIterable()) {
			error("*** Semantic error: type " + getExpr().type().name() + 
			      " of expression in foreach is neither array type nor java.lang.Iterable");
		}	
	}

    // Declared in EnhancedFor.jrag at line 40

  
	// pretty printing
  public void toString(StringBuffer s) {
    s.append("for (");
    getParameter().toString(s);
    s.append(" : ");
    getExpr().toString(s);
    s.append(") ");
    getStmt().toString(s);
  }

    // Declared in EnhancedFor.ast at line 3
    // Declared in EnhancedFor.ast line 1

    public EnhancedForStmt() {
        super();

        setChild(null, 0);
        setChild(null, 1);
        setChild(null, 2);

    }

    // Declared in EnhancedFor.ast at line 13


    // Declared in EnhancedFor.ast line 1
    public EnhancedForStmt(ParameterDeclaration p0, Expr p1, Stmt p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in EnhancedFor.ast at line 19


  protected int numChildren() {
    return 3;
  }

    // Declared in EnhancedFor.ast at line 22

  public boolean mayHaveRewrite() { return false; }

    // Declared in EnhancedFor.ast at line 2
    // Declared in EnhancedFor.ast line 1
    public void setParameter(ParameterDeclaration node) {
        setChild(node, 0);
    }

    // Declared in EnhancedFor.ast at line 5

    public ParameterDeclaration getParameter() {
        return (ParameterDeclaration)getChild(0);
    }

    // Declared in EnhancedFor.ast at line 9


    public ParameterDeclaration getParameterNoTransform() {
        return (ParameterDeclaration)getChildNoTransform(0);
    }

    // Declared in EnhancedFor.ast at line 2
    // Declared in EnhancedFor.ast line 1
    public void setExpr(Expr node) {
        setChild(node, 1);
    }

    // Declared in EnhancedFor.ast at line 5

    public Expr getExpr() {
        return (Expr)getChild(1);
    }

    // Declared in EnhancedFor.ast at line 9


    public Expr getExprNoTransform() {
        return (Expr)getChildNoTransform(1);
    }

    // Declared in EnhancedFor.ast at line 2
    // Declared in EnhancedFor.ast line 1
    public void setStmt(Stmt node) {
        setChild(node, 2);
    }

    // Declared in EnhancedFor.ast at line 5

    public Stmt getStmt() {
        return (Stmt)getChild(2);
    }

    // Declared in EnhancedFor.ast at line 9


    public Stmt getStmtNoTransform() {
        return (Stmt)getChildNoTransform(2);
    }

    // Declared in EnhancedFor.jrag at line 32
    public SimpleSet localLookupVariable(String name) {
        SimpleSet localLookupVariable_String_value = localLookupVariable_compute(name);
        return localLookupVariable_String_value;
    }

    private SimpleSet localLookupVariable_compute(String name)  {
		if(getParameter().name().equals(name)) {
      return SimpleSet.emptySet.add(getParameter());
    }
 	  return lookupVariable(name);
	}

    protected java.util.Map targetOf_ContinueStmt_values;
    // Declared in EnhancedFor.jrag at line 54
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
    // Declared in EnhancedFor.jrag at line 55
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

    // Declared in EnhancedFor.jrag at line 58
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

    private boolean canCompleteNormally_compute() {  return  reachable();  }

    // Declared in EnhancedFor.jrag at line 62
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
    if(!isDAbefore(v))
      return false;
    for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
      BreakStmt stmt = (BreakStmt)iter.next();
      if(!stmt.isDAafterReachedFinallyBlocks(v))
        return false;
    }
    return isDAbefore(v);
  }

    // Declared in EnhancedFor.jrag at line 75
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
    for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
      BreakStmt stmt = (BreakStmt)iter.next();
      if(!stmt.isDUafterReachedFinallyBlocks(v))
        return false;
    }
    return isDUbefore(v);
  }

    // Declared in EnhancedFor.jrag at line 87
    public boolean continueLabel() {
        boolean continueLabel_value = continueLabel_compute();
        return continueLabel_value;
    }

    private boolean continueLabel_compute() {  return  true;  }

    // Declared in EnhancedFor.jrag at line 20
    public SimpleSet lookupVariable(String name) {
        SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);
        return lookupVariable_String_value;
    }

    // Declared in EnhancedFor.jrag at line 51
    public boolean Define_boolean_isConstructorParameter(ASTNode caller, ASTNode child) {
        if(caller == getParameterNoTransform()) {
            return  false;
        }
        return getParent().Define_boolean_isConstructorParameter(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 86
    public boolean Define_boolean_insideLoop(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_insideLoop(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 50
    public boolean Define_boolean_isMethodParameter(ASTNode caller, ASTNode child) {
        if(caller == getParameterNoTransform()) {
            return  false;
        }
        return getParent().Define_boolean_isMethodParameter(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 23
    public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
        if(caller == getStmtNoTransform()) {
            return  localLookupVariable(name);
        }
        if(caller == getExprNoTransform()) {
            return  localLookupVariable(name);
        }
        if(caller == getParameterNoTransform()) {
            return  localLookupVariable(name);
        }
        return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }

    // Declared in VariableArityParameters.jrag at line 15
    public boolean Define_boolean_variableArityValid(ASTNode caller, ASTNode child) {
        if(caller == getParameterNoTransform()) {
            return  false;
        }
        return getParent().Define_boolean_variableArityValid(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 52
    public boolean Define_boolean_isExceptionHandlerParameter(ASTNode caller, ASTNode child) {
        if(caller == getParameterNoTransform()) {
            return  false;
        }
        return getParent().Define_boolean_isExceptionHandlerParameter(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 59
    public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  reachable();
        }
        return getParent().Define_boolean_reachable(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 73
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getStmtNoTransform()) {
            return  isDAbefore(v);
        }
        if(caller == getExprNoTransform()) {
            return  isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in EnhancedFor.jrag at line 30
    public VariableScope Define_VariableScope_outerScope(ASTNode caller, ASTNode child) {
        if(caller == getStmtNoTransform()) {
            return  this;
        }
        if(caller == getExprNoTransform()) {
            return  this;
        }
        if(caller == getParameterNoTransform()) {
            return  this;
        }
        return getParent().Define_VariableScope_outerScope(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 25
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getParameterNoTransform()) {
            return  NameType.TYPE_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in EnhancedFor.jrag at line 84
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getStmtNoTransform()) {
            return  isDUbefore(v);
        }
        if(caller == getExprNoTransform()) {
            return  isDUbefore(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
