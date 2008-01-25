
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class TypeVariable extends ReferenceType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        erasure_computed = false;
        erasure_value = null;
        fullName_computed = false;
        fullName_value = null;
        usesTypeVariable_computed = false;
        accessibleFrom_TypeDecl_values = null;
        instanceOf_TypeDecl_values = null;
        typeDescriptor_computed = false;
        typeDescriptor_value = null;
        constantPoolName_computed = false;
        constantPoolName_value = null;
        needsSignatureAttribute_computed = false;
        fieldTypeSignature_computed = false;
        fieldTypeSignature_value = null;
        classTypeSignature_computed = false;
        classTypeSignature_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        TypeVariable node = (TypeVariable)super.clone();
        node.erasure_computed = false;
        node.erasure_value = null;
        node.fullName_computed = false;
        node.fullName_value = null;
        node.usesTypeVariable_computed = false;
        node.accessibleFrom_TypeDecl_values = null;
        node.instanceOf_TypeDecl_values = null;
        node.typeDescriptor_computed = false;
        node.typeDescriptor_value = null;
        node.constantPoolName_computed = false;
        node.constantPoolName_value = null;
        node.needsSignatureAttribute_computed = false;
        node.fieldTypeSignature_computed = false;
        node.fieldTypeSignature_value = null;
        node.classTypeSignature_computed = false;
        node.classTypeSignature_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          TypeVariable node = (TypeVariable)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        TypeVariable res = (TypeVariable)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in GenericTypeVariables.jrag at line 19
    

  public void nameCheck() {
    if(extractSingleType(lookupType(name())) != this)
      error("*** Semantic Error: type variable " + name() + " is multiply declared");
  }

    // Declared in GenericTypeVariables.jrag at line 57


  public void typeCheck() {
    if(getTypeBound(0).type().isTypeVariable()) {
      if(getNumTypeBound() > 1)
        error("a type variable may not be followed by other bounds");
    }
    else {
      if(!getTypeBound(0).type().isClassDecl() && !getTypeBound(0).type().isInterfaceDecl()) {
      error("the first type bound must be a class or interface type which " + 
        getTypeBound(0).type().fullName() + " is not");
      }
      for(int i = 1; i < getNumTypeBound(); i++) {
        if(!getTypeBound(i).type().isInterfaceDecl()) {
          error("type bound " + i + " must be an interface type which " + 
            getTypeBound(i).type().fullName() + " is not");
        }
      }
    }
    HashSet typeSet = new HashSet();
    for(int i = 0; i < getNumTypeBound(); i++) {
      TypeDecl type = getTypeBound(i).type();
      TypeDecl erasure = type.erasure();
      if(typeSet.contains(erasure)) {
        if(type != erasure) {
          error("the erasure " + erasure.fullName() + " of typebound " + getTypeBound(i) + " is multiply declared in " + this);
        }
        else {
          error(type.fullName() + " is multiply declared");
        }
      }
      typeSet.add(erasure);
    }

    for(int i = 0; i < getNumTypeBound(); i++) {
      TypeDecl type = getTypeBound(i).type();
      for(Iterator iter = type.methodsIterator(); iter.hasNext(); ) {
        MethodDecl m = (MethodDecl)iter.next();
        for(int j = i+1; j < getNumTypeBound(); j++) {
          TypeDecl destType = getTypeBound(j).type();
          for(Iterator destIter = destType.memberMethods(m.name()).iterator(); destIter.hasNext(); ) {
            MethodDecl n = (MethodDecl)destIter.next();
            if(m.sameSignature(n) && m.type() != n.type()) {
              error("the two bounds, " + type.name() + " and " + destType.name() + ", in type variable " + name() + 
                " have a method " + m.signature() + " with conflicting return types " + m.type().name() + " and " + n.type().name());
            }
          }
        }
      }
    }

    
  }

    // Declared in Generics.jrag at line 598

  public Access substitute(Parameterization parTypeDecl) {
    if(parTypeDecl.isRawType())
      return erasure().createBoundAccess();
    for(int i = 0; i < parTypeDecl.numTypeParameter(); i++)
      if(parTypeDecl.typeParameter(i) == this)
        return parTypeDecl.typeArgument(i).createBoundAccess();
    return createBoundAccess();
  }

    // Declared in Generics.jrag at line 639

  
  public Access substituteReturnType(Parameterization parTypeDecl) {
    if(parTypeDecl.isRawType())
      return erasure().createBoundAccess();
    for(int i = 0; i < parTypeDecl.numTypeParameter(); i++) {
      if(parTypeDecl.typeParameter(i) == this) {
        TypeDecl typeDecl = parTypeDecl.typeArgument(i);
        if(typeDecl instanceof WildcardType)
          return typeObject().createBoundAccess();
        else if(typeDecl instanceof WildcardExtendsType)
          return ((WildcardExtendsType)typeDecl).extendsType().createBoundAccess();
        else if(typeDecl instanceof WildcardSuperType)
          return typeObject().createBoundAccess();
        return typeDecl.createBoundAccess();
      }
    }
    return createBoundAccess();
  }

    // Declared in Generics.jrag at line 664

  public Access substituteParameterType(Parameterization parTypeDecl) {
    if(parTypeDecl.isRawType())
      return erasure().createBoundAccess();
    for(int i = 0; i < parTypeDecl.numTypeParameter(); i++) {
      if(parTypeDecl.typeParameter(i) == this) {
        TypeDecl typeDecl = parTypeDecl.typeArgument(i);
        if(typeDecl instanceof WildcardType)
          return typeNull().createQualifiedAccess();
        else if(typeDecl instanceof WildcardExtendsType)
          return typeNull().createQualifiedAccess();
        else if(typeDecl instanceof WildcardSuperType)
          return ((WildcardSuperType)typeDecl).superType().createBoundAccess();
        return typeDecl.createBoundAccess();
      }
    }
    return createBoundAccess();
  }

    // Declared in Generics.jrag at line 1060


  public Access createQualifiedAccess() {
    return createBoundAccess();
  }

    // Declared in GenericsPrettyPrint.jrag at line 2

  public void toString(StringBuffer s) {
    s.append(name());
    if(getNumTypeBound() > 0) {
      s.append(" extends ");
      s.append(getTypeBound(0).type().fullName());
      for(int i = 1; i < getNumTypeBound(); i++) {
        s.append(" & ");
        s.append(getTypeBound(i).type().fullName());
      }
    }
  }

    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 18

    public TypeVariable() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);

    }

    // Declared in Generics.ast at line 13


    // Declared in Generics.ast line 18
    public TypeVariable(Modifiers p0, String p1, List p2, List p3) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
    }

    // Declared in Generics.ast at line 20


  protected int numChildren() {
    return 3;
  }

    // Declared in Generics.ast at line 23

  public boolean mayHaveRewrite() { return true; }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 18
    public void setModifiers(Modifiers node) {
        setChild(node, 0);
    }

    // Declared in Generics.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(0);
    }

    // Declared in Generics.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(0);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 18
    private String tokenString_ID;

    // Declared in Generics.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in Generics.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 18
    public void setBodyDeclList(List list) {
        setChild(list, 1);
    }

    // Declared in Generics.ast at line 6


    public int getNumBodyDecl() {
        return getBodyDeclList().getNumChild();
    }

    // Declared in Generics.ast at line 10


    public BodyDecl getBodyDecl(int i) {
        return (BodyDecl)getBodyDeclList().getChild(i);
    }

    // Declared in Generics.ast at line 14


    public void addBodyDecl(BodyDecl node) {
        List list = getBodyDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Generics.ast at line 19


    public void setBodyDecl(BodyDecl node, int i) {
        List list = getBodyDeclList();
        list.setChild(node, i);
    }

    // Declared in Generics.ast at line 23

    public List getBodyDeclList() {
        return (List)getChild(1);
    }

    // Declared in Generics.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 18
    public void setTypeBoundList(List list) {
        setChild(list, 2);
    }

    // Declared in Generics.ast at line 6


    public int getNumTypeBound() {
        return getTypeBoundList().getNumChild();
    }

    // Declared in Generics.ast at line 10


    public Access getTypeBound(int i) {
        return (Access)getTypeBoundList().getChild(i);
    }

    // Declared in Generics.ast at line 14


    public void addTypeBound(Access node) {
        List list = getTypeBoundList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Generics.ast at line 19


    public void setTypeBound(Access node, int i) {
        List list = getTypeBoundList();
        list.setChild(node, i);
    }

    // Declared in Generics.ast at line 23

    public List getTypeBoundList() {
        return (List)getChild(2);
    }

    // Declared in Generics.ast at line 27


    public List getTypeBoundListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    protected boolean involvesTypeParameters_visited = false;
    protected boolean involvesTypeParameters_computed = false;
    protected boolean involvesTypeParameters_initialized = false;
    protected boolean involvesTypeParameters_value;
    public boolean involvesTypeParameters() {
        if(involvesTypeParameters_computed)
            return involvesTypeParameters_value;
        if (!involvesTypeParameters_initialized) {
            involvesTypeParameters_initialized = true;
            involvesTypeParameters_value = false;
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            involvesTypeParameters_visited = true;
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            do {
                CHANGE = false;
                boolean new_involvesTypeParameters_value = involvesTypeParameters_compute();
                if (new_involvesTypeParameters_value!=involvesTypeParameters_value)
                    CHANGE = true;
                involvesTypeParameters_value = new_involvesTypeParameters_value; 
            } while (CHANGE);
            involvesTypeParameters_visited = false;
            if(isFinal && num == boundariesCrossed)
{
            involvesTypeParameters_computed = true;
            }
            else {
            RESET_CYCLE = true;
            involvesTypeParameters_compute();
            RESET_CYCLE = false;
              involvesTypeParameters_computed = false;
              involvesTypeParameters_initialized = false;
            }
            IN_CIRCLE = false; 
            return involvesTypeParameters_value;
        }
        if(!involvesTypeParameters_visited) {
            if (RESET_CYCLE) {
                involvesTypeParameters_computed = false;
                involvesTypeParameters_initialized = false;
                return involvesTypeParameters_value;
            }
            involvesTypeParameters_visited = true;
            boolean new_involvesTypeParameters_value = involvesTypeParameters_compute();
            if (new_involvesTypeParameters_value!=involvesTypeParameters_value)
                CHANGE = true;
            involvesTypeParameters_value = new_involvesTypeParameters_value; 
            involvesTypeParameters_visited = false;
            return involvesTypeParameters_value;
        }
        return involvesTypeParameters_value;
    }

    private boolean involvesTypeParameters_compute() {  return  true;  }

    // Declared in GenericTypeVariables.jrag at line 24
    public TypeDecl lowerBound() {
        TypeDecl lowerBound_value = lowerBound_compute();
        return lowerBound_value;
    }

    private TypeDecl lowerBound_compute() {  return  getTypeBound(0).type();  }

    // Declared in GenericTypeVariables.jrag at line 29
    public Collection memberMethods(String name) {
        Collection memberMethods_String_value = memberMethods_compute(name);
        return memberMethods_String_value;
    }

    private Collection memberMethods_compute(String name)  {
    Collection list = new HashSet();
    for(int i = 0; i < getNumTypeBound(); i++) {
      for(Iterator iter = getTypeBound(i).type().memberMethods(name).iterator(); iter.hasNext(); ) {
        MethodDecl decl = (MethodDecl)iter.next();
        if(!decl.isPrivate())
          list.add(decl);
      }
    }
    return list;
  }

    // Declared in GenericTypeVariables.jrag at line 41
    public SimpleSet fields(String name) {
        SimpleSet fields_String_value = fields_compute(name);
        return fields_String_value;
    }

    private SimpleSet fields_compute(String name)  {
    SimpleSet set = SimpleSet.emptySet;
    for(int i = 0; i < getNumTypeBound(); i++) {
      for(Iterator iter = getTypeBound(i).type().fields(name).iterator(); iter.hasNext(); ) {
        FieldDeclaration decl = (FieldDeclaration)iter.next();
        if(!decl.isPrivate())
          set = set.add(decl);
      }
    }
    return set;
  }

    // Declared in Generics.jrag at line 56
    public boolean isNestedType() {
        boolean isNestedType_value = isNestedType_compute();
        return isNestedType_value;
    }

    private boolean isNestedType_compute() {  return  false;  }

    // Declared in Generics.jrag at line 220
    public TypeDecl erasure() {
        if(erasure_computed)
            return erasure_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        erasure_value = erasure_compute();
        if(isFinal && num == boundariesCrossed)
            erasure_computed = true;
        return erasure_value;
    }

    private TypeDecl erasure_compute() {  return  getTypeBound(0).type().erasure();  }

    // Declared in Generics.jrag at line 418
    public String fullName() {
        if(fullName_computed)
            return fullName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        fullName_value = fullName_compute();
        if(isFinal && num == boundariesCrossed)
            fullName_computed = true;
        return fullName_value;
    }

    private String fullName_compute()  {
    if(getParent().getParent() instanceof TypeDecl) {
      TypeDecl typeDecl = (TypeDecl)getParent().getParent();
      return typeDecl.fullName() + "@" + name();
    }
    return super.fullName();
  }

    // Declared in Generics.jrag at line 431
    public boolean sameSignature(Access a) {
        boolean sameSignature_Access_value = sameSignature_compute(a);
        return sameSignature_Access_value;
    }

    private boolean sameSignature_compute(Access a) {  return  a.type() == this;  }

    protected boolean usesTypeVariable_visited = false;
    protected boolean usesTypeVariable_computed = false;
    protected boolean usesTypeVariable_initialized = false;
    protected boolean usesTypeVariable_value;
    public boolean usesTypeVariable() {
        if(usesTypeVariable_computed)
            return usesTypeVariable_value;
        if (!usesTypeVariable_initialized) {
            usesTypeVariable_initialized = true;
            usesTypeVariable_value = false;
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            usesTypeVariable_visited = true;
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            do {
                CHANGE = false;
                boolean new_usesTypeVariable_value = usesTypeVariable_compute();
                if (new_usesTypeVariable_value!=usesTypeVariable_value)
                    CHANGE = true;
                usesTypeVariable_value = new_usesTypeVariable_value; 
            } while (CHANGE);
            usesTypeVariable_visited = false;
            if(isFinal && num == boundariesCrossed)
{
            usesTypeVariable_computed = true;
            }
            else {
            RESET_CYCLE = true;
            usesTypeVariable_compute();
            RESET_CYCLE = false;
              usesTypeVariable_computed = false;
              usesTypeVariable_initialized = false;
            }
            IN_CIRCLE = false; 
            return usesTypeVariable_value;
        }
        if(!usesTypeVariable_visited) {
            if (RESET_CYCLE) {
                usesTypeVariable_computed = false;
                usesTypeVariable_initialized = false;
                return usesTypeVariable_value;
            }
            usesTypeVariable_visited = true;
            boolean new_usesTypeVariable_value = usesTypeVariable_compute();
            if (new_usesTypeVariable_value!=usesTypeVariable_value)
                CHANGE = true;
            usesTypeVariable_value = new_usesTypeVariable_value; 
            usesTypeVariable_visited = false;
            return usesTypeVariable_value;
        }
        return usesTypeVariable_value;
    }

    private boolean usesTypeVariable_compute() {  return  true;  }

    // Declared in Generics.jrag at line 1064
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

    private boolean accessibleFrom_compute(TypeDecl type) {  return  true;  }

    // Declared in GenericsParTypeDecl.jrag at line 62
    public boolean isTypeVariable() {
        boolean isTypeVariable_value = isTypeVariable_compute();
        return isTypeVariable_value;
    }

    private boolean isTypeVariable_compute() {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 40
    public boolean supertypeWildcard(WildcardType type) {
        boolean supertypeWildcard_WildcardType_value = supertypeWildcard_compute(type);
        return supertypeWildcard_WildcardType_value;
    }

    private boolean supertypeWildcard_compute(WildcardType type) {  return  
    true;  }

    // Declared in GenericsSubtype.jrag at line 51
    public boolean supertypeWildcardExtends(WildcardExtendsType type) {
        boolean supertypeWildcardExtends_WildcardExtendsType_value = supertypeWildcardExtends_compute(type);
        return supertypeWildcardExtends_WildcardExtendsType_value;
    }

    private boolean supertypeWildcardExtends_compute(WildcardExtendsType type) {  return 
    type.extendsType().subtype(this);  }

    // Declared in GenericsSubtype.jrag at line 60
    public boolean supertypeWildcardSuper(WildcardSuperType type) {
        boolean supertypeWildcardSuper_WildcardSuperType_value = supertypeWildcardSuper_compute(type);
        return supertypeWildcardSuper_WildcardSuperType_value;
    }

    private boolean supertypeWildcardSuper_compute(WildcardSuperType type) {  return 
    type.superType().subtype(this);  }

    // Declared in GenericsSubtype.jrag at line 174
    public boolean supertypeArrayDecl(ArrayDecl type) {
        boolean supertypeArrayDecl_ArrayDecl_value = supertypeArrayDecl_compute(type);
        return supertypeArrayDecl_ArrayDecl_value;
    }

    private boolean supertypeArrayDecl_compute(ArrayDecl type)  {
    for(int i = 0; i < getNumTypeBound(); i++)
      if(type.subtype(getTypeBound(i).type())) {
        return true;
      }
    return false;
  }

    protected java.util.Set subtype_TypeDecl_visited;
    protected java.util.Set subtype_TypeDecl_computed = new java.util.HashSet(4);
    protected java.util.Set subtype_TypeDecl_initialized = new java.util.HashSet(4);
    protected java.util.Map subtype_TypeDecl_values = new java.util.HashMap(4);
    public boolean subtype(TypeDecl type) {
        Object _parameters = type;
if(subtype_TypeDecl_visited == null) subtype_TypeDecl_visited = new java.util.HashSet(4);
if(subtype_TypeDecl_values == null) subtype_TypeDecl_values = new java.util.HashMap(4);
        if(subtype_TypeDecl_computed.contains(_parameters))
            return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
        if (!subtype_TypeDecl_initialized.contains(_parameters)) {
            subtype_TypeDecl_initialized.add(_parameters);
            subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(true));
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            subtype_TypeDecl_visited.add(_parameters);
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            boolean new_subtype_TypeDecl_value;
            do {
                CHANGE = false;
                new_subtype_TypeDecl_value = subtype_compute(type);
                if (new_subtype_TypeDecl_value!=((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue())
                    CHANGE = true;
                subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(new_subtype_TypeDecl_value));
            } while (CHANGE);
            subtype_TypeDecl_visited.remove(_parameters);
            if(isFinal && num == boundariesCrossed)
{
            subtype_TypeDecl_computed.add(_parameters);
            }
            else {
            RESET_CYCLE = true;
            subtype_compute(type);
            RESET_CYCLE = false;
            subtype_TypeDecl_computed.remove(_parameters);
            subtype_TypeDecl_initialized.remove(_parameters);
            }
            IN_CIRCLE = false; 
            return new_subtype_TypeDecl_value;
        }
        if(!subtype_TypeDecl_visited.contains(_parameters)) {
            if (RESET_CYCLE) {
                subtype_TypeDecl_computed.remove(_parameters);
                subtype_TypeDecl_initialized.remove(_parameters);
                return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
            }
            subtype_TypeDecl_visited.add(_parameters);
            boolean new_subtype_TypeDecl_value = subtype_compute(type);
            if (new_subtype_TypeDecl_value!=((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue())
                CHANGE = true;
            subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(new_subtype_TypeDecl_value));
            subtype_TypeDecl_visited.remove(_parameters);
            return new_subtype_TypeDecl_value;
        }
        return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
    }

    private boolean subtype_compute(TypeDecl type) {  return  type.supertypeTypeVariable(this);  }

    // Declared in GenericsSubtype.jrag at line 192
    public boolean supertypeClassDecl(ClassDecl type) {
        boolean supertypeClassDecl_ClassDecl_value = supertypeClassDecl_compute(type);
        return supertypeClassDecl_ClassDecl_value;
    }

    private boolean supertypeClassDecl_compute(ClassDecl type)  {
    for(int i = 0; i < getNumTypeBound(); i++)
      if(!type.subtype(getTypeBound(i).type()))
        return false;
    return true;
  }

    // Declared in GenericsSubtype.jrag at line 198
    public boolean supertypeInterfaceDecl(InterfaceDecl type) {
        boolean supertypeInterfaceDecl_InterfaceDecl_value = supertypeInterfaceDecl_compute(type);
        return supertypeInterfaceDecl_InterfaceDecl_value;
    }

    private boolean supertypeInterfaceDecl_compute(InterfaceDecl type)  {
    for(int i = 0; i < getNumTypeBound(); i++)
      if(!type.subtype(getTypeBound(i).type()))
        return false;
    return true;
  }

    // Declared in GenericsSubtype.jrag at line 221
    public boolean instanceOf(TypeDecl type) {
        Object _parameters = type;
if(instanceOf_TypeDecl_values == null) instanceOf_TypeDecl_values = new java.util.HashMap(4);
        if(instanceOf_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)instanceOf_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean instanceOf_TypeDecl_value = instanceOf_compute(type);
        if(isFinal && num == boundariesCrossed)
            instanceOf_TypeDecl_values.put(_parameters, Boolean.valueOf(instanceOf_TypeDecl_value));
        return instanceOf_TypeDecl_value;
    }

    private boolean instanceOf_compute(TypeDecl type) {  return  subtype(type);  }

    // Declared in GenericsCodegen.jrag at line 3
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

    private String typeDescriptor_compute() {  return  erasure().typeDescriptor();  }

    // Declared in GenericsCodegen.jrag at line 123
    public String constantPoolName() {
        if(constantPoolName_computed)
            return constantPoolName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        constantPoolName_value = constantPoolName_compute();
        if(isFinal && num == boundariesCrossed)
            constantPoolName_computed = true;
        return constantPoolName_value;
    }

    private String constantPoolName_compute() {  return  erasure().constantPoolName();  }

    // Declared in GenericsCodegen.jrag at line 306
    public boolean needsSignatureAttribute() {
        if(needsSignatureAttribute_computed)
            return needsSignatureAttribute_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        needsSignatureAttribute_value = needsSignatureAttribute_compute();
        if(isFinal && num == boundariesCrossed)
            needsSignatureAttribute_computed = true;
        return needsSignatureAttribute_value;
    }

    private boolean needsSignatureAttribute_compute() {  return  true;  }

    // Declared in GenericsCodegen.jrag at line 387
    public String formalTypeParameter() {
        String formalTypeParameter_value = formalTypeParameter_compute();
        return formalTypeParameter_value;
    }

    private String formalTypeParameter_compute()  {
    StringBuffer buf = new StringBuffer();
    // Identifier
    buf.append(name());
    buf.append(":");
    if(getNumTypeBound() > 0) {
      // ClassBound InterfaceBound*
      if(getTypeBound(0).type().isClassDecl())
        buf.append(getTypeBound(0).type().fieldTypeSignature());
      else
        buf.append(":" + getTypeBound(0).type().fieldTypeSignature());
      for(int i = 1; i < getNumTypeBound(); i++)
        buf.append(":" + getTypeBound(i).type().fieldTypeSignature());
    }
    return buf.toString();
  }

    // Declared in GenericsCodegen.jrag at line 406
    public String fieldTypeSignature() {
        if(fieldTypeSignature_computed)
            return fieldTypeSignature_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        fieldTypeSignature_value = fieldTypeSignature_compute();
        if(isFinal && num == boundariesCrossed)
            fieldTypeSignature_computed = true;
        return fieldTypeSignature_value;
    }

    private String fieldTypeSignature_compute() {  return  classTypeSignature();  }

    // Declared in GenericsCodegen.jrag at line 414
    public String classTypeSignature() {
        if(classTypeSignature_computed)
            return classTypeSignature_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        classTypeSignature_value = classTypeSignature_compute();
        if(isFinal && num == boundariesCrossed)
            classTypeSignature_computed = true;
        return classTypeSignature_value;
    }

    private String classTypeSignature_compute() {  return  "T" + name() + ";";  }

    // Declared in Generics.jrag at line 637
    public TypeDecl typeObject() {
        TypeDecl typeObject_value = getParent().Define_TypeDecl_typeObject(this, null);
        return typeObject_value;
    }

    // Declared in Generics.jrag at line 663
    public TypeDecl typeNull() {
        TypeDecl typeNull_value = getParent().Define_TypeDecl_typeNull(this, null);
        return typeNull_value;
    }

    // Declared in GenericTypeVariables.jrag at line 4
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getTypeBoundListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        return super.Define_NameType_nameType(caller, child);
    }

public ASTNode rewriteTo() {
    // Declared in GenericTypeVariables.jrag at line 7
    if(getNumTypeBound() == 0) {
        duringGenericTypeVariables++;
        ASTNode result = rewriteRule0();
        duringGenericTypeVariables--;
        return result;
    }

    return super.rewriteTo();
}

    // Declared in GenericTypeVariables.jrag at line 7
    private TypeVariable rewriteRule0() {
			addTypeBound(
        new TypeAccess(
          "java.lang",
          "Object"
        )
      );
			return this;
		}
}
