
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class ParInterfaceDecl extends InterfaceDecl implements Cloneable,  ParTypeDecl {
    public void flushCache() {
        super.flushCache();
        erasure_computed = false;
        erasure_value = null;
        getSuperInterfaceIdList_computed = false;
        getSuperInterfaceIdList_value = null;
        getBodyDeclList_computed = false;
        getBodyDeclList_value = null;
        instanceOf_TypeDecl_values = null;
        sameSignature_ArrayList_values = null;
        usesTypeVariable_computed = false;
        localMethodsSignatureMap_computed = false;
        localMethodsSignatureMap_value = null;
        fields_String_values = null;
        memberTypes_String_values = null;
        constructors_computed = false;
        constructors_value = null;
        fullName_computed = false;
        fullName_value = null;
        typeName_computed = false;
        typeName_value = null;
        genericDecl_computed = false;
        genericDecl_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ParInterfaceDecl node = (ParInterfaceDecl)super.clone();
        node.erasure_computed = false;
        node.erasure_value = null;
        node.getSuperInterfaceIdList_computed = false;
        node.getSuperInterfaceIdList_value = null;
        node.getBodyDeclList_computed = false;
        node.getBodyDeclList_value = null;
        node.instanceOf_TypeDecl_values = null;
        node.sameSignature_ArrayList_values = null;
        node.usesTypeVariable_computed = false;
        node.localMethodsSignatureMap_computed = false;
        node.localMethodsSignatureMap_value = null;
        node.fields_String_values = null;
        node.memberTypes_String_values = null;
        node.constructors_computed = false;
        node.constructors_value = null;
        node.fullName_computed = false;
        node.fullName_value = null;
        node.typeName_computed = false;
        node.typeName_value = null;
        node.genericDecl_computed = false;
        node.genericDecl_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ParInterfaceDecl node = (ParInterfaceDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ParInterfaceDecl res = (ParInterfaceDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.jrag at line 412

  public void collectErrors() {
    // Disable error check for ParInterfaceDecl which is an instanciated GenericInterfaceDecl
  }

    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 9

    public ParInterfaceDecl() {
        super();
        setChild(null, 0);
        setChild(null, 1);

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);
        setChild(new List(), 3);

    }

    // Declared in Generics.ast at line 16


    // Declared in Generics.ast line 9
    public ParInterfaceDecl(Modifiers p0, String p1, List p2) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(new List(), 2);
        setChild(new List(), 3);
    }

    // Declared in Generics.ast at line 24


  protected int numChildren() {
    return 2;
  }

    // Declared in Generics.ast at line 27

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 63
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
    // Declared in java.ast line 63
    private String tokenString_ID;

    // Declared in java.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in java.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 9
    public void setArgumentList(List list) {
        setChild(list, 1);
    }

    // Declared in Generics.ast at line 6


    public int getNumArgument() {
        return getArgumentList().getNumChild();
    }

    // Declared in Generics.ast at line 10


    public Access getArgument(int i) {
        return (Access)getArgumentList().getChild(i);
    }

    // Declared in Generics.ast at line 14


    public void addArgument(Access node) {
        List list = getArgumentList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Generics.ast at line 19


    public void setArgument(Access node, int i) {
        List list = getArgumentList();
        list.setChild(node, i);
    }

    // Declared in Generics.ast at line 23

    public List getArgumentList() {
        return (List)getChild(1);
    }

    // Declared in Generics.ast at line 27


    public List getArgumentListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 9
    public void setSuperInterfaceIdList(List list) {
        setChild(list, 2);
    }

    // Declared in Generics.ast at line 6


    public int getNumSuperInterfaceId() {
        return getSuperInterfaceIdList().getNumChild();
    }

    // Declared in Generics.ast at line 10


    public Access getSuperInterfaceId(int i) {
        return (Access)getSuperInterfaceIdList().getChild(i);
    }

    // Declared in Generics.ast at line 14


    public void addSuperInterfaceId(Access node) {
        List list = getSuperInterfaceIdList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Generics.ast at line 19


    public void setSuperInterfaceId(Access node, int i) {
        List list = getSuperInterfaceIdList();
        list.setChild(node, i);
    }

    // Declared in Generics.ast at line 23

    public List getSuperInterfaceIdListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in Generics.ast at line 27


    protected int getSuperInterfaceIdListChildPosition() {
        return 2;
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 9
    public void setBodyDeclList(List list) {
        setChild(list, 3);
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

    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(3);
    }

    // Declared in Generics.ast at line 27


    protected int getBodyDeclListChildPosition() {
        return 3;
    }

    // Declared in Generics.jrag at line 563

  public int numTypeParameter() {
    return ((GenericTypeDecl)genericDecl()).original().getNumTypeParameter(); 
  }

    // Declared in Generics.jrag at line 566

  public TypeVariable typeParameter(int index) {
    return ((GenericTypeDecl)genericDecl()).original().getTypeParameter(index);
  }

    // Declared in Generics.jrag at line 569

  public int numTypeArgument() {
    return getNumArgument();
  }

    // Declared in Generics.jrag at line 572

  public TypeDecl typeArgument(int index) {
    return getArgument(index).type();
  }

    // Declared in Generics.jrag at line 606

  public Access substitute(Parameterization parTypeDecl) {
    if(parTypeDecl.isRawType())
      return ((GenericTypeDecl)genericDecl()).rawType().createBoundAccess();
      //return erasure().createBoundAccess();
    if(!usesTypeVariable())
      return super.substitute(parTypeDecl);
    List list = new List();
    for(int i = 0; i < getNumArgument(); i++)
      list.add(getArgument(i).type().substitute(parTypeDecl));
    return new ParTypeAccess(genericDecl().createQualifiedAccess(), list);
  }

    // Declared in GenericsParTypeDecl.jrag at line 76

  
  public Access createQualifiedAccess() {
    List typeArgumentList = (List)getArgumentList().fullCopy();
    if(!isTopLevelType()) {
      return enclosingType().createQualifiedAccess().qualifiesAccess(
        new ParTypeAccess(new TypeAccess("", getID()), typeArgumentList)
      );
    }
    else {
      return new ParTypeAccess(new TypeAccess(packageName(), getID()), typeArgumentList);
    }
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

    private boolean involvesTypeParameters_compute()  {
    for(int i = 0; i < getNumArgument(); i++)
      if(getArgument(i).type().involvesTypeParameters())
        return true;
    return false;
  }

    // Declared in Generics.jrag at line 161
    public boolean isRawType() {
        boolean isRawType_value = isRawType_compute();
        return isRawType_value;
    }

    private boolean isRawType_compute() {  return  false;  }

    // Declared in Generics.jrag at line 219
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

    private TypeDecl erasure_compute() {  return  genericDecl();  }

    protected boolean getSuperInterfaceIdList_computed = false;
    protected List getSuperInterfaceIdList_value;
    // Declared in Generics.jrag at line 741
    public List getSuperInterfaceIdList() {
        if(getSuperInterfaceIdList_computed)
            return (List)ASTNode.getChild(this, getSuperInterfaceIdListChildPosition());
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        getSuperInterfaceIdList_value = getSuperInterfaceIdList_compute();
        setSuperInterfaceIdList(getSuperInterfaceIdList_value);
        if(isFinal && num == boundariesCrossed)
            getSuperInterfaceIdList_computed = true;
        return (List)ASTNode.getChild(this, getSuperInterfaceIdListChildPosition());
    }

    private List getSuperInterfaceIdList_compute()  {
    GenericInterfaceDecl decl = (GenericInterfaceDecl)genericDecl();
    //System.err.println("Begin substituting implements list");
    List list = decl.getSuperInterfaceIdList().substitute(this);
    //System.err.println("End substituting implements list");
    return list;
  }

    protected boolean getBodyDeclList_computed = false;
    protected List getBodyDeclList_value;
    // Declared in Generics.jrag at line 748
    public List getBodyDeclList() {
        if(getBodyDeclList_computed)
            return (List)ASTNode.getChild(this, getBodyDeclListChildPosition());
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        getBodyDeclList_value = getBodyDeclList_compute();
        setBodyDeclList(getBodyDeclList_value);
        if(isFinal && num == boundariesCrossed)
            getBodyDeclList_computed = true;
        return (List)ASTNode.getChild(this, getBodyDeclListChildPosition());
    }

    private List getBodyDeclList_compute() {  return  new List();  }

    // Declared in GenericsParTypeDecl.jrag at line 69
    public boolean isTypeVariable() {
        boolean isTypeVariable_value = isTypeVariable_compute();
        return isTypeVariable_value;
    }

    private boolean isTypeVariable_compute()  {
    for(int i = 0; i < getNumArgument(); i++)
      if(getArgument(i).type().isTypeVariable())
        return true;
    return false;
  }

    // Declared in GenericsSubtype.jrag at line 27
    public boolean supertypeGenericClassDecl(GenericClassDecl type) {
        boolean supertypeGenericClassDecl_GenericClassDecl_value = supertypeGenericClassDecl_compute(type);
        return supertypeGenericClassDecl_GenericClassDecl_value;
    }

    private boolean supertypeGenericClassDecl_compute(GenericClassDecl type) {  return 
    type.subtype(genericDecl());  }

    // Declared in GenericsSubtype.jrag at line 29
    public boolean supertypeGenericInterfaceDecl(GenericInterfaceDecl type) {
        boolean supertypeGenericInterfaceDecl_GenericInterfaceDecl_value = supertypeGenericInterfaceDecl_compute(type);
        return supertypeGenericInterfaceDecl_GenericInterfaceDecl_value;
    }

    private boolean supertypeGenericInterfaceDecl_compute(GenericInterfaceDecl type) {  return 
    type.subtype(genericDecl());  }

    // Declared in GenericsSubtype.jrag at line 98
    public boolean supertypeClassDecl(ClassDecl type) {
        boolean supertypeClassDecl_ClassDecl_value = supertypeClassDecl_compute(type);
        return supertypeClassDecl_ClassDecl_value;
    }

    private boolean supertypeClassDecl_compute(ClassDecl type) {  return 
    super.supertypeClassDecl(type);  }

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

    private boolean subtype_compute(TypeDecl type) {  return  type.supertypeParInterfaceDecl(this);  }

    // Declared in GenericsSubtype.jrag at line 127
    public boolean supertypeRawClassDecl(RawClassDecl type) {
        boolean supertypeRawClassDecl_RawClassDecl_value = supertypeRawClassDecl_compute(type);
        return supertypeRawClassDecl_RawClassDecl_value;
    }

    private boolean supertypeRawClassDecl_compute(RawClassDecl type) {  return 
    type.genericDecl().subtype(genericDecl());  }

    // Declared in GenericsSubtype.jrag at line 129
    public boolean supertypeRawInterfaceDecl(RawInterfaceDecl type) {
        boolean supertypeRawInterfaceDecl_RawInterfaceDecl_value = supertypeRawInterfaceDecl_compute(type);
        return supertypeRawInterfaceDecl_RawInterfaceDecl_value;
    }

    private boolean supertypeRawInterfaceDecl_compute(RawInterfaceDecl type) {  return 
    type.genericDecl().subtype(genericDecl());  }

    // Declared in GenericsSubtype.jrag at line 144
    public boolean supertypeParClassDecl(ParClassDecl type) {
        boolean supertypeParClassDecl_ParClassDecl_value = supertypeParClassDecl_compute(type);
        return supertypeParClassDecl_ParClassDecl_value;
    }

    private boolean supertypeParClassDecl_compute(ParClassDecl type)  {
    if(type.genericDecl().subtype(genericDecl()) &&
       type.getNumArgument() == getNumArgument()) {
      for(int i = 0; i < getNumArgument(); i++)
        if(!type.getArgument(i).type().subtype(getArgument(i).type()))
          return false;
      return true;
    }
    return supertypeClassDecl(type);
  }

    // Declared in GenericsSubtype.jrag at line 154
    public boolean supertypeParInterfaceDecl(ParInterfaceDecl type) {
        boolean supertypeParInterfaceDecl_ParInterfaceDecl_value = supertypeParInterfaceDecl_compute(type);
        return supertypeParInterfaceDecl_ParInterfaceDecl_value;
    }

    private boolean supertypeParInterfaceDecl_compute(ParInterfaceDecl type)  {
    if(type.genericDecl().subtype(genericDecl()) &&
       type.getNumArgument() == getNumArgument()) {
      for(int i = 0; i < getNumArgument(); i++)
        if(!type.getArgument(i).type().subtype(getArgument(i).type()))
          return false;
      return true;
    }
    return supertypeInterfaceDecl(type);
  }

    // Declared in GenericsSubtype.jrag at line 219
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

    // Declared in Generics.jrag at line 157
    public boolean isParameterizedType() {
        boolean isParameterizedType_value = isParameterizedType_compute();
        return isParameterizedType_value;
    }

    private boolean isParameterizedType_compute() {  return  true;  }

    // Declared in Generics.jrag at line 248
    public boolean sameArgument(ParTypeDecl decl) {
        boolean sameArgument_ParTypeDecl_value = sameArgument_compute(decl);
        return sameArgument_ParTypeDecl_value;
    }

    private boolean sameArgument_compute(ParTypeDecl decl)  {
    if(this == decl) return true;
    if(genericDecl() != decl.genericDecl())
      return false;
    for(int i = 0; i < getNumArgument(); i++) {
      TypeDecl t1 = getArgument(i).type();
      TypeDecl t2 = decl.getArgument(i).type();
      if(t1 instanceof ParTypeDecl && t2 instanceof ParTypeDecl) {
        if(!((ParTypeDecl)t1).sameArgument((ParTypeDecl)t2))
          return false;
      }
      else {
        if(t1 != t2)
          return false;
      }
    }
    return true;
  }

    // Declared in Generics.jrag at line 432
    public boolean sameSignature(Access a) {
        boolean sameSignature_Access_value = sameSignature_compute(a);
        return sameSignature_Access_value;
    }

    private boolean sameSignature_compute(Access a) {
    if(a instanceof ParTypeAccess) {
      ParTypeAccess ta = (ParTypeAccess)a;
      if(genericDecl() != ta.genericDecl())
        return false;
      if(getNumArgument() != ta.getNumTypeArgument())
        return false;
      for(int i = 0; i < getNumArgument(); i++)
        if(!getArgument(i).type().sameSignature(ta.getTypeArgument(i)))
          return false;
      return true;
    }
    else if(a instanceof TypeAccess && ((TypeAccess)a).isRaw())
      return false;
    return super.sameSignature(a);
  }

    protected java.util.Set sameSignature_ArrayList_visited;
    protected java.util.Set sameSignature_ArrayList_computed = new java.util.HashSet(4);
    protected java.util.Set sameSignature_ArrayList_initialized = new java.util.HashSet(4);
    protected java.util.Map sameSignature_ArrayList_values = new java.util.HashMap(4);
    public boolean sameSignature(ArrayList list) {
        Object _parameters = list;
if(sameSignature_ArrayList_visited == null) sameSignature_ArrayList_visited = new java.util.HashSet(4);
if(sameSignature_ArrayList_values == null) sameSignature_ArrayList_values = new java.util.HashMap(4);
        if(sameSignature_ArrayList_computed.contains(_parameters))
            return ((Boolean)sameSignature_ArrayList_values.get(_parameters)).booleanValue();
        if (!sameSignature_ArrayList_initialized.contains(_parameters)) {
            sameSignature_ArrayList_initialized.add(_parameters);
            sameSignature_ArrayList_values.put(_parameters, Boolean.valueOf(true));
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            sameSignature_ArrayList_visited.add(_parameters);
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            boolean new_sameSignature_ArrayList_value;
            do {
                CHANGE = false;
                new_sameSignature_ArrayList_value = sameSignature_compute(list);
                if (new_sameSignature_ArrayList_value!=((Boolean)sameSignature_ArrayList_values.get(_parameters)).booleanValue())
                    CHANGE = true;
                sameSignature_ArrayList_values.put(_parameters, Boolean.valueOf(new_sameSignature_ArrayList_value));
            } while (CHANGE);
            sameSignature_ArrayList_visited.remove(_parameters);
            if(isFinal && num == boundariesCrossed)
{
            sameSignature_ArrayList_computed.add(_parameters);
            }
            else {
            RESET_CYCLE = true;
            sameSignature_compute(list);
            RESET_CYCLE = false;
            sameSignature_ArrayList_computed.remove(_parameters);
            sameSignature_ArrayList_initialized.remove(_parameters);
            }
            IN_CIRCLE = false; 
            return new_sameSignature_ArrayList_value;
        }
        if(!sameSignature_ArrayList_visited.contains(_parameters)) {
            if (RESET_CYCLE) {
                sameSignature_ArrayList_computed.remove(_parameters);
                sameSignature_ArrayList_initialized.remove(_parameters);
                return ((Boolean)sameSignature_ArrayList_values.get(_parameters)).booleanValue();
            }
            sameSignature_ArrayList_visited.add(_parameters);
            boolean new_sameSignature_ArrayList_value = sameSignature_compute(list);
            if (new_sameSignature_ArrayList_value!=((Boolean)sameSignature_ArrayList_values.get(_parameters)).booleanValue())
                CHANGE = true;
            sameSignature_ArrayList_values.put(_parameters, Boolean.valueOf(new_sameSignature_ArrayList_value));
            sameSignature_ArrayList_visited.remove(_parameters);
            return new_sameSignature_ArrayList_value;
        }
        return ((Boolean)sameSignature_ArrayList_values.get(_parameters)).booleanValue();
    }

    private boolean sameSignature_compute(ArrayList list)  {
    if(getNumArgument() != list.size())
      return false;
    for(int i = 0; i < list.size(); i++)
      if(getArgument(i).type() != list.get(i))
        return false;
    return true;
  }

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

    private boolean usesTypeVariable_compute()  {
    for(int i = 0; i < getNumArgument(); i++)
      if(getArgument(i).type().usesTypeVariable())
        return true;
    return false;
  }

    // Declared in Generics.jrag at line 773
    public HashMap localMethodsSignatureMap() {
        if(localMethodsSignatureMap_computed)
            return localMethodsSignatureMap_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        localMethodsSignatureMap_value = localMethodsSignatureMap_compute();
        if(isFinal && num == boundariesCrossed)
            localMethodsSignatureMap_computed = true;
        return localMethodsSignatureMap_value;
    }

    private HashMap localMethodsSignatureMap_compute()  {
    HashMap map = new HashMap(getNumBodyDecl());
    for(Iterator iter = genericDecl().localMethodsIterator(); iter.hasNext(); ) {
      MethodDecl decl = (MethodDecl)iter.next();
      if(decl.usesTypeVariable()) {
        BodyDecl b = decl.p(this);
        b.is$Final = true;
        addBodyDecl(b);
        decl = (MethodDecl)b;
      }
      map.put(decl.signature(), decl);
    }
    return map;
  }

    protected java.util.Map fields_String_values;
    // Declared in Generics.jrag at line 788
    public SimpleSet fields(String name) {
        Object _parameters = name;
if(fields_String_values == null) fields_String_values = new java.util.HashMap(4);
        if(fields_String_values.containsKey(_parameters))
            return (SimpleSet)fields_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet fields_String_value = fields_compute(name);
        if(isFinal && num == boundariesCrossed)
            fields_String_values.put(_parameters, fields_String_value);
        return fields_String_value;
    }

    private SimpleSet fields_compute(String name)  {
    SimpleSet set = SimpleSet.emptySet;
    for(Iterator iter = genericDecl().fields(name).iterator(); iter.hasNext(); ) {
      FieldDeclaration f = (FieldDeclaration)iter.next();
      if(f.usesTypeVariable()) {
        BodyDecl b = f.p(this);
        b.is$Final = true;
        addBodyDecl(b);
        f = (FieldDeclaration)b;
      }
      set = set.add(f);
    }
    return set;
  }

    // Declared in Generics.jrag at line 803
    public SimpleSet memberTypes(String name) {
        Object _parameters = name;
if(memberTypes_String_values == null) memberTypes_String_values = new java.util.HashMap(4);
        if(memberTypes_String_values.containsKey(_parameters))
            return (SimpleSet)memberTypes_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet memberTypes_String_value = memberTypes_compute(name);
        if(isFinal && num == boundariesCrossed)
            memberTypes_String_values.put(_parameters, memberTypes_String_value);
        return memberTypes_String_value;
    }

    private SimpleSet memberTypes_compute(String name)  {
    SimpleSet set = SimpleSet.emptySet;
    for(Iterator iter = genericDecl().memberTypes(name).iterator(); iter.hasNext(); ) {
      TypeDecl t = (TypeDecl)iter.next();
      if(t.isStatic())
        set = set.add(t);
      else {
        BodyDecl b;
        TypeDecl typeDecl;
        if(t instanceof ClassDecl) {
          ClassDecl classDecl = (ClassDecl)t;
          typeDecl = classDecl.p(this);
          b = new MemberClassDecl((ClassDecl)typeDecl);
          b.is$Final = true;
          addBodyDecl(b);
          set = set.add(typeDecl);
        }
        else if(t instanceof InterfaceDecl) {
          InterfaceDecl interfaceDecl = (InterfaceDecl)t;
          typeDecl = interfaceDecl.p(this);
          b = new MemberInterfaceDecl((InterfaceDecl)typeDecl);
          b.is$Final = true;
          addBodyDecl(b);
          set = set.add(typeDecl);
        }
      }
    }
    return set;
  }

    // Declared in Generics.jrag at line 833
    public Collection constructors() {
        if(constructors_computed)
            return constructors_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        constructors_value = constructors_compute();
        if(isFinal && num == boundariesCrossed)
            constructors_computed = true;
        return constructors_value;
    }

    private Collection constructors_compute()  {
    Collection set = new ArrayList();
    for(Iterator iter = genericDecl().constructors().iterator(); iter.hasNext(); ) {
      ConstructorDecl c = (ConstructorDecl)iter.next();
      BodyDecl b = c.p(this);
      b.is$Final = true;
      addBodyDecl(b);
      set.add(b);
    }
    return set;
  }

    // Declared in GenericsParTypeDecl.jrag at line 3
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
    if(isNestedType())
      return enclosingType().fullName() + "." + nameWithArgs();
    String packageName = packageName();
    if(packageName.equals(""))
      return nameWithArgs();
    return packageName + "." + nameWithArgs();
  }

    // Declared in GenericsParTypeDecl.jrag at line 12
    public String typeName() {
        if(typeName_computed)
            return typeName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeName_value = typeName_compute();
        if(isFinal && num == boundariesCrossed)
            typeName_computed = true;
        return typeName_value;
    }

    private String typeName_compute()  {
    if(isNestedType())
      return enclosingType().typeName() + "." + nameWithArgs();
    String packageName = packageName();
    if(packageName.equals("") || packageName.equals(PRIMITIVE_PACKAGE_NAME))
      return nameWithArgs();
    return packageName + "." + nameWithArgs();
  }

    // Declared in GenericsParTypeDecl.jrag at line 21
    public String nameWithArgs() {
        String nameWithArgs_value = nameWithArgs_compute();
        return nameWithArgs_value;
    }

    private String nameWithArgs_compute()  {
    StringBuffer s = new StringBuffer();
    s.append(name());
    s.append("<");
    for(int i = 0; i < getNumArgument(); i++) {
      if(i != 0)
        s.append(", ");
      s.append(getArgument(i).type().fullName());
    }
    s.append(">");
    return s.toString();
  }

    protected boolean genericDecl_computed = false;
    protected TypeDecl genericDecl_value;
    // Declared in GenericsParTypeDecl.jrag at line 36
    public TypeDecl genericDecl() {
        if(genericDecl_computed)
            return genericDecl_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        genericDecl_value = getParent().Define_TypeDecl_genericDecl(this, null);
        if(isFinal && num == boundariesCrossed)
            genericDecl_computed = true;
        return genericDecl_value;
    }

    // Declared in GenericsParTypeDecl.jrag at line 47
    public TypeDecl Define_TypeDecl_genericDecl(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    if(getBodyDecl(index) instanceof MemberTypeDecl) {
      MemberTypeDecl m = (MemberTypeDecl)getBodyDecl(index);
      return extractSingleType(genericDecl().memberTypes(m.typeDecl().name()));
    }
    return genericDecl();
  }
}
        return getParent().Define_TypeDecl_genericDecl(this, caller);
    }

    // Declared in Generics.jrag at line 333
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getArgumentListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.TYPE_NAME;
        }
        return super.Define_NameType_nameType(caller, child);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
