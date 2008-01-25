
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class GenericInterfaceDecl extends InterfaceDecl implements Cloneable,  GenericTypeDecl {
    public void flushCache() {
        super.flushCache();
        rawType_computed = false;
        rawType_value = null;
        lookupParTypeDecl_ParTypeAccess_values = null;
        lookupParTypeDecl_ArrayList_values = null;
        instanceOf_TypeDecl_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        GenericInterfaceDecl node = (GenericInterfaceDecl)super.clone();
        node.rawType_computed = false;
        node.rawType_value = null;
        node.lookupParTypeDecl_ParTypeAccess_values = null;
        node.lookupParTypeDecl_ArrayList_values = null;
        node.instanceOf_TypeDecl_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          GenericInterfaceDecl node = (GenericInterfaceDecl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        GenericInterfaceDecl res = (GenericInterfaceDecl)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.jrag at line 298

  public void typeCheck() {
    super.typeCheck();
    if(instanceOf(typeThrowable()))
      error(" generic interface " + typeName() + " may not directly or indirectly inherit java.lang.Throwable");
  }

    // Declared in Generics.jrag at line 949

  public InterfaceDecl p(ParTypeDecl parTypeDecl) {
    GenericInterfaceDecl c = new GenericInterfaceDecl(
      (Modifiers)getModifiers().fullCopy(),
      getID(),
      getSuperInterfaceIdList().substitute(parTypeDecl),
      new List(),
      new List(), // delegates TypeParameter lookup to original
      new List()
    );
    c.original = this;
    return c;
  }

    // Declared in GenericsPrettyPrint.jrag at line 112

  
	public void toString(StringBuffer s) {
		getModifiers().toString(s);
		s.append("interface " + getID());
		s.append('<');
    	if (getNumTypeParameter() > 0) {
    		getTypeParameter(0).toString(s);
    		for (int i = 1; i < getNumTypeParameter(); i++) {
    			s.append(", ");
    			getTypeParameter(i).toString(s);
    		}
    	}
    	s.append('>');
		if(getNumSuperInterfaceId() > 0) {
			s.append(" extends ");
			getSuperInterfaceId(0).toString(s);
      for(int i = 1; i < getNumSuperInterfaceId(); i++) {
        s.append(", ");
			  getSuperInterfaceId(i).toString(s);
      }
    }

    s.append(" instantiated with: ");
    for(int i = 0; i < getNumParTypeDecl(); i++) {
      if(i != 0) s.append(", ");
      ParTypeDecl decl = getParTypeDecl(i);
      s.append("<");
      for(int j = 0; j < decl.getNumArgument(); j++) {
        if(j != 0) s.append(", ");
        s.append(decl.getArgument(j).type().fullName());
      }
      s.append(">");
    }
    
		s.append(" {\n");
		indent++;
		for(int i=0; i < getNumBodyDecl(); i++) {
			getBodyDecl(i).toString(s);
		}
		indent--;
		s.append(indent() + "}\n");
    
    for(int i = 0; i < getNumParTypeDecl(); i++) {
      ParInterfaceDecl decl = getParTypeDecl(i);
      decl.toString(s);
    }
	}

    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 3

    public GenericInterfaceDecl() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);
        setChild(new List(), 3);
        setChild(new List(), 4);

    }

    // Declared in Generics.ast at line 15


    // Declared in Generics.ast line 3
    public GenericInterfaceDecl(Modifiers p0, String p1, List p2, List p3, List p4, List p5) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
        setChild(p5, 4);
    }

    // Declared in Generics.ast at line 24


  protected int numChildren() {
    return 5;
  }

    // Declared in Generics.ast at line 27

  public boolean mayHaveRewrite() { return false; }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 3
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
    // Declared in Generics.ast line 3
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
    // Declared in Generics.ast line 3
    public void setSuperInterfaceIdList(List list) {
        setChild(list, 1);
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

    public List getSuperInterfaceIdList() {
        return (List)getChild(1);
    }

    // Declared in Generics.ast at line 27


    public List getSuperInterfaceIdListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 3
    public void setBodyDeclList(List list) {
        setChild(list, 2);
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
        return (List)getChild(2);
    }

    // Declared in Generics.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 3
    public void setTypeParameterList(List list) {
        setChild(list, 3);
    }

    // Declared in Generics.ast at line 6


    public int getNumTypeParameter() {
        return getTypeParameterList().getNumChild();
    }

    // Declared in Generics.ast at line 10


    public TypeVariable getTypeParameter(int i) {
        return (TypeVariable)getTypeParameterList().getChild(i);
    }

    // Declared in Generics.ast at line 14


    public void addTypeParameter(TypeVariable node) {
        List list = getTypeParameterList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Generics.ast at line 19


    public void setTypeParameter(TypeVariable node, int i) {
        List list = getTypeParameterList();
        list.setChild(node, i);
    }

    // Declared in Generics.ast at line 23

    public List getTypeParameterList() {
        return (List)getChild(3);
    }

    // Declared in Generics.ast at line 27


    public List getTypeParameterListNoTransform() {
        return (List)getChildNoTransform(3);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 3
    public void setParTypeDeclList(List list) {
        setChild(list, 4);
    }

    // Declared in Generics.ast at line 6


    public int getNumParTypeDecl() {
        return getParTypeDeclList().getNumChild();
    }

    // Declared in Generics.ast at line 10


    public ParInterfaceDecl getParTypeDecl(int i) {
        return (ParInterfaceDecl)getParTypeDeclList().getChild(i);
    }

    // Declared in Generics.ast at line 14


    public void addParTypeDecl(ParInterfaceDecl node) {
        List list = getParTypeDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Generics.ast at line 19


    public void setParTypeDecl(ParInterfaceDecl node, int i) {
        List list = getParTypeDeclList();
        list.setChild(node, i);
    }

    // Declared in Generics.ast at line 23

    public List getParTypeDeclList() {
        return (List)getChild(4);
    }

    // Declared in Generics.ast at line 27


    public List getParTypeDeclListNoTransform() {
        return (List)getChildNoTransform(4);
    }

    // Declared in Generics.jrag at line 140

  public TypeDecl makeGeneric(Signatures.ClassSignature s) {
    return (TypeDecl)this;
  }

    // Declared in Generics.jrag at line 345


  public SimpleSet addTypeVariables(SimpleSet c, String name) {
    for(int i = 0; i < original().getNumTypeParameter(); i++) {
      TypeVariable p = original().getTypeParameter(i);
      if(p.name().equals(name))
        c = c.add(p);
    }
    return c;
  }

    // Declared in Generics.jrag at line 543

  public List createArgumentList(ArrayList params) {
    List list = new List();
    if(params.isEmpty())
      for(int i = 0; i < original().getNumTypeParameter(); i++)
        list.add(original().getTypeParameter(i).erasure().createBoundAccess());
    else
      for(Iterator iter = params.iterator(); iter.hasNext(); )
        list.add(((TypeDecl)iter.next()).createBoundAccess());
    return list;
  }

    protected boolean rawType_computed = false;
    protected TypeDecl rawType_value;
    // Declared in Generics.jrag at line 80
    public TypeDecl rawType() {
        if(rawType_computed)
            return rawType_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        rawType_value = rawType_compute();
        if(isFinal && num == boundariesCrossed)
            rawType_computed = true;
        return rawType_value;
    }

    private TypeDecl rawType_compute() {  return  lookupParTypeDecl(new ArrayList());  }

    protected java.util.Map lookupParTypeDecl_ParTypeAccess_values;
    // Declared in Generics.jrag at line 495
    public TypeDecl lookupParTypeDecl(ParTypeAccess p) {
        Object _parameters = p;
if(lookupParTypeDecl_ParTypeAccess_values == null) lookupParTypeDecl_ParTypeAccess_values = new java.util.HashMap(4);
        if(lookupParTypeDecl_ParTypeAccess_values.containsKey(_parameters))
            return (TypeDecl)lookupParTypeDecl_ParTypeAccess_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        TypeDecl lookupParTypeDecl_ParTypeAccess_value = lookupParTypeDecl_compute(p);
        if(isFinal && num == boundariesCrossed)
            lookupParTypeDecl_ParTypeAccess_values.put(_parameters, lookupParTypeDecl_ParTypeAccess_value);
        return lookupParTypeDecl_ParTypeAccess_value;
    }

    private TypeDecl lookupParTypeDecl_compute(ParTypeAccess p)  {
    for(int i = 0; i < getNumParTypeDecl(); i++) {
      ParTypeDecl decl = (ParTypeDecl)getParTypeDecl(i);
      if(decl.sameSignature(p))
        return (TypeDecl)decl;
    }
    ParInterfaceDecl typeDecl = new ParInterfaceDecl();
    typeDecl.setModifiers((Modifiers)getModifiers().fullCopy());
    typeDecl.setID(getID());
    addParTypeDecl(typeDecl);
    List list = new List();
    for(int i = 0; i < p.getNumTypeArgument(); i++)
      list.add(p.getTypeArgument(i).type().createBoundAccess());
    typeDecl.setArgumentList(list);
    typeDecl.is$Final = true;
    return typeDecl;
  }

    protected java.util.Map lookupParTypeDecl_ArrayList_values;
    // Declared in Generics.jrag at line 529
    public TypeDecl lookupParTypeDecl(ArrayList list) {
        Object _parameters = list;
if(lookupParTypeDecl_ArrayList_values == null) lookupParTypeDecl_ArrayList_values = new java.util.HashMap(4);
        if(lookupParTypeDecl_ArrayList_values.containsKey(_parameters))
            return (TypeDecl)lookupParTypeDecl_ArrayList_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        TypeDecl lookupParTypeDecl_ArrayList_value = lookupParTypeDecl_compute(list);
        if(true)
            lookupParTypeDecl_ArrayList_values.put(_parameters, lookupParTypeDecl_ArrayList_value);
        return lookupParTypeDecl_ArrayList_value;
    }

    private TypeDecl lookupParTypeDecl_compute(ArrayList list)  {
    for(int i = 0; i < getNumParTypeDecl(); i++) {
      ParTypeDecl decl = (ParTypeDecl)getParTypeDecl(i);
      if(decl.isRawType() ? list.isEmpty() : decl.sameSignature(list))
        return (TypeDecl)decl;
    }
    ParInterfaceDecl typeDecl = list.size() == 0 ? new RawInterfaceDecl() : new ParInterfaceDecl();
    typeDecl.setModifiers((Modifiers)getModifiers().fullCopy());
    typeDecl.setID(getID());
    typeDecl.setArgumentList(createArgumentList(list));
    typeDecl.is$Final = true;
    addParTypeDecl(typeDecl);
    return typeDecl;
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

    private boolean subtype_compute(TypeDecl type) {  return  type.supertypeGenericInterfaceDecl(this);  }

    // Declared in GenericsSubtype.jrag at line 169
    public boolean supertypeParClassDecl(ParClassDecl type) {
        boolean supertypeParClassDecl_ParClassDecl_value = supertypeParClassDecl_compute(type);
        return supertypeParClassDecl_ParClassDecl_value;
    }

    private boolean supertypeParClassDecl_compute(ParClassDecl type) {  return 
    type.genericDecl().subtype(this);  }

    // Declared in GenericsSubtype.jrag at line 171
    public boolean supertypeParInterfaceDecl(ParInterfaceDecl type) {
        boolean supertypeParInterfaceDecl_ParInterfaceDecl_value = supertypeParInterfaceDecl_compute(type);
        return supertypeParInterfaceDecl_ParInterfaceDecl_value;
    }

    private boolean supertypeParInterfaceDecl_compute(ParInterfaceDecl type) {  return 
    type.genericDecl().subtype(this);  }

    // Declared in GenericsSubtype.jrag at line 216
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

    // Declared in Generics.jrag at line 83
    public boolean isGenericType() {
        boolean isGenericType_value = isGenericType_compute();
        return isGenericType_value;
    }

    private boolean isGenericType_compute() {  return  true;  }

    // Declared in Generics.jrag at line 912
    public GenericTypeDecl original() {
        GenericTypeDecl original_value = original_compute();
        return original_value;
    }

    private GenericTypeDecl original_compute() {  return  original != null ? (GenericTypeDecl)original : this;  }

    // Declared in Generics.jrag at line 304
    public TypeDecl typeThrowable() {
        TypeDecl typeThrowable_value = getParent().Define_TypeDecl_typeThrowable(this, null);
        return typeThrowable_value;
    }

    // Declared in GenericsParTypeDecl.jrag at line 39
    public TypeDecl Define_TypeDecl_genericDecl(ASTNode caller, ASTNode child) {
        if(caller == getParTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  this;
        }
        return getParent().Define_TypeDecl_genericDecl(this, caller);
    }

    // Declared in Generics.jrag at line 343
    public TypeDecl Define_TypeDecl_enclosingType(ASTNode caller, ASTNode child) {
        if(caller == getTypeParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  this;
        }
        return super.Define_TypeDecl_enclosingType(caller, child);
    }

    // Declared in Generics.jrag at line 342
    public boolean Define_boolean_isNestedType(ASTNode caller, ASTNode child) {
        if(caller == getTypeParameterListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  true;
        }
        return super.Define_boolean_isNestedType(caller, child);
    }

    // Declared in Generics.jrag at line 386
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(caller == getBodyDeclListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    SimpleSet c = memberTypes(name);
    if(getBodyDecl(index).visibleTypeParameters())
      c = addTypeVariables(c, name);
    if(!c.isEmpty())
      return c;
    // 8.5.2
    if(isClassDecl() && isStatic() && !isTopLevelType()) {
      for(Iterator iter = lookupType(name).iterator(); iter.hasNext(); ) {
        TypeDecl d = (TypeDecl)iter.next();
        if(d.isStatic() || (d.enclosingType() != null && instanceOf(d.enclosingType()))) {
          c = c.add(d);
        }
      }
    }
    else
      c = lookupType(name);
    if(!c.isEmpty())
      return c;
    return topLevelType().lookupType(name); // Fix to search imports
    // include type parameters if not static
  }
}
        if(caller == getTypeParameterListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    SimpleSet c = memberTypes(name);
    c = addTypeVariables(c, name);
    if(!c.isEmpty()) return c;
    // 8.5.2
    if(isClassDecl() && isStatic() && !isTopLevelType()) {
      for(Iterator iter = lookupType(name).iterator(); iter.hasNext(); ) {
        TypeDecl d = (TypeDecl)iter.next();
        if(d.isStatic() || (d.enclosingType() != null && instanceOf(d.enclosingType()))) {
          c = c.add(d);
        }
      }
    }
    else
      c = lookupType(name);
    if(!c.isEmpty())
      return c;
    return topLevelType().lookupType(name); // Fix to search imports
  }
}
        if(caller == getSuperInterfaceIdListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    SimpleSet c = addTypeVariables(SimpleSet.emptySet, name);
    return !c.isEmpty() ? c : lookupType(name);
  }
}
        return super.Define_SimpleSet_lookupType(caller, child, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
