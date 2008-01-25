
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class ConstructorDecl extends BodyDecl implements Cloneable,  ExceptionHolder {
    public void flushCache() {
        super.flushCache();
        accessibleFrom_TypeDecl_values = null;
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
        throwsException_TypeDecl_values = null;
        name_computed = false;
        name_value = null;
        signature_computed = false;
        signature_value = null;
        sameSignature_ConstructorDecl_values = null;
        moreSpecificThan_ConstructorDecl_values = null;
        parameterDeclaration_String_values = null;
        circularThisInvocation_ConstructorDecl_values = null;
        attributes_computed = false;
        attributes_value = null;
        descName_computed = false;
        descName_value = null;
        accessorDescName_computed = false;
        accessorDescName_value = null;
        bytecodes_ConstantPool_values = null;
        flags_computed = false;
        accessorIndex_computed = false;
        localNumOfFirstParameter_computed = false;
        enclosingVariablesOffset_computed = false;
        offsetFirstEnclosingVariable_computed = false;
        handlesException_TypeDecl_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ConstructorDecl node = (ConstructorDecl)super.clone();
        node.accessibleFrom_TypeDecl_values = null;
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.throwsException_TypeDecl_values = null;
        node.name_computed = false;
        node.name_value = null;
        node.signature_computed = false;
        node.signature_value = null;
        node.sameSignature_ConstructorDecl_values = null;
        node.moreSpecificThan_ConstructorDecl_values = null;
        node.parameterDeclaration_String_values = null;
        node.circularThisInvocation_ConstructorDecl_values = null;
        node.attributes_computed = false;
        node.attributes_value = null;
        node.descName_computed = false;
        node.descName_value = null;
        node.accessorDescName_computed = false;
        node.accessorDescName_value = null;
        node.bytecodes_ConstantPool_values = null;
        node.flags_computed = false;
        node.accessorIndex_computed = false;
        node.localNumOfFirstParameter_computed = false;
        node.enclosingVariablesOffset_computed = false;
        node.offsetFirstEnclosingVariable_computed = false;
        node.handlesException_TypeDecl_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ConstructorDecl node = (ConstructorDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ConstructorDecl res = (ConstructorDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in LookupConstructor.jrag at line 154


  public boolean applicable(List argList) {
    if(getNumParameter() != argList.getNumChild())
      return false;
    for(int i = 0; i < getNumParameter(); i++) {
      TypeDecl arg = ((Expr)argList.getChild(i)).type();
      TypeDecl parameter = getParameter(i).type();
      if(!arg.instanceOf(parameter)) {
        return false;
      }  
    }
    return true;
  }

    // Declared in Modifiers.jrag at line 99

 
  public void checkModifiers() {
    super.checkModifiers();
  }

    // Declared in NameCheck.jrag at line 56



  public void nameCheck() {
    super.nameCheck();
    // 8.8
    if(!hostType().name().equals(name()))
      error("constructor " + name() +" does not have the same name as the simple name of the host class " + hostType().name());
    
    // 8.8.2
    if(hostType().lookupConstructor(this) != this)
      error("constructor with signature " + signature() + " is multiply declared in type " + hostType().typeName());

    if(circularThisInvocation(this))
      error("The constructor " + signature() + " may not directly or indirectly invoke itself");
  }

    // Declared in PrettyPrint.jadd at line 126

  
  public void toString(StringBuffer s) {
    s.append(indent());
    getModifiers().toString(s);
    s.append(name() + "(");
    if(getNumParameter() > 0) {
      getParameter(0).toString(s);
      for(int i = 1; i < getNumParameter(); i++) {
        s.append(", ");
        getParameter(i).toString(s);
      }
    }
    s.append(")");
    if(getNumException() > 0) {
      s.append(" throws ");
      getException(0).toString(s);
      for(int i = 1; i < getNumException(); i++) {
        s.append(", ");
        getException(i).toString(s);
      }
    }
    
    s.append("{\n");
    indent++;
    if(hasConstructorInvocation()) {
      s.append(indent());
      getConstructorInvocation().toString(s);
    }
    for(int i = 0; i < getBlock().getNumStmt(); i++) {
      s.append(indent());
      getBlock().getStmt(i).toString(s);
    }
    indent--;
    s.append(indent());
    s.append("}\n");
  }

    // Declared in TypeCheck.jrag at line 413


  public void typeCheck() {
    // 8.8.4 (8.4.4)
    TypeDecl exceptionType = typeThrowable();
    for(int i = 0; i < getNumException(); i++) {
      TypeDecl typeDecl = getException(i).type();
      if(!typeDecl.instanceOf(exceptionType))
        error(signature() + " throws non throwable type " + typeDecl.fullName());
    }
  }

    // Declared in CodeGeneration.jrag at line 869


  public void emitInvokeConstructor(CodeGeneration gen) {
    int size = -1;
    for(int i = 0; i < getNumParameter(); i++)
      size -= getParameter(i).type().variableSize();
    if(hostType().needsEnclosing())
      size--;
    if(hostType().needsSuperEnclosing()) {
      size--;
    }
    for(Iterator iter = hostType().enclosingVariables().iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      size -= v.type().variableSize();
    }
    String classname = hostType().constantPoolName();
    String      desc = descName();
    String      name = "<init>";
    int index = gen.constantPool().addMethodref(classname, name, desc);
    gen.emit(Bytecode.INVOKESPECIAL, size).add2(index);
  }

    // Declared in CreateBCode.jrag at line 91


  public void createBCode(CodeGeneration gen) {
    try {
    boolean needsInit = true;

    if(hasConstructorInvocation()) {
      getConstructorInvocation().createBCode(gen);
      Stmt stmt = getConstructorInvocation();
      if(stmt instanceof ExprStmt) {
        ExprStmt exprStmt = (ExprStmt)stmt;
        Expr expr = exprStmt.getExpr();
        if(!expr.isSuperConstructorAccess())
          needsInit = false;

      }
    }

    int localIndex = 1;
    if(hostType().needsEnclosing()) {
      TypeDecl type = hostType().enclosingType();
      gen.emitLoadReference(0);
      gen.emitLoadReference(localIndex);
      String classname = hostType().constantPoolName();
      String desc = type.typeDescriptor();
      String name = "this$0";
      int index = gen.constantPool().addFieldref(classname, name, desc);
      gen.emit(Bytecode.PUTFIELD, -2).add2(index);
      localIndex++;
    }
    if(needsSuperEnclosing()) {
      localIndex++;
    }
    for(int i = 0; i < getNumParameter(); i++)
      localIndex += getParameter(i).type().variableSize();
    for(Iterator iter = hostType().enclosingVariables().iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      gen.emitLoadReference(0);
      v.type().emitLoadLocal(gen, localIndex);
      String classname = hostType().constantPoolName();
      String desc = v.type().typeDescriptor();
      String name = "val$" + v.name();
      int index = gen.constantPool().addFieldref(classname, name, desc);
      gen.emit(Bytecode.PUTFIELD, -1 - v.type().variableSize()).add2(index);
      localIndex += v.type().variableSize();
    }

    if(needsInit) {
      TypeDecl typeDecl = hostType();
      for(int i = 0; i < typeDecl.getNumBodyDecl(); i++) {
        BodyDecl b = typeDecl.getBodyDecl(i);
        if(b instanceof FieldDeclaration && b.isBytecodeField()) {
          FieldDeclaration f = (FieldDeclaration)b;
          if(!f.isStatic() && f.hasInit()) {
            gen.emit(Bytecode.ALOAD_0);
            f.getInit().createBCode(gen);
            f.getInit().type().emitAssignConvTo(gen, f.type()); // AssignConversion
            f.emitStoreField(gen, hostType());
          }
        }
        else if(b instanceof InstanceInitializer) {
          b.createBCode(gen);
        }
      }
    }
    gen.maxLocals = Math.max(gen.maxLocals, getBlock().localNum());
    getBlock().createBCode(gen);
    } catch (Error e) {
      System.err.println(hostType().typeName() + ": " + this);
      throw e;
    }
  }

    // Declared in GenerateClassfile.jrag at line 275

  public void generateMethod(DataOutputStream out, ConstantPool cp) throws IOException {
    out.writeChar(flags());
    out.writeChar(cp.addUtf8("<init>"));
    out.writeChar(cp.addUtf8(descName()));
    out.writeChar(attributes().size());
    for(Iterator itera = attributes().iterator(); itera.hasNext();)
      ((Attribute)itera.next()).emit(out);
    if(needsAccessor())
      emitAccessor(cp, out);
  }

    // Declared in GenerateClassfile.jrag at line 293

  public void touchMethod(ConstantPool cp) {
    cp.addUtf8("<init>");
    cp.addUtf8(descName());
    attributes();
    if(needsAccessor()) {
      cp.addUtf8(accessorDescName());
      accessorAttributes();
    }
  }

    // Declared in GenerateClassfile.jrag at line 397


  public boolean clear() {
    getBlock().clear();
    bytecodes_ConstantPool_values = null;
    return false;
  }

    // Declared in InnerClasses.jrag at line 92

  private String anonymousJavaName;

    // Declared in InnerClasses.jrag at line 94


  private boolean accessorIndexVisited = false;

    // Declared in InnerClasses.jrag at line 127

  private int accessorIndex = -1;

    // Declared in InnerClasses.jrag at line 268

  
  public void emitAccessor(ConstantPool cp, DataOutputStream out) throws java.io.IOException {
    accessorIndex();
    out.writeChar(0);
    out.writeChar(cp.addUtf8("<init>"));
    out.writeChar(cp.addUtf8(accessorDescName()));
    out.writeChar(accessorAttributes().size());
    for(Iterator iter = accessorAttributes().iterator(); iter.hasNext(); ) {
      ((Attribute)iter.next()).emit(out);
    }
  }

    // Declared in InnerClasses.jrag at line 307


  public ArrayList accessorAttributes() {
    ConstantPool cp = hostType().constantPool();
    ArrayList list = new ArrayList();
    CodeGeneration gen = new CodeGeneration(cp);
    int index = 0;
    gen.emitLoadReference(index++);
    // this$0
    if(hostType().needsEnclosing())
      gen.emitLoadReference(index++);
    if(hostType().needsSuperEnclosing())
      gen.emitLoadReference(index++);

    // args
    for(int i = 0; i < getNumParameter(); i++) {
      getParameter(i).type().emitLoadLocal(gen, index);
      index += getParameter(i).type().variableSize();
    }
    // this$val
    for(Iterator iter = hostType().enclosingVariables().iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      v.type().emitLoadLocal(gen, index);
      index += v.type().variableSize();
    }
    gen.maxLocals++; // Increase max locals to include dummy constructor argument for private constructors
    emitInvokeConstructor(gen);
    gen.emit(Bytecode.RETURN);
    CodeAttribute a = new CodeAttribute(gen, null);
    list.add(a);
    list.add(new SyntheticAttribute(cp));
    return list;
  }

    // Declared in InnerClasses.jrag at line 339


  public void emitInvokeConstructorAccessor(CodeGeneration gen) {
    accessorIndex();
    int size = -2; // take this and null (reference to anonymous class)
    for(int i = 0; i < getNumParameter(); i++)
      size -= getParameter(i).type().variableSize();
    if(hostType().needsEnclosing())
      size--;
    if(hostType().needsSuperEnclosing())
      size--;
    for(Iterator iter = hostType().enclosingVariables().iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      size -= v.type().variableSize();
    }
    String classname = hostType().constantPoolName();
    String      desc = accessorDescName();
    String      name = "<init>";
    int index = gen.constantPool().addMethodref(classname, name, desc);
    gen.emit(Bytecode.INVOKESPECIAL, size).add2(index);
  }

    // Declared in Enums.jrag at line 128

  protected void transformEnumConstructors() {
    super.transformEnumConstructors();
    getParameterList().insertChild(
      new ParameterDeclaration(new TypeAccess("java.lang", "String"), "@p0"),
      0
    );
    getParameterList().insertChild(
      new ParameterDeclaration(new TypeAccess("int"), "@p1"),
      1
    );
  }

    // Declared in Generics.jrag at line 889

  

  public BodyDecl p(ParTypeDecl parTypeDecl) {
    ConstructorDecl c = new ConstructorDeclSubstituted(
      (Modifiers)getModifiers().fullCopy(),
      getID(),
      getParameterList().substitute(parTypeDecl),
      getExceptionList().substitute(parTypeDecl),
      new Opt(),
      new Block(),
      this
    );
    return c;
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 71

    public ConstructorDecl() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);
        setChild(new Opt(), 3);
        setChild(null, 4);

    }

    // Declared in java.ast at line 15


    // Declared in java.ast line 71
    public ConstructorDecl(Modifiers p0, String p1, List p2, List p3, Opt p4, Block p5) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
        setChild(p5, 4);
    }

    // Declared in java.ast at line 24


  protected int numChildren() {
    return 5;
  }

    // Declared in java.ast at line 27

  public boolean mayHaveRewrite() { return true; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
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
    // Declared in java.ast line 71
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
    // Declared in java.ast line 71
    public void setParameterList(List list) {
        setChild(list, 1);
    }

    // Declared in java.ast at line 6


    public int getNumParameter() {
        return getParameterList().getNumChild();
    }

    // Declared in java.ast at line 10


    public ParameterDeclaration getParameter(int i) {
        return (ParameterDeclaration)getParameterList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addParameter(ParameterDeclaration node) {
        List list = getParameterList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setParameter(ParameterDeclaration node, int i) {
        List list = getParameterList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getParameterList() {
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getParameterListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
    public void setExceptionList(List list) {
        setChild(list, 2);
    }

    // Declared in java.ast at line 6


    public int getNumException() {
        return getExceptionList().getNumChild();
    }

    // Declared in java.ast at line 10


    public Access getException(int i) {
        return (Access)getExceptionList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addException(Access node) {
        List list = getExceptionList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setException(Access node, int i) {
        List list = getExceptionList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getExceptionList() {
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getExceptionListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
    public void setConstructorInvocationOpt(Opt opt) {
        setChild(opt, 3);
    }

    // Declared in java.ast at line 6


    public boolean hasConstructorInvocation() {
        return getConstructorInvocationOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Stmt getConstructorInvocation() {
        return (Stmt)getConstructorInvocationOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setConstructorInvocation(Stmt node) {
        getConstructorInvocationOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getConstructorInvocationOpt() {
        return (Opt)getChild(3);
    }

    // Declared in java.ast at line 21


    public Opt getConstructorInvocationOptNoTransform() {
        return (Opt)getChildNoTransform(3);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 71
    public void setBlock(Block node) {
        setChild(node, 4);
    }

    // Declared in java.ast at line 5

    public Block getBlock() {
        return (Block)getChild(4);
    }

    // Declared in java.ast at line 9


    public Block getBlockNoTransform() {
        return (Block)getChildNoTransform(4);
    }

    // Declared in Attributes.jrag at line 193
private Collection refined_Attributes_attributes()
 {
    ArrayList l = new ArrayList();
    l.add(new CodeAttribute(bytecodes(hostType().constantPool()), null));
    l.add(new ExceptionsAttribute(bytecodes(hostType().constantPool()), this));
    if(getModifiers().isSynthetic())
      l.add(new SyntheticAttribute(hostType().constantPool()));
    return l;
  }

    protected java.util.Map accessibleFrom_TypeDecl_values;
    // Declared in AccessControl.jrag at line 85
    public boolean accessibleFrom(TypeDecl type) {
        Object _parameters = type;
if(accessibleFrom_TypeDecl_values == null) accessibleFrom_TypeDecl_values = new java.util.HashMap(4);
        if(accessibleFrom_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)accessibleFrom_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean accessibleFrom_TypeDecl_value = accessibleFrom_compute(type);
        if(isFinal && num == boundariesCrossed)
            accessibleFrom_TypeDecl_values.put(_parameters, Boolean.valueOf(accessibleFrom_TypeDecl_value));
        return accessibleFrom_TypeDecl_value;
    }

    private boolean accessibleFrom_compute(TypeDecl type)  {
    if(!hostType().accessibleFrom(type))
      return false;
    else if(isPublic())
      return true;
    else if(isProtected()) {
      return true;
    }
    else if(isPrivate()) {
      return hostType().topLevelType() == type.topLevelType();
    }
    else
      return hostPackage().equals(type.hostPackage());
  }

    // Declared in DefiniteAssignment.jrag at line 284
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

    private boolean isDAafter_compute(Variable v) {  return  getBlock().isDAafter(v) && getBlock().checkReturnDA(v);  }

    // Declared in DefiniteAssignment.jrag at line 746
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

    private boolean isDUafter_compute(Variable v) {  return  getBlock().isDUafter(v) && getBlock().checkReturnDU(v);  }

    protected java.util.Map throwsException_TypeDecl_values;
    // Declared in ExceptionHandling.jrag at line 127
    public boolean throwsException(TypeDecl exceptionType) {
        Object _parameters = exceptionType;
if(throwsException_TypeDecl_values == null) throwsException_TypeDecl_values = new java.util.HashMap(4);
        if(throwsException_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)throwsException_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean throwsException_TypeDecl_value = throwsException_compute(exceptionType);
        if(isFinal && num == boundariesCrossed)
            throwsException_TypeDecl_values.put(_parameters, Boolean.valueOf(throwsException_TypeDecl_value));
        return throwsException_TypeDecl_value;
    }

    private boolean throwsException_compute(TypeDecl exceptionType)  {
    for(int i = 0; i < getNumException(); i++)
      if(exceptionType.instanceOf(getException(i).type()))
        return true;
    return false;
  }

    protected boolean name_computed = false;
    protected String name_value;
    // Declared in LookupConstructor.jrag at line 120
    public String name() {
        if(name_computed)
            return name_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        name_value = name_compute();
        if(isFinal && num == boundariesCrossed)
            name_computed = true;
        return name_value;
    }

    private String name_compute() {  return  getID();  }

    protected boolean signature_computed = false;
    protected String signature_value;
    // Declared in LookupConstructor.jrag at line 122
    public String signature() {
        if(signature_computed)
            return signature_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        signature_value = signature_compute();
        if(isFinal && num == boundariesCrossed)
            signature_computed = true;
        return signature_value;
    }

    private String signature_compute()  {
    StringBuffer s = new StringBuffer();
    s.append(name() + "(");
    for(int i = 0; i < getNumParameter(); i++) {
      s.append(getParameter(i));
      if(i != getNumParameter() - 1)
        s.append(", ");
    }
    s.append(")");
    return s.toString();
  }

    protected java.util.Map sameSignature_ConstructorDecl_values;
    // Declared in LookupConstructor.jrag at line 135
    public boolean sameSignature(ConstructorDecl c) {
        Object _parameters = c;
if(sameSignature_ConstructorDecl_values == null) sameSignature_ConstructorDecl_values = new java.util.HashMap(4);
        if(sameSignature_ConstructorDecl_values.containsKey(_parameters))
            return ((Boolean)sameSignature_ConstructorDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean sameSignature_ConstructorDecl_value = sameSignature_compute(c);
        if(isFinal && num == boundariesCrossed)
            sameSignature_ConstructorDecl_values.put(_parameters, Boolean.valueOf(sameSignature_ConstructorDecl_value));
        return sameSignature_ConstructorDecl_value;
    }

    private boolean sameSignature_compute(ConstructorDecl c)  {
    if(!name().equals(c.name()))
      return false;
    if(c.getNumParameter() != getNumParameter())
      return false;
    for(int i = 0; i < getNumParameter(); i++)
      if(!c.getParameter(i).type().equals(getParameter(i).type()))
        return false;
    return true;
  }

    protected java.util.Map moreSpecificThan_ConstructorDecl_values;
    // Declared in LookupConstructor.jrag at line 146
    public boolean moreSpecificThan(ConstructorDecl m) {
        Object _parameters = m;
if(moreSpecificThan_ConstructorDecl_values == null) moreSpecificThan_ConstructorDecl_values = new java.util.HashMap(4);
        if(moreSpecificThan_ConstructorDecl_values.containsKey(_parameters))
            return ((Boolean)moreSpecificThan_ConstructorDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean moreSpecificThan_ConstructorDecl_value = moreSpecificThan_compute(m);
        if(isFinal && num == boundariesCrossed)
            moreSpecificThan_ConstructorDecl_values.put(_parameters, Boolean.valueOf(moreSpecificThan_ConstructorDecl_value));
        return moreSpecificThan_ConstructorDecl_value;
    }

    private boolean moreSpecificThan_compute(ConstructorDecl m)  {
    for(int i = 0; i < getNumParameter(); i++) {
      if(!getParameter(i).type().instanceOf(m.getParameter(i).type()))
        return false;
    }
    return true;
  }

    protected java.util.Map parameterDeclaration_String_values;
    // Declared in LookupVariable.jrag at line 98
    public SimpleSet parameterDeclaration(String name) {
        Object _parameters = name;
if(parameterDeclaration_String_values == null) parameterDeclaration_String_values = new java.util.HashMap(4);
        if(parameterDeclaration_String_values.containsKey(_parameters))
            return (SimpleSet)parameterDeclaration_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet parameterDeclaration_String_value = parameterDeclaration_compute(name);
        if(isFinal && num == boundariesCrossed)
            parameterDeclaration_String_values.put(_parameters, parameterDeclaration_String_value);
        return parameterDeclaration_String_value;
    }

    private SimpleSet parameterDeclaration_compute(String name)  {
    for(int i = 0; i < getNumParameter(); i++)
      if(getParameter(i).name().equals(name))
        return (ParameterDeclaration)getParameter(i);
    return SimpleSet.emptySet;
  }

    // Declared in Modifiers.jrag at line 220
    public boolean isPublic() {
        boolean isPublic_value = isPublic_compute();
        return isPublic_value;
    }

    private boolean isPublic_compute() {  return  getModifiers().isPublic();  }

    // Declared in Modifiers.jrag at line 221
    public boolean isPrivate() {
        boolean isPrivate_value = isPrivate_compute();
        return isPrivate_value;
    }

    private boolean isPrivate_compute() {  return  getModifiers().isPrivate();  }

    // Declared in Modifiers.jrag at line 222
    public boolean isProtected() {
        boolean isProtected_value = isProtected_compute();
        return isProtected_value;
    }

    private boolean isProtected_compute() {  return  getModifiers().isProtected();  }

    protected java.util.Map circularThisInvocation_ConstructorDecl_values;
    // Declared in NameCheck.jrag at line 71
    public boolean circularThisInvocation(ConstructorDecl decl) {
        Object _parameters = decl;
if(circularThisInvocation_ConstructorDecl_values == null) circularThisInvocation_ConstructorDecl_values = new java.util.HashMap(4);
        if(circularThisInvocation_ConstructorDecl_values.containsKey(_parameters))
            return ((Boolean)circularThisInvocation_ConstructorDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean circularThisInvocation_ConstructorDecl_value = circularThisInvocation_compute(decl);
        if(isFinal && num == boundariesCrossed)
            circularThisInvocation_ConstructorDecl_values.put(_parameters, Boolean.valueOf(circularThisInvocation_ConstructorDecl_value));
        return circularThisInvocation_ConstructorDecl_value;
    }

    private boolean circularThisInvocation_compute(ConstructorDecl decl)  {
    if(hasConstructorInvocation()) {
      Expr e = ((ExprStmt)getConstructorInvocation()).getExpr();
      if(e instanceof ConstructorAccess) {
        ConstructorDecl constructorDecl = ((ConstructorAccess)e).decl();
        if(constructorDecl == decl)
          return true;
        return constructorDecl.circularThisInvocation(decl);
      }
    }
    return false;
  }

    // Declared in TypeAnalysis.jrag at line 264
    public TypeDecl type() {
        TypeDecl type_value = type_compute();
        return type_value;
    }

    private TypeDecl type_compute() {  return  unknownType();  }

    // Declared in TypeAnalysis.jrag at line 275
    public boolean isVoid() {
        boolean isVoid_value = isVoid_compute();
        return isVoid_value;
    }

    private boolean isVoid_compute() {  return  true;  }

    // Declared in AnnotationsCodegen.jrag at line 22
    public Collection attributes() {
        if(attributes_computed)
            return attributes_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        attributes_value = attributes_compute();
        if(isFinal && num == boundariesCrossed)
            attributes_computed = true;
        return attributes_value;
    }

    private Collection attributes_compute()  {
    Collection c = refined_Attributes_attributes();
    getModifiers().addRuntimeVisibleAnnotationsAttribute(c);
    getModifiers().addRuntimeInvisibleAnnotationsAttribute(c);
    return c;
  }

    protected boolean descName_computed = false;
    protected String descName_value;
    // Declared in ConstantPoolNames.jrag at line 71
    public String descName() {
        if(descName_computed)
            return descName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        descName_value = descName_compute();
        if(isFinal && num == boundariesCrossed)
            descName_computed = true;
        return descName_value;
    }

    private String descName_compute()  {
    StringBuffer b = new StringBuffer();
    b.append("(");
    // this$0
    TypeDecl typeDecl = hostType();
    if(typeDecl.needsEnclosing())
      b.append(typeDecl.enclosingType().typeDescriptor());
    if(typeDecl.needsSuperEnclosing()) {
      TypeDecl superClass = ((ClassDecl)typeDecl).superclass();
      b.append(superClass.enclosingType().typeDescriptor());
    }
    // args
    for (int i=0; i<getNumParameter(); i++)
      b.append(getParameter(i).type().typeDescriptor());
    // this$val
    for(Iterator iter = typeDecl.enclosingVariables().iterator(); iter.hasNext(); )
      b.append(((Variable)iter.next()).type().typeDescriptor());
    b.append(")V");
    return b.toString();
  }

    protected boolean accessorDescName_computed = false;
    protected String accessorDescName_value;
    // Declared in ConstantPoolNames.jrag at line 92
    public String accessorDescName() {
        if(accessorDescName_computed)
            return accessorDescName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        accessorDescName_value = accessorDescName_compute();
        if(isFinal && num == boundariesCrossed)
            accessorDescName_computed = true;
        return accessorDescName_value;
    }

    private String accessorDescName_compute()  {
    StringBuffer b = new StringBuffer();
    b.append("(");
    // this$0
    TypeDecl typeDecl = hostType();
    if(typeDecl.needsEnclosing())
      b.append(typeDecl.enclosingType().typeDescriptor());
    if(typeDecl.needsSuperEnclosing()) {
      TypeDecl superClass = ((ClassDecl)typeDecl).superclass();
      b.append(superClass.enclosingType().typeDescriptor());
    }
    // args
    for (int i=0; i<getNumParameter(); i++)
      b.append(getParameter(i).type().typeDescriptor());
    // this$val
    for(Iterator iter = typeDecl.enclosingVariables().iterator(); iter.hasNext(); )
      b.append(((Variable)iter.next()).type().typeDescriptor());
    // anonymous class to handle private constructors
    b.append(anonymousJavaName);
    b.append(")");
    b.append("V");
    return b.toString();
  }

    protected java.util.Map bytecodes_ConstantPool_values;
    // Declared in CreateBCode.jrag at line 63
    public CodeGeneration bytecodes(ConstantPool constantPool) {
        Object _parameters = constantPool;
if(bytecodes_ConstantPool_values == null) bytecodes_ConstantPool_values = new java.util.HashMap(4);
        if(bytecodes_ConstantPool_values.containsKey(_parameters))
            return (CodeGeneration)bytecodes_ConstantPool_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        CodeGeneration bytecodes_ConstantPool_value = bytecodes_compute(constantPool);
        if(isFinal && num == boundariesCrossed)
            bytecodes_ConstantPool_values.put(_parameters, bytecodes_ConstantPool_value);
        return bytecodes_ConstantPool_value;
    }

    private CodeGeneration bytecodes_compute(ConstantPool constantPool)  {
    CodeGeneration gen = new CodeGeneration(constantPool);
    int label = gen.variableScopeLabel();
    gen.addLocalVariableEntryAtCurrentPC("this", hostType().typeDescriptor(), 0, label);
    for(int i = 0; i < getNumParameter(); i++) {
      ParameterDeclaration p = (ParameterDeclaration)getParameter(i);
      gen.addLocalVariableEntryAtCurrentPC(
        p.name(), p.type().typeDescriptor(), p.localNum(), label
      );
    }
    createBCode(gen);
    gen.emitReturn();
    gen.addVariableScopeLabel(label);
    return gen;
  }

    // Declared in CreateBCode.jrag at line 713
    public int localIndexOfEnclosingVariable(Variable v) {
        int localIndexOfEnclosingVariable_Variable_value = localIndexOfEnclosingVariable_compute(v);
        return localIndexOfEnclosingVariable_Variable_value;
    }

    private int localIndexOfEnclosingVariable_compute(Variable v)  {
    int localIndex  = offsetFirstEnclosingVariable();
    Iterator iter = hostType().enclosingVariables().iterator();
    Variable varDecl = (Variable)iter.next();
    while(varDecl != v && iter.hasNext()) {
      localIndex += varDecl.type().variableSize();
      varDecl = (Variable)iter.next();
    }
    return localIndex;
  }

    protected boolean flags_computed = false;
    protected int flags_value;
    // Declared in Flags.jrag at line 45
    public int flags() {
        if(flags_computed)
            return flags_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        flags_value = flags_compute();
        if(isFinal && num == boundariesCrossed)
            flags_computed = true;
        return flags_value;
    }

    private int flags_compute()  {
    int res = 0;
    if(isPublic()) res |= Modifiers.ACC_PUBLIC;
    if(isPrivate()) res |= Modifiers.ACC_PRIVATE;
    if(isProtected()) res |= Modifiers.ACC_PROTECTED;
    //if(isSynchronized()) res |= Modifiers.ACC_SYNCHRONIZED;
    //if(isStrictfp()) res |= Modifiers.ACC_STRICT;
    return res;
  }

    // Declared in GenerateClassfile.jrag at line 327
    public boolean isBytecodeMethod() {
        boolean isBytecodeMethod_value = isBytecodeMethod_compute();
        return isBytecodeMethod_value;
    }

    private boolean isBytecodeMethod_compute() {  return  true;  }

    // Declared in GenerateClassfile.jrag at line 356
    public boolean flush() {
        boolean flush_value = flush_compute();
        return flush_value;
    }

    private boolean flush_compute() {  return  false;  }

    // Declared in InnerClasses.jrag at line 91
    public boolean needsAccessor() {
        boolean needsAccessor_value = needsAccessor_compute();
        return needsAccessor_value;
    }

    private boolean needsAccessor_compute() {  return  accessorIndex != -1;  }

    protected boolean accessorIndex_computed = false;
    protected int accessorIndex_value;
    // Declared in InnerClasses.jrag at line 95
    public int accessorIndex() {
        if(accessorIndex_computed)
            return accessorIndex_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        accessorIndex_value = accessorIndex_compute();
        if(isFinal && num == boundariesCrossed)
            accessorIndex_computed = true;
        return accessorIndex_value;
    }

    private int accessorIndex_compute()  {
    // rework treebuilding, final
    if(accessorIndexVisited)
      return accessorIndex;
    accessorIndexVisited = true;

    ClassDecl classDecl =
      new ClassDecl(
          new Modifiers(new List().add(new Modifier("synthetic"))),
          "Dummy",
          new Opt(),
          new List(),
          new List()
          );
    // add as LocalClassDeclStmt
    getBlock().addStmt(new LocalClassDeclStmt(classDecl)); 
    // force new subtree to be rewritten and final
    // TODO: why is this necessary?
    LocalClassDeclStmt stmt = (LocalClassDeclStmt)getBlock().getStmt(getBlock().getNumStmt()-1);
    classDecl = stmt.getClassDecl();
    classDecl.toString(new StringBuffer());

    accessorIndex = hostType().accessorCounter++;
    anonymousJavaName = classDecl.typeDescriptor();

    hostType().addUsedNestedType(classDecl);
    hostType().addNestedType(classDecl);


    //classDecl.generateClassfile();
    return accessorIndex;
  }

    // Declared in InnerClasses.jrag at line 279
    public boolean needsEnclosing() {
        boolean needsEnclosing_value = needsEnclosing_compute();
        return needsEnclosing_value;
    }

    private boolean needsEnclosing_compute() {  return  hostType().needsEnclosing();  }

    // Declared in InnerClasses.jrag at line 280
    public boolean needsSuperEnclosing() {
        boolean needsSuperEnclosing_value = needsSuperEnclosing_compute();
        return needsSuperEnclosing_value;
    }

    private boolean needsSuperEnclosing_compute() {  return  hostType().needsSuperEnclosing();  }

    protected boolean localNumOfFirstParameter_computed = false;
    protected int localNumOfFirstParameter_value;
    // Declared in LocalNum.jrag at line 36
    public int localNumOfFirstParameter() {
        if(localNumOfFirstParameter_computed)
            return localNumOfFirstParameter_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        localNumOfFirstParameter_value = localNumOfFirstParameter_compute();
        if(isFinal && num == boundariesCrossed)
            localNumOfFirstParameter_computed = true;
        return localNumOfFirstParameter_value;
    }

    private int localNumOfFirstParameter_compute()  {
    int i = 1;
    //if(hostType().isInnerType())
    if(hostType().needsEnclosing())
      i++;
    if(hostType().needsSuperEnclosing())
      i++;
    /*
    for(Iterator iter = hostType().enclosingVariables().iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      i += v.type().variableSize();
    }*/
    return i;
  }

    protected boolean enclosingVariablesOffset_computed = false;
    protected int enclosingVariablesOffset_value;
    // Declared in LocalNum.jrag at line 51
    public int enclosingVariablesOffset() {
        if(enclosingVariablesOffset_computed)
            return enclosingVariablesOffset_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        enclosingVariablesOffset_value = enclosingVariablesOffset_compute();
        if(isFinal && num == boundariesCrossed)
            enclosingVariablesOffset_computed = true;
        return enclosingVariablesOffset_value;
    }

    private int enclosingVariablesOffset_compute()  {
    int i = 0;
    for(Iterator iter = hostType().enclosingVariables().iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      i += v.type().variableSize();
    }
    return i;
  }

    protected boolean offsetFirstEnclosingVariable_computed = false;
    protected int offsetFirstEnclosingVariable_value;
    // Declared in LocalNum.jrag at line 60
    public int offsetFirstEnclosingVariable() {
        if(offsetFirstEnclosingVariable_computed)
            return offsetFirstEnclosingVariable_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        offsetFirstEnclosingVariable_value = offsetFirstEnclosingVariable_compute();
        if(isFinal && num == boundariesCrossed)
            offsetFirstEnclosingVariable_computed = true;
        return offsetFirstEnclosingVariable_value;
    }

    private int offsetFirstEnclosingVariable_compute() {  return  getNumParameter() == 0 ?
    localNumOfFirstParameter() :
    getParameter(getNumParameter()-1).localNum() + getParameter(getNumParameter()-1).type().variableSize();  }

    // Declared in Annotations.jrag at line 282
    public boolean hasAnnotationSuppressWarnings(String s) {
        boolean hasAnnotationSuppressWarnings_String_value = hasAnnotationSuppressWarnings_compute(s);
        return hasAnnotationSuppressWarnings_String_value;
    }

    private boolean hasAnnotationSuppressWarnings_compute(String s) {  return  getModifiers().hasAnnotationSuppressWarnings(s);  }

    // Declared in Annotations.jrag at line 320
    public boolean isDeprecated() {
        boolean isDeprecated_value = isDeprecated_compute();
        return isDeprecated_value;
    }

    private boolean isDeprecated_compute() {  return  getModifiers().hasDeprecatedAnnotation();  }

    // Declared in MethodSignature.jrag at line 129
    public boolean applicableBySubtyping(List argList) {
        boolean applicableBySubtyping_List_value = applicableBySubtyping_compute(argList);
        return applicableBySubtyping_List_value;
    }

    private boolean applicableBySubtyping_compute(List argList)  {
    if(getNumParameter() != argList.getNumChild())
      return false;
    for(int i = 0; i < getNumParameter(); i++) {
      TypeDecl arg = ((Expr)argList.getChild(i)).type();
      if(!arg.instanceOf(getParameter(i).type()))
        return false;
    }
    return true;
  }

    // Declared in MethodSignature.jrag at line 149
    public boolean applicableByMethodInvocationConversion(List argList) {
        boolean applicableByMethodInvocationConversion_List_value = applicableByMethodInvocationConversion_compute(argList);
        return applicableByMethodInvocationConversion_List_value;
    }

    private boolean applicableByMethodInvocationConversion_compute(List argList)  {
    if(getNumParameter() != argList.getNumChild())
      return false;
    for(int i = 0; i < getNumParameter(); i++) {
      TypeDecl arg = ((Expr)argList.getChild(i)).type();
      if(!arg.methodInvocationConversionTo(getParameter(i).type()))
        return false;
    }
    return true;
  }

    // Declared in MethodSignature.jrag at line 170
    public boolean applicableVariableArity(List argList) {
        boolean applicableVariableArity_List_value = applicableVariableArity_compute(argList);
        return applicableVariableArity_List_value;
    }

    private boolean applicableVariableArity_compute(List argList)  {
    for(int i = 0; i < getNumParameter() - 1; i++) {
      TypeDecl arg = ((Expr)argList.getChild(i)).type();
      if(!arg.methodInvocationConversionTo(getParameter(i).type()))
        return false;
    }
    for(int i = getNumParameter() - 1; i < argList.getNumChild(); i++) {
      TypeDecl arg = ((Expr)argList.getChild(i)).type();
      if(!arg.methodInvocationConversionTo(lastParameter().type().componentType()))
        return false;
    }
    return true;
  }

    // Declared in MethodSignature.jrag at line 239
    public boolean potentiallyApplicable(List argList) {
        boolean potentiallyApplicable_List_value = potentiallyApplicable_compute(argList);
        return potentiallyApplicable_List_value;
    }

    private boolean potentiallyApplicable_compute(List argList)  {
    if(isVariableArity() && !(argList.getNumChild() >= arity()-1))
      return false;
    if(!isVariableArity() && !(arity() == argList.getNumChild()))
      return false;
    return true;
  }

    // Declared in MethodSignature.jrag at line 246
    public int arity() {
        int arity_value = arity_compute();
        return arity_value;
    }

    private int arity_compute() {  return  getNumParameter();  }

    // Declared in VariableArityParameters.jrag at line 25
    public boolean isVariableArity() {
        boolean isVariableArity_value = isVariableArity_compute();
        return isVariableArity_value;
    }

    private boolean isVariableArity_compute() {  return  getNumParameter() == 0 ? false : getParameter(getNumParameter()-1).isVariableArity();  }

    // Declared in VariableArityParameters.jrag at line 39
    public ParameterDeclaration lastParameter() {
        ParameterDeclaration lastParameter_value = lastParameter_compute();
        return lastParameter_value;
    }

    private ParameterDeclaration lastParameter_compute() {  return  
    getParameter(getNumParameter() - 1);  }

    // Declared in GenericsCodegen.jrag at line 119
    public ConstructorDecl erasedConstructor() {
        ConstructorDecl erasedConstructor_value = erasedConstructor_compute();
        return erasedConstructor_value;
    }

    private ConstructorDecl erasedConstructor_compute() {  return  this;  }

    // Declared in GenericsCodegen.jrag at line 334
    public boolean needsSignatureAttribute() {
        boolean needsSignatureAttribute_value = needsSignatureAttribute_compute();
        return needsSignatureAttribute_value;
    }

    private boolean needsSignatureAttribute_compute()  {
    for(int i = 0; i < getNumParameter(); i++)
      if(getParameter(i).type().needsSignatureAttribute())
        return true;
    return false;
  }

    protected java.util.Map handlesException_TypeDecl_values;
    // Declared in ExceptionHandling.jrag at line 27
    public boolean handlesException(TypeDecl exceptionType) {
        Object _parameters = exceptionType;
if(handlesException_TypeDecl_values == null) handlesException_TypeDecl_values = new java.util.HashMap(4);
        if(handlesException_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)handlesException_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean handlesException_TypeDecl_value = getParent().Define_boolean_handlesException(this, null, exceptionType);
        if(isFinal && num == boundariesCrossed)
            handlesException_TypeDecl_values.put(_parameters, Boolean.valueOf(handlesException_TypeDecl_value));
        return handlesException_TypeDecl_value;
    }

    // Declared in TypeAnalysis.jrag at line 263
    public TypeDecl unknownType() {
        TypeDecl unknownType_value = getParent().Define_TypeDecl_unknownType(this, null);
        return unknownType_value;
    }

    // Declared in VariableDeclaration.jrag at line 68
    public boolean Define_boolean_isConstructorParameter(ASTNode caller, ASTNode child) {
        if(caller == getParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  true;
        }
        return getParent().Define_boolean_isConstructorParameter(this, caller);
    }

    // Declared in Modifiers.jrag at line 269
    public boolean Define_boolean_mayBePrivate(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBePrivate(this, caller);
    }

    // Declared in LookupMethod.jrag at line 33
    public Collection Define_Collection_lookupMethod(ASTNode caller, ASTNode child, String name) {
        if(caller == getConstructorInvocationOptNoTransform()) {
    Collection c = hostType().memberMethods(name);
    if(!c.isEmpty()) return removeInstanceMethods(c);
    if(hostType().isNestedType())
      return hostType().lookupMethod(name);
    return Collections.EMPTY_LIST;
  }
        return getParent().Define_Collection_lookupMethod(this, caller, name);
    }

    // Declared in LookupVariable.jrag at line 57
    public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
        if(caller == getParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  parameterDeclaration(name);
        }
        if(caller == getConstructorInvocationOptNoTransform()) {
    SimpleSet set = parameterDeclaration(name);
    if(!set.isEmpty()) return set;
    set = hostType().memberFields(name); // search members
    if(!set.isEmpty()) {
      set = removeInstanceVariables(set);
      return set;
    }
    if(hostType().isNestedType() || hostType().isAnonymous())
      return hostType().lookupVariable(name);
    return SimpleSet.emptySet;
  }
        if(caller == getBlockNoTransform()) {
    SimpleSet set = parameterDeclaration(name);
    if(!set.isEmpty()) return set;
    return lookupVariable(name);
  }
        return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }

    // Declared in ExceptionHandling.jrag at line 124
    public boolean Define_boolean_handlesException(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
        if(caller == getConstructorInvocationOptNoTransform()) {
            return  
    throwsException(exceptionType) || handlesException(exceptionType);
        }
        if(caller == getBlockNoTransform()) {
            return  
    throwsException(exceptionType) || handlesException(exceptionType);
        }
        return getParent().Define_boolean_handlesException(this, caller, exceptionType);
    }

    // Declared in UnreachableStatements.jrag at line 23
    public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
        if(caller == getBlockNoTransform()) {
            return  !hasConstructorInvocation() ? true : getConstructorInvocation().canCompleteNormally();
        }
        if(caller == getConstructorInvocationOptNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_reachable(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 287
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getBlockNoTransform()) {
            return  hasConstructorInvocation() ? getConstructorInvocation().isDAafter(v) : isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in Annotations.jrag at line 78
    public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
        if(caller == getModifiersNoTransform()) {
            return 
    name.equals("CONSTRUCTOR");
        }
        return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }

    // Declared in TypeHierarchyCheck.jrag at line 123
    public boolean Define_boolean_inExplicitConstructorInvocation(ASTNode caller, ASTNode child) {
        if(caller == getConstructorInvocationOptNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_inExplicitConstructorInvocation(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 585
    public BodyDecl Define_BodyDecl_hostBodyDecl(ASTNode caller, ASTNode child) {
        if(caller == getConstructorInvocationOptNoTransform()) {
            return  this;
        }
        if(caller == getBlockNoTransform()) {
            return  this;
        }
        return getParent().Define_BodyDecl_hostBodyDecl(this, caller);
    }

    // Declared in VariableDeclaration.jrag at line 67
    public boolean Define_boolean_isMethodParameter(ASTNode caller, ASTNode child) {
        if(caller == getParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isMethodParameter(this, caller);
    }

    // Declared in Modifiers.jrag at line 267
    public boolean Define_boolean_mayBePublic(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBePublic(this, caller);
    }

    // Declared in LocalNum.jrag at line 71
    public int Define_int_localNum(ASTNode caller, ASTNode child) {
        if(caller == getBlockNoTransform()) {
    if(getNumParameter() == 0) {
      return localNumOfFirstParameter() + enclosingVariablesOffset();
    }
    else {
      return getParameter(getNumParameter()-1).localNum() + getParameter(getNumParameter()-1).type().variableSize() + enclosingVariablesOffset();
    }
  }
        if(caller == getParameterListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    if(index == 0) {
      return localNumOfFirstParameter();
    }
    return getParameter(index-1).localNum() + getParameter(index-1).type().variableSize();
  }
}
        return getParent().Define_int_localNum(this, caller);
    }

    // Declared in Modifiers.jrag at line 268
    public boolean Define_boolean_mayBeProtected(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeProtected(this, caller);
    }

    // Declared in NameCheck.jrag at line 230
    public ASTNode Define_ASTNode_enclosingBlock(ASTNode caller, ASTNode child) {
        if(caller == getBlockNoTransform()) {
            return  this;
        }
        return getParent().Define_ASTNode_enclosingBlock(this, caller);
    }

    // Declared in VariableArityParameters.jrag at line 12
    public boolean Define_boolean_variableArityValid(ASTNode caller, ASTNode child) {
        if(caller == getParameterListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  i == getNumParameter() - 1;
        }
        return getParent().Define_boolean_variableArityValid(this, caller);
    }

    // Declared in VariableDeclaration.jrag at line 69
    public boolean Define_boolean_isExceptionHandlerParameter(ASTNode caller, ASTNode child) {
        if(caller == getParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isExceptionHandlerParameter(this, caller);
    }

    // Declared in SyntacticClassification.jrag at line 107
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getConstructorInvocationOptNoTransform()) {
            return  NameType.EXPRESSION_NAME;
        }
        if(caller == getExceptionListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        if(caller == getParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in TypeCheck.jrag at line 437
    public TypeDecl Define_TypeDecl_enclosingInstance(ASTNode caller, ASTNode child) {
        if(caller == getConstructorInvocationOptNoTransform()) {
            return  unknownType();
        }
        return getParent().Define_TypeDecl_enclosingInstance(this, caller);
    }

    // Declared in TypeHierarchyCheck.jrag at line 135
    public boolean Define_boolean_inStaticContext(ASTNode caller, ASTNode child) {
        if(caller == getConstructorInvocationOptNoTransform()) {
            return  false;
        }
        if(caller == getBlockNoTransform()) {
            return  false;
        }
        return getParent().Define_boolean_inStaticContext(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 749
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getBlockNoTransform()) {
            return  hasConstructorInvocation() ? getConstructorInvocation().isDUafter(v) : isDUbefore(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    // Declared in LookupConstructor.jrag at line 177
    if(!hasConstructorInvocation() && !hostType().isObject()) {
        duringLookupConstructor++;
        ASTNode result = rewriteRule0();
        duringLookupConstructor--;
        return result;
    }

    return super.rewriteTo();
}

    // Declared in LookupConstructor.jrag at line 177
    private ConstructorDecl rewriteRule0() {
      setConstructorInvocation(
        new ExprStmt(
          new SuperConstructorAccess("super", new List())
          )
        );
      return this;
    }
}
