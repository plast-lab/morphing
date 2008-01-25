
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class FieldDeclaration extends MemberDecl implements Cloneable,  SimpleSet,  Iterator,  Variable {
    public void flushCache() {
        super.flushCache();
        accessibleFrom_TypeDecl_values = null;
        exceptions_computed = false;
        exceptions_value = null;
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
        constant_computed = false;
        constant_value = null;
        attributes_computed = false;
        attributes_value = null;
        accessorDescName_computed = false;
        accessorDescName_value = null;
        accessorWriteDescName_computed = false;
        accessorWriteDescName_value = null;
        flags_computed = false;
        accessorIndex_computed = false;
        accessorWriteIndex_computed = false;
        usesTypeVariable_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        FieldDeclaration node = (FieldDeclaration)super.clone();
        node.accessibleFrom_TypeDecl_values = null;
        node.exceptions_computed = false;
        node.exceptions_value = null;
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.constant_computed = false;
        node.constant_value = null;
        node.attributes_computed = false;
        node.attributes_value = null;
        node.accessorDescName_computed = false;
        node.accessorDescName_value = null;
        node.accessorWriteDescName_computed = false;
        node.accessorWriteDescName_value = null;
        node.flags_computed = false;
        node.accessorIndex_computed = false;
        node.accessorWriteIndex_computed = false;
        node.usesTypeVariable_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          FieldDeclaration node = (FieldDeclaration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        FieldDeclaration res = (FieldDeclaration)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in BoundNames.jrag at line 2

  public Access createQualifiedBoundAccess() {
    if(isStatic())
      return hostType().createQualifiedAccess().qualifiesAccess(new BoundFieldAccess(this));
    else
      return new ThisAccess("this").qualifiesAccess(
        new BoundFieldAccess(this));
  }

    // Declared in BoundNames.jrag at line 77


  public Access createBoundFieldAccess() {
    return createQualifiedBoundAccess();
  }

    // Declared in DataStructures.jrag at line 60

  public SimpleSet add(Object o) {
    return new SimpleSetImpl().add(this).add(o);
  }

    // Declared in DataStructures.jrag at line 66

  private FieldDeclaration iterElem;

    // Declared in DataStructures.jrag at line 67

  public Iterator iterator() { iterElem = this; return this; }

    // Declared in DataStructures.jrag at line 68

  public boolean hasNext() { return iterElem != null; }

    // Declared in DataStructures.jrag at line 69

  public Object next() { Object o = iterElem; iterElem = null; return o; }

    // Declared in DataStructures.jrag at line 70

  public void remove() { throw new UnsupportedOperationException(); }

    // Declared in DefiniteAssignment.jrag at line 168

  
  public void definiteAssignment() {
    super.definiteAssignment();
    if(isBlank() && isFinal() && isClassVariable()) {
      boolean found = false;
      TypeDecl typeDecl = hostType();
      for(int i = 0; i < typeDecl.getNumBodyDecl(); i++) {
        if(typeDecl.getBodyDecl(i) instanceof StaticInitializer) {
          StaticInitializer s = (StaticInitializer)typeDecl.getBodyDecl(i);
          if(s.isDAafter(this))
            found = true;
        }
        
        else if(typeDecl.getBodyDecl(i) instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration)typeDecl.getBodyDecl(i);
          if(f.isStatic() && f.isDAafter(this))
            found = true;
        }
        
      }
      if(!found)
        error("blank final class variable " + name() + " in " + hostType().typeName() + " is not definitely assigned in static initializer");

    }
    if(isBlank() && isFinal() && isInstanceVariable()) {
      TypeDecl typeDecl = hostType();
      boolean found = false;
      for(int i = 0; !found && i < typeDecl.getNumBodyDecl(); i++) {
        if(typeDecl.getBodyDecl(i) instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration)typeDecl.getBodyDecl(i);
          if(!f.isStatic() && f.isDAafter(this))
            found = true;
        }
        else if(typeDecl.getBodyDecl(i) instanceof InstanceInitializer) {
          InstanceInitializer ii = (InstanceInitializer)typeDecl.getBodyDecl(i);
          if(ii.getBlock().isDAafter(this))
            found = true;
        }
      }
      for(Iterator iter = typeDecl.constructors().iterator(); !found && iter.hasNext(); ) {
        ConstructorDecl c = (ConstructorDecl)iter.next();
        if(!c.isDAafter(this)) {
          error("blank final instance variable " + name() + " in " + hostType().typeName() + " is not definitely assigned after " + c.signature());
          }
      }
    }
    if(isBlank() && hostType().isInterfaceDecl()) {
            error("variable  " + name() + " in " + hostType().typeName() + " which is an interface must have an initializer");
    }

  }

    // Declared in Modifiers.jrag at line 103

 
  public void checkModifiers() {
    super.checkModifiers();
    if(hostType().isInterfaceDecl()) {
      if(isProtected())
        error("an interface field may not be protected");
      if(isPrivate())
        error("an interface field may not be private");
      if(isTransient())
        error("an interface field may not be transient");
      if(isVolatile())
        error("an interface field may not be volatile");
    }
  }

    // Declared in NameCheck.jrag at line 265


  public void nameCheck() {
    super.nameCheck();
    // 8.3
    for(Iterator iter = hostType().memberFields(name()).iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      if(v != this && v.hostType() == hostType())
        error("field named " + name() + " is multiply declared in type " + hostType().typeName());
    }

  }

    // Declared in NodeConstructors.jrag at line 77


  public FieldDeclaration(Modifiers m, Access type, String name) {
    this(m, type, name, new Opt());
  }

    // Declared in NodeConstructors.jrag at line 81

  
  public FieldDeclaration(Modifiers m, Access type, String name, Expr init) {
    this(m, type, name, new Opt(init));
  }

    // Declared in PrettyPrint.jadd at line 177

  
  public void toString(StringBuffer s) {
    s.append(indent());
    getModifiers().toString(s);
    getTypeAccess().toString(s);
    s.append(" " + name());
    if(hasInit()) {
      s.append(" = ");
      getInit().toString(s);
    }
    s.append(";\n");
  }

    // Declared in TypeCheck.jrag at line 24


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

    // Declared in CodeGeneration.jrag at line 635


  public void emitLoadField(CodeGeneration gen, TypeDecl typeDecl) {
    if(hostType().isArrayDecl() && name().equals("length")) {
      gen.emit(Bytecode.ARRAYLENGTH);
      return;
    }
    String classname = typeDecl.constantPoolName();
    String      desc = type().typeDescriptor();
    String      name = name();
    int index = gen.constantPool().addFieldref(classname, name, desc);
    if(isStatic())
      gen.emit(Bytecode.GETSTATIC, type().variableSize()).add2(index);
    else
      gen.emit(Bytecode.GETFIELD, type().variableSize() - 1).add2(index);
  }

    // Declared in CodeGeneration.jrag at line 693

  
  public void emitStoreField(CodeGeneration gen, TypeDecl typeDecl) {
    String classname = typeDecl.constantPoolName();
    String      desc = type().typeDescriptor();
    String      name = name();
    int index = gen.constantPool().addFieldref(classname, name, desc);
    if(isStatic())
      gen.emit(Bytecode.PUTSTATIC, -type().variableSize()).add2(index);
    else
      gen.emit(Bytecode.PUTFIELD, -type().variableSize() - 1).add2(index);
  }

    // Declared in GenerateClassfile.jrag at line 393


  public boolean clear() {
    return false;
  }

    // Declared in InnerClasses.jrag at line 86

  private int accessorIndex = -1;

    // Declared in InnerClasses.jrag at line 89

  private int accessorWriteIndex = -1;

    // Declared in InnerClasses.jrag at line 157


  public void emitAccessor(ConstantPool cp, DataOutputStream out) throws java.io.IOException {
    out.writeChar(Modifiers.ACC_STATIC);
    out.writeChar(cp.addUtf8("access$" + accessorIndex()));
    out.writeChar(cp.addUtf8(accessorDescName()));
    out.writeChar(accessorAttributes().size());
    for(Iterator iter = accessorAttributes().iterator(); iter.hasNext(); ) {
      ((Attribute)iter.next()).emit(out);
    }
  }

    // Declared in InnerClasses.jrag at line 166

  public void emitAccessorWrite(ConstantPool cp, DataOutputStream out) throws java.io.IOException {
    out.writeChar(Modifiers.ACC_STATIC);
    out.writeChar(cp.addUtf8("access$" + accessorWriteIndex()));
    out.writeChar(cp.addUtf8(accessorWriteDescName()));
    out.writeChar(accessorAttributes().size());
    for(Iterator iter = accessorWriteAttributes().iterator(); iter.hasNext(); ) {
      ((Attribute)iter.next()).emit(out);
    }
  }

    // Declared in InnerClasses.jrag at line 176


  public ArrayList accessorAttributes() {
    ConstantPool cp = hostType().constantPool();
    ArrayList list = new ArrayList();
    CodeGeneration gen = new CodeGeneration(cp);
    int index = 0;
    if(!isStatic())
      gen.emitLoadReference(index++);
    emitLoadField(gen, hostType());
    type().emitReturn(gen);
    CodeAttribute a = new CodeAttribute(gen, null);
    list.add(a);
    list.add(new SyntheticAttribute(cp));
    return list;
  }

    // Declared in InnerClasses.jrag at line 191


  public ArrayList accessorWriteAttributes() {
    ConstantPool cp = hostType().constantPool();
    ArrayList list = new ArrayList();
    CodeGeneration gen = new CodeGeneration(cp);
    int index = 0;
    if(!isStatic())
      gen.emitLoadReference(index++);
    type().emitLoadLocal(gen, index);
    emitStoreField(gen, hostType());
    gen.emit(Bytecode.RETURN);
    CodeAttribute a = new CodeAttribute(gen, null);
    list.add(a);
    list.add(new SyntheticAttribute(cp));
    return list;
  }

    // Declared in InnerClasses.jrag at line 358

  public void emitInvokeFieldAccessor(CodeGeneration gen, TypeDecl hostType) {
    String classname = hostType.constantPoolName();
    String      desc = accessorDescName();
    String      name = "access$" + accessorIndex();
    int index = gen.constantPool().addMethodref(classname, name, desc);
    int size = isStatic() ? type().variableSize() : (type().variableSize() - 1);
    gen.emit(Bytecode.INVOKESTATIC, size).add2(index);
  }

    // Declared in InnerClasses.jrag at line 366

  public void emitInvokeFieldAccessorWrite(CodeGeneration gen, TypeDecl hostType) {
    String classname = hostType.constantPoolName();
    String      desc = accessorWriteDescName();
    String      name = "access$" + accessorWriteIndex();
    int index = gen.constantPool().addMethodref(classname, name, desc);
    int size = isStatic() ? -type().variableSize() : (-type().variableSize() - 1);
    gen.emit(Bytecode.INVOKESTATIC, size).add2(index);
  }

    // Declared in Generics.jrag at line 901

  public BodyDecl p(ParTypeDecl parTypeDecl) {
    FieldDeclaration f = new FieldDeclarationSubstituted(
      (Modifiers)getModifiers().fullCopy(),
      getTypeAccess().type().substituteReturnType(parTypeDecl),
      getID(),
      new Opt(),
      this
    );
    return f;
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 76

    public FieldDeclaration() {
        super();

        setChild(null, 0);
        setChild(null, 1);
        setChild(new Opt(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 76
    public FieldDeclaration(Modifiers p0, Access p1, String p2, Opt p3) {
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
    // Declared in java.ast line 76
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
    // Declared in java.ast line 76
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
    // Declared in java.ast line 76
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
    // Declared in java.ast line 76
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

    // Declared in Attributes.jrag at line 178
private Collection refined_Attributes_attributes()
 {
    ArrayList l = new ArrayList();
    if(isStatic() && isFinal() && isConstant() && (type().isPrimitive() || type().isString()))
      l.add(new ConstantValueAttribute(hostType().constantPool(), this));
    return l;
  }

    // Declared in AnnotationsCodegen.jrag at line 8
private Collection refined_AnnotationsCodegen_attributes()
 {
    Collection c = refined_Attributes_attributes();
    getModifiers().addRuntimeVisibleAnnotationsAttribute(c);
    getModifiers().addRuntimeInvisibleAnnotationsAttribute(c);
    return c;
  }

    protected java.util.Map accessibleFrom_TypeDecl_values;
    // Declared in AccessControl.jrag at line 100
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
    if(isPublic())
      return true;
    else if(isProtected()) {
      if(hostPackage().equals(type.hostPackage()))
        return true;
      if(type.withinBodyThatSubclasses(hostType()) != null)
        return true;
      return false;
    }
    else if(isPrivate())
      return hostType().topLevelType() == type.topLevelType();
    else
      return hostPackage().equals(type.hostPackage());
  }

    protected boolean exceptions_computed = false;
    protected Collection exceptions_value;
    // Declared in AnonymousClasses.jrag at line 102
    public Collection exceptions() {
        if(exceptions_computed)
            return exceptions_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        exceptions_value = exceptions_compute();
        if(isFinal && num == boundariesCrossed)
            exceptions_computed = true;
        return exceptions_value;
    }

    private Collection exceptions_compute()  {
    HashSet set = new HashSet();
    if(isInstanceVariable() && hasInit()) {
      collectExceptions(set, this);
      for(Iterator iter = set.iterator(); iter.hasNext(); ) {
        TypeDecl typeDecl = (TypeDecl)iter.next();
        if(!getInit().reachedException(typeDecl))
          iter.remove();
      }
    }
    return set;
  }

    // Declared in ConstantExpression.jrag at line 446
    public boolean isConstant() {
        boolean isConstant_value = isConstant_compute();
        return isConstant_value;
    }

    private boolean isConstant_compute() {  return  isFinal() && hasInit() && getInit().isConstant() && (type().isPrimitive() || type().isString());  }

    // Declared in DataStructures.jrag at line 58
    public int size() {
        int size_value = size_compute();
        return size_value;
    }

    private int size_compute() {  return  1;  }

    // Declared in DataStructures.jrag at line 59
    public boolean isEmpty() {
        boolean isEmpty_value = isEmpty_compute();
        return isEmpty_value;
    }

    private boolean isEmpty_compute() {  return  false;  }

    // Declared in DataStructures.jrag at line 63
    public boolean contains(Object o) {
        boolean contains_Object_value = contains_compute(o);
        return contains_Object_value;
    }

    private boolean contains_compute(Object o) {  return  this == o;  }

    // Declared in DefiniteAssignment.jrag at line 303
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

    // Declared in DefiniteAssignment.jrag at line 765
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

    // Declared in Modifiers.jrag at line 205
    public boolean isSynthetic() {
        boolean isSynthetic_value = isSynthetic_compute();
        return isSynthetic_value;
    }

    private boolean isSynthetic_compute() {  return  getModifiers().isSynthetic();  }

    // Declared in Modifiers.jrag at line 224
    public boolean isPublic() {
        boolean isPublic_value = isPublic_compute();
        return isPublic_value;
    }

    private boolean isPublic_compute() {  return  getModifiers().isPublic() || hostType().isInterfaceDecl();  }

    // Declared in Modifiers.jrag at line 225
    public boolean isPrivate() {
        boolean isPrivate_value = isPrivate_compute();
        return isPrivate_value;
    }

    private boolean isPrivate_compute() {  return  getModifiers().isPrivate();  }

    // Declared in Modifiers.jrag at line 226
    public boolean isProtected() {
        boolean isProtected_value = isProtected_compute();
        return isProtected_value;
    }

    private boolean isProtected_compute() {  return  getModifiers().isProtected();  }

    // Declared in Modifiers.jrag at line 227
    public boolean isStatic() {
        boolean isStatic_value = isStatic_compute();
        return isStatic_value;
    }

    private boolean isStatic_compute() {  return  getModifiers().isStatic() || hostType().isInterfaceDecl();  }

    // Declared in Modifiers.jrag at line 229
    public boolean isFinal() {
        boolean isFinal_value = isFinal_compute();
        return isFinal_value;
    }

    private boolean isFinal_compute() {  return  getModifiers().isFinal() || hostType().isInterfaceDecl();  }

    // Declared in Modifiers.jrag at line 230
    public boolean isTransient() {
        boolean isTransient_value = isTransient_compute();
        return isTransient_value;
    }

    private boolean isTransient_compute() {  return  getModifiers().isTransient();  }

    // Declared in Modifiers.jrag at line 231
    public boolean isVolatile() {
        boolean isVolatile_value = isVolatile_compute();
        return isVolatile_value;
    }

    private boolean isVolatile_compute() {  return  getModifiers().isVolatile();  }

    // Declared in PrettyPrint.jadd at line 946
    public String dumpString() {
        String dumpString_value = dumpString_compute();
        return dumpString_value;
    }

    private String dumpString_compute() {  return  getClass().getName() + " [" + getID() + "]";  }

    // Declared in TypeAnalysis.jrag at line 242
    public TypeDecl type() {
        TypeDecl type_value = type_compute();
        return type_value;
    }

    private TypeDecl type_compute() {  return  getTypeAccess().type();  }

    // Declared in TypeAnalysis.jrag at line 274
    public boolean isVoid() {
        boolean isVoid_value = isVoid_compute();
        return isVoid_value;
    }

    private boolean isVoid_compute() {  return  type().isVoid();  }

    // Declared in VariableDeclaration.jrag at line 45
    public boolean isClassVariable() {
        boolean isClassVariable_value = isClassVariable_compute();
        return isClassVariable_value;
    }

    private boolean isClassVariable_compute() {  return  isStatic() || hostType().isInterfaceDecl();  }

    // Declared in VariableDeclaration.jrag at line 46
    public boolean isInstanceVariable() {
        boolean isInstanceVariable_value = isInstanceVariable_compute();
        return isInstanceVariable_value;
    }

    private boolean isInstanceVariable_compute() {  return  (hostType().isClassDecl() || hostType().isAnonymous() )&& !isStatic();  }

    // Declared in VariableDeclaration.jrag at line 47
    public boolean isMethodParameter() {
        boolean isMethodParameter_value = isMethodParameter_compute();
        return isMethodParameter_value;
    }

    private boolean isMethodParameter_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 48
    public boolean isConstructorParameter() {
        boolean isConstructorParameter_value = isConstructorParameter_compute();
        return isConstructorParameter_value;
    }

    private boolean isConstructorParameter_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 49
    public boolean isExceptionHandlerParameter() {
        boolean isExceptionHandlerParameter_value = isExceptionHandlerParameter_compute();
        return isExceptionHandlerParameter_value;
    }

    private boolean isExceptionHandlerParameter_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 50
    public boolean isLocalVariable() {
        boolean isLocalVariable_value = isLocalVariable_compute();
        return isLocalVariable_value;
    }

    private boolean isLocalVariable_compute() {  return  false;  }

    // Declared in VariableDeclaration.jrag at line 52
    public boolean isBlank() {
        boolean isBlank_value = isBlank_compute();
        return isBlank_value;
    }

    private boolean isBlank_compute() {  return  !hasInit();  }

    // Declared in VariableDeclaration.jrag at line 54
    public String name() {
        String name_value = name_compute();
        return name_value;
    }

    private String name_compute() {  return  getID();  }

    protected boolean constant_computed = false;
    protected Constant constant_value;
    // Declared in VariableDeclaration.jrag at line 55
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

    // Declared in GenericsCodegen.jrag at line 285
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
    Collection c = refined_AnnotationsCodegen_attributes();
    if(needsSignatureAttribute())
      c.add(new SignatureAttribute(hostType().constantPool(), type().fieldTypeSignature()));
    return c;
  }

    protected boolean accessorDescName_computed = false;
    protected String accessorDescName_value;
    // Declared in ConstantPoolNames.jrag at line 39
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
    if(!isStatic())
      b.append(hostType().typeDescriptor());
    b.append(")");
    b.append(type().typeDescriptor());
    return b.toString();
  }

    protected boolean accessorWriteDescName_computed = false;
    protected String accessorWriteDescName_value;
    // Declared in ConstantPoolNames.jrag at line 49
    public String accessorWriteDescName() {
        if(accessorWriteDescName_computed)
            return accessorWriteDescName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        accessorWriteDescName_value = accessorWriteDescName_compute();
        if(isFinal && num == boundariesCrossed)
            accessorWriteDescName_computed = true;
        return accessorWriteDescName_value;
    }

    private String accessorWriteDescName_compute()  {
    StringBuffer b = new StringBuffer();
    b.append("(");
    if(!isStatic())
      b.append(hostType().typeDescriptor());
    b.append(type().typeDescriptor());
    b.append(")V");
    return b.toString();
  }

    protected boolean flags_computed = false;
    protected int flags_value;
    // Declared in Flags.jrag at line 67
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
    if(isStatic()) res |= Modifiers.ACC_STATIC;
    if(isFinal()) res |= Modifiers.ACC_FINAL;
    if(isVolatile()) res |= Modifiers.ACC_VOLATILE;
    if(isTransient()) res |= Modifiers.ACC_TRANSIENT;
    return res;
  }

    // Declared in GenerateClassfile.jrag at line 323
    public boolean isBytecodeField() {
        boolean isBytecodeField_value = isBytecodeField_compute();
        return isBytecodeField_value;
    }

    private boolean isBytecodeField_compute() {  return  true;  }

    // Declared in GenerateClassfile.jrag at line 355
    public boolean flush() {
        boolean flush_value = flush_compute();
        return flush_value;
    }

    private boolean flush_compute() {  return  false;  }

    // Declared in InnerClasses.jrag at line 84
    public boolean needsAccessor() {
        boolean needsAccessor_value = needsAccessor_compute();
        return needsAccessor_value;
    }

    private boolean needsAccessor_compute() {  return  accessorIndex != -1;  }

    protected boolean accessorIndex_computed = false;
    protected int accessorIndex_value;
    // Declared in InnerClasses.jrag at line 85
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

    private int accessorIndex_compute() {  return  accessorIndex = hostType().accessorCounter++;  }

    // Declared in InnerClasses.jrag at line 87
    public boolean needsAccessorWrite() {
        boolean needsAccessorWrite_value = needsAccessorWrite_compute();
        return needsAccessorWrite_value;
    }

    private boolean needsAccessorWrite_compute() {  return  accessorWriteIndex != -1;  }

    protected boolean accessorWriteIndex_computed = false;
    protected int accessorWriteIndex_value;
    // Declared in InnerClasses.jrag at line 88
    public int accessorWriteIndex() {
        if(accessorWriteIndex_computed)
            return accessorWriteIndex_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        accessorWriteIndex_value = accessorWriteIndex_compute();
        if(isFinal && num == boundariesCrossed)
            accessorWriteIndex_computed = true;
        return accessorWriteIndex_value;
    }

    private int accessorWriteIndex_compute() {  return  accessorWriteIndex = hostType().accessorCounter++;  }

    // Declared in Annotations.jrag at line 283
    public boolean hasAnnotationSuppressWarnings(String s) {
        boolean hasAnnotationSuppressWarnings_String_value = hasAnnotationSuppressWarnings_compute(s);
        return hasAnnotationSuppressWarnings_String_value;
    }

    private boolean hasAnnotationSuppressWarnings_compute(String s) {  return  getModifiers().hasAnnotationSuppressWarnings(s);  }

    // Declared in Annotations.jrag at line 321
    public boolean isDeprecated() {
        boolean isDeprecated_value = isDeprecated_compute();
        return isDeprecated_value;
    }

    private boolean isDeprecated_compute() {  return  getModifiers().hasDeprecatedAnnotation();  }

    protected boolean usesTypeVariable_computed = false;
    protected boolean usesTypeVariable_value;
    // Declared in Generics.jrag at line 759
    public boolean usesTypeVariable() {
        if(usesTypeVariable_computed)
            return usesTypeVariable_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        usesTypeVariable_value = usesTypeVariable_compute();
        if(isFinal && num == boundariesCrossed)
            usesTypeVariable_computed = true;
        return usesTypeVariable_value;
    }

    private boolean usesTypeVariable_compute() {  return  getTypeAccess().usesTypeVariable();  }

    // Declared in GenericsParTypeDecl.jrag at line 57
    public boolean visibleTypeParameters() {
        boolean visibleTypeParameters_value = visibleTypeParameters_compute();
        return visibleTypeParameters_value;
    }

    private boolean visibleTypeParameters_compute() {  return  !isStatic();  }

    // Declared in GenericsCodegen.jrag at line 8
    public FieldDeclaration erasedField() {
        FieldDeclaration erasedField_value = erasedField_compute();
        return erasedField_value;
    }

    private FieldDeclaration erasedField_compute() {  return  this;  }

    // Declared in GenericsCodegen.jrag at line 342
    public boolean needsSignatureAttribute() {
        boolean needsSignatureAttribute_value = needsSignatureAttribute_compute();
        return needsSignatureAttribute_value;
    }

    private boolean needsSignatureAttribute_compute() {  return  type().needsSignatureAttribute();  }

    // Declared in ExceptionHandling.jrag at line 25
    public boolean handlesException(TypeDecl exceptionType) {
        boolean handlesException_TypeDecl_value = getParent().Define_boolean_handlesException(this, null, exceptionType);
        return handlesException_TypeDecl_value;
    }

    // Declared in Modifiers.jrag at line 249
    public boolean Define_boolean_mayBePrivate(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBePrivate(this, caller);
    }

    // Declared in GenericMethodsInference.jrag at line 26
    public TypeDecl Define_TypeDecl_assignConvertedType(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  type();
        }
        return getParent().Define_TypeDecl_assignConvertedType(this, caller);
    }

    // Declared in ExceptionHandling.jrag at line 134
    public boolean Define_boolean_handlesException(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
        if(caller == getInitOptNoTransform()) {
    if(hostType().isAnonymous())
      return true;
    if(!exceptionType.isUncheckedException())
      return true;
    for(Iterator iter = hostType().constructors().iterator(); iter.hasNext(); ) {
      ConstructorDecl decl = (ConstructorDecl)iter.next();
      if(!decl.throwsException(exceptionType))
        return false;
    }
    return true;
  }
        return getParent().Define_boolean_handlesException(this, caller, exceptionType);
    }

    // Declared in DefiniteAssignment.jrag at line 309
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getInitOptNoTransform()) {
    return isDAbefore(v);
  }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in Modifiers.jrag at line 251
    public boolean Define_boolean_mayBeFinal(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeFinal(this, caller);
    }

    // Declared in Annotations.jrag at line 69
    public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
        if(caller == getModifiersNoTransform()) {
            return 
    name.equals("FIELD");
        }
        return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }

    // Declared in CreateBCode.jrag at line 863
    public TypeDecl Define_TypeDecl_expectedType(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  type().componentType();
        }
        return getParent().Define_TypeDecl_expectedType(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 586
    public BodyDecl Define_BodyDecl_hostBodyDecl(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  this;
        }
        return getParent().Define_BodyDecl_hostBodyDecl(this, caller);
    }

    // Declared in Modifiers.jrag at line 247
    public boolean Define_boolean_mayBePublic(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBePublic(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 28
    public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_isSource(this, caller);
    }

    // Declared in Modifiers.jrag at line 253
    public boolean Define_boolean_mayBeVolatile(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeVolatile(this, caller);
    }

    // Declared in Modifiers.jrag at line 248
    public boolean Define_boolean_mayBeProtected(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeProtected(this, caller);
    }

    // Declared in Modifiers.jrag at line 252
    public boolean Define_boolean_mayBeTransient(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeTransient(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 256
    public TypeDecl Define_TypeDecl_declType(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  type();
        }
        return getParent().Define_TypeDecl_declType(this, caller);
    }

    // Declared in SyntacticClassification.jrag at line 68
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeAccessNoTransform()) {
            return  NameType.TYPE_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in TypeHierarchyCheck.jrag at line 132
    public boolean Define_boolean_inStaticContext(ASTNode caller, ASTNode child) {
        if(caller == getInitOptNoTransform()) {
            return  isStatic() || hostType().isInterfaceDecl();
        }
        return getParent().Define_boolean_inStaticContext(this, caller);
    }

    // Declared in Modifiers.jrag at line 250
    public boolean Define_boolean_mayBeStatic(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeStatic(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
