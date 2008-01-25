
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class VariableDeclaration extends Stmt implements Cloneable,  SimpleSet,  Iterator,  Variable {
    public void flushCache() {
        super.flushCache();
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
        constant_computed = false;
        constant_value = null;
        localNum_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        VariableDeclaration node = (VariableDeclaration)super.clone();
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.constant_computed = false;
        node.constant_value = null;
        node.localNum_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          VariableDeclaration node = (VariableDeclaration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        VariableDeclaration res = (VariableDeclaration)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in DataStructures.jrag at line 76

  public SimpleSet add(Object o) {
    return new SimpleSetImpl().add(this).add(o);
  }

    // Declared in DataStructures.jrag at line 82

  private VariableDeclaration iterElem;

    // Declared in DataStructures.jrag at line 83

  public Iterator iterator() { iterElem = this; return this; }

    // Declared in DataStructures.jrag at line 84

  public boolean hasNext() { return iterElem != null; }

    // Declared in DataStructures.jrag at line 85

  public Object next() { Object o = iterElem; iterElem = null; return o; }

    // Declared in DataStructures.jrag at line 86

  public void remove() { throw new UnsupportedOperationException(); }

    // Declared in NameCheck.jrag at line 295

  
  public void nameCheck() {
    SimpleSet decls = outerScope().lookupVariable(name());
    for(Iterator iter = decls.iterator(); iter.hasNext(); ) {
      Variable var = (Variable)iter.next();
      if(var instanceof VariableDeclaration) {
        VariableDeclaration decl = (VariableDeclaration)var;
        if(decl != this && decl.enclosingBodyDecl() == enclosingBodyDecl())
  	      error("duplicate declaration of local variable " + name() + " in enclosing scope");
      }
      // 8.4.1
      else if(var instanceof ParameterDeclaration) {
        ParameterDeclaration decl = (ParameterDeclaration)var;
	      if(decl.enclosingBodyDecl() == enclosingBodyDecl())
  	      error("duplicate declaration of local variable and parameter " + name());
      }
    }
    if(getParent().getParent() instanceof Block) {
      Block block = (Block)getParent().getParent();
      for(int i = 0; i < block.getNumStmt(); i++) {
        if(block.getStmt(i) instanceof Variable) {
          Variable v = (Variable)block.getStmt(i);
          if(v.name().equals(name()) && v != this) {
     	    error("duplicate declaration of local variable " + name());
          }
	}
      }
    }
  }

    // Declared in NodeConstructors.jrag at line 69


  public VariableDeclaration(Access type, String name, Expr init) {
    this(new Modifiers(new List()), type, name, new Opt(init));
  }

    // Declared in PrettyPrint.jadd at line 885


  public void toString(StringBuffer s) {
    super.toString(s);
    getModifiers().toString(s);
    getTypeAccess().toString(s);
    s.append(" " + name());
    if(hasInit()) {
      s.append(" = ");
      getInit().toString(s);
    }
    s.append(";\n");
  }

    // Declared in TypeCheck.jrag at line 13

 
  // 5.2
  public void typeCheck() {
    if(hasInit()) {
      TypeDecl source = getInit().type();
      TypeDecl dest = type();
      if(!source.assignConversionTo(dest, getInit()))
        error("can not assign " + name() + " of type " + dest.typeName() +
              " a value of type " + source.typeName());
    }
  }

    // Declared in CreateBCode.jrag at line 190


  public void createBCode(CodeGeneration gen) {
    super.createBCode(gen);
    if(hasInit()) {
      gen.addLocalVariableEntryAtCurrentPC(name(), type().typeDescriptor(), localNum(), variableScopeEndLabel(gen));
      getInit().createBCode(gen);
      getInit().type().emitAssignConvTo(gen, type()); // AssignConversion
      type().emitStoreLocal(gen, localNum());
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 79

    public VariableDeclaration() {
        super();

        setChild(null, 0);
        setChild(null, 1);
        setChild(new Opt(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 79
    public VariableDeclaration(Modifiers p0, Access p1, String p2, Opt p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setID(p2);
        setChild(p3, 2);
    }

    // Declared in java.ast at line 20


  protected int numChildren() {
    return 3;
  }

    // Declared in java.ast at line 23

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 79
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
    // Declared in java.ast line 79
    public void setTypeAccess(Access node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Access getTypeAccess() {
        return (Access)getChild(1);
    }

    // Declared in java.ast at line 9


    public Access getTypeAccessNoTransform() {
        return (Access)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 79
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
    // Declared in java.ast line 79
    public void setInitOpt(Opt opt) {
        setChild(opt, 2);
    }

    // Declared in java.ast at line 6


    public boolean hasInit() {
        return getInitOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Expr getInit() {
        return (Expr)getInitOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setInit(Expr node) {
        getInitOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getInitOpt() {
        return (Opt)getChild(2);
    }

    // Declared in java.ast at line 21


    public Opt getInitOptNoTransform() {
        return (Opt)getChildNoTransform(2);
    }

    // Declared in DataStructures.jrag at line 74
    public int size() {
        int size_value = size_compute();
        return size_value;
    }

    private int size_compute() {  return  1;  }

    // Declared in DataStructures.jrag at line 75
    public boolean isEmpty() {
        boolean isEmpty_value = isEmpty_compute();
        return isEmpty_value;
    }

    private boolean isEmpty_compute() {  return  false;  }

    // Declared in DataStructures.jrag at line 79
    public boolean contains(Object o) {
        boolean contains_Object_value = contains_compute(o);
        return contains_Object_value;
    }

    private boolean contains_compute(Object o) {  return  this == o;  }

    // Declared in DefiniteAssignment.jrag at line 80
    public boolean isBlankFinal() {
        boolean isBlankFinal_value = isBlankFinal_compute();
        return isBlankFinal_value;
    }

    private boolean isBlankFinal_compute() {  return  isFinal() && (!hasInit() || !getInit().isConstant());  }

    // Declared in DefiniteAssignment.jrag at line 81
    public boolean isValue() {
        boolean isValue_value = isValue_compute();
        return isValue_value;
    }

    private boolean isValue_compute() {  return  isFinal() && hasInit() && getInit().isConstant();  }

    // Declared in DefiniteAssignment.jrag at line 486
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
    if(v == this)
      return hasInit();
    return hasInit() ? getInit().isDAafter(v) : isDAbefore(v);
  }

    // Declared in DefiniteAssignment.jrag at line 878
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
    if(v == this)
      return !hasInit();
    return hasInit() ? getInit().isDUafter(v) : isDUbefore(v);
  }

    // Declared in LookupVariable.jrag at line 121
    public boolean declaresVariable(String name) {
        boolean declaresVariable_String_value = declaresVariable_compute(name);
        return declaresVariable_String_value;
    }

    private boolean declaresVariable_compute(String name) {  return  name().equals(name);  }

    // Declared in PrettyPrint.jadd at line 947
    public String dumpString() {
        String dumpString_value = dumpString_compute();
        return dumpString_value;
    }

    private String dumpString_compute() {  return  getClass().getName() + " [" + getID() + "]";  }

    // Declared in TypeAnalysis.jrag at line 243
    public TypeDecl type() {
        TypeDecl type_value = type_compute();
        return type_value;
    }

    private TypeDecl type_compute() {  return  getTypeAccess().type();  }

    // Declared in VariableDeclaration.jrag at line 28
    public boolean isClassVariable() {
        boolean isClassVariable_value = isClassVariable_compute();
        return isClassVariable_value;
    }

    private boolean isClassVariable_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 29
    public boolean isInstanceVariable() {
        boolean isInstanceVariable_value = isInstanceVariable_compute();
        return isInstanceVariable_value;
    }

    private boolean isInstanceVariable_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 30
    public boolean isMethodParameter() {
        boolean isMethodParameter_value = isMethodParameter_compute();
        return isMethodParameter_value;
    }

    private boolean isMethodParameter_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 31
    public boolean isConstructorParameter() {
        boolean isConstructorParameter_value = isConstructorParameter_compute();
        return isConstructorParameter_value;
    }

    private boolean isConstructorParameter_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 32
    public boolean isExceptionHandlerParameter() {
        boolean isExceptionHandlerParameter_value = isExceptionHandlerParameter_compute();
        return isExceptionHandlerParameter_value;
    }

    private boolean isExceptionHandlerParameter_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 33
    public boolean isLocalVariable() {
        boolean isLocalVariable_value = isLocalVariable_compute();
        return isLocalVariable_value;
    }

    private boolean isLocalVariable_compute() {  return  true;  }

    // Declared in VariableDeclaration.jrag at line 35
    public boolean isFinal() {
        boolean isFinal_value = isFinal_compute();
        return isFinal_value;
    }

    private boolean isFinal_compute() {  return  getModifiers().isFinal();  }

    // Declared in VariableDeclaration.jrag at line 36
    public boolean isBlank() {
        boolean isBlank_value = isBlank_compute();
        return isBlank_value;
    }

    private boolean isBlank_compute() {  return  !hasInit();  }

    // Declared in VariableDeclaration.jrag at line 37
    public boolean isStatic() {
        boolean isStatic_value = isStatic_compute();
        return isStatic_value;
    }

    private boolean isStatic_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 39
    public String name() {
        String name_value = name_compute();
        return name_value;
    }

    private String name_compute() {  return  getID();  }

    protected boolean constant_computed = false;
    protected Constant constant_value;
    // Declared in VariableDeclaration.jrag at line 41
    public Constant constant() {
        if(constant_computed)
            return constant_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        constant_value = constant_compute();
        if(isFinal && num == boundariesCrossed)
            constant_computed = true;
        return constant_value;
    }

    private Constant constant_compute() {  return  getInit().constant();  }

    // Declared in LookupVariable.jrag at line 12
    public SimpleSet lookupVariable(String name) {
        SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);
        return lookupVariable_String_value;
    }

    // Declared in NameCheck.jrag at line 277
    public VariableScope outerScope() {
        VariableScope outerScope_value = getParent().Define_VariableScope_outerScope(this, null);
        return outerScope_value;
    }

    // Declared in NameCheck.jrag at line 289
    public BodyDecl enclosingBodyDecl() {
        BodyDecl enclosingBodyDecl_value = getParent().Define_BodyDecl_enclosingBodyDecl(this, null);
        return enclosingBodyDecl_value;
    }

    // Declared in TypeAnalysis.jrag at line 576
    public TypeDecl hostType() {
        TypeDecl hostType_value = getParent().Define_TypeDecl_hostType(this, null);
        return hostType_value;
    }

    // Declared in CodeGeneration.jrag at line 33
    public int variableScopeEndLabel(CodeGeneration gen) {
        int variableScopeEndLabel_CodeGeneration_value = getParent().Define_int_variableScopeEndLabel(this, null, gen);
        return variableScopeEndLabel_CodeGeneration_value;
    }

    protected boolean localNum_computed = false;
    protected int localNum_value;
    // Declared in LocalNum.jrag at line 2
    public int localNum() {
        if(localNum_computed)
            return localNum_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        localNum_value = getParent().Define_int_localNum(this, null);
        if(isFinal && num == boundariesCrossed)
            localNum_computed = true;
        return localNum_value;
    }

    // Declared in CreateBCode.jrag at line 864
    public TypeDecl Define_TypeDecl_expectedType(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  type().componentType();
        }
        return getParent().Define_TypeDecl_expectedType(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 29
    public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_isSource(this, caller);
    }

    // Declared in GenericMethodsInference.jrag at line 25
    public TypeDecl Define_TypeDecl_assignConvertedType(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  type();
        }
        return getParent().Define_TypeDecl_assignConvertedType(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 257
    public TypeDecl Define_TypeDecl_declType(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  type();
        }
        return getParent().Define_TypeDecl_declType(this, caller);
    }

    // Declared in SyntacticClassification.jrag at line 75
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeAccessNoTransform()) {
            return  NameType.TYPE_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 491
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getInitOptNoTransform()) {
            return  isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in Modifiers.jrag at line 271
    public boolean Define_boolean_mayBeFinal(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeFinal(this, caller);
    }

    // Declared in Annotations.jrag at line 81
    public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
        if(caller == getModifiersNoTransform()) {
            return 
    name.equals("LOCAL_VARIABLE");
        }
        return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }

    // Declared in DefiniteAssignment.jrag at line 883
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getInitOptNoTransform()) {
            return  isDUbefore(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
