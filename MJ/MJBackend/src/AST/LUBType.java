
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class LUBType extends ReferenceType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        lub_computed = false;
        lub_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        LUBType node = (LUBType)super.clone();
        node.lub_computed = false;
        node.lub_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          LUBType node = (LUBType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        LUBType res = (LUBType)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in GenericMethodsInference.jrag at line 630


    private HashSet EC(ArrayList list) {
      HashSet result = new HashSet();
      boolean first = true;
      for(Iterator iter = list.iterator(); iter.hasNext(); ) {
        TypeDecl U = (TypeDecl)iter.next();
        HashSet EST = EST(U);
        if(first) {
          result.addAll(EST);
          first = false;
        }
        else
          result.retainAll(EST);
      }
      return result;
    }

    // Declared in GenericMethodsInference.jrag at line 646


    private HashSet MEC(ArrayList list) {
      HashSet EC = EC(list);
      if(EC.size() == 1)
        return EC;
      HashSet MEC = new HashSet();
      for(Iterator iter = EC.iterator(); iter.hasNext(); ) {
        TypeDecl V = (TypeDecl)iter.next();
        boolean keep = true;
        for(Iterator i2 = EC.iterator(); i2.hasNext(); ) {
          TypeDecl W = (TypeDecl)i2.next();
          if(V != W && W.instanceOf(V))
            keep = false;
        }
        if(keep)
          MEC.add(V);
      }
      return MEC;
    }

    // Declared in GenericMethodsInference.jrag at line 665


    private HashSet Inv(TypeDecl G, ArrayList Us) {
      HashSet result = new HashSet();
      for(Iterator iter = Us.iterator(); iter.hasNext(); ) {
        TypeDecl U = (TypeDecl)iter.next();
        for(Iterator i2 = ST(U).iterator(); i2.hasNext(); ) {
          TypeDecl V = (TypeDecl)i2.next();
          if(V instanceof ParTypeDecl && !V.isRawType() && ((ParTypeDecl)V).genericDecl() == G)
            result.add(V);
        }
      }
      return result;
    }

    // Declared in GenericMethodsInference.jrag at line 678


    private TypeDecl lci(HashSet set, TypeDecl G) {
      ArrayList list = new ArrayList();
      boolean first = true;
      for(Iterator iter = set.iterator(); iter.hasNext(); ) {
        ParTypeDecl decl = (ParTypeDecl)iter.next();
        if(first) {
          first = false;
          for(int i = 0; i < decl.getNumArgument(); i++)
            list.add(decl.getArgument(i).type());
        }
        else {
          for(int i = 0; i < decl.getNumArgument(); i++)
            list.set(i, lcta((TypeDecl)list.get(i), decl.getArgument(i).type()));
        }
      }
      return ((GenericTypeDecl)G).lookupParTypeDecl(list);
    }

    // Declared in GenericMethodsInference.jrag at line 696


    private TypeDecl lcta(TypeDecl X, TypeDecl Y) {
      System.err.println("Computing lcta for " + X.typeName() + " and " + Y.typeName());
      if(!X.isWildcard() && !Y.isWildcard()) {
        TypeDecl U = X;
        TypeDecl V = Y;
        return U == V ? U : lub(U, V).asWildcardExtends();
      }
      else if(!X.isWildcard() && Y instanceof WildcardExtendsType) {
        TypeDecl U = X;
        TypeDecl V = ((WildcardExtendsType)Y).getAccess().type();
        return lub(U, V).asWildcardExtends();
      }
      else if(!X.isWildcard() && Y instanceof WildcardSuperType) {
        TypeDecl U = X;
        TypeDecl V = ((WildcardSuperType)Y).getAccess().type();
        return glb(U, V).asWildcardSuper();
      }
      else if(X instanceof WildcardExtendsType && Y instanceof WildcardExtendsType) {
        TypeDecl U = ((WildcardExtendsType)X).getAccess().type();
        TypeDecl V = ((WildcardExtendsType)Y).getAccess().type();
        return lub(U, V).asWildcardExtends();
      }
      else if(X instanceof WildcardExtendsType && Y instanceof WildcardSuperType) {
        TypeDecl U = ((WildcardExtendsType)X).getAccess().type();
        TypeDecl V = ((WildcardSuperType)Y).getAccess().type();
        return U == V ? U : U.typeWildcard();
      }
      else if(X instanceof WildcardSuperType && Y instanceof WildcardSuperType) {
        TypeDecl U = ((WildcardSuperType)X).getAccess().type();
        TypeDecl V = ((WildcardSuperType)Y).getAccess().type();
        return glb(U, V).asWildcardSuper();
      }
      else
        throw new Error("lcta not defined for (" + X.getClass().getName() + ", " + Y.getClass().getName());
    }

    // Declared in GenericMethodsInference.jrag at line 732


    private TypeDecl lub(TypeDecl X, TypeDecl Y) {
      ArrayList list = new ArrayList(2);
      list.add(X);
      list.add(Y);
      return lub(list);
    }

    // Declared in GenericMethodsInference.jrag at line 739


    private TypeDecl lub(ArrayList list) {
      return lookupLUBType(list);
    }

    // Declared in GenericMethodsInference.jrag at line 743


    private TypeDecl glb(TypeDecl X, TypeDecl Y) {
      return null;
    }

    // Declared in GenericMethodsInference.jrag at line 747


    private HashSet EST(TypeDecl t) {
      HashSet result = new HashSet();
      for(Iterator iter = ST(t).iterator(); iter.hasNext(); ) {
        TypeDecl typeDecl = (TypeDecl)iter.next();
        result.add(typeDecl.erasure());
      }
      return result;
    }

    // Declared in GenericMethodsInference.jrag at line 756


    private HashSet ST(TypeDecl t) {
      HashSet result = new HashSet();
      addSupertypes(result, t);
      return result;
    }

    // Declared in GenericMethodsInference.jrag at line 762


    private void addSupertypes(HashSet set, TypeDecl t) {
      set.add(t);
      if(t instanceof ClassDecl) {
        ClassDecl type = (ClassDecl)t;
        if(type.hasSuperclass()) {
          addSupertypes(set, type.superclass());
        }
        for(int i = 0; i < type.getNumImplements(); i++) {
          addSupertypes(set, type.getImplements(i).type());
        }
      }
      else if(t instanceof InterfaceDecl) {
        InterfaceDecl type = (InterfaceDecl)t;
        for(int i = 0; i < type.getNumSuperInterfaceId(); i++) {
          addSupertypes(set, type.getSuperInterfaceId(i).type());
        }
        if(type.getNumSuperInterfaceId() == 0)
          set.add(type.typeObject());
      }
      else if(t instanceof TypeVariable) {
        TypeVariable type = (TypeVariable)t;
        for(int i = 0; i < type.getNumTypeBound(); i++) {
          addSupertypes(set, type.getTypeBound(i).type());
        }
        if(type.getNumTypeBound() == 0)
          set.add(type.typeObject());
      }
      else if(t instanceof LUBType) {
        LUBType type = (LUBType)t;
        for(int i = 0; i < type.getNumTypeBound(); i++) {
          addSupertypes(set, type.getTypeBound(i).type());
        }
        if(type.getNumTypeBound() == 0)
          set.add(type.typeObject());
      }
      else
        throw new Error("Operation not supported for " + t.fullName() + ", " + t.getClass().getName());
    }

    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 34

    public LUBType() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);
        setChild(new List(), 2);

    }

    // Declared in Generics.ast at line 13


    // Declared in Generics.ast line 34
    public LUBType(Modifiers p0, String p1, List p2, List p3) {
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

  public boolean mayHaveRewrite() { return false; }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 34
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
    // Declared in Generics.ast line 34
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
    // Declared in Generics.ast line 34
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
    // Declared in Generics.ast line 34
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

    protected boolean lub_computed = false;
    protected TypeDecl lub_value;
    // Declared in GenericMethodsInference.jrag at line 615
    public TypeDecl lub() {
        if(lub_computed)
            return lub_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        lub_value = lub_compute();
        if(isFinal && num == boundariesCrossed)
            lub_computed = true;
        return lub_value;
    }

    private TypeDecl lub_compute()  {
    ArrayList list = new ArrayList();
    for(int i = 0; i < getNumTypeBound(); i++)
      list.add(getTypeBound(i).type());
    ArrayList bounds = new ArrayList();
    for(Iterator iter = MEC(list).iterator(); iter.hasNext(); ) {
      TypeDecl W = (TypeDecl)iter.next();
      TypeDecl C = W instanceof GenericTypeDecl ? lci(Inv(W, list), W) : W;
      bounds.add(C);
    }
    if(bounds.size() == 1)
      return (TypeDecl)bounds.iterator().next();
    return lookupLUBType(bounds);
  }

    // Declared in Generics.jrag at line 1037
    public boolean supertypeClassDecl(ClassDecl type) {
        boolean supertypeClassDecl_ClassDecl_value = supertypeClassDecl_compute(type);
        return supertypeClassDecl_ClassDecl_value;
    }

    private boolean supertypeClassDecl_compute(ClassDecl type) {  return  type.subtype(lub());  }

    // Declared in Generics.jrag at line 1038
    public boolean supertypeInterfaceDecl(InterfaceDecl type) {
        boolean supertypeInterfaceDecl_InterfaceDecl_value = supertypeInterfaceDecl_compute(type);
        return supertypeInterfaceDecl_InterfaceDecl_value;
    }

    private boolean supertypeInterfaceDecl_compute(InterfaceDecl type) {  return  type.subtype(lub());  }

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

    private boolean subtype_compute(TypeDecl type)  {
    for(int i = 0; i < getNumTypeBound(); i++)
      if(!getTypeBound(i).type().instanceOf(type))
        return false;
    return true;
  }

    // Declared in Generics.jrag at line 1046
    public String typeName() {
        String typeName_value = typeName_compute();
        return typeName_value;
    }

    private String typeName_compute()  {
    if(getNumTypeBound() == 0)
      return "<NOTYPE>";
    StringBuffer s = new StringBuffer();
    s.append(getTypeBound(0).type().typeName());
    for(int i = 1; i < getNumTypeBound(); i++)
      s.append(" & " + getTypeBound(i).type().typeName());
    return s.toString();
  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
