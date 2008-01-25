
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;
  // a statement that can be reached by break or continue
public class Block extends Stmt implements Cloneable,  VariableScope {
    public void flushCache() {
        super.flushCache();
        checkReturnDA_Variable_values = null;
        isDAafter_Variable_values = null;
        checkReturnDU_Variable_values = null;
        isDUafter_Variable_values = null;
        localVariableDeclaration_String_values = null;
        canCompleteNormally_computed = false;
        variableScopeEndLabel_CodeGeneration_values = null;
        lookupType_String_values = null;
        lookupVariable_String_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        Block node = (Block)super.clone();
        node.checkReturnDA_Variable_values = null;
        node.isDAafter_Variable_values = null;
        node.checkReturnDU_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.localVariableDeclaration_String_values = null;
        node.canCompleteNormally_computed = false;
        node.variableScopeEndLabel_CodeGeneration_values = null;
        node.lookupType_String_values = null;
        node.lookupVariable_String_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          Block node = (Block)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Block res = (Block)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in DeclareBeforeUse.jrag at line 12


  public boolean declaredBeforeUse(Variable decl, ASTNode use) {
    int indexDecl = ((ASTNode)decl).varChildIndex(this);
    int indexUse = use.varChildIndex(this);
    return indexDecl <= indexUse;
  }

    // Declared in DeclareBeforeUse.jrag at line 17

  public boolean declaredBeforeUse(Variable decl, int indexUse) {
    int indexDecl = ((ASTNode)decl).varChildIndex(this);
    return indexDecl <= indexUse;
  }

    // Declared in PrettyPrint.jadd at line 680


  public void toString(StringBuffer s) {
    super.toString(s);
    s.append("{\n");
    indent++;
    for(int i = 0; i < getNumStmt(); i++) {
      s.append(indent());
      getStmt(i).toString(s);
    }
    indent--;
    s.append(indent());
    s.append("}\n");
  }

    // Declared in CreateBCode.jrag at line 1242

  
  public void createBCode(CodeGeneration gen) {
    //super.createBCode(gen);
    for(int i = 0; i < getNumStmt(); i++) {
      try {
        getStmt(i).createBCode(gen);
      } catch (Exception e) {
        e.printStackTrace();
        throw new Error("Error generating code for " + errorPrefix() + " " + getStmt(i));
      }
    }
    gen.addVariableScopeLabel(variableScopeEndLabel(gen));
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 201

    public Block() {
        super();

        setChild(new List(), 0);

    }

    // Declared in java.ast at line 11


    // Declared in java.ast line 201
    public Block(List p0) {
        setChild(p0, 0);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 201
    public void setStmtList(List list) {
        setChild(list, 0);
    }

    // Declared in java.ast at line 6


    public int getNumStmt() {
        return getStmtList().getNumChild();
    }

    // Declared in java.ast at line 10


    public Stmt getStmt(int i) {
        return (Stmt)getStmtList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addStmt(Stmt node) {
        List list = getStmtList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setStmt(Stmt node, int i) {
        List list = getStmtList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getStmtList() {
        return (List)getChild(0);
    }

    // Declared in java.ast at line 27


    public List getStmtListNoTransform() {
        return (List)getChildNoTransform(0);
    }

    protected java.util.Map checkReturnDA_Variable_values;
    // Declared in DefiniteAssignment.jrag at line 289
    public boolean checkReturnDA(Variable v) {
        Object _parameters = v;
if(checkReturnDA_Variable_values == null) checkReturnDA_Variable_values = new java.util.HashMap(4);
        if(checkReturnDA_Variable_values.containsKey(_parameters))
            return ((Boolean)checkReturnDA_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean checkReturnDA_Variable_value = checkReturnDA_compute(v);
        if(isFinal && num == boundariesCrossed)
            checkReturnDA_Variable_values.put(_parameters, Boolean.valueOf(checkReturnDA_Variable_value));
        return checkReturnDA_Variable_value;
    }

    private boolean checkReturnDA_compute(Variable v)  {
    HashSet set = new HashSet();
    collectBranches(set);
    for(Iterator iter = set.iterator(); iter.hasNext(); ) {
      Object o = iter.next();
      if(o instanceof ReturnStmt) {
        ReturnStmt stmt = (ReturnStmt)o;
        if(!stmt.isDAafterReachedFinallyBlocks(v))
          return false;
      }
    }
    return true;
  }

    // Declared in DefiniteAssignment.jrag at line 435
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

    private boolean isDAafter_compute(Variable v) {  return  getNumStmt() == 0 ? isDAbefore(v) : getStmt(getNumStmt()-1).isDAafter(v);  }

    // Declared in DefiniteAssignment.jrag at line 441
    public boolean isDUeverywhere(Variable v) {
        boolean isDUeverywhere_Variable_value = isDUeverywhere_compute(v);
        return isDUeverywhere_Variable_value;
    }

    private boolean isDUeverywhere_compute(Variable v) {  return  isDUbefore(v) && checkDUeverywhere(v);  }

    protected java.util.Map checkReturnDU_Variable_values;
    // Declared in DefiniteAssignment.jrag at line 751
    public boolean checkReturnDU(Variable v) {
        Object _parameters = v;
if(checkReturnDU_Variable_values == null) checkReturnDU_Variable_values = new java.util.HashMap(4);
        if(checkReturnDU_Variable_values.containsKey(_parameters))
            return ((Boolean)checkReturnDU_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean checkReturnDU_Variable_value = checkReturnDU_compute(v);
        if(isFinal && num == boundariesCrossed)
            checkReturnDU_Variable_values.put(_parameters, Boolean.valueOf(checkReturnDU_Variable_value));
        return checkReturnDU_Variable_value;
    }

    private boolean checkReturnDU_compute(Variable v)  {
    HashSet set = new HashSet();
    collectBranches(set);
    for(Iterator iter = set.iterator(); iter.hasNext(); ) {
      Object o = iter.next();
      if(o instanceof ReturnStmt) {
        ReturnStmt stmt = (ReturnStmt)o;
        if(!stmt.isDUafterReachedFinallyBlocks(v))
          return false;
      }
    }
    return true;
  }

    // Declared in DefiniteAssignment.jrag at line 873
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

    private boolean isDUafter_compute(Variable v) {  return  getNumStmt() == 0 ? isDUbefore(v) : getStmt(getNumStmt()-1).isDUafter(v);  }

    protected java.util.Map localVariableDeclaration_String_values;
    // Declared in LookupVariable.jrag at line 107
    public VariableDeclaration localVariableDeclaration(String name) {
        Object _parameters = name;
if(localVariableDeclaration_String_values == null) localVariableDeclaration_String_values = new java.util.HashMap(4);
        if(localVariableDeclaration_String_values.containsKey(_parameters))
            return (VariableDeclaration)localVariableDeclaration_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        VariableDeclaration localVariableDeclaration_String_value = localVariableDeclaration_compute(name);
        if(isFinal && num == boundariesCrossed)
            localVariableDeclaration_String_values.put(_parameters, localVariableDeclaration_String_value);
        return localVariableDeclaration_String_value;
    }

    private VariableDeclaration localVariableDeclaration_compute(String name)  {
    for(int i = 0; i < getNumStmt(); i++)
      if(getStmt(i).declaresVariable(name))
        return (VariableDeclaration)getStmt(i);
    return null;
  }

    // Declared in UnreachableStatements.jrag at line 28
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

    private boolean canCompleteNormally_compute() {  return  getNumStmt() == 0 ? reachable() : getStmt(getNumStmt() - 1).canCompleteNormally();  }

    protected java.util.Map variableScopeEndLabel_CodeGeneration_values;
    // Declared in CodeGeneration.jrag at line 34
    public int variableScopeEndLabel(CodeGeneration gen) {
        Object _parameters = gen;
if(variableScopeEndLabel_CodeGeneration_values == null) variableScopeEndLabel_CodeGeneration_values = new java.util.HashMap(4);
        if(variableScopeEndLabel_CodeGeneration_values.containsKey(_parameters))
            return ((Integer)variableScopeEndLabel_CodeGeneration_values.get(_parameters)).intValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        int variableScopeEndLabel_CodeGeneration_value = variableScopeEndLabel_compute(gen);
        if(isFinal && num == boundariesCrossed)
            variableScopeEndLabel_CodeGeneration_values.put(_parameters, new Integer(variableScopeEndLabel_CodeGeneration_value));
        return variableScopeEndLabel_CodeGeneration_value;
    }

    private int variableScopeEndLabel_compute(CodeGeneration gen) {  return  gen.variableScopeLabel();  }

    protected java.util.Map lookupType_String_values;
    // Declared in LookupType.jrag at line 174
    public SimpleSet lookupType(String name) {
        Object _parameters = name;
if(lookupType_String_values == null) lookupType_String_values = new java.util.HashMap(4);
        if(lookupType_String_values.containsKey(_parameters))
            return (SimpleSet)lookupType_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet lookupType_String_value = getParent().Define_SimpleSet_lookupType(this, null, name);
        if(isFinal && num == boundariesCrossed)
            lookupType_String_values.put(_parameters, lookupType_String_value);
        return lookupType_String_value;
    }

    protected java.util.Map lookupVariable_String_values;
    // Declared in LookupVariable.jrag at line 8
    public SimpleSet lookupVariable(String name) {
        Object _parameters = name;
if(lookupVariable_String_values == null) lookupVariable_String_values = new java.util.HashMap(4);
        if(lookupVariable_String_values.containsKey(_parameters))
            return (SimpleSet)lookupVariable_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);
        if(isFinal && num == boundariesCrossed)
            lookupVariable_String_values.put(_parameters, lookupVariable_String_value);
        return lookupVariable_String_value;
    }

    // Declared in UnreachableStatements.jrag at line 19
    public boolean reachable() {
        boolean reachable_value = getParent().Define_boolean_reachable(this, null);
        return reachable_value;
    }

    // Declared in LocalNum.jrag at line 97
    public int Define_int_localNum(ASTNode caller, ASTNode child) {
        if(caller == getStmtListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    if(index == 0)
      return localNum();
    if(getStmt(index-1) instanceof VariableDeclaration)
      return getStmt(index-1).localNum() + ((VariableDeclaration)getStmt(index-1)).type().variableSize();
    return getStmt(index-1).localNum();
  }
}
        return getParent().Define_int_localNum(this, caller);
    }

    // Declared in LookupVariable.jrag at line 61
    public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
        if(caller == getStmtListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    VariableDeclaration v = localVariableDeclaration(name);
    // declare before use and shadowing
    if(v != null && declaredBeforeUse(v, index))
      return v;
    return lookupVariable(name);
  }
}
        return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }

    // Declared in CodeGeneration.jrag at line 35
    public int Define_int_variableScopeEndLabel(ASTNode caller, ASTNode child, CodeGeneration gen) {
        if(caller == getStmtListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  variableScopeEndLabel(gen);
        }
        return getParent().Define_int_variableScopeEndLabel(this, caller, gen);
    }

    // Declared in UnreachableStatements.jrag at line 137
    public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
        if(caller == getStmtListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  i == 0 ? reachable() : getStmt(i-1).reachable();
        }
        return getParent().Define_boolean_reportUnreachable(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 41
    public boolean Define_boolean_isIncOrDec(ASTNode caller, ASTNode child) {
        if(caller == getStmtListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isIncOrDec(this, caller);
    }

    // Declared in UnreachableStatements.jrag at line 29
    public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
        if(caller == getStmtListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  childIndex == 0 ? reachable() : getStmt(childIndex-1).canCompleteNormally();
        }
        return getParent().Define_boolean_reachable(this, caller);
    }

    // Declared in SyntacticClassification.jrag at line 106
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getStmtListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.EXPRESSION_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in NameCheck.jrag at line 279
    public VariableScope Define_VariableScope_outerScope(ASTNode caller, ASTNode child) {
        if(caller == getStmtListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  this;
        }
        return getParent().Define_VariableScope_outerScope(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 438
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getStmtListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return  index == 0 ? isDAbefore(v) : getStmt(index - 1).isDAafter(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in LookupType.jrag at line 233
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(caller == getStmtListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    SimpleSet c = SimpleSet.emptySet;
    for(int i = index - 1; i >= 0 && !(getStmt(i) instanceof Case); i--) {
      if(getStmt(i) instanceof LocalClassDeclStmt) {
        TypeDecl t = ((LocalClassDeclStmt)getStmt(i)).getClassDecl();
        if(t.name().equals(name)) {
          c = c.add(t);
        }
      }
    }
    if(!c.isEmpty())
      return c;
    return lookupType(name);
  }
}
        return getParent().Define_SimpleSet_lookupType(this, caller, name);
    }

    // Declared in DefiniteAssignment.jrag at line 874
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getStmtListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return  index == 0 ? isDUbefore(v) : getStmt(index - 1).isDUafter(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
