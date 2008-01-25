
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

 
public abstract class TypeDecl extends ASTNode implements Cloneable,  SimpleSet,  Iterator,  VariableScope {
    public void flushCache() {
        super.flushCache();
        accessibleFromPackage_String_values = null;
        accessibleFromExtend_TypeDecl_values = null;
        accessibleFrom_TypeDecl_values = null;
        dimension_computed = false;
        elementType_computed = false;
        elementType_value = null;
        arrayType_computed = false;
        arrayType_value = null;
        isException_computed = false;
        isCheckedException_computed = false;
        isUncheckedException_computed = false;
        mayCatch_TypeDecl_values = null;
        constructors_computed = false;
        constructors_value = null;
        unqualifiedLookupMethod_String_values = null;
        methodsNameMap_computed = false;
        methodsNameMap_value = null;
        localMethodsSignatureMap_computed = false;
        localMethodsSignatureMap_value = null;
        methodsSignatureMap_computed = false;
        methodsSignatureMap_value = null;
        ancestorMethods_String_values = null;
        memberTypes_String_values = null;
        memberFields_String_values = null;
        localFieldsMap_computed = false;
        localFieldsMap_value = null;
        hasAbstract_computed = false;
        unimplementedMethods_computed = false;
        unimplementedMethods_value = null;
        isPublic_computed = false;
        isStatic_computed = false;
        fullName_computed = false;
        fullName_value = null;
        typeName_computed = false;
        typeName_value = null;
        narrowingConversionTo_TypeDecl_values = null;
        methodInvocationConversionTo_TypeDecl_values = null;
        castingConversionTo_TypeDecl_values = null;
        isString_computed = false;
        isObject_computed = false;
        instanceOf_TypeDecl_values = null;
        isCircular_computed = false;
        innerClassesAttributeEntries_computed = false;
        innerClassesAttributeEntries_value = null;
        attributes_computed = false;
        attributes_value = null;
        clinit_attributes_computed = false;
        clinit_attributes_value = null;
        constantPool_computed = false;
        constantPool_value = null;
        typeDescriptor_computed = false;
        typeDescriptor_value = null;
        hasClinit_computed = false;
        bytecodes_ConstantPool_values = null;
        flags_computed = false;
        bcFields_computed = false;
        bcFields_value = null;
        constantPoolName_computed = false;
        constantPoolName_value = null;
        enclosingVariables_computed = false;
        enclosingVariables_value = null;
        boxed_computed = false;
        boxed_value = null;
        unboxed_computed = false;
        unboxed_value = null;
        isIterable_computed = false;
        erasure_computed = false;
        erasure_value = null;
        implementedInterfaces_computed = false;
        implementedInterfaces_value = null;
        usesTypeVariable_computed = false;
        createEnumMethod_TypeDecl_values = null;
        createEnumIndex_EnumConstant_values = null;
        createEnumArray_TypeDecl_values = null;
        needsSignatureAttribute_computed = false;
        classSignature_computed = false;
        classSignature_value = null;
        fieldTypeSignature_computed = false;
        fieldTypeSignature_value = null;
        classTypeSignature_computed = false;
        classTypeSignature_value = null;
        componentType_computed = false;
        componentType_value = null;
        isDAbefore_Variable_values = null;
        isDUbefore_Variable_values = null;
        typeException_computed = false;
        typeException_value = null;
        typeRuntimeException_computed = false;
        typeRuntimeException_value = null;
        typeError_computed = false;
        typeError_value = null;
        lookupMethod_String_values = null;
        typeObject_computed = false;
        typeObject_value = null;
        lookupType_String_values = null;
        lookupVariable_String_values = null;
        packageName_computed = false;
        packageName_value = null;
        isAnonymous_computed = false;
        unknownType_computed = false;
        unknownType_value = null;
        inExplicitConstructorInvocation_computed = false;
        inStaticContext_computed = false;
        destinationPath_computed = false;
        destinationPath_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        TypeDecl node = (TypeDecl)super.clone();
        node.accessibleFromPackage_String_values = null;
        node.accessibleFromExtend_TypeDecl_values = null;
        node.accessibleFrom_TypeDecl_values = null;
        node.dimension_computed = false;
        node.elementType_computed = false;
        node.elementType_value = null;
        node.arrayType_computed = false;
        node.arrayType_value = null;
        node.isException_computed = false;
        node.isCheckedException_computed = false;
        node.isUncheckedException_computed = false;
        node.mayCatch_TypeDecl_values = null;
        node.constructors_computed = false;
        node.constructors_value = null;
        node.unqualifiedLookupMethod_String_values = null;
        node.methodsNameMap_computed = false;
        node.methodsNameMap_value = null;
        node.localMethodsSignatureMap_computed = false;
        node.localMethodsSignatureMap_value = null;
        node.methodsSignatureMap_computed = false;
        node.methodsSignatureMap_value = null;
        node.ancestorMethods_String_values = null;
        node.memberTypes_String_values = null;
        node.memberFields_String_values = null;
        node.localFieldsMap_computed = false;
        node.localFieldsMap_value = null;
        node.hasAbstract_computed = false;
        node.unimplementedMethods_computed = false;
        node.unimplementedMethods_value = null;
        node.isPublic_computed = false;
        node.isStatic_computed = false;
        node.fullName_computed = false;
        node.fullName_value = null;
        node.typeName_computed = false;
        node.typeName_value = null;
        node.narrowingConversionTo_TypeDecl_values = null;
        node.methodInvocationConversionTo_TypeDecl_values = null;
        node.castingConversionTo_TypeDecl_values = null;
        node.isString_computed = false;
        node.isObject_computed = false;
        node.instanceOf_TypeDecl_values = null;
        node.isCircular_computed = false;
        node.innerClassesAttributeEntries_computed = false;
        node.innerClassesAttributeEntries_value = null;
        node.attributes_computed = false;
        node.attributes_value = null;
        node.clinit_attributes_computed = false;
        node.clinit_attributes_value = null;
        node.constantPool_computed = false;
        node.constantPool_value = null;
        node.typeDescriptor_computed = false;
        node.typeDescriptor_value = null;
        node.hasClinit_computed = false;
        node.bytecodes_ConstantPool_values = null;
        node.flags_computed = false;
        node.bcFields_computed = false;
        node.bcFields_value = null;
        node.constantPoolName_computed = false;
        node.constantPoolName_value = null;
        node.enclosingVariables_computed = false;
        node.enclosingVariables_value = null;
        node.boxed_computed = false;
        node.boxed_value = null;
        node.unboxed_computed = false;
        node.unboxed_value = null;
        node.isIterable_computed = false;
        node.erasure_computed = false;
        node.erasure_value = null;
        node.implementedInterfaces_computed = false;
        node.implementedInterfaces_value = null;
        node.usesTypeVariable_computed = false;
        node.createEnumMethod_TypeDecl_values = null;
        node.createEnumIndex_EnumConstant_values = null;
        node.createEnumArray_TypeDecl_values = null;
        node.needsSignatureAttribute_computed = false;
        node.classSignature_computed = false;
        node.classSignature_value = null;
        node.fieldTypeSignature_computed = false;
        node.fieldTypeSignature_value = null;
        node.classTypeSignature_computed = false;
        node.classTypeSignature_value = null;
        node.componentType_computed = false;
        node.componentType_value = null;
        node.isDAbefore_Variable_values = null;
        node.isDUbefore_Variable_values = null;
        node.typeException_computed = false;
        node.typeException_value = null;
        node.typeRuntimeException_computed = false;
        node.typeRuntimeException_value = null;
        node.typeError_computed = false;
        node.typeError_value = null;
        node.lookupMethod_String_values = null;
        node.typeObject_computed = false;
        node.typeObject_value = null;
        node.lookupType_String_values = null;
        node.lookupVariable_String_values = null;
        node.packageName_computed = false;
        node.packageName_value = null;
        node.isAnonymous_computed = false;
        node.unknownType_computed = false;
        node.unknownType_value = null;
        node.inExplicitConstructorInvocation_computed = false;
        node.inStaticContext_computed = false;
        node.destinationPath_computed = false;
        node.destinationPath_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in AnonymousClasses.jrag at line 19

  
  public int anonymousIndex = 0;

    // Declared in AnonymousClasses.jrag at line 36


  public int nextAnonymousIndex() {
    if(isNestedType())
      return enclosingType().nextAnonymousIndex();
    return anonymousIndex++;
  }

    // Declared in BoundNames.jrag at line 15


  // The memberMethods(String name) attribute is used to lookup member methods.
  // It uses the methodsNameMap() map where a name is mapped to a list of member
  // methods. We extend the map with the declaration m by either appending
  // it to an existing list of declarations or adding a new list. That list
  // will be used to name bind a new qualified name access.
  public MethodDecl addMemberMethod(MethodDecl m) {
    addBodyDecl(m);
    return (MethodDecl)getBodyDecl(getNumBodyDecl()-1);
    /*
    HashMap map = methodsNameMap();
    ArrayList list = (ArrayList)map.get(m.name());
    if(list == null) {
      list = new ArrayList(4);
      map.put(m.name(), list);
    }
    list.add(m);
    if(!memberMethods(m.name()).contains(m))
      throw new Error("The method " + m.signature() + " added to " + typeName() + " can not be found using lookupMemberMethod");
    */
  }

    // Declared in BoundNames.jrag at line 31


  public ConstructorDecl addConstructor(ConstructorDecl c) {
    addBodyDecl(c);
    return (ConstructorDecl)getBodyDecl(getNumBodyDecl()-1);
  }

    // Declared in BoundNames.jrag at line 36


  public ClassDecl addMemberClass(ClassDecl c) {
    addBodyDecl(new MemberClassDecl(c));
    return ((MemberClassDecl)getBodyDecl(getNumBodyDecl()-1)).getClassDecl();
  }

    // Declared in BoundNames.jrag at line 43



  // the new field must be unique otherwise an error occurs
  public FieldDeclaration addMemberField(FieldDeclaration f) {
    addBodyDecl(f);
    return (FieldDeclaration)getBodyDecl(getNumBodyDecl()-1);
    //if(!memberFields(f.name()).contains(f))
    //  throw new Error("The field " + f.name() + " added to " + typeName() + " can not be found using lookupMemberField");
  }

    // Declared in BoundNames.jrag at line 81


  public TypeAccess createBoundAccess() {
    return new BoundTypeAccess("", name(), this);
  }

    // Declared in DataStructures.jrag at line 109

  public SimpleSet add(Object o) {
    return new SimpleSetImpl().add(this).add(o);
  }

    // Declared in DataStructures.jrag at line 115

  private TypeDecl iterElem;

    // Declared in DataStructures.jrag at line 116

  public Iterator iterator() { iterElem = this; return this; }

    // Declared in DataStructures.jrag at line 117

  public boolean hasNext() { return iterElem != null; }

    // Declared in DataStructures.jrag at line 118

  public Object next() { Object o = iterElem; iterElem = null; return o; }

    // Declared in DataStructures.jrag at line 119

  public void remove() { throw new UnsupportedOperationException(); }

    // Declared in DeclareBeforeUse.jrag at line 32


  public boolean declaredBeforeUse(Variable decl, ASTNode use) {
    int indexDecl = ((ASTNode)decl).varChildIndex(this);
    int indexUse = use.varChildIndex(this);
    return indexDecl < indexUse;
  }

    // Declared in DeclareBeforeUse.jrag at line 37

  public boolean declaredBeforeUse(Variable decl, int indexUse) {
    int indexDecl = ((ASTNode)decl).varChildIndex(this);
    return indexDecl < indexUse;
  }

    // Declared in LookupConstructor.jrag at line 79

  public ConstructorDecl lookupConstructor(ConstructorDecl signature) {
    for(Iterator iter = constructors().iterator(); iter.hasNext(); ) {
      ConstructorDecl decl = (ConstructorDecl)iter.next();
      if(decl.sameSignature(signature)) {
        return decl;
      }
    }
    return null;
  }

    // Declared in LookupMethod.jrag at line 200



  public Iterator localMethodsIterator() {
    return new Iterator() {
      private Iterator outer = localMethodsSignatureMap().values().iterator();
      private Iterator inner = null;
      public boolean hasNext() {
        if((inner == null || !inner.hasNext()) && outer.hasNext())
          inner = ((SimpleSet)outer.next()).iterator();
        return inner == null ? false : inner.hasNext();
      }
      public Object next() {
        return inner.next();
      }
      public void remove() { throw new UnsupportedOperationException(); }
    };
    //return localMethodsSignatureMap().values().iterator();
  }

    // Declared in LookupMethod.jrag at line 268


  // iterate over all member methods in this type
  public Iterator methodsIterator() {
    return new Iterator() {
      private Iterator outer = methodsSignatureMap().values().iterator();
      private Iterator inner = null;
      public boolean hasNext() {
        if((inner == null || !inner.hasNext()) && outer.hasNext())
          inner = ((SimpleSet)outer.next()).iterator();
        return inner != null ? inner.hasNext() : false;
      }
      public Object next() {
        return inner.next();
      }
      public void remove() { throw new UnsupportedOperationException(); }
    };
  }

    // Declared in LookupMethod.jrag at line 333

  protected boolean allMethodsAbstract(SimpleSet set) {
    if(set == null) return true;
    for(Iterator iter = set.iterator(); iter.hasNext(); ) {
      MethodDecl m = (MethodDecl)iter.next();
      if(!m.isAbstract())
        return false;
    }
    return true;
  }

    // Declared in LookupVariable.jrag at line 200

  
  public TypeDecl subclassWithinBody(TypeDecl typeDecl) {
    if(instanceOf(typeDecl))
      return this;
    if(isNestedType()) {
      return enclosingType().subclassWithinBody(typeDecl);
    }
    return null;
  }

    // Declared in Modifiers.jrag at line 57


  public void checkModifiers() {
    super.checkModifiers();
    // 8.1.1
    if(isPublic() && !isTopLevelType() && !isMemberType())
      error("public pertains only to top level types and member types");

    // 8.1.1
    if((isProtected() || isPrivate()) && !(isMemberType() && enclosingType().isClassDecl()))
      error("protected and private may only be used on member types within a directly enclosing class declaration");

    // 8.1.1
    if(isStatic() && !isMemberType())
      error("static pertains only to member types");
    
    
    // 8.4.3.1
    // 8.1.1.1
    if(!isAbstract() && hasAbstract()) {
      StringBuffer s = new StringBuffer();
      s.append("" + name() + " is not declared abstract but contains abstract members: \n");
      for(Iterator iter = unimplementedMethods().iterator(); iter.hasNext(); ) {
        MethodDecl m = (MethodDecl)iter.next();
        s.append("  " + m.signature() + " in " + m.hostType().typeName() + "\n");
      }
      error(s.toString());
    }
  }

    // Declared in NameCheck.jrag at line 234


  public void nameCheck() {
    if(isTopLevelType() && lookupType(packageName(), name()) != this)
      error("duplicate member " + name() + " in compilation unit");
  
    if(!isTopLevelType() && !isAnonymous() && !isLocalClass() && extractSingleType(enclosingType().memberTypes(name())) != this)
      error("duplicate member type " + name() + " in type " + enclosingType().typeName());

    // 14.3
    if(isLocalClass()) {
      TypeDecl typeDecl = extractSingleType(lookupType(name()));
      if(typeDecl != null && typeDecl != this && typeDecl.isLocalClass() && enclosingBlock() == typeDecl.enclosingBlock())
        error("local class named " + name() + " may not be redeclared as a local class in the same block");
    }

    if(!packageName().equals("") && hasPackage(fullName()))
      error("duplicate member class and package " + name());
    
    // 8.1 & 9.1
    if(hasEnclosingTypeDecl(name())) {
      error("type may not have the same simple name as an enclosing type declaration");
    }
  }

    // Declared in QualifiedNames.jrag at line 87

  public Access createQualifiedAccess() {
    if(isLocalClass() || isAnonymous()) {
      return new TypeAccess(name());
    }
    else if(!isTopLevelType()) {
      return enclosingType().createQualifiedAccess().qualifiesAccess(new TypeAccess(name()));
    }
    else {
      return new TypeAccess(packageName(), name());
    }
  }

    // Declared in TypeAnalysis.jrag at line 225

  public FieldDeclaration findSingleVariable(String name) {
    return (FieldDeclaration)fields(name).iterator().next();
  }

    // Declared in TypeHierarchyCheck.jrag at line 148


  public void refined_TypeHierarchyCheck_typeCheck() {
    // 8.4.6.4 & 9.4.1
    for(Iterator iter1 = localMethodsIterator(); iter1.hasNext(); ) {
      MethodDecl m = (MethodDecl)iter1.next();
      ASTNode target = m.hostType() == this ? (ASTNode)m : (ASTNode)this;
      
      //for(Iterator i2 = overrides(m).iterator(); i2.hasNext(); ) {
      for(Iterator i2 = ancestorMethods(m.signature()).iterator(); i2.hasNext(); ) {
        MethodDecl decl = (MethodDecl)i2.next();
        if(m.overrides(decl)) {
          // 8.4.6.1
          if(!m.isStatic() && decl.isStatic())
            target.error("an instance method may not override a static method");
 
          // regardless of overriding
          // 8.4.6.3
          if(!m.mayOverrideReturn(decl))
            target.error("the return type of method " + m.signature() + " in " + m.hostType().typeName() + " does not match the return type of method " + decl.signature() + " in " + decl.hostType().typeName() + " and may thus not be overriden");
 
          // regardless of overriding
          // 8.4.4
          for(int i = 0; i < m.getNumException(); i++) {
            Access e = m.getException(i);
            boolean found = false;
            for(int j = 0; !found && j < decl.getNumException(); j++) {
              if(e.type().instanceOf(decl.getException(j).type()))
                found = true;
            }
            if(!found && e.type().isUncheckedException())
              target.error(m.signature() + " in " + m.hostType().typeName() + " may not throw more checked exceptions than overridden method " +
               decl.signature() + " in " + decl.hostType().typeName());
          }
          // 8.4.6.3
          if(decl.isPublic() && !m.isPublic())
            target.error("overriding access modifier error");
          // 8.4.6.3
          if(decl.isProtected() && !(m.isPublic() || m.isProtected()))
            target.error("overriding access modifier error");
          // 8.4.6.3
          if((!decl.isPrivate() && !decl.isProtected() && !decl.isPublic()) && m.isPrivate())
            target.error("overriding access modifier error");
 
          // regardless of overriding
          if(decl.isFinal())
            target.error("method " + m.signature() + " in " + hostType().typeName() + " can not override final method " + decl.signature() + " in " + decl.hostType().typeName());
        }
        if(m.hides(decl)) {
          // 8.4.6.2
          if(m.isStatic() && !decl.isStatic())
            target.error("a static method may not hide an instance method");
          // 8.4.6.3
          if(m.type() != decl.type())
            target.error("can not hide a method with a different return type");
          // 8.4.4
          for(int i = 0; i < m.getNumException(); i++) {
            Access e = m.getException(i);
            boolean found = false;
            for(int j = 0; !found && j < decl.getNumException(); j++) {
              if(e.type().instanceOf(decl.getException(j).type()))
                found = true;
            }
            if(!found)
              target.error("may not throw more checked exceptions than hidden method");
          }
          // 8.4.6.3
          if(decl.isPublic() && !m.isPublic())
            target.error("hiding access modifier error: public method " + decl.signature() + " in " + decl.hostType().typeName() + " is hidden by non public method " + m.signature() + " in " + m.hostType().typeName());
          // 8.4.6.3
          if(decl.isProtected() && !(m.isPublic() || m.isProtected()))
            target.error("hiding access modifier error: protected method " + decl.signature() + " in " + decl.hostType().typeName() + " is hidden by non (public|protected) method " + m.signature() + " in " + m.hostType().typeName());
          // 8.4.6.3
          if((!decl.isPrivate() && !decl.isProtected() && !decl.isPublic()) && m.isPrivate())
            target.error("hiding access modifier error: default method " + decl.signature() + " in " + decl.hostType().typeName() + " is hidden by private method " + m.signature() + " in " + m.hostType().typeName());
          if(decl.isFinal())
            target.error("method " + m.signature() + " in " + hostType().typeName() + " can not hide final method " + decl.signature() + " in " + decl.hostType().typeName());
        }
      }
    }
  }

    // Declared in Attributes.jrag at line 49


  public int addConstant(ConstantPool p, Constant c)     { 
    if(isString()) return p.addConstant(c.stringValue());
    throw new Error("Not supported"); 
  }

    // Declared in CodeGeneration.jrag at line 457


  public void emitPushConstant(CodeGeneration gen, int value) {
  }

    // Declared in CodeGeneration.jrag at line 569


  // return

  public void emitReturn(CodeGeneration gen) { error(); }

    // Declared in CodeGeneration.jrag at line 591


  public void emitLoadLocal(CodeGeneration gen, int pos) {error();}

    // Declared in CodeGeneration.jrag at line 704

  
  public void emitStoreLocal(CodeGeneration gen, int pos) {error();}

    // Declared in CodeGeneration.jrag at line 801


  // dup

  public void emitDup(CodeGeneration gen)      { gen.emit(Bytecode.DUP); }

    // Declared in CodeGeneration.jrag at line 806

  
  public void emitDup_x1(CodeGeneration gen)   { gen.emit(Bytecode.DUP_X1); }

    // Declared in CodeGeneration.jrag at line 811


  public void emitDup_x2(CodeGeneration gen)   { gen.emit(Bytecode.DUP_X2); }

    // Declared in CodeGeneration.jrag at line 816

  
  public void emitPop(CodeGeneration gen)      { gen.emit(Bytecode.POP); }

    // Declared in CodeGeneration.jrag at line 891


  // emitNew

  public void emitNew(CodeGeneration gen) {
    int index = gen.constantPool().addClass(constantPoolName());
    gen.emit(Bytecode.NEW).add2(index);
  }

    // Declared in CodeGeneration.jrag at line 897

  void emitAssignConvTo(CodeGeneration gen, TypeDecl type) {
    emitCastTo(gen, type);
  }

    // Declared in CodeGeneration.jrag at line 901

  
  void emitCastTo(CodeGeneration gen, TypeDecl type) { throw new Error("CastTo not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 913


  void intToThis(CodeGeneration gen) { throw new Error("intToThis not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 922


  void floatToThis(CodeGeneration gen) { throw new Error("floatToThis not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 931


  void doubleToThis(CodeGeneration gen) { throw new Error("doubleToThis not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 940


  void longToThis(CodeGeneration gen) { throw new Error("longToThis not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 949


  void byteToThis(CodeGeneration gen) { throw new Error("byteToThis not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 956

  
  void charToThis(CodeGeneration gen) { throw new Error("charToThis not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 964

  
  void shortToThis(CodeGeneration gen) { throw new Error("shortToThis not implemented for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 997

  
  void neg(CodeGeneration gen) { error(); }

    // Declared in CodeGeneration.jrag at line 1003


  void bitNot(CodeGeneration gen) { error(); }

    // Declared in CodeGeneration.jrag at line 1007


  void logNot(CodeGeneration gen) { error();}

    // Declared in CodeGeneration.jrag at line 1010


  void add(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1016


  void sub(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1022


  void mul(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1028


  void div(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1034


  void rem(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1040


  void shl(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1044


  void shr(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1048


  void ushr(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1052


  void bitand(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1057


  void bitor(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1062


  void bitxor(CodeGeneration gen) {error();}

    // Declared in CodeGeneration.jrag at line 1069

  public void branchLT(CodeGeneration gen, int label) { throw new Error("branchLT not supported for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 1075

    
  public void branchLE(CodeGeneration gen, int label) { throw new Error("branchLE not supported for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 1081

  
  public void branchGE(CodeGeneration gen, int label) { throw new Error("branchGE not supported for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 1087

  
  public void branchGT(CodeGeneration gen, int label) { throw new Error("branchGT not supported for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 1093


  public void branchEQ(CodeGeneration gen, int label) { throw new Error("branchEQ not supported for " + getClass().getName()); }

    // Declared in CodeGeneration.jrag at line 1102

  
  public void branchNE(CodeGeneration gen, int label) { throw new Error("branchNE not supported for " + getClass().getName()); }

    // Declared in CreateBCode.jrag at line 447


  // no lazy since needed in phases when tree has been modified
  public boolean hasField(String name) {
    if(!fields(name).isEmpty())
      return true;
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof FieldDeclaration) {
        FieldDeclaration decl = (FieldDeclaration)getBodyDecl(i);
        if(decl.name().equals(name))
          return true;
      }
    }
    return false;
  }

    // Declared in CreateBCode.jrag at line 517


  private HashMap createSuperAccessorMap = null;

    // Declared in CreateBCode.jrag at line 518

  public MethodDecl createSuperAccessor(MethodDecl decl) {
    if(createSuperAccessorMap == null) createSuperAccessorMap = new HashMap();
    if(createSuperAccessorMap.containsKey(decl))
      return (MethodDecl)createSuperAccessorMap.get(decl);
      
    List parameters = new List();
    parameters.add(new ParameterDeclaration(new Modifiers(new List()), createQualifiedAccess(), "self"));
    List args = new List();
    for(int i = 0; i < decl.getNumParameter(); i++) {
      parameters.add(decl.getParameter(i).fullCopy());
      args.add(new VarAccess(decl.getParameter(i).name()));
    }
    MethodDecl m = new MethodDecl(
      new Modifiers(new List().add(new Modifier("static")).add(new Modifier("synthetic"))),
      decl.type().createQualifiedAccess(),
      "access$" + accessorCounter++,
      parameters,
      new List(),
      new List(),
      new Opt(
        new Block(
          new List().add(
            new ReturnStmt(
              new Opt(
                new SuperAccess("super").qualifiesAccess(new MethodAccess(decl.name(), args))
              )
            )
          )
        )
      )
    );
    m = addMemberMethod(m);
    createSuperAccessorMap.put(decl, m);
    return m;
  }

    // Declared in Flags.jrag at line 19
 //             method


  // mangle modifiers for nested types
  public int mangledFlags(int flags) {
    boolean privateFlag = (flags & Modifiers.ACC_PRIVATE) != 0;
    boolean protectedFlag = (flags & Modifiers.ACC_PROTECTED) != 0;
    flags &= ~ Modifiers.ACC_PRIVATE;
    flags &= ~ Modifiers.ACC_PROTECTED;
    if(protectedFlag)
      flags |= Modifiers.ACC_PUBLIC;
    return flags;
  }

    // Declared in GenerateClassfile.jrag at line 18

  
  public void generateClassfile() {
    for(Iterator iter = nestedTypes().iterator(); iter.hasNext(); ) {
      TypeDecl typeDecl = (TypeDecl)iter.next();
      typeDecl.generateClassfile();
    }
  }

    // Declared in GenerateClassfile.jrag at line 358

  
  public boolean clear() {
    bytecodes(constantPool()).clearCodeGeneration();
    for(int i = 0; i < getNumBodyDecl(); i++)
      getBodyDecl(i).clear();
    attributes_computed = false;
    attributes_value = null;
    clinit_attributes_computed = false;
    clinit_attributes_value = null;
    constantPool_computed = false;
    constantPool_value = null;
    bytecodes_ConstantPool_values = null;
    return false;
  }

    // Declared in InnerClasses.jrag at line 5


  // The set of TypeDecls that has this TypeDecl as their directly enclosing TypeDecl.
  // I.e., NestedTypes, InnerTypes, AnonymousClasses, LocalClasses.
  private Collection nestedTypes;

    // Declared in InnerClasses.jrag at line 6

  public Collection nestedTypes() {
    return nestedTypes != null ? nestedTypes : new HashSet();
  }

    // Declared in InnerClasses.jrag at line 9

  public void addNestedType(TypeDecl typeDecl) {
    if(nestedTypes == null) nestedTypes = new ArrayList();
    if(typeDecl != this)
      nestedTypes.add(typeDecl);
  }

    // Declared in InnerClasses.jrag at line 16


  // The set of nested TypeDecls that are accessed in this TypeDecl
  private Collection usedNestedTypes;

    // Declared in InnerClasses.jrag at line 17

  public Collection usedNestedTypes() {
    return usedNestedTypes != null ? usedNestedTypes : new HashSet();
  }

    // Declared in InnerClasses.jrag at line 20

  public void addUsedNestedType(TypeDecl typeDecl) {
    if(usedNestedTypes == null) usedNestedTypes = new HashSet();
    usedNestedTypes.add(typeDecl);
  }

    // Declared in InnerClasses.jrag at line 25

  
  int constantPoolNameIndex = 1;

    // Declared in InnerClasses.jrag at line 82



  public int accessorCounter = 0;

    // Declared in InnerClasses.jrag at line 129


  public int numAccessorMethods(Collection c) {
    int num = 0;
    for(Iterator iter = c.iterator(); iter.hasNext(); ) {
      Object o = iter.next();
      if(o instanceof ConstructorDecl) {
        ConstructorDecl m = (ConstructorDecl)o;
        if(m.needsAccessor())
          num++;
      }
    }
    return num;
  }

    // Declared in InnerClasses.jrag at line 142


  public int numAccessorFields(Collection c) {
    int num = 0;
    for(Iterator iter = c.iterator(); iter.hasNext(); ) {
      Object o = iter.next();
      if(o instanceof FieldDeclaration) {
        FieldDeclaration f = (FieldDeclaration)o;
        if(f.needsAccessor())
          num++;
        if(f.needsAccessorWrite())
          num++;
      }
    }
    return num;
  }

    // Declared in Java2Rewrites.jrag at line 34

  
  // lazily build a static field for assertionsDisabled 
  private FieldDeclaration createAssertionsDisabled = null;

    // Declared in Java2Rewrites.jrag at line 35

  public FieldDeclaration createAssertionsDisabled() {
    if(createAssertionsDisabled != null)
      return createAssertionsDisabled;
    // static final boolean $assertionsDisabled = !TypeName.class.desiredAssertionStatus();
    createAssertionsDisabled = new FieldDeclaration(
      new Modifiers(new List().add(new Modifier("static")).add(new Modifier("final"))),
      new PrimitiveTypeAccess("boolean"),
      "$assertionsDisabled",
      new Opt(
          new LogNotExpr(
            createQualifiedAccess().qualifiesAccess(
              new ClassAccess().qualifiesAccess(
                new MethodAccess(
                  "desiredAssertionStatus",
                  new List()
                )
              )
            )
          )
      )
    );
    getBodyDeclList().insertChild(createAssertionsDisabled, 0);
    // explicit read to trigger possible rewrites
    createAssertionsDisabled = (FieldDeclaration)getBodyDeclList().getChild(0);
    // transform the generated initalization, e.g., the ClassAccess construct
    createAssertionsDisabled.java2Transformation();
    return createAssertionsDisabled;
  }

    // Declared in Java2Rewrites.jrag at line 65


  // lazily build a static field for each typename used in a .class expression
  private HashMap createStaticClassField = null;

    // Declared in Java2Rewrites.jrag at line 66

  public FieldDeclaration createStaticClassField(String name) {
    if(createStaticClassField == null)
      createStaticClassField = new HashMap();
    if(createStaticClassField.containsKey(name))
      return (FieldDeclaration)createStaticClassField.get(name);
    // static synthetic Class class$java$lang$String;
    FieldDeclaration f = new FieldDeclaration(
      new Modifiers(new List().add(new Modifier("static"))),
      lookupType("java.lang", "Class").createQualifiedAccess(),
      name,
      new Opt()
    ) {
      public boolean isConstant() {
        return true;
      }
    };
    createStaticClassField.put(name, f);
    return addMemberField(f);
  }

    // Declared in Java2Rewrites.jrag at line 87


  // lazily build a static class$ method in this type declaration
  private MethodDecl createStaticClassMethod = null;

    // Declared in Java2Rewrites.jrag at line 88

  public MethodDecl createStaticClassMethod() {
    if(createStaticClassMethod != null)
      return createStaticClassMethod;
    // static synthetic Class class$(String name) {
    //   try {
    //     return java.lang.Class.forName(name);
    //   } catch(java.lang.ClassNotFoundException e) {
    //     throw new java.lang.NoClassDefFoundError(e.getMessage());
    //   }
    // }
    createStaticClassMethod = new MethodDecl(
      new Modifiers(new List().add(new Modifier("static"))),
      lookupType("java.lang", "Class").createQualifiedAccess(),
      "class$",
      new List().add(
        new ParameterDeclaration(
          new Modifiers(new List()),
          lookupType("java.lang", "String").createQualifiedAccess(),
          "name"
        )
      ),
      new List(),
      new List(),
      new Opt(
        new Block(
          new List().add(
            new TryStmt(
              new Block(
                new List().add(
                  new ReturnStmt(
                    new Opt(
                      lookupType("java.lang", "Class").createQualifiedAccess().qualifiesAccess(
                        new MethodAccess(
                          "forName",
                          new List().add(
                            new VarAccess("name")
                          )
                        )
                      )
                    )
                  )
                )
              ),
              new List().add(
                new CatchClause(
                  new ParameterDeclaration(
                    new Modifiers(new List()),
                    lookupType("java.lang", "ClassNotFoundException").createQualifiedAccess(),
                    "e"
                  ),
                  new Block(
                    new List().add(
                      new ThrowStmt(
                        new ClassInstanceExpr(
                          lookupType("java.lang", "NoClassDefFoundError").createQualifiedAccess(),
                          new List().add(
                            new VarAccess("e").qualifiesAccess(
                              new MethodAccess(
                                "getMessage",
                                new List()
                              )
                            )
                          ),
                          new Opt()
                        )
                      )
                    )
                  )
                )
              ),
              new Opt()
            )
          )
        )
      )
    ) {
      public boolean isConstant() {
        return true;
      }
    };
    return addMemberMethod(createStaticClassMethod);
  }

    // Declared in Java2Transformations.jrag at line 18

  
  // remote collection
  public void java2Transformation() {
    super.java2Transformation();
    if(isNestedType())
      enclosingType().addNestedType(this);
  }

    // Declared in Generics.jrag at line 87


  // Brute force replacesment with generic one in AST
  // make sure that the AST has not beed traversed yet!
  public TypeDecl makeGeneric(Signatures.ClassSignature s) {
    return this;
  }

    // Declared in Generics.jrag at line 592

  
  public Access substitute(Parameterization parTypeDecl) {
    return createBoundAccess();
  }

    // Declared in Generics.jrag at line 631

  
  public Access substituteReturnType(Parameterization parTypeDecl) {
    return substitute(parTypeDecl);
  }

    // Declared in Generics.jrag at line 659


  public Access substituteParameterType(Parameterization parTypeDecl) {
    return substitute(parTypeDecl);
  }

    // Declared in Generics.jrag at line 913

  public TypeDecl original;

    // Declared in AutoBoxingCodegen.jrag at line 70

  protected void emitBoxingOperation(CodeGeneration gen) {
    // Box the value on the stack into this Reference type
    String classname = constantPoolName();
    String desc = "(" + unboxed().typeDescriptor() + ")" + typeDescriptor();
    String name = "valueOf";
    int index = gen.constantPool().addMethodref(classname, name, desc);
    gen.emit(Bytecode.INVOKESTATIC, variableSize() - unboxed().variableSize()).add2(index);
  }

    // Declared in AutoBoxingCodegen.jrag at line 88

  protected void emitUnboxingOperation(CodeGeneration gen) {
    // Unbox the value on the stack from this Reference type
    String classname = constantPoolName();
    String desc = "(" + ")" + unboxed().typeDescriptor();
    String name = unboxed().name() + "Value";
    int index = gen.constantPool().addMethodref(classname, name, desc);
    gen.emit(Bytecode.INVOKEVIRTUAL, unboxed().variableSize() - 1).add2(index);
  }

    // Declared in EnumsCodegen.jrag at line 81

  // compute index of enum constants
  private HashMap createEnumIndexMap = null;

    // Declared in java.ast at line 3
    // Declared in java.ast line 37

    public TypeDecl() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 37
    public TypeDecl(Modifiers p0, String p1, List p2) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
    }

    // Declared in java.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in java.ast at line 21

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 37
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
    // Declared in java.ast line 37
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
    // Declared in java.ast line 37
    public void setBodyDeclList(List list) {
        setChild(list, 1);
    }

    // Declared in java.ast at line 6


    public int getNumBodyDecl() {
        return getBodyDeclList().getNumChild();
    }

    // Declared in java.ast at line 10


    public BodyDecl getBodyDecl(int i) {
        return (BodyDecl)getBodyDeclList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addBodyDecl(BodyDecl node) {
        List list = getBodyDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setBodyDecl(BodyDecl node, int i) {
        List list = getBodyDeclList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getBodyDeclList() {
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Generics.jrag at line 227


  // different parameterizations of the same generic interface may not be implemented
    public void typeCheck() {
    refined_TypeHierarchyCheck_typeCheck();
    ArrayList list = new ArrayList();
    list.addAll(implementedInterfaces());
    for(int i = 0; i < list.size(); i++) {
      InterfaceDecl decl = (InterfaceDecl)list.get(i);
      if(decl instanceof ParInterfaceDecl) {
        ParInterfaceDecl p = (ParInterfaceDecl)decl;
        for(Iterator i2 = list.listIterator(i); i2.hasNext(); ) {
          InterfaceDecl decl2 = (InterfaceDecl)i2.next();
          if(decl2 instanceof ParInterfaceDecl) {
            ParInterfaceDecl q = (ParInterfaceDecl)decl2;
            if(p != q && p.genericDecl() == q.genericDecl() && !p.sameArgument(q))
              error(p.genericDecl().name() + " cannot be inherited with different arguments: " +
                p.typeName() + " and " + q.typeName());
          }
        }
      }
    }
  }

    // Declared in Arrays.jrag at line 15
private TypeDecl refined_Arrays_arrayType()
 {
    String name = name() + "[]";
    TypeDecl typeDecl =
      new ArrayDecl(
        new Modifiers(new List().add(new Modifier("public"))),
        name,
        new Opt(typeObject().createQualifiedAccess()), // [SuperClassAccess]
        new List().add(typeCloneable().createQualifiedAccess()).add(typeSerializable().createQualifiedAccess()), // Implements*
        new List().add( // BodyDecl*
          new FieldDeclaration(
            new Modifiers(new List().add(new Modifier("public")).add(new Modifier("final"))),
            new PrimitiveTypeAccess("int"),
            "length",
            new Opt() // [Init:Expr]
          )).add(
          new MethodDecl(
            new Modifiers(new List().add(new Modifier("public"))),
            typeObject().createQualifiedAccess(),
            "clone",
            new List(),
            new List(),
            new List(),
            new Opt(new Block())
          )
        )
      );
    return typeDecl;
  }

    // Declared in TypeAnalysis.jrag at line 50
private boolean refined_TypeAnalysis_assignConversionTo_TypeDecl_Expr(TypeDecl type, Expr expr)
 {
    //System.out.println("@@@ " + fullName() + " assign conversion to " + type.fullName() + ", expr: " + expr);
    boolean sourceIsConstant = expr != null ? expr.isConstant() : false;
    //System.out.println("@@@ sourceIsConstant: " + sourceIsConstant);
    if(identityConversionTo(type) || wideningConversionTo(type))
      return true;
    //System.out.println("@@@ narrowing conversion needed");
    //System.out.println("@@@ value: " + expr.value());
    if(sourceIsConstant && (isInt() || isChar() || isShort() || isByte()) &&
        (type.isByte() || type.isShort() || type.isChar()) &&
        narrowingConversionTo(type) && expr.representableIn(type))
      return true;
    //System.out.println("@@@ false");
    return false;
  }

    // Declared in TypeAnalysis.jrag at line 67
private boolean refined_TypeAnalysis_methodInvocationConversionTo_TypeDecl(TypeDecl type)
 {
    return identityConversionTo(type) || wideningConversionTo(type);
  }

    // Declared in TypeAnalysis.jrag at line 72
private boolean refined_TypeAnalysis_castingConversionTo_TypeDecl(TypeDecl type)
{ return  identityConversionTo(type) ||
    wideningConversionTo(type) || narrowingConversionTo(type); }

    // Declared in TypeAnalysis.jrag at line 406
private boolean refined_TypeAnalysis_instanceOf_TypeDecl(TypeDecl type)
{ return  type == this; }

    // Declared in Attributes.jrag at line 159
private Collection refined_Attributes_attributes()
 {
    Collection c = new ArrayList();
    if(!innerClassesAttributeEntries().isEmpty())
      c.add(new InnerClassesAttribute(this));
    if(isSynthetic())
      c.add(new SyntheticAttribute(constantPool()));
    if(compilationUnit().fromSource()) {
      String relativeName = compilationUnit().relativeName();
      if(relativeName != null) {
        String splitToken = java.io.File.separator;
        if(splitToken.equals("\\"))
          splitToken = "\\\\";
        String[] strings = relativeName.split(splitToken);
        c.add(new SourceFileAttribute(constantPool(), strings[strings.length-1]));
      }
    }
    return c;
  }

    // Declared in GenerateClassfile.jrag at line 27
private int refined_GenerateClassfile_majorVersion()
{ return  48; }

    // Declared in AnnotationsCodegen.jrag at line 2
private Collection refined_AnnotationsCodegen_attributes()
 {
    Collection c = refined_Attributes_attributes();
    getModifiers().addRuntimeVisibleAnnotationsAttribute(c);
    getModifiers().addRuntimeInvisibleAnnotationsAttribute(c);
    return c;
  }

    protected java.util.Map accessibleFromPackage_String_values;
    // Declared in AccessControl.jrag at line 6
    public boolean accessibleFromPackage(String packageName) {
        Object _parameters = packageName;
if(accessibleFromPackage_String_values == null) accessibleFromPackage_String_values = new java.util.HashMap(4);
        if(accessibleFromPackage_String_values.containsKey(_parameters))
            return ((Boolean)accessibleFromPackage_String_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean accessibleFromPackage_String_value = accessibleFromPackage_compute(packageName);
        if(isFinal && num == boundariesCrossed)
            accessibleFromPackage_String_values.put(_parameters, Boolean.valueOf(accessibleFromPackage_String_value));
        return accessibleFromPackage_String_value;
    }

    private boolean accessibleFromPackage_compute(String packageName) {  return 
    !isPrivate() && (isPublic() || hostPackage().equals(packageName));  }

    protected java.util.Map accessibleFromExtend_TypeDecl_values;
    // Declared in AccessControl.jrag at line 9
    public boolean accessibleFromExtend(TypeDecl type) {
        Object _parameters = type;
if(accessibleFromExtend_TypeDecl_values == null) accessibleFromExtend_TypeDecl_values = new java.util.HashMap(4);
        if(accessibleFromExtend_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)accessibleFromExtend_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean accessibleFromExtend_TypeDecl_value = accessibleFromExtend_compute(type);
        if(isFinal && num == boundariesCrossed)
            accessibleFromExtend_TypeDecl_values.put(_parameters, Boolean.valueOf(accessibleFromExtend_TypeDecl_value));
        return accessibleFromExtend_TypeDecl_value;
    }

    private boolean accessibleFromExtend_compute(TypeDecl type)  {
    if(type == this)
      return true;
    if(isInnerType()) { 
      if(!enclosingType().accessibleFrom(type)) {
        return false;
      }
    }
    if(isPublic()) 
      return true;
    else if(isProtected()) {
      // isProtected implies a nested type
      if(hostPackage().equals(type.hostPackage())) {
        return true;
      }
      if(type.isNestedType() && type.enclosingType().withinBodyThatSubclasses(enclosingType()) != null)
        return true;
      return false;
    }
    else if(isPrivate()) {
      return topLevelType() == type.topLevelType();
    }
    else
      return hostPackage().equals(type.hostPackage());
  }

    protected java.util.Map accessibleFrom_TypeDecl_values;
    // Declared in AccessControl.jrag at line 35
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
    if(type == this)
      return true;
    if(isInnerType()) { 
      if(!enclosingType().accessibleFrom(type)) {
        return false;
      }
    }
    if(isPublic()) {  
      return true;
    }
    else if(isProtected()) {
      if(hostPackage().equals(type.hostPackage())) {
        return true;
      }
      if(isMemberType()) {
        TypeDecl typeDecl = type;
        while(typeDecl != null && !typeDecl.instanceOf(enclosingType()))
          typeDecl = typeDecl.enclosingType();
        if(typeDecl != null) {
          return true;
        }
      }
      return false;
    }
    else if(isPrivate()) {
      return topLevelType() == type.topLevelType();
    }
    else {
      return hostPackage().equals(type.hostPackage());
    }
  }

    protected boolean dimension_computed = false;
    protected int dimension_value;
    // Declared in Arrays.jrag at line 2
    public int dimension() {
        if(dimension_computed)
            return dimension_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        dimension_value = dimension_compute();
        if(isFinal && num == boundariesCrossed)
            dimension_computed = true;
        return dimension_value;
    }

    private int dimension_compute() {  return  0;  }

    protected boolean elementType_computed = false;
    protected TypeDecl elementType_value;
    // Declared in Arrays.jrag at line 7
    public TypeDecl elementType() {
        if(elementType_computed)
            return elementType_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        elementType_value = elementType_compute();
        if(isFinal && num == boundariesCrossed)
            elementType_computed = true;
        return elementType_value;
    }

    private TypeDecl elementType_compute() {  return  this;  }

    protected boolean arrayType_computed = false;
    protected TypeDecl arrayType_value;
    // Declared in GenericsArrays.jrag at line 2
    public TypeDecl arrayType() {
        if(arrayType_computed)
            return arrayType_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        arrayType_value = arrayType_compute();
        arrayType_value.setParent(this);
        arrayType_value.is$Final = true;
        if(true)
            arrayType_computed = true;
        return arrayType_value;
    }

    private TypeDecl arrayType_compute()  {
    String name = name() + "[]";
    TypeDecl typeDecl =
      new ArrayDecl(
        new Modifiers(new List().add(new Modifier("public"))),
        name,
        new Opt(typeObject().createQualifiedAccess()), // [SuperClassAccess]
        new List().add(typeCloneable().createQualifiedAccess()).add(typeSerializable().createQualifiedAccess()), // Implements*
        new List().add( // BodyDecl*
          new FieldDeclaration(
            new Modifiers(new List().add(new Modifier("public")).add(new Modifier("final"))),
            new PrimitiveTypeAccess("int"),
            "length",
            new Opt() // [Init:Expr]
          )).add(
          // we create a substituted method that substitutes the clone method in object
          // this has the following two consequences: the return value will be cast to the
          // expected return type rather than object, and the invoked method will be the
          // method in object rather in the array
          new MethodDeclSubstituted(
            new Modifiers(new List().add(new Modifier("public"))),
            new ArrayTypeAccess(createQualifiedAccess(), 1),
            "clone",
            new List(),
            new List(),
            new List(),
            new Opt(new Block()),
            (MethodDecl)typeObject().memberMethods("clone").iterator().next()
          )
        )
      );
    return typeDecl;
  }

    // Declared in ConstantExpression.jrag at line 273
    public Constant cast(Constant c) {
        Constant cast_Constant_value = cast_compute(c);
        return cast_Constant_value;
    }

    private Constant cast_compute(Constant c)  {
    throw new UnsupportedOperationException("ConstantExpression operation cast" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 287
    public Constant plus(Constant c) {
        Constant plus_Constant_value = plus_compute(c);
        return plus_Constant_value;
    }

    private Constant plus_compute(Constant c)  {
    throw new UnsupportedOperationException("ConstantExpression operation plus" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 296
    public Constant minus(Constant c) {
        Constant minus_Constant_value = minus_compute(c);
        return minus_Constant_value;
    }

    private Constant minus_compute(Constant c)  {
    throw new UnsupportedOperationException("ConstantExpression operation minus" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 305
    public Constant bitNot(Constant c) {
        Constant bitNot_Constant_value = bitNot_compute(c);
        return bitNot_Constant_value;
    }

    private Constant bitNot_compute(Constant c)  {
    throw new UnsupportedOperationException("ConstantExpression operation bitNot" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 312
    public Constant mul(Constant c1, Constant c2) {
        Constant mul_Constant_Constant_value = mul_compute(c1, c2);
        return mul_Constant_Constant_value;
    }

    private Constant mul_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation mul" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 321
    public Constant div(Constant c1, Constant c2) {
        Constant div_Constant_Constant_value = div_compute(c1, c2);
        return div_Constant_Constant_value;
    }

    private Constant div_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation div" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 330
    public Constant mod(Constant c1, Constant c2) {
        Constant mod_Constant_Constant_value = mod_compute(c1, c2);
        return mod_Constant_Constant_value;
    }

    private Constant mod_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation mod" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 339
    public Constant add(Constant c1, Constant c2) {
        Constant add_Constant_Constant_value = add_compute(c1, c2);
        return add_Constant_Constant_value;
    }

    private Constant add_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation add" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 349
    public Constant sub(Constant c1, Constant c2) {
        Constant sub_Constant_Constant_value = sub_compute(c1, c2);
        return sub_Constant_Constant_value;
    }

    private Constant sub_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation sub" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 358
    public Constant lshift(Constant c1, Constant c2) {
        Constant lshift_Constant_Constant_value = lshift_compute(c1, c2);
        return lshift_Constant_Constant_value;
    }

    private Constant lshift_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation lshift" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 365
    public Constant rshift(Constant c1, Constant c2) {
        Constant rshift_Constant_Constant_value = rshift_compute(c1, c2);
        return rshift_Constant_Constant_value;
    }

    private Constant rshift_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation rshift" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 372
    public Constant urshift(Constant c1, Constant c2) {
        Constant urshift_Constant_Constant_value = urshift_compute(c1, c2);
        return urshift_Constant_Constant_value;
    }

    private Constant urshift_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation urshift" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 379
    public Constant andBitwise(Constant c1, Constant c2) {
        Constant andBitwise_Constant_Constant_value = andBitwise_compute(c1, c2);
        return andBitwise_Constant_Constant_value;
    }

    private Constant andBitwise_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation andBitwise" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 387
    public Constant xorBitwise(Constant c1, Constant c2) {
        Constant xorBitwise_Constant_Constant_value = xorBitwise_compute(c1, c2);
        return xorBitwise_Constant_Constant_value;
    }

    private Constant xorBitwise_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation xorBitwise" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 395
    public Constant orBitwise(Constant c1, Constant c2) {
        Constant orBitwise_Constant_Constant_value = orBitwise_compute(c1, c2);
        return orBitwise_Constant_Constant_value;
    }

    private Constant orBitwise_compute(Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation orBitwise" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 403
    public Constant questionColon(Constant cond, Constant c1, Constant c2) {
        Constant questionColon_Constant_Constant_Constant_value = questionColon_compute(cond, c1, c2);
        return questionColon_Constant_Constant_Constant_value;
    }

    private Constant questionColon_compute(Constant cond, Constant c1, Constant c2)  {
    throw new UnsupportedOperationException("ConstantExpression operation questionColon" +
      " not supported for type " + getClass().getName()); 
  }

    // Declared in ConstantExpression.jrag at line 507
    public boolean eqIsTrue(Expr left, Expr right) {
        boolean eqIsTrue_Expr_Expr_value = eqIsTrue_compute(left, right);
        return eqIsTrue_Expr_Expr_value;
    }

    private boolean eqIsTrue_compute(Expr left, Expr right)  {
    System.err.println("Evaluation eqIsTrue for unknown type: " + getClass().getName());
    return false;
  }

    // Declared in ConstantExpression.jrag at line 518
    public boolean ltIsTrue(Expr left, Expr right) {
        boolean ltIsTrue_Expr_Expr_value = ltIsTrue_compute(left, right);
        return ltIsTrue_Expr_Expr_value;
    }

    private boolean ltIsTrue_compute(Expr left, Expr right) {  return  false;  }

    // Declared in ConstantExpression.jrag at line 524
    public boolean leIsTrue(Expr left, Expr right) {
        boolean leIsTrue_Expr_Expr_value = leIsTrue_compute(left, right);
        return leIsTrue_Expr_Expr_value;
    }

    private boolean leIsTrue_compute(Expr left, Expr right) {  return  false;  }

    // Declared in DataStructures.jrag at line 107
    public int size() {
        int size_value = size_compute();
        return size_value;
    }

    private int size_compute() {  return  1;  }

    // Declared in DataStructures.jrag at line 108
    public boolean isEmpty() {
        boolean isEmpty_value = isEmpty_compute();
        return isEmpty_value;
    }

    private boolean isEmpty_compute() {  return  false;  }

    // Declared in DataStructures.jrag at line 112
    public boolean contains(Object o) {
        boolean contains_Object_value = contains_compute(o);
        return contains_Object_value;
    }

    private boolean contains_compute(Object o) {  return  this == o;  }

    protected boolean isException_computed = false;
    protected boolean isException_value;
    // Declared in ExceptionHandling.jrag at line 15
    public boolean isException() {
        if(isException_computed)
            return isException_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isException_value = isException_compute();
        if(isFinal && num == boundariesCrossed)
            isException_computed = true;
        return isException_value;
    }

    private boolean isException_compute() {  return  instanceOf(typeException());  }

    protected boolean isCheckedException_computed = false;
    protected boolean isCheckedException_value;
    // Declared in ExceptionHandling.jrag at line 16
    public boolean isCheckedException() {
        if(isCheckedException_computed)
            return isCheckedException_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isCheckedException_value = isCheckedException_compute();
        if(isFinal && num == boundariesCrossed)
            isCheckedException_computed = true;
        return isCheckedException_value;
    }

    private boolean isCheckedException_compute() {  return  isException() &&
    (instanceOf(typeRuntimeException()) || instanceOf(typeError()));  }

    protected boolean isUncheckedException_computed = false;
    protected boolean isUncheckedException_value;
    // Declared in ExceptionHandling.jrag at line 18
    public boolean isUncheckedException() {
        if(isUncheckedException_computed)
            return isUncheckedException_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isUncheckedException_value = isUncheckedException_compute();
        if(isFinal && num == boundariesCrossed)
            isUncheckedException_computed = true;
        return isUncheckedException_value;
    }

    private boolean isUncheckedException_compute() {  return  isException() && !isCheckedException();  }

    protected java.util.Map mayCatch_TypeDecl_values;
    // Declared in ExceptionHandling.jrag at line 212
    public boolean mayCatch(TypeDecl thrownType) {
        Object _parameters = thrownType;
if(mayCatch_TypeDecl_values == null) mayCatch_TypeDecl_values = new java.util.HashMap(4);
        if(mayCatch_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)mayCatch_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean mayCatch_TypeDecl_value = mayCatch_compute(thrownType);
        if(isFinal && num == boundariesCrossed)
            mayCatch_TypeDecl_values.put(_parameters, Boolean.valueOf(mayCatch_TypeDecl_value));
        return mayCatch_TypeDecl_value;
    }

    private boolean mayCatch_compute(TypeDecl thrownType) {  return 
    thrownType.instanceOf(this) || this.instanceOf(thrownType);  }

    // Declared in LookupConstructor.jrag at line 12
    public Collection lookupSuperConstructor() {
        Collection lookupSuperConstructor_value = lookupSuperConstructor_compute();
        return lookupSuperConstructor_value;
    }

    private Collection lookupSuperConstructor_compute() {  return  Collections.EMPTY_LIST;  }

    protected boolean constructors_computed = false;
    protected Collection constructors_value;
    // Declared in LookupConstructor.jrag at line 90
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
    Collection c = new ArrayList();
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof ConstructorDecl) {
        c.add(getBodyDecl(i));
      }
    }
    if(c.isEmpty() && isClassDecl()) {
      Modifiers m = new Modifiers();
      if(isPublic()) m.addModifier(new Modifier("public"));
      else if(isProtected()) m.addModifier(new Modifier("protected"));
      else if(isPrivate()) m.addModifier(new Modifier("private"));
      addBodyDecl(
          new ConstructorDecl(
            m,
            name(),
            new List(),
            new List(),
            new Opt(),
            new Block()
          )
      );
      c.add(getBodyDecl(getNumBodyDecl()-1));
    }
    return c;
  }

    protected java.util.Map unqualifiedLookupMethod_String_values;
    // Declared in LookupMethod.jrag at line 24
    public Collection unqualifiedLookupMethod(String name) {
        Object _parameters = name;
if(unqualifiedLookupMethod_String_values == null) unqualifiedLookupMethod_String_values = new java.util.HashMap(4);
        if(unqualifiedLookupMethod_String_values.containsKey(_parameters))
            return (Collection)unqualifiedLookupMethod_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        Collection unqualifiedLookupMethod_String_value = unqualifiedLookupMethod_compute(name);
        if(isFinal && num == boundariesCrossed)
            unqualifiedLookupMethod_String_values.put(_parameters, unqualifiedLookupMethod_String_value);
        return unqualifiedLookupMethod_String_value;
    }

    private Collection unqualifiedLookupMethod_compute(String name)  {
    Collection c = memberMethods(name);
    if(!c.isEmpty()) return c;
    if(isInnerType())
      return lookupMethod(name);
    return removeInstanceMethods(lookupMethod(name));
  }

    // Declared in LookupMethod.jrag at line 179
    public Collection memberMethods(String name) {
        Collection memberMethods_String_value = memberMethods_compute(name);
        return memberMethods_String_value;
    }

    private Collection memberMethods_compute(String name)  {
    Collection c = (Collection)methodsNameMap().get(name);
    if(c != null) return c;
    return Collections.EMPTY_LIST;
  }

    protected boolean methodsNameMap_computed = false;
    protected HashMap methodsNameMap_value;
    // Declared in LookupMethod.jrag at line 185
    public HashMap methodsNameMap() {
        if(methodsNameMap_computed)
            return methodsNameMap_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        methodsNameMap_value = methodsNameMap_compute();
        if(isFinal && num == boundariesCrossed)
            methodsNameMap_computed = true;
        return methodsNameMap_value;
    }

    private HashMap methodsNameMap_compute()  {
    HashMap map = new HashMap();
    for(Iterator iter = methodsIterator(); iter.hasNext(); ) {
      MethodDecl m = (MethodDecl)iter.next();
      ArrayList list = (ArrayList)map.get(m.name());
      if(list == null) {
        list = new ArrayList(4);
        map.put(m.name(), list);
      }
      list.add(m);
    }
    return map;
  }

    // Declared in LookupMethod.jrag at line 216
    public SimpleSet localMethodsSignature(String signature) {
        SimpleSet localMethodsSignature_String_value = localMethodsSignature_compute(signature);
        return localMethodsSignature_String_value;
    }

    private SimpleSet localMethodsSignature_compute(String signature)  {
    SimpleSet set = (SimpleSet)localMethodsSignatureMap().get(signature);
    if(set != null) return set;
    return SimpleSet.emptySet;
  }

    protected boolean localMethodsSignatureMap_computed = false;
    protected HashMap localMethodsSignatureMap_value;
    // Declared in LookupMethod.jrag at line 222
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
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof MethodDecl) {
        MethodDecl decl = (MethodDecl)getBodyDecl(i);
        map.put(decl.signature(), decl);
      }
    }
    return map;
  }

    // Declared in LookupMethod.jrag at line 284
    public SimpleSet methodsSignature(String signature) {
        SimpleSet methodsSignature_String_value = methodsSignature_compute(signature);
        return methodsSignature_String_value;
    }

    private SimpleSet methodsSignature_compute(String signature)  {
    SimpleSet set = (SimpleSet)methodsSignatureMap().get(signature);
    if(set != null) return set;
    return SimpleSet.emptySet;
  }

    protected boolean methodsSignatureMap_computed = false;
    protected HashMap methodsSignatureMap_value;
    // Declared in LookupMethod.jrag at line 290
    public HashMap methodsSignatureMap() {
        if(methodsSignatureMap_computed)
            return methodsSignatureMap_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        methodsSignatureMap_value = methodsSignatureMap_compute();
        if(isFinal && num == boundariesCrossed)
            methodsSignatureMap_computed = true;
        return methodsSignatureMap_value;
    }

    private HashMap methodsSignatureMap_compute() {  return  localMethodsSignatureMap();  }

    protected java.util.Map ancestorMethods_String_values;
    // Declared in LookupMethod.jrag at line 347
    public SimpleSet ancestorMethods(String signature) {
        Object _parameters = signature;
if(ancestorMethods_String_values == null) ancestorMethods_String_values = new java.util.HashMap(4);
        if(ancestorMethods_String_values.containsKey(_parameters))
            return (SimpleSet)ancestorMethods_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet ancestorMethods_String_value = ancestorMethods_compute(signature);
        if(isFinal && num == boundariesCrossed)
            ancestorMethods_String_values.put(_parameters, ancestorMethods_String_value);
        return ancestorMethods_String_value;
    }

    private SimpleSet ancestorMethods_compute(String signature) {  return  SimpleSet.emptySet;  }

    // Declared in LookupType.jrag at line 331
    public boolean hasType(String name) {
        boolean hasType_String_value = hasType_compute(name);
        return hasType_String_value;
    }

    private boolean hasType_compute(String name) {  return  !memberTypes(name).isEmpty();  }

    protected java.util.Map memberTypes_String_values;
    // Declared in LookupType.jrag at line 341
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

    private SimpleSet memberTypes_compute(String name) {  return  SimpleSet.emptySet;  }

    protected java.util.Map memberFields_String_values;
    // Declared in LookupVariable.jrag at line 246
    public SimpleSet memberFields(String name) {
        Object _parameters = name;
if(memberFields_String_values == null) memberFields_String_values = new java.util.HashMap(4);
        if(memberFields_String_values.containsKey(_parameters))
            return (SimpleSet)memberFields_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        SimpleSet memberFields_String_value = memberFields_compute(name);
        if(isFinal && num == boundariesCrossed)
            memberFields_String_values.put(_parameters, memberFields_String_value);
        return memberFields_String_value;
    }

    private SimpleSet memberFields_compute(String name) {  return  fields(name);  }

    // Declared in LookupVariable.jrag at line 261
    public SimpleSet localFields(String name) {
        SimpleSet localFields_String_value = localFields_compute(name);
        return localFields_String_value;
    }

    private SimpleSet localFields_compute(String name) {  return  localFieldsMap().containsKey(name) ? (SimpleSet)localFieldsMap().get(name) : SimpleSet.emptySet;  }

    protected boolean localFieldsMap_computed = false;
    protected HashMap localFieldsMap_value;
    // Declared in LookupVariable.jrag at line 263
    public HashMap localFieldsMap() {
        if(localFieldsMap_computed)
            return localFieldsMap_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        localFieldsMap_value = localFieldsMap_compute();
        if(isFinal && num == boundariesCrossed)
            localFieldsMap_computed = true;
        return localFieldsMap_value;
    }

    private HashMap localFieldsMap_compute()  {
    HashMap map = new HashMap();
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof FieldDeclaration) {
        FieldDeclaration decl = (FieldDeclaration)getBodyDecl(i);
        SimpleSet fields = (SimpleSet)map.get(decl.name());
        if(fields == null) fields = SimpleSet.emptySet;
        fields = fields.add(decl);
        map.put(decl.name(), fields);
      }
    }
    return map;
  }

    // Declared in LookupVariable.jrag at line 277
    public SimpleSet fields(String name) {
        SimpleSet fields_String_value = fields_compute(name);
        return fields_String_value;
    }

    private SimpleSet fields_compute(String name) {  return  localFields(name);  }

    protected boolean hasAbstract_computed = false;
    protected boolean hasAbstract_value;
    // Declared in Modifiers.jrag at line 5
    public boolean hasAbstract() {
        if(hasAbstract_computed)
            return hasAbstract_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        hasAbstract_value = hasAbstract_compute();
        if(isFinal && num == boundariesCrossed)
            hasAbstract_computed = true;
        return hasAbstract_value;
    }

    private boolean hasAbstract_compute() {  return  false;  }

    protected boolean unimplementedMethods_computed = false;
    protected Collection unimplementedMethods_value;
    // Declared in Modifiers.jrag at line 7
    public Collection unimplementedMethods() {
        if(unimplementedMethods_computed)
            return unimplementedMethods_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        unimplementedMethods_value = unimplementedMethods_compute();
        if(isFinal && num == boundariesCrossed)
            unimplementedMethods_computed = true;
        return unimplementedMethods_value;
    }

    private Collection unimplementedMethods_compute() {  return  Collections.EMPTY_LIST;  }

    protected boolean isPublic_computed = false;
    protected boolean isPublic_value;
    // Declared in Modifiers.jrag at line 189
    public boolean isPublic() {
        if(isPublic_computed)
            return isPublic_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isPublic_value = isPublic_compute();
        if(isFinal && num == boundariesCrossed)
            isPublic_computed = true;
        return isPublic_value;
    }

    private boolean isPublic_compute() {  return  getModifiers().isPublic() || isMemberType() && enclosingType().isInterfaceDecl();  }

    // Declared in Modifiers.jrag at line 191
    public boolean isPrivate() {
        boolean isPrivate_value = isPrivate_compute();
        return isPrivate_value;
    }

    private boolean isPrivate_compute() {  return  getModifiers().isPrivate();  }

    // Declared in Modifiers.jrag at line 192
    public boolean isProtected() {
        boolean isProtected_value = isProtected_compute();
        return isProtected_value;
    }

    private boolean isProtected_compute() {  return  getModifiers().isProtected();  }

    // Declared in Modifiers.jrag at line 193
    public boolean isAbstract() {
        boolean isAbstract_value = isAbstract_compute();
        return isAbstract_value;
    }

    private boolean isAbstract_compute() {  return  getModifiers().isAbstract();  }

    protected boolean isStatic_computed = false;
    protected boolean isStatic_value;
    // Declared in Modifiers.jrag at line 195
    public boolean isStatic() {
        if(isStatic_computed)
            return isStatic_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isStatic_value = isStatic_compute();
        if(isFinal && num == boundariesCrossed)
            isStatic_computed = true;
        return isStatic_value;
    }

    private boolean isStatic_compute() {  return  getModifiers().isStatic() || isMemberType() && enclosingType().isInterfaceDecl();  }

    // Declared in Modifiers.jrag at line 198
    public boolean isFinal() {
        boolean isFinal_value = isFinal_compute();
        return isFinal_value;
    }

    private boolean isFinal_compute() {  return  getModifiers().isFinal();  }

    // Declared in Modifiers.jrag at line 199
    public boolean isStrictfp() {
        boolean isStrictfp_value = isStrictfp_compute();
        return isStrictfp_value;
    }

    private boolean isStrictfp_compute() {  return  getModifiers().isStrictfp();  }

    // Declared in Modifiers.jrag at line 201
    public boolean isSynthetic() {
        boolean isSynthetic_value = isSynthetic_compute();
        return isSynthetic_value;
    }

    private boolean isSynthetic_compute() {  return  getModifiers().isSynthetic();  }

    // Declared in NameCheck.jrag at line 257
    public boolean hasEnclosingTypeDecl(String name) {
        boolean hasEnclosingTypeDecl_String_value = hasEnclosingTypeDecl_compute(name);
        return hasEnclosingTypeDecl_String_value;
    }

    private boolean hasEnclosingTypeDecl_compute(String name)  {
    TypeDecl enclosingType = enclosingType();
    if(enclosingType != null) {
      return enclosingType.name().equals(name) || enclosingType.hasEnclosingTypeDecl(name);
    }
    return false;
  }

    // Declared in NameCheck.jrag at line 417
    public boolean assignableToInt() {
        boolean assignableToInt_value = assignableToInt_compute();
        return assignableToInt_value;
    }

    private boolean assignableToInt_compute() {  return  false;  }

    // Declared in PrettyPrint.jadd at line 945
    public String dumpString() {
        String dumpString_value = dumpString_compute();
        return dumpString_value;
    }

    private String dumpString_compute() {  return  getClass().getName() + " [" + getID() + "]";  }

    // Declared in QualifiedNames.jrag at line 59
    public String name() {
        String name_value = name_compute();
        return name_value;
    }

    private String name_compute() {  return  getID();  }

    protected boolean fullName_computed = false;
    protected String fullName_value;
    // Declared in QualifiedNames.jrag at line 61
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
      return enclosingType().fullName() + "." + name();
    String packageName = packageName();
    if(packageName.equals(""))
      return name();
    return packageName + "." + name();
  }

    protected boolean typeName_computed = false;
    protected String typeName_value;
    // Declared in QualifiedNames.jrag at line 70
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
      return enclosingType().typeName() + "." + name();
    String packageName = packageName();
    if(packageName.equals("") || packageName.equals(PRIMITIVE_PACKAGE_NAME))
      return name();
    return packageName + "." + name();
  }

    // Declared in TypeAnalysis.jrag at line 6
    public boolean identityConversionTo(TypeDecl type) {
        boolean identityConversionTo_TypeDecl_value = identityConversionTo_compute(type);
        return identityConversionTo_TypeDecl_value;
    }

    private boolean identityConversionTo_compute(TypeDecl type) {  return  this == type;  }

    // Declared in TypeAnalysis.jrag at line 8
    public boolean wideningConversionTo(TypeDecl type) {
        boolean wideningConversionTo_TypeDecl_value = wideningConversionTo_compute(type);
        return wideningConversionTo_TypeDecl_value;
    }

    private boolean wideningConversionTo_compute(TypeDecl type) {  return  instanceOf(type);  }

    protected java.util.Map narrowingConversionTo_TypeDecl_values;
    // Declared in TypeAnalysis.jrag at line 9
    public boolean narrowingConversionTo(TypeDecl type) {
        Object _parameters = type;
if(narrowingConversionTo_TypeDecl_values == null) narrowingConversionTo_TypeDecl_values = new java.util.HashMap(4);
        if(narrowingConversionTo_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)narrowingConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean narrowingConversionTo_TypeDecl_value = narrowingConversionTo_compute(type);
        if(isFinal && num == boundariesCrossed)
            narrowingConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(narrowingConversionTo_TypeDecl_value));
        return narrowingConversionTo_TypeDecl_value;
    }

    private boolean narrowingConversionTo_compute(TypeDecl type) {  return  instanceOf(type);  }

    // Declared in TypeAnalysis.jrag at line 46
    public boolean stringConversion() {
        boolean stringConversion_value = stringConversion_compute();
        return stringConversion_value;
    }

    private boolean stringConversion_compute() {  return  true;  }

    // Declared in AutoBoxing.jrag at line 68
    public boolean assignConversionTo(TypeDecl type, Expr expr) {
        boolean assignConversionTo_TypeDecl_Expr_value = assignConversionTo_compute(type, expr);
        return assignConversionTo_TypeDecl_Expr_value;
    }

    private boolean assignConversionTo_compute(TypeDecl type, Expr expr)  {
    if(refined_TypeAnalysis_assignConversionTo_TypeDecl_Expr(type, expr))
      return true;
    if(!boxed().isUnknown() && boxed().wideningConversionTo(type))
      return true;
    if(!unboxed().isUnknown() && unboxed().wideningConversionTo(type))
      return true;
    boolean sourceIsConstant = expr != null ? expr.isConstant() : false;
    if(sourceIsConstant && (isInt() || isChar() || isShort() || isByte()) &&
        (type.unboxed().isByte() || type.unboxed().isShort() || type.unboxed().isChar()) &&
        narrowingConversionTo(type) && expr.representableIn(type))
      return true;
    return false;
  }

    protected java.util.Map methodInvocationConversionTo_TypeDecl_values;
    // Declared in AutoBoxing.jrag at line 84
    public boolean methodInvocationConversionTo(TypeDecl type) {
        Object _parameters = type;
if(methodInvocationConversionTo_TypeDecl_values == null) methodInvocationConversionTo_TypeDecl_values = new java.util.HashMap(4);
        if(methodInvocationConversionTo_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)methodInvocationConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean methodInvocationConversionTo_TypeDecl_value = methodInvocationConversionTo_compute(type);
        if(isFinal && num == boundariesCrossed)
            methodInvocationConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(methodInvocationConversionTo_TypeDecl_value));
        return methodInvocationConversionTo_TypeDecl_value;
    }

    private boolean methodInvocationConversionTo_compute(TypeDecl type)  {
    if(refined_TypeAnalysis_methodInvocationConversionTo_TypeDecl(type))
      return true;
    if(!boxed().isUnknown() && boxed().wideningConversionTo(type))
      return true;
    if(!unboxed().isUnknown() && unboxed().wideningConversionTo(type))
      return true;
    return false;
  }

    protected java.util.Map castingConversionTo_TypeDecl_values;
    // Declared in AutoBoxing.jrag at line 95
    public boolean castingConversionTo(TypeDecl type) {
        Object _parameters = type;
if(castingConversionTo_TypeDecl_values == null) castingConversionTo_TypeDecl_values = new java.util.HashMap(4);
        if(castingConversionTo_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)castingConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean castingConversionTo_TypeDecl_value = castingConversionTo_compute(type);
        if(isFinal && num == boundariesCrossed)
            castingConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(castingConversionTo_TypeDecl_value));
        return castingConversionTo_TypeDecl_value;
    }

    private boolean castingConversionTo_compute(TypeDecl type)  {
    if(refined_TypeAnalysis_castingConversionTo_TypeDecl(type))
      return true;
    if(boxingConversionTo(type))
      return true;
    if(unboxingConversionTo(type))
      return true;
    return false;
  }

    // Declared in TypeAnalysis.jrag at line 137
    public TypeDecl unaryNumericPromotion() {
        TypeDecl unaryNumericPromotion_value = unaryNumericPromotion_compute();
        return unaryNumericPromotion_value;
    }

    private TypeDecl unaryNumericPromotion_compute() {  return  this;  }

    // Declared in TypeAnalysis.jrag at line 145
    public TypeDecl binaryNumericPromotion(TypeDecl type) {
        TypeDecl binaryNumericPromotion_TypeDecl_value = binaryNumericPromotion_compute(type);
        return binaryNumericPromotion_TypeDecl_value;
    }

    private TypeDecl binaryNumericPromotion_compute(TypeDecl type) {  return  unknownType();  }

    // Declared in TypeAnalysis.jrag at line 156
    public boolean isReferenceType() {
        boolean isReferenceType_value = isReferenceType_compute();
        return isReferenceType_value;
    }

    private boolean isReferenceType_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 159
    public boolean isPrimitiveType() {
        boolean isPrimitiveType_value = isPrimitiveType_compute();
        return isPrimitiveType_value;
    }

    private boolean isPrimitiveType_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 164
    public boolean isNumericType() {
        boolean isNumericType_value = isNumericType_compute();
        return isNumericType_value;
    }

    private boolean isNumericType_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 168
    public boolean isIntegralType() {
        boolean isIntegralType_value = isIntegralType_compute();
        return isIntegralType_value;
    }

    private boolean isIntegralType_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 172
    public boolean isBoolean() {
        boolean isBoolean_value = isBoolean_compute();
        return isBoolean_value;
    }

    private boolean isBoolean_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 176
    public boolean isByte() {
        boolean isByte_value = isByte_compute();
        return isByte_value;
    }

    private boolean isByte_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 178
    public boolean isChar() {
        boolean isChar_value = isChar_compute();
        return isChar_value;
    }

    private boolean isChar_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 180
    public boolean isShort() {
        boolean isShort_value = isShort_compute();
        return isShort_value;
    }

    private boolean isShort_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 182
    public boolean isInt() {
        boolean isInt_value = isInt_compute();
        return isInt_value;
    }

    private boolean isInt_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 186
    public boolean isFloat() {
        boolean isFloat_value = isFloat_compute();
        return isFloat_value;
    }

    private boolean isFloat_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 188
    public boolean isLong() {
        boolean isLong_value = isLong_compute();
        return isLong_value;
    }

    private boolean isLong_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 190
    public boolean isDouble() {
        boolean isDouble_value = isDouble_compute();
        return isDouble_value;
    }

    private boolean isDouble_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 193
    public boolean isVoid() {
        boolean isVoid_value = isVoid_compute();
        return isVoid_value;
    }

    private boolean isVoid_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 196
    public boolean isNull() {
        boolean isNull_value = isNull_compute();
        return isNull_value;
    }

    private boolean isNull_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 200
    public boolean isClassDecl() {
        boolean isClassDecl_value = isClassDecl_compute();
        return isClassDecl_value;
    }

    private boolean isClassDecl_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 202
    public boolean isInterfaceDecl() {
        boolean isInterfaceDecl_value = isInterfaceDecl_compute();
        return isInterfaceDecl_value;
    }

    private boolean isInterfaceDecl_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 204
    public boolean isArrayDecl() {
        boolean isArrayDecl_value = isArrayDecl_compute();
        return isArrayDecl_value;
    }

    private boolean isArrayDecl_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 212
    public boolean isPrimitive() {
        boolean isPrimitive_value = isPrimitive_compute();
        return isPrimitive_value;
    }

    private boolean isPrimitive_compute() {  return  false;  }

    protected boolean isString_computed = false;
    protected boolean isString_value;
    // Declared in TypeAnalysis.jrag at line 215
    public boolean isString() {
        if(isString_computed)
            return isString_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isString_value = isString_compute();
        if(isFinal && num == boundariesCrossed)
            isString_computed = true;
        return isString_value;
    }

    private boolean isString_compute() {  return  false;  }

    protected boolean isObject_computed = false;
    protected boolean isObject_value;
    // Declared in TypeAnalysis.jrag at line 218
    public boolean isObject() {
        if(isObject_computed)
            return isObject_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isObject_value = isObject_compute();
        if(isFinal && num == boundariesCrossed)
            isObject_computed = true;
        return isObject_value;
    }

    private boolean isObject_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 221
    public boolean isUnknown() {
        boolean isUnknown_value = isUnknown_compute();
        return isUnknown_value;
    }

    private boolean isUnknown_compute() {  return  false;  }

    protected java.util.Map instanceOf_TypeDecl_values;
    // Declared in GenericsSubtype.jrag at line 207
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

    // Declared in TypeAnalysis.jrag at line 421
    public boolean isSupertypeOfClassDecl(ClassDecl type) {
        boolean isSupertypeOfClassDecl_ClassDecl_value = isSupertypeOfClassDecl_compute(type);
        return isSupertypeOfClassDecl_ClassDecl_value;
    }

    private boolean isSupertypeOfClassDecl_compute(ClassDecl type) {  return  type == this;  }

    // Declared in TypeAnalysis.jrag at line 438
    public boolean isSupertypeOfInterfaceDecl(InterfaceDecl type) {
        boolean isSupertypeOfInterfaceDecl_InterfaceDecl_value = isSupertypeOfInterfaceDecl_compute(type);
        return isSupertypeOfInterfaceDecl_InterfaceDecl_value;
    }

    private boolean isSupertypeOfInterfaceDecl_compute(InterfaceDecl type) {  return  type == this;  }

    // Declared in TypeAnalysis.jrag at line 451
    public boolean isSupertypeOfArrayDecl(ArrayDecl type) {
        boolean isSupertypeOfArrayDecl_ArrayDecl_value = isSupertypeOfArrayDecl_compute(type);
        return isSupertypeOfArrayDecl_ArrayDecl_value;
    }

    private boolean isSupertypeOfArrayDecl_compute(ArrayDecl type) {  return  this == type;  }

    // Declared in TypeAnalysis.jrag at line 473
    public boolean isSupertypeOfPrimitiveType(PrimitiveType type) {
        boolean isSupertypeOfPrimitiveType_PrimitiveType_value = isSupertypeOfPrimitiveType_compute(type);
        return isSupertypeOfPrimitiveType_PrimitiveType_value;
    }

    private boolean isSupertypeOfPrimitiveType_compute(PrimitiveType type) {  return  type == this;  }

    // Declared in TypeAnalysis.jrag at line 480
    public boolean isSupertypeOfNullType(NullType type) {
        boolean isSupertypeOfNullType_NullType_value = isSupertypeOfNullType_compute(type);
        return isSupertypeOfNullType_NullType_value;
    }

    private boolean isSupertypeOfNullType_compute(NullType type) {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 484
    public boolean isSupertypeOfVoidType(VoidType type) {
        boolean isSupertypeOfVoidType_VoidType_value = isSupertypeOfVoidType_compute(type);
        return isSupertypeOfVoidType_VoidType_value;
    }

    private boolean isSupertypeOfVoidType_compute(VoidType type) {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 496
    public TypeDecl topLevelType() {
        TypeDecl topLevelType_value = topLevelType_compute();
        return topLevelType_value;
    }

    private TypeDecl topLevelType_compute()  {
    if(isTopLevelType())
      return this;
    return enclosingType().topLevelType();
  }

    // Declared in TypeAnalysis.jrag at line 516
    public boolean isTopLevelType() {
        boolean isTopLevelType_value = isTopLevelType_compute();
        return isTopLevelType_value;
    }

    private boolean isTopLevelType_compute() {  return  !isNestedType();  }

    // Declared in TypeAnalysis.jrag at line 527
    public boolean isInnerClass() {
        boolean isInnerClass_value = isInnerClass_compute();
        return isInnerClass_value;
    }

    private boolean isInnerClass_compute() {  return  false;  }

    // Declared in TypeAnalysis.jrag at line 529
    public boolean isInnerType() {
        boolean isInnerType_value = isInnerType_compute();
        return isInnerType_value;
    }

    private boolean isInnerType_compute() {  return  (isLocalClass() || isAnonymous() || (isMemberType() && !isStatic())) && !inStaticContext();  }

    // Declared in TypeAnalysis.jrag at line 531
    public boolean isInnerTypeOf(TypeDecl typeDecl) {
        boolean isInnerTypeOf_TypeDecl_value = isInnerTypeOf_compute(typeDecl);
        return isInnerTypeOf_TypeDecl_value;
    }

    private boolean isInnerTypeOf_compute(TypeDecl typeDecl) {  return  typeDecl == this || (isInnerType() && enclosingType().isInnerTypeOf(typeDecl));  }

    // Declared in TypeAnalysis.jrag at line 538
    public TypeDecl withinBodyThatSubclasses(TypeDecl type) {
        TypeDecl withinBodyThatSubclasses_TypeDecl_value = withinBodyThatSubclasses_compute(type);
        return withinBodyThatSubclasses_TypeDecl_value;
    }

    private TypeDecl withinBodyThatSubclasses_compute(TypeDecl type)  {
    if(instanceOf(type))
      return this;
    if(!isTopLevelType())
      return enclosingType().withinBodyThatSubclasses(type);
    return null;
  }

    // Declared in TypeAnalysis.jrag at line 546
    public boolean encloses(TypeDecl type) {
        boolean encloses_TypeDecl_value = encloses_compute(type);
        return encloses_TypeDecl_value;
    }

    private boolean encloses_compute(TypeDecl type) {  return  type.enclosedBy(this);  }

    // Declared in TypeAnalysis.jrag at line 548
    public boolean enclosedBy(TypeDecl type) {
        boolean enclosedBy_TypeDecl_value = enclosedBy_compute(type);
        return enclosedBy_TypeDecl_value;
    }

    private boolean enclosedBy_compute(TypeDecl type)  {
    if(this == type)
      return true;
    if(isTopLevelType())
      return false;
    return enclosingType().enclosedBy(type);
  }

    // Declared in TypeAnalysis.jrag at line 562
    public TypeDecl hostType() {
        TypeDecl hostType_value = hostType_compute();
        return hostType_value;
    }

    private TypeDecl hostType_compute() {  return  this;  }

    protected boolean isCircular_visited = false;
    protected boolean isCircular_computed = false;
    protected boolean isCircular_initialized = false;
    protected boolean isCircular_value;
    public boolean isCircular() {
        if(isCircular_computed)
            return isCircular_value;
        if (!isCircular_initialized) {
            isCircular_initialized = true;
            isCircular_value = true;
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            isCircular_visited = true;
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            do {
                CHANGE = false;
                boolean new_isCircular_value = isCircular_compute();
                if (new_isCircular_value!=isCircular_value)
                    CHANGE = true;
                isCircular_value = new_isCircular_value; 
            } while (CHANGE);
            isCircular_visited = false;
            if(isFinal && num == boundariesCrossed)
{
            isCircular_computed = true;
            }
            else {
            RESET_CYCLE = true;
            isCircular_compute();
            RESET_CYCLE = false;
              isCircular_computed = false;
              isCircular_initialized = false;
            }
            IN_CIRCLE = false; 
            return isCircular_value;
        }
        if(!isCircular_visited) {
            if (RESET_CYCLE) {
                isCircular_computed = false;
                isCircular_initialized = false;
                return isCircular_value;
            }
            isCircular_visited = true;
            boolean new_isCircular_value = isCircular_compute();
            if (new_isCircular_value!=isCircular_value)
                CHANGE = true;
            isCircular_value = new_isCircular_value; 
            isCircular_visited = false;
            return isCircular_value;
        }
        return isCircular_value;
    }

    private boolean isCircular_compute() {  return  false;  }

    protected boolean innerClassesAttributeEntries_computed = false;
    protected Collection innerClassesAttributeEntries_value;
    // Declared in Attributes.jrag at line 74
    public Collection innerClassesAttributeEntries() {
        if(innerClassesAttributeEntries_computed)
            return innerClassesAttributeEntries_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        innerClassesAttributeEntries_value = innerClassesAttributeEntries_compute();
        if(isFinal && num == boundariesCrossed)
            innerClassesAttributeEntries_computed = true;
        return innerClassesAttributeEntries_value;
    }

    private Collection innerClassesAttributeEntries_compute()  {
    HashSet list = new HashSet();
    if(isNestedType())
      list.add(this);
    for(Iterator iter = nestedTypes().iterator(); iter.hasNext(); )
      list.add(iter.next());
    for(Iterator iter = usedNestedTypes().iterator(); iter.hasNext(); )
      list.add(iter.next());
    return list;
  }

    protected boolean attributes_computed = false;
    protected Collection attributes_value;
    // Declared in GenericsCodegen.jrag at line 271
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
      c.add(new SignatureAttribute(constantPool(), classSignature()));
    return c;
  }

    protected boolean clinit_attributes_computed = false;
    protected Collection clinit_attributes_value;
    // Declared in Attributes.jrag at line 201
    public Collection clinit_attributes() {
        if(clinit_attributes_computed)
            return clinit_attributes_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        clinit_attributes_value = clinit_attributes_compute();
        if(isFinal && num == boundariesCrossed)
            clinit_attributes_computed = true;
        return clinit_attributes_value;
    }

    private Collection clinit_attributes_compute()  {
    ArrayList l = new ArrayList();
    l.add(new CodeAttribute(bytecodes(constantPool()), null));
    return l;
  }

    // Declared in CodeGeneration.jrag at line 578
    public byte arrayLoad() {
        byte arrayLoad_value = arrayLoad_compute();
        return arrayLoad_value;
    }

    private byte arrayLoad_compute()  { 
    throw new Error("Cannot create array load for TypeDecl");
  }

    // Declared in CodeGeneration.jrag at line 680
    public byte arrayStore() {
        byte arrayStore_value = arrayStore_compute();
        return arrayStore_value;
    }

    private byte arrayStore_compute()  { 
    throw new Error("Cannot create array load for TypeDecl");
  }

    protected boolean constantPool_computed = false;
    protected ConstantPool constantPool_value;
    // Declared in ConstantPool.jrag at line 4
    public ConstantPool constantPool() {
        if(constantPool_computed)
            return constantPool_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        constantPool_value = constantPool_compute();
        if(isFinal && num == boundariesCrossed)
            constantPool_computed = true;
        return constantPool_value;
    }

    private ConstantPool constantPool_compute() {  return  new ConstantPool(this);  }

    protected boolean typeDescriptor_computed = false;
    protected String typeDescriptor_value;
    // Declared in ConstantPoolNames.jrag at line 3
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

    private String typeDescriptor_compute()  {
    throw new Error("Can not compute typeDescriptor for " + getClass().getName());
  }

    protected boolean hasClinit_computed = false;
    protected boolean hasClinit_value;
    // Declared in CreateBCode.jrag at line 7
    public boolean hasClinit() {
        if(hasClinit_computed)
            return hasClinit_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        hasClinit_value = hasClinit_compute();
        if(isFinal && num == boundariesCrossed)
            hasClinit_computed = true;
        return hasClinit_value;
    }

    private boolean hasClinit_compute()  {
    for(int i = 0; i < getNumBodyDecl(); i++) {
      BodyDecl b = getBodyDecl(i);
      if(b instanceof FieldDeclaration) {
        FieldDeclaration f = (FieldDeclaration)b;
        if(f.isStatic() && f.hasInit()) {
          return true;
        }
      }
      else if(b instanceof StaticInitializer) {
        return true;
      }
    }
    return false;
  }

    protected java.util.Map bytecodes_ConstantPool_values;
    // Declared in CreateBCode.jrag at line 23
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
    for(int i = 0; i < getNumBodyDecl(); i++) {
      BodyDecl b = getBodyDecl(i);
      if(b instanceof FieldDeclaration && b.isBytecodeField()) {
        FieldDeclaration f = (FieldDeclaration)b;
        if(f.isStatic() && f.hasInit()) {
          f.getInit().createBCode(gen);
          f.getInit().type().emitAssignConvTo(gen, f.type()); // AssignConversion
          f.emitStoreField(gen, this);
        }
      }
      else if(b instanceof StaticInitializer) {
        b.createBCode(gen);
      }
    }
    gen.emitReturn();
    return gen;
  }

    // Declared in CreateBCode.jrag at line 579
    public boolean hasMethod(String id) {
        boolean hasMethod_String_value = hasMethod_compute(id);
        return hasMethod_String_value;
    }

    private boolean hasMethod_compute(String id)  {
    if(!memberMethods(id).isEmpty()) return true;
    for(int i = 0; i < getNumBodyDecl(); i++) {
      if(getBodyDecl(i) instanceof MethodDecl) {
        MethodDecl decl = (MethodDecl)getBodyDecl(i);
        if(decl.name().equals(id))
          return true;
      }
    }
    return false;
  }

    // Declared in CreateBCode.jrag at line 875
    public String arrayTypeDescriptor() {
        String arrayTypeDescriptor_value = arrayTypeDescriptor_compute();
        return arrayTypeDescriptor_value;
    }

    private String arrayTypeDescriptor_compute()  { throw new Error("Operation not supported"); }

    // Declared in CreateBCode.jrag at line 880
    public int arrayPrimitiveTypeDescriptor() {
        int arrayPrimitiveTypeDescriptor_value = arrayPrimitiveTypeDescriptor_compute();
        return arrayPrimitiveTypeDescriptor_value;
    }

    private int arrayPrimitiveTypeDescriptor_compute()  { error(); return -1; }

    // Declared in CreateBCode.jrag at line 955
    public TypeDecl stringPromotion() {
        TypeDecl stringPromotion_value = stringPromotion_compute();
        return stringPromotion_value;
    }

    private TypeDecl stringPromotion_compute() {  return  this;  }

    protected boolean flags_computed = false;
    protected int flags_value;
    // Declared in Flags.jrag at line 55
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
    // ACC_INTERFACE handled in InterfaceDecl
    if(isAbstract()) res |= Modifiers.ACC_ABSTRACT;
    return res;
  }

    // Declared in GenerateClassfile.jrag at line 25
    public int magicHeader() {
        int magicHeader_value = magicHeader_compute();
        return magicHeader_value;
    }

    private int magicHeader_compute() {  return  0xCAFEBABE;  }

    // Declared in GenerateClassfile.jrag at line 26
    public int minorVersion() {
        int minorVersion_value = minorVersion_compute();
        return minorVersion_value;
    }

    private int minorVersion_compute() {  return  0;  }

    // Declared in Version.jrag at line 2
    public int majorVersion() {
        int majorVersion_value = majorVersion_compute();
        return majorVersion_value;
    }

    private int majorVersion_compute() {  return  49;  }

    protected boolean bcFields_computed = false;
    protected Collection bcFields_value;
    // Declared in GenerateClassfile.jrag at line 304
    public Collection bcFields() {
        if(bcFields_computed)
            return bcFields_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        bcFields_value = bcFields_compute();
        if(isFinal && num == boundariesCrossed)
            bcFields_computed = true;
        return bcFields_value;
    }

    private Collection bcFields_compute() {  return  new ArrayList();  }

    // Declared in GenerateClassfile.jrag at line 350
    public boolean flush() {
        boolean flush_value = flush_compute();
        return flush_value;
    }

    private boolean flush_compute() {  return  false;  }

    protected boolean constantPoolName_computed = false;
    protected String constantPoolName_value;
    // Declared in InnerClasses.jrag at line 27
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

    private String constantPoolName_compute()  {
    if(!isNestedType()) {
      String packageName = packageName();
      if(!packageName.equals("")) {
        packageName = packageName.replace('.', '/') + "/";
      }
      return packageName + name();
    }
    else {
      String prefix = enclosingType().constantPoolName();
      if(isAnonymous()) {
        int index = topLevelType().constantPoolNameIndex++;
        return prefix + "$" + index;
      }
      else if(isLocalClass()) {
        int index = topLevelType().constantPoolNameIndex++;
        return prefix + "$" + index + name();
      }
      return prefix + "$" + name();
    }
  }

    protected boolean enclosingVariables_computed = false;
    protected Collection enclosingVariables_value;
    // Declared in InnerClasses.jrag at line 51
    public Collection enclosingVariables() {
        if(enclosingVariables_computed)
            return enclosingVariables_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        enclosingVariables_value = enclosingVariables_compute();
        if(isFinal && num == boundariesCrossed)
            enclosingVariables_computed = true;
        return enclosingVariables_value;
    }

    private Collection enclosingVariables_compute()  {
    HashSet set = new HashSet();
    for(TypeDecl e = this; e != null; e = e.enclosingType()) {
      if(e.isLocalClass() || e.isAnonymous()) {
        collectEnclosingVariables(set, e.enclosingType());
      }
    }
    if(isClassDecl()) {
      ClassDecl classDecl = (ClassDecl)this;
      if(classDecl.isNestedType() && classDecl.hasSuperclass())
        set.addAll(classDecl.superclass().enclosingVariables());
    }
    return set;
  }

    // Declared in InnerClasses.jrag at line 282
    public boolean isAnonymousInNonStaticContext() {
        boolean isAnonymousInNonStaticContext_value = isAnonymousInNonStaticContext_compute();
        return isAnonymousInNonStaticContext_value;
    }

    private boolean isAnonymousInNonStaticContext_compute()  {
    return isAnonymous() && !((ClassInstanceExpr)getParent().getParent()).unqualifiedScope().inStaticContext() && !inExplicitConstructorInvocation();
  }

    // Declared in InnerClasses.jrag at line 286
    public boolean needsEnclosing() {
        boolean needsEnclosing_value = needsEnclosing_compute();
        return needsEnclosing_value;
    }

    private boolean needsEnclosing_compute()  {
    if(isAnonymous())
      return isAnonymousInNonStaticContext();
    else if(isLocalClass())
      return !inStaticContext();
    else if(isInnerType())
      return true;
    return false;
  }

    // Declared in InnerClasses.jrag at line 296
    public boolean needsSuperEnclosing() {
        boolean needsSuperEnclosing_value = needsSuperEnclosing_compute();
        return needsSuperEnclosing_value;
    }

    private boolean needsSuperEnclosing_compute()  {
    if(!isAnonymous())
      return false;
    TypeDecl superClass = ((ClassDecl)this).superclass();
    if(superClass.isLocalClass())
      return !superClass.inStaticContext();
    else if(superClass.isInnerType())
      return true;
    return false;
  }

    // Declared in Java2Rewrites.jrag at line 5
    public String primitiveClassName() {
        String primitiveClassName_value = primitiveClassName_compute();
        return primitiveClassName_value;
    }

    private String primitiveClassName_compute()  {
    throw new Error("primitiveClassName not supported for " + name() + " of type " + getClass().getName());
  }

    // Declared in Java2Rewrites.jrag at line 18
    public String referenceClassName() {
        String referenceClassName_value = referenceClassName_compute();
        return referenceClassName_value;
    }

    private String referenceClassName_compute()  {
    throw new Error("referenceClassName not supported for " + name() + " of type " + getClass().getName());
  }

    // Declared in Java2Rewrites.jrag at line 25
    public String referenceClassFieldName() {
        String referenceClassFieldName_value = referenceClassFieldName_compute();
        return referenceClassFieldName_value;
    }

    private String referenceClassFieldName_compute()  {
    throw new Error("referenceClassFieldName not supported for " + name() + " of type " + getClass().getName());
  }

    // Declared in LocalNum.jrag at line 111
    public int variableSize() {
        int variableSize_value = variableSize_compute();
        return variableSize_value;
    }

    private int variableSize_compute() {  return  0;  }

    // Declared in Annotations.jrag at line 109
    public boolean isValidAnnotationMethodReturnType() {
        boolean isValidAnnotationMethodReturnType_value = isValidAnnotationMethodReturnType_compute();
        return isValidAnnotationMethodReturnType_value;
    }

    private boolean isValidAnnotationMethodReturnType_compute() {  return  false;  }

    // Declared in Annotations.jrag at line 219
    public Annotation annotation(String packageName, String annotationName) {
        Annotation annotation_String_String_value = annotation_compute(packageName, annotationName);
        return annotation_String_String_value;
    }

    private Annotation annotation_compute(String packageName, String annotationName) {  return 
    getModifiers().annotation(packageName, annotationName);  }

    // Declared in Annotations.jrag at line 278
    public boolean hasAnnotationSuppressWarnings(String s) {
        boolean hasAnnotationSuppressWarnings_String_value = hasAnnotationSuppressWarnings_compute(s);
        return hasAnnotationSuppressWarnings_String_value;
    }

    private boolean hasAnnotationSuppressWarnings_compute(String s) {  return  getModifiers().hasAnnotationSuppressWarnings(s);  }

    // Declared in Annotations.jrag at line 317
    public boolean isDeprecated() {
        boolean isDeprecated_value = isDeprecated_compute();
        return isDeprecated_value;
    }

    private boolean isDeprecated_compute() {  return  getModifiers().hasDeprecatedAnnotation();  }

    // Declared in Annotations.jrag at line 468
    public boolean commensurateWith(ElementValue value) {
        boolean commensurateWith_ElementValue_value = commensurateWith_compute(value);
        return commensurateWith_ElementValue_value;
    }

    private boolean commensurateWith_compute(ElementValue value) {  return  value.commensurateWithTypeDecl(this);  }

    // Declared in Annotations.jrag at line 537
    public boolean isAnnotationDecl() {
        boolean isAnnotationDecl_value = isAnnotationDecl_compute();
        return isAnnotationDecl_value;
    }

    private boolean isAnnotationDecl_compute() {  return  false;  }

    // Declared in AutoBoxing.jrag at line 22
    public boolean boxingConversionTo(TypeDecl typeDecl) {
        boolean boxingConversionTo_TypeDecl_value = boxingConversionTo_compute(typeDecl);
        return boxingConversionTo_TypeDecl_value;
    }

    private boolean boxingConversionTo_compute(TypeDecl typeDecl) {  return  false;  }

    protected boolean boxed_computed = false;
    protected TypeDecl boxed_value;
    // Declared in AutoBoxing.jrag at line 26
    public TypeDecl boxed() {
        if(boxed_computed)
            return boxed_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boxed_value = boxed_compute();
        if(isFinal && num == boundariesCrossed)
            boxed_computed = true;
        return boxed_value;
    }

    private TypeDecl boxed_compute() {  return  unknownType();  }

    // Declared in AutoBoxing.jrag at line 38
    public boolean unboxingConversionTo(TypeDecl typeDecl) {
        boolean unboxingConversionTo_TypeDecl_value = unboxingConversionTo_compute(typeDecl);
        return unboxingConversionTo_TypeDecl_value;
    }

    private boolean unboxingConversionTo_compute(TypeDecl typeDecl) {  return  false;  }

    protected boolean unboxed_computed = false;
    protected TypeDecl unboxed_value;
    // Declared in AutoBoxing.jrag at line 42
    public TypeDecl unboxed() {
        if(unboxed_computed)
            return unboxed_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        unboxed_value = unboxed_compute();
        if(isFinal && num == boundariesCrossed)
            unboxed_computed = true;
        return unboxed_value;
    }

    private TypeDecl unboxed_compute() {  return  unknownType();  }

    protected boolean isIterable_computed = false;
    protected boolean isIterable_value;
/**
	 * True if type is java.lang.Iterable or subtype
	   As long as we use the 1.4 API we check for java.util.Collection instead.
	 
    Declared in EnhancedFor.jrag at line 17
*/
    public boolean isIterable() {
        if(isIterable_computed)
            return isIterable_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isIterable_value = isIterable_compute();
        if(isFinal && num == boundariesCrossed)
            isIterable_computed = true;
        return isIterable_value;
    }

    private boolean isIterable_compute() {  return  instanceOf(lookupType("java.lang", "Iterable"));  }

    // Declared in Enums.jrag at line 7
    public boolean isEnumDecl() {
        boolean isEnumDecl_value = isEnumDecl_compute();
        return isEnumDecl_value;
    }

    private boolean isEnumDecl_compute() {  return  false;  }

    // Declared in GenericMethodsInference.jrag at line 4
    public boolean isUnboxedPrimitive() {
        boolean isUnboxedPrimitive_value = isUnboxedPrimitive_compute();
        return isUnboxedPrimitive_value;
    }

    private boolean isUnboxedPrimitive_compute() {  return  this instanceof PrimitiveType && isPrimitive();  }

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

    private boolean involvesTypeParameters_compute() {  return  false;  }

    // Declared in Generics.jrag at line 82
    public boolean isGenericType() {
        boolean isGenericType_value = isGenericType_compute();
        return isGenericType_value;
    }

    private boolean isGenericType_compute() {  return  false;  }

    // Declared in Generics.jrag at line 156
    public boolean isParameterizedType() {
        boolean isParameterizedType_value = isParameterizedType_compute();
        return isParameterizedType_value;
    }

    private boolean isParameterizedType_compute() {  return  false;  }

    // Declared in Generics.jrag at line 159
    public boolean isRawType() {
        boolean isRawType_value = isRawType_compute();
        return isRawType_value;
    }

    private boolean isRawType_compute() {  return  false;  }

    protected boolean erasure_computed = false;
    protected TypeDecl erasure_value;
    // Declared in Generics.jrag at line 211
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

    private TypeDecl erasure_compute()  {
    if(isAnonymous() || isLocalClass())
      return this;
    if(!isNestedType())
      return this;
    return extractSingleType(enclosingType().erasure().memberTypes(name()));
  }

    protected boolean implementedInterfaces_computed = false;
    protected HashSet implementedInterfaces_value;
    // Declared in Generics.jrag at line 267
    public HashSet implementedInterfaces() {
        if(implementedInterfaces_computed)
            return implementedInterfaces_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        implementedInterfaces_value = implementedInterfaces_compute();
        if(isFinal && num == boundariesCrossed)
            implementedInterfaces_computed = true;
        return implementedInterfaces_value;
    }

    private HashSet implementedInterfaces_compute() {  return  new HashSet();  }

    // Declared in Generics.jrag at line 426
    public boolean sameSignature(Access a) {
        boolean sameSignature_Access_value = sameSignature_compute(a);
        return sameSignature_Access_value;
    }

    private boolean sameSignature_compute(Access a)  {
    if(a instanceof ParTypeAccess) return false;
    if(a instanceof AbstractWildcard) return false;
    return this == a.type();
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

    private boolean usesTypeVariable_compute() {  return  false;  }

    // Declared in Generics.jrag at line 1002
    public TypeDecl asWildcardExtends() {
        TypeDecl asWildcardExtends_value = asWildcardExtends_compute();
        return asWildcardExtends_value;
    }

    private TypeDecl asWildcardExtends_compute() {  return  lookupWildcardExtends(this);  }

    // Declared in Generics.jrag at line 1015
    public TypeDecl asWildcardSuper() {
        TypeDecl asWildcardSuper_value = asWildcardSuper_compute();
        return asWildcardSuper_value;
    }

    private TypeDecl asWildcardSuper_compute() {  return  lookupWildcardSuper(this);  }

    // Declared in GenericsParTypeDecl.jrag at line 61
    public boolean isTypeVariable() {
        boolean isTypeVariable_value = isTypeVariable_compute();
        return isTypeVariable_value;
    }

    private boolean isTypeVariable_compute() {  return  false;  }

    // Declared in GenericsSubtype.jrag at line 5
    public boolean supertypeGenericClassDecl(GenericClassDecl type) {
        boolean supertypeGenericClassDecl_GenericClassDecl_value = supertypeGenericClassDecl_compute(type);
        return supertypeGenericClassDecl_GenericClassDecl_value;
    }

    private boolean supertypeGenericClassDecl_compute(GenericClassDecl type) {  return 
    supertypeClassDecl(type);  }

    // Declared in GenericsSubtype.jrag at line 11
    public boolean supertypeGenericInterfaceDecl(GenericInterfaceDecl type) {
        boolean supertypeGenericInterfaceDecl_GenericInterfaceDecl_value = supertypeGenericInterfaceDecl_compute(type);
        return supertypeGenericInterfaceDecl_GenericInterfaceDecl_value;
    }

    private boolean supertypeGenericInterfaceDecl_compute(GenericInterfaceDecl type) {  return 
    this == type || supertypeInterfaceDecl(type);  }

    // Declared in GenericsSubtype.jrag at line 17
    public boolean supertypeRawClassDecl(RawClassDecl type) {
        boolean supertypeRawClassDecl_RawClassDecl_value = supertypeRawClassDecl_compute(type);
        return supertypeRawClassDecl_RawClassDecl_value;
    }

    private boolean supertypeRawClassDecl_compute(RawClassDecl type) {  return 
    supertypeParClassDecl(type);  }

    // Declared in GenericsSubtype.jrag at line 21
    public boolean supertypeRawInterfaceDecl(RawInterfaceDecl type) {
        boolean supertypeRawInterfaceDecl_RawInterfaceDecl_value = supertypeRawInterfaceDecl_compute(type);
        return supertypeRawInterfaceDecl_RawInterfaceDecl_value;
    }

    private boolean supertypeRawInterfaceDecl_compute(RawInterfaceDecl type) {  return 
    supertypeParInterfaceDecl(type);  }

    // Declared in GenericsSubtype.jrag at line 37
    public boolean supertypeWildcard(WildcardType type) {
        boolean supertypeWildcard_WildcardType_value = supertypeWildcard_compute(type);
        return supertypeWildcard_WildcardType_value;
    }

    private boolean supertypeWildcard_compute(WildcardType type) {  return  false;  }

    // Declared in GenericsSubtype.jrag at line 48
    public boolean supertypeWildcardExtends(WildcardExtendsType type) {
        boolean supertypeWildcardExtends_WildcardExtendsType_value = supertypeWildcardExtends_compute(type);
        return supertypeWildcardExtends_WildcardExtendsType_value;
    }

    private boolean supertypeWildcardExtends_compute(WildcardExtendsType type) {  return  false;  }

    // Declared in GenericsSubtype.jrag at line 57
    public boolean supertypeWildcardSuper(WildcardSuperType type) {
        boolean supertypeWildcardSuper_WildcardSuperType_value = supertypeWildcardSuper_compute(type);
        return supertypeWildcardSuper_WildcardSuperType_value;
    }

    private boolean supertypeWildcardSuper_compute(WildcardSuperType type) {  return  false;  }

    // Declared in GenericsSubtype.jrag at line 93
    public boolean isWildcard() {
        boolean isWildcard_value = isWildcard_compute();
        return isWildcard_value;
    }

    private boolean isWildcard_compute() {  return  false;  }

    // Declared in GenericsSubtype.jrag at line 116
    public boolean supertypeParClassDecl(ParClassDecl type) {
        boolean supertypeParClassDecl_ParClassDecl_value = supertypeParClassDecl_compute(type);
        return supertypeParClassDecl_ParClassDecl_value;
    }

    private boolean supertypeParClassDecl_compute(ParClassDecl type) {  return 
    supertypeClassDecl(type);  }

    // Declared in GenericsSubtype.jrag at line 120
    public boolean supertypeParInterfaceDecl(ParInterfaceDecl type) {
        boolean supertypeParInterfaceDecl_ParInterfaceDecl_value = supertypeParInterfaceDecl_compute(type);
        return supertypeParInterfaceDecl_ParInterfaceDecl_value;
    }

    private boolean supertypeParInterfaceDecl_compute(ParInterfaceDecl type) {  return 
    supertypeInterfaceDecl(type);  }

    // Declared in GenericsSubtype.jrag at line 183
    public boolean supertypeTypeVariable(TypeVariable type) {
        boolean supertypeTypeVariable_TypeVariable_value = supertypeTypeVariable_compute(type);
        return supertypeTypeVariable_TypeVariable_value;
    }

    private boolean supertypeTypeVariable_compute(TypeVariable type)  {
    if(type == this)
      return true;
    for(int i = 0; i < type.getNumTypeBound(); i++)
      if(type.getTypeBound(i).type().subtype(this))
        return true;
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

    private boolean subtype_compute(TypeDecl type) {  return 
    type == this;  }

    // Declared in GenericsSubtype.jrag at line 242
    public boolean supertypeClassDecl(ClassDecl type) {
        boolean supertypeClassDecl_ClassDecl_value = supertypeClassDecl_compute(type);
        return supertypeClassDecl_ClassDecl_value;
    }

    private boolean supertypeClassDecl_compute(ClassDecl type) {  return  type == this;  }

    // Declared in GenericsSubtype.jrag at line 258
    public boolean supertypeInterfaceDecl(InterfaceDecl type) {
        boolean supertypeInterfaceDecl_InterfaceDecl_value = supertypeInterfaceDecl_compute(type);
        return supertypeInterfaceDecl_InterfaceDecl_value;
    }

    private boolean supertypeInterfaceDecl_compute(InterfaceDecl type) {  return  type == this;  }

    // Declared in GenericsSubtype.jrag at line 271
    public boolean supertypeArrayDecl(ArrayDecl type) {
        boolean supertypeArrayDecl_ArrayDecl_value = supertypeArrayDecl_compute(type);
        return supertypeArrayDecl_ArrayDecl_value;
    }

    private boolean supertypeArrayDecl_compute(ArrayDecl type) {  return  this == type;  }

    // Declared in GenericsSubtype.jrag at line 293
    public boolean supertypePrimitiveType(PrimitiveType type) {
        boolean supertypePrimitiveType_PrimitiveType_value = supertypePrimitiveType_compute(type);
        return supertypePrimitiveType_PrimitiveType_value;
    }

    private boolean supertypePrimitiveType_compute(PrimitiveType type) {  return  type == this;  }

    // Declared in GenericsSubtype.jrag at line 300
    public boolean supertypeNullType(NullType type) {
        boolean supertypeNullType_NullType_value = supertypeNullType_compute(type);
        return supertypeNullType_NullType_value;
    }

    private boolean supertypeNullType_compute(NullType type) {  return  false;  }

    // Declared in GenericsSubtype.jrag at line 304
    public boolean supertypeVoidType(VoidType type) {
        boolean supertypeVoidType_VoidType_value = supertypeVoidType_compute(type);
        return supertypeVoidType_VoidType_value;
    }

    private boolean supertypeVoidType_compute(VoidType type) {  return  false;  }

    protected java.util.Map createEnumMethod_TypeDecl_values;
    // Declared in EnumsCodegen.jrag at line 33
    public MethodDecl createEnumMethod(TypeDecl enumDecl) {
        Object _parameters = enumDecl;
if(createEnumMethod_TypeDecl_values == null) createEnumMethod_TypeDecl_values = new java.util.HashMap(4);
        if(createEnumMethod_TypeDecl_values.containsKey(_parameters))
            return (MethodDecl)createEnumMethod_TypeDecl_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        MethodDecl createEnumMethod_TypeDecl_value = createEnumMethod_compute(enumDecl);
        if(isFinal && num == boundariesCrossed)
            createEnumMethod_TypeDecl_values.put(_parameters, createEnumMethod_TypeDecl_value);
        return createEnumMethod_TypeDecl_value;
    }

    private MethodDecl createEnumMethod_compute(TypeDecl enumDecl)  {
    MethodDecl m = new MethodDecl(
      new Modifiers(new List().add(new Modifier("static")).add(new Modifier("final")).add(new Modifier("private"))),
      typeInt().arrayType().createQualifiedAccess(),
      "$SwitchMap$" + enumDecl.fullName().replace('.', '$'),
      new List(),
      new List(),
      new List(),
      new Opt(
        new Block(
          new List().add(
            new IfStmt(
              new EQExpr(
                createEnumArray(enumDecl).createBoundFieldAccess(),
                new NullLiteral("null")
              ),
              AssignExpr.asStmt(
                createEnumArray(enumDecl).createBoundFieldAccess(),
                new ArrayCreationExpr(
                  typeInt().createQualifiedAccess(),
                  new List().add(
                    new Dims(
                      new Opt(
                        enumDecl.createQualifiedAccess().qualifiesAccess(
                        new MethodAccess("values", new List())).qualifiesAccess(
                        new VarAccess("length"))
                      )
                    )
                  ),
                  new Opt()
                )
              ),
              new Opt()
            )
          ).add(
            new ReturnStmt(
              createEnumArray(enumDecl).createBoundFieldAccess()
            )
          )
        )
      )
    );
    // add method declaration as a body declaration
    getBodyDeclList().insertChild(m, 1);
    // trigger possible rewrites
    return (MethodDecl)getBodyDeclList().getChild(1);
  }

    protected java.util.Map createEnumIndex_EnumConstant_values;
    // Declared in EnumsCodegen.jrag at line 82
    public int createEnumIndex(EnumConstant e) {
        Object _parameters = e;
if(createEnumIndex_EnumConstant_values == null) createEnumIndex_EnumConstant_values = new java.util.HashMap(4);
        if(createEnumIndex_EnumConstant_values.containsKey(_parameters))
            return ((Integer)createEnumIndex_EnumConstant_values.get(_parameters)).intValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        int createEnumIndex_EnumConstant_value = createEnumIndex_compute(e);
        if(isFinal && num == boundariesCrossed)
            createEnumIndex_EnumConstant_values.put(_parameters, new Integer(createEnumIndex_EnumConstant_value));
        return createEnumIndex_EnumConstant_value;
    }

    private int createEnumIndex_compute(EnumConstant e)  {
    if(createEnumIndexMap == null)
      createEnumIndexMap = new HashMap();
    if(!createEnumIndexMap.containsKey(e.hostType()))
      createEnumIndexMap.put(e.hostType(), new Integer(0));
    Integer i = (Integer)createEnumIndexMap.get(e.hostType());
    i = new Integer(i.intValue() + 1);
    createEnumIndexMap.put(e.hostType(), i);

    MethodDecl m = createEnumMethod(e.hostType());
    List list = m.getBlock().getStmtList();
    list.insertChild(
      new TryStmt(
        new Block(
          new List().add(
            AssignExpr.asStmt(
              createEnumArray(e.hostType()).createBoundFieldAccess().qualifiesAccess(
                new ArrayAccess(
                  e.createBoundFieldAccess().qualifiesAccess(new MethodAccess("ordinal", new List()))
                )
              ),
              new IntegerLiteral(i.toString())
            )
          )
        ),
        new List().add(
          new CatchClause(
            new ParameterDeclaration(
              lookupType("java.lang", "NoSuchFieldError").createQualifiedAccess(),
              "e"
            ),
            new Block(
              new List()
            )
          )
        ),
        new Opt()
      ),
      list.getNumChild()-1
    );
    return i.intValue();
  }

    protected java.util.Map createEnumArray_TypeDecl_values;
    // Declared in EnumsCodegen.jrag at line 125
    public FieldDeclaration createEnumArray(TypeDecl enumDecl) {
        Object _parameters = enumDecl;
if(createEnumArray_TypeDecl_values == null) createEnumArray_TypeDecl_values = new java.util.HashMap(4);
        if(createEnumArray_TypeDecl_values.containsKey(_parameters))
            return (FieldDeclaration)createEnumArray_TypeDecl_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        FieldDeclaration createEnumArray_TypeDecl_value = createEnumArray_compute(enumDecl);
        if(isFinal && num == boundariesCrossed)
            createEnumArray_TypeDecl_values.put(_parameters, createEnumArray_TypeDecl_value);
        return createEnumArray_TypeDecl_value;
    }

    private FieldDeclaration createEnumArray_compute(TypeDecl enumDecl)  {
    FieldDeclaration f = new FieldDeclaration(
      new Modifiers(new List().add(new Modifier("static")).add(new Modifier("final")).add(new Modifier("private"))),
      typeInt().arrayType().createQualifiedAccess(),
      "$SwitchMap$" + enumDecl.fullName().replace('.', '$'),
      new Opt()
    );
    // add field declaration as a body declaration
    getBodyDeclList().insertChild(f, 0);
    // trigger possible rewrites
    return (FieldDeclaration)getBodyDeclList().getChild(0);
  }

    protected boolean needsSignatureAttribute_computed = false;
    protected boolean needsSignatureAttribute_value;
    // Declared in GenericsCodegen.jrag at line 300
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

    private boolean needsSignatureAttribute_compute() {  return  false;  }

    protected boolean classSignature_computed = false;
    protected String classSignature_value;
    // Declared in GenericsCodegen.jrag at line 345
    public String classSignature() {
        if(classSignature_computed)
            return classSignature_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        classSignature_value = classSignature_compute();
        if(isFinal && num == boundariesCrossed)
            classSignature_computed = true;
        return classSignature_value;
    }

    private String classSignature_compute() {  return  "";  }

    protected boolean fieldTypeSignature_computed = false;
    protected String fieldTypeSignature_value;
    // Declared in GenericsCodegen.jrag at line 404
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

    protected boolean classTypeSignature_computed = false;
    protected String classTypeSignature_value;
    // Declared in GenericsCodegen.jrag at line 413
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

    private String classTypeSignature_compute() {  return  "L" + classTypeSignatureContents() + ";";  }

    // Declared in GenericsCodegen.jrag at line 418
    public String classTypeSignatureContents() {
        String classTypeSignatureContents_value = classTypeSignatureContents_compute();
        return classTypeSignatureContents_value;
    }

    private String classTypeSignatureContents_compute()  {
    StringBuffer buf = new StringBuffer();
    if(isTopLevelType()) {
      if(!packageName().equals(""))
        buf.append(packageName().replace('.', '/') + "/");
    }
    else
      buf.append(enclosingType().classTypeSignatureContents() + ".");
    buf.append(name());
    buf.append(typeArgumentsOpt());
    return buf.toString();
  }

    // Declared in GenericsCodegen.jrag at line 430
    public String typeArgumentsOpt() {
        String typeArgumentsOpt_value = typeArgumentsOpt_compute();
        return typeArgumentsOpt_value;
    }

    private String typeArgumentsOpt_compute() {  return  "";  }

    protected boolean componentType_computed = false;
    protected TypeDecl componentType_value;
    // Declared in Arrays.jrag at line 13
    public TypeDecl componentType() {
        if(componentType_computed)
            return componentType_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        componentType_value = getParent().Define_TypeDecl_componentType(this, null);
        if(isFinal && num == boundariesCrossed)
            componentType_computed = true;
        return componentType_value;
    }

    // Declared in Arrays.jrag at line 43
    public TypeDecl typeCloneable() {
        TypeDecl typeCloneable_value = getParent().Define_TypeDecl_typeCloneable(this, null);
        return typeCloneable_value;
    }

    // Declared in Arrays.jrag at line 44
    public TypeDecl typeSerializable() {
        TypeDecl typeSerializable_value = getParent().Define_TypeDecl_typeSerializable(this, null);
        return typeSerializable_value;
    }

    protected java.util.Map isDAbefore_Variable_values;
    // Declared in DefiniteAssignment.jrag at line 231
    public boolean isDAbefore(Variable v) {
        Object _parameters = v;
if(isDAbefore_Variable_values == null) isDAbefore_Variable_values = new java.util.HashMap(4);
        if(isDAbefore_Variable_values.containsKey(_parameters))
            return ((Boolean)isDAbefore_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDAbefore_Variable_value = getParent().Define_boolean_isDAbefore(this, null, v);
        if(isFinal && num == boundariesCrossed)
            isDAbefore_Variable_values.put(_parameters, Boolean.valueOf(isDAbefore_Variable_value));
        return isDAbefore_Variable_value;
    }

    protected java.util.Map isDUbefore_Variable_values;
    // Declared in DefiniteAssignment.jrag at line 699
    public boolean isDUbefore(Variable v) {
        Object _parameters = v;
if(isDUbefore_Variable_values == null) isDUbefore_Variable_values = new java.util.HashMap(4);
        if(isDUbefore_Variable_values.containsKey(_parameters))
            return ((Boolean)isDUbefore_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDUbefore_Variable_value = getParent().Define_boolean_isDUbefore(this, null, v);
        if(isFinal && num == boundariesCrossed)
            isDUbefore_Variable_values.put(_parameters, Boolean.valueOf(isDUbefore_Variable_value));
        return isDUbefore_Variable_value;
    }

    protected boolean typeException_computed = false;
    protected TypeDecl typeException_value;
    // Declared in ExceptionHandling.jrag at line 5
    public TypeDecl typeException() {
        if(typeException_computed)
            return typeException_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeException_value = getParent().Define_TypeDecl_typeException(this, null);
        if(isFinal && num == boundariesCrossed)
            typeException_computed = true;
        return typeException_value;
    }

    protected boolean typeRuntimeException_computed = false;
    protected TypeDecl typeRuntimeException_value;
    // Declared in ExceptionHandling.jrag at line 7
    public TypeDecl typeRuntimeException() {
        if(typeRuntimeException_computed)
            return typeRuntimeException_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeRuntimeException_value = getParent().Define_TypeDecl_typeRuntimeException(this, null);
        if(isFinal && num == boundariesCrossed)
            typeRuntimeException_computed = true;
        return typeRuntimeException_value;
    }

    protected boolean typeError_computed = false;
    protected TypeDecl typeError_value;
    // Declared in ExceptionHandling.jrag at line 9
    public TypeDecl typeError() {
        if(typeError_computed)
            return typeError_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeError_value = getParent().Define_TypeDecl_typeError(this, null);
        if(isFinal && num == boundariesCrossed)
            typeError_computed = true;
        return typeError_value;
    }

    protected java.util.Map lookupMethod_String_values;
    // Declared in LookupMethod.jrag at line 15
    public Collection lookupMethod(String name) {
        Object _parameters = name;
if(lookupMethod_String_values == null) lookupMethod_String_values = new java.util.HashMap(4);
        if(lookupMethod_String_values.containsKey(_parameters))
            return (Collection)lookupMethod_String_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        Collection lookupMethod_String_value = getParent().Define_Collection_lookupMethod(this, null, name);
        if(isFinal && num == boundariesCrossed)
            lookupMethod_String_values.put(_parameters, lookupMethod_String_value);
        return lookupMethod_String_value;
    }

    // Declared in LookupType.jrag at line 53
    public TypeDecl typeInt() {
        TypeDecl typeInt_value = getParent().Define_TypeDecl_typeInt(this, null);
        return typeInt_value;
    }

    protected boolean typeObject_computed = false;
    protected TypeDecl typeObject_value;
    // Declared in LookupType.jrag at line 56
    public TypeDecl typeObject() {
        if(typeObject_computed)
            return typeObject_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeObject_value = getParent().Define_TypeDecl_typeObject(this, null);
        if(isFinal && num == boundariesCrossed)
            typeObject_computed = true;
        return typeObject_value;
    }

    // Declared in LookupType.jrag at line 88
    public TypeDecl lookupType(String packageName, String typeName) {
        TypeDecl lookupType_String_String_value = getParent().Define_TypeDecl_lookupType(this, null, packageName, typeName);
        return lookupType_String_String_value;
    }

    protected java.util.Map lookupType_String_values;
    // Declared in LookupType.jrag at line 173
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
    // Declared in LookupVariable.jrag at line 5
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

    // Declared in NameCheck.jrag at line 225
    public boolean hasPackage(String packageName) {
        boolean hasPackage_String_value = getParent().Define_boolean_hasPackage(this, null, packageName);
        return hasPackage_String_value;
    }

    // Declared in NameCheck.jrag at line 228
    public ASTNode enclosingBlock() {
        ASTNode enclosingBlock_value = getParent().Define_ASTNode_enclosingBlock(this, null);
        return enclosingBlock_value;
    }

    protected boolean packageName_computed = false;
    protected String packageName_value;
    // Declared in QualifiedNames.jrag at line 80
    public String packageName() {
        if(packageName_computed)
            return packageName_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        packageName_value = getParent().Define_String_packageName(this, null);
        if(isFinal && num == boundariesCrossed)
            packageName_computed = true;
        return packageName_value;
    }

    protected boolean isAnonymous_computed = false;
    protected boolean isAnonymous_value;
    // Declared in TypeAnalysis.jrag at line 207
    public boolean isAnonymous() {
        if(isAnonymous_computed)
            return isAnonymous_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isAnonymous_value = getParent().Define_boolean_isAnonymous(this, null);
        if(isFinal && num == boundariesCrossed)
            isAnonymous_computed = true;
        return isAnonymous_value;
    }

    // Declared in TypeAnalysis.jrag at line 495
    public TypeDecl enclosingType() {
        TypeDecl enclosingType_value = getParent().Define_TypeDecl_enclosingType(this, null);
        return enclosingType_value;
    }

    // Declared in TypeAnalysis.jrag at line 511
    public boolean isNestedType() {
        boolean isNestedType_value = getParent().Define_boolean_isNestedType(this, null);
        return isNestedType_value;
    }

    // Declared in TypeAnalysis.jrag at line 519
    public boolean isMemberType() {
        boolean isMemberType_value = getParent().Define_boolean_isMemberType(this, null);
        return isMemberType_value;
    }

    // Declared in TypeAnalysis.jrag at line 533
    public boolean isLocalClass() {
        boolean isLocalClass_value = getParent().Define_boolean_isLocalClass(this, null);
        return isLocalClass_value;
    }

    // Declared in TypeAnalysis.jrag at line 558
    public String hostPackage() {
        String hostPackage_value = getParent().Define_String_hostPackage(this, null);
        return hostPackage_value;
    }

    protected boolean unknownType_computed = false;
    protected TypeDecl unknownType_value;
    // Declared in TypeAnalysis.jrag at line 673
    public TypeDecl unknownType() {
        if(unknownType_computed)
            return unknownType_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        unknownType_value = getParent().Define_TypeDecl_unknownType(this, null);
        if(isFinal && num == boundariesCrossed)
            unknownType_computed = true;
        return unknownType_value;
    }

    // Declared in TypeCheck.jrag at line 391
    public TypeDecl typeVoid() {
        TypeDecl typeVoid_value = getParent().Define_TypeDecl_typeVoid(this, null);
        return typeVoid_value;
    }

    // Declared in TypeCheck.jrag at line 425
    public TypeDecl enclosingInstance() {
        TypeDecl enclosingInstance_value = getParent().Define_TypeDecl_enclosingInstance(this, null);
        return enclosingInstance_value;
    }

    protected boolean inExplicitConstructorInvocation_computed = false;
    protected boolean inExplicitConstructorInvocation_value;
    // Declared in TypeHierarchyCheck.jrag at line 118
    public boolean inExplicitConstructorInvocation() {
        if(inExplicitConstructorInvocation_computed)
            return inExplicitConstructorInvocation_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        inExplicitConstructorInvocation_value = getParent().Define_boolean_inExplicitConstructorInvocation(this, null);
        if(isFinal && num == boundariesCrossed)
            inExplicitConstructorInvocation_computed = true;
        return inExplicitConstructorInvocation_value;
    }

    protected boolean inStaticContext_computed = false;
    protected boolean inStaticContext_value;
    // Declared in TypeHierarchyCheck.jrag at line 126
    public boolean inStaticContext() {
        if(inStaticContext_computed)
            return inStaticContext_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        inStaticContext_value = getParent().Define_boolean_inStaticContext(this, null);
        if(isFinal && num == boundariesCrossed)
            inStaticContext_computed = true;
        return inStaticContext_value;
    }

    // Declared in Attributes.jrag at line 155
    public CompilationUnit compilationUnit() {
        CompilationUnit compilationUnit_value = getParent().Define_CompilationUnit_compilationUnit(this, null);
        return compilationUnit_value;
    }

    protected boolean destinationPath_computed = false;
    protected String destinationPath_value;
    // Declared in ConstantPoolNames.jrag at line 117
    public String destinationPath() {
        if(destinationPath_computed)
            return destinationPath_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        destinationPath_value = getParent().Define_String_destinationPath(this, null);
        if(isFinal && num == boundariesCrossed)
            destinationPath_computed = true;
        return destinationPath_value;
    }

    // Declared in Annotations.jrag at line 276
    public boolean withinSuppressWarnings(String s) {
        boolean withinSuppressWarnings_String_value = getParent().Define_boolean_withinSuppressWarnings(this, null, s);
        return withinSuppressWarnings_String_value;
    }

    // Declared in Annotations.jrag at line 375
    public boolean withinDeprecatedAnnotation() {
        boolean withinDeprecatedAnnotation_value = getParent().Define_boolean_withinDeprecatedAnnotation(this, null);
        return withinDeprecatedAnnotation_value;
    }

    // Declared in Generics.jrag at line 988
    public TypeDecl typeWildcard() {
        TypeDecl typeWildcard_value = getParent().Define_TypeDecl_typeWildcard(this, null);
        return typeWildcard_value;
    }

    // Declared in Generics.jrag at line 1001
    public TypeDecl lookupWildcardExtends(TypeDecl typeDecl) {
        TypeDecl lookupWildcardExtends_TypeDecl_value = getParent().Define_TypeDecl_lookupWildcardExtends(this, null, typeDecl);
        return lookupWildcardExtends_TypeDecl_value;
    }

    // Declared in Generics.jrag at line 1014
    public TypeDecl lookupWildcardSuper(TypeDecl typeDecl) {
        TypeDecl lookupWildcardSuper_TypeDecl_value = getParent().Define_TypeDecl_lookupWildcardSuper(this, null, typeDecl);
        return lookupWildcardSuper_TypeDecl_value;
    }

    // Declared in Generics.jrag at line 1033
    public LUBType lookupLUBType(ArrayList bounds) {
        LUBType lookupLUBType_ArrayList_value = getParent().Define_LUBType_lookupLUBType(this, null, bounds);
        return lookupLUBType_ArrayList_value;
    }

    // Declared in Modifiers.jrag at line 288
    public boolean Define_boolean_mayBePrivate(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBePrivate(this, caller);
    }

    // Declared in LookupMethod.jrag at line 22
    public Collection Define_Collection_lookupMethod(ASTNode caller, ASTNode child, String name) {
        if(caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  unqualifiedLookupMethod(name);
        }
        return getParent().Define_Collection_lookupMethod(this, caller, name);
    }

    // Declared in TypeAnalysis.jrag at line 564
    public TypeDecl Define_TypeDecl_hostType(ASTNode caller, ASTNode child) {
        if(caller == getModifiersNoTransform()) {
            return  hostType();
        }
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  hostType();
        }
        return getParent().Define_TypeDecl_hostType(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 11
    public boolean Define_boolean_isDest(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isDest(this, caller);
    }

    // Declared in LookupConstructor.jrag at line 7
    public Collection Define_Collection_lookupConstructor(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  constructors();
        }
        return getParent().Define_Collection_lookupConstructor(this, caller);
    }

    // Declared in Modifiers.jrag at line 290
    public boolean Define_boolean_mayBeFinal(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_mayBeFinal(this, caller);
    }

    // Declared in Annotations.jrag at line 63
    public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
        if(caller == getModifiersNoTransform()) {
            return 
    name.equals("TYPE");
        }
        return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }

    // Declared in NameCheck.jrag at line 359
    public boolean Define_boolean_insideLoop(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_insideLoop(this, caller);
    }

    // Declared in Modifiers.jrag at line 286
    public boolean Define_boolean_mayBePublic(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBePublic(this, caller);
    }

    // Declared in LookupConstructor.jrag at line 11
    public Collection Define_Collection_lookupSuperConstructor(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  lookupSuperConstructor();
        }
        return getParent().Define_Collection_lookupSuperConstructor(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 21
    public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  true;
        }
        return getParent().Define_boolean_isSource(this, caller);
    }

    // Declared in Modifiers.jrag at line 287
    public boolean Define_boolean_mayBeProtected(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeProtected(this, caller);
    }

    // Declared in Modifiers.jrag at line 293
    public boolean Define_boolean_mayBeTransient(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_mayBeTransient(this, caller);
    }

    // Declared in Modifiers.jrag at line 296
    public boolean Define_boolean_mayBeNative(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_mayBeNative(this, caller);
    }

    // Declared in Annotations.jrag at line 267
    public boolean Define_boolean_withinSuppressWarnings(ASTNode caller, ASTNode child, String s) {
        if(caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return 
    getBodyDecl(i).hasAnnotationSuppressWarnings(s) || hasAnnotationSuppressWarnings(s) ||
    withinSuppressWarnings(s);
        }
        return getParent().Define_boolean_withinSuppressWarnings(this, caller, s);
    }

    // Declared in Arrays.jrag at line 12
    public TypeDecl Define_TypeDecl_componentType(ASTNode caller, ASTNode child) {
        if(caller == arrayType_value) {
            return  this;
        }
        return getParent().Define_TypeDecl_componentType(this, caller);
    }

    // Declared in SyntacticClassification.jrag at line 108
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  NameType.EXPRESSION_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in TypeHierarchyCheck.jrag at line 129
    public boolean Define_boolean_inStaticContext(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  isStatic() || inStaticContext();
        }
        return getParent().Define_boolean_inStaticContext(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 706
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getBodyDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    BodyDecl b = getBodyDecl(childIndex);
    if(b instanceof MethodDecl || b instanceof MemberTypeDecl) {
      return false;
    }
    if(v.isClassVariable() || v.isInstanceVariable()) {
      int index = childIndex - 1;
      if(b instanceof ConstructorDecl)
        index = getNumBodyDecl() - 1;
        
      for(int i = index; i >= 0; i--) {
        b = getBodyDecl(i);
        if(b instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration)b;
          //System.err.println("  working on field " + f.name() + " which is child " + i);
          if(f == v)
            return !f.hasInit();
          if((v.isClassVariable() && f.isStatic()) || (v.isInstanceVariable() && !f.isStatic()))
            return f.isDUafter(v);
          //System.err.println("  field " + f.name() + " can not affect " + v.name());
        }
        else if(b instanceof StaticInitializer && v.isClassVariable()) {
          StaticInitializer si = (StaticInitializer)b;
          //System.err.println("  working on static initializer which is child " + i);
          return si.isDUafter(v);
        }
        else if(b instanceof InstanceInitializer && v.isInstanceVariable()) {
          InstanceInitializer ii = (InstanceInitializer)b;
          //System.err.println("  working on instance initializer which is child " + i);
          return ii.isDUafter(v);
        }
      }
    }
    //System.err.println("Reached TypeDecl when searching for DU for variable");
    return isDUbefore(v);
  }
}
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

    // Declared in Annotations.jrag at line 370
    public boolean Define_boolean_withinDeprecatedAnnotation(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return 
    getBodyDecl(i).isDeprecated() || isDeprecated() || withinDeprecatedAnnotation();
        }
        return getParent().Define_boolean_withinDeprecatedAnnotation(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 493
    public TypeDecl Define_TypeDecl_enclosingType(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  this;
        }
        return getParent().Define_TypeDecl_enclosingType(this, caller);
    }

    // Declared in LookupVariable.jrag at line 18
    public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
        if(caller == getBodyDeclListNoTransform()) { 
   int i = caller.getIndexOfChild(child);
 {
    SimpleSet list = memberFields(name);
    if(!list.isEmpty()) return list;
    list = lookupVariable(name);
    if(inStaticContext() || isStatic() || (isAnonymous() && inExplicitConstructorInvocation()))
      list = removeInstanceVariables(list);
    return list;
  }
}
        return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }

    // Declared in Modifiers.jrag at line 291
    public boolean Define_boolean_mayBeAbstract(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeAbstract(this, caller);
    }

    // Declared in Modifiers.jrag at line 294
    public boolean Define_boolean_mayBeStrictfp(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeStrictfp(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 209
    public boolean Define_boolean_isAnonymous(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isAnonymous(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 236
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getBodyDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    BodyDecl b = getBodyDecl(childIndex);
    //if(b instanceof MethodDecl || b instanceof MemberTypeDecl) {
    if(!v.isInstanceVariable() && !v.isClassVariable()) {
      if(v.hostType() != this)
        return isDAbefore(v);
      return false;
    }

    if(b instanceof MethodDecl) {
      return true;
    }
    if(b instanceof MemberTypeDecl && v.isBlank() && v.isFinal() && v.hostType() == this)
      return true;
    if(v.isClassVariable() || v.isInstanceVariable()) {
      if(v.isFinal() &&  v.hostType() != this && instanceOf(v.hostType()))
        return true;
      int index = childIndex - 1;
      if(b instanceof ConstructorDecl)
        index = getNumBodyDecl() - 1;
        
      for(int i = index; i >= 0; i--) {
        b = getBodyDecl(i);
        if(b instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration)b;
          if((v.isClassVariable() && f.isStatic()) || (v.isInstanceVariable() && !f.isStatic())) {
            boolean c = f.isDAafter(v);
            //System.err.println("DefiniteAssignment: is " + v.name() + " DA after index " + i + ", " + f + ": " + c);
            return c;
            //return f.isDAafter(v);
          }
        }
        else if(b instanceof StaticInitializer && v.isClassVariable()) {
          StaticInitializer si = (StaticInitializer)b;
          return si.isDAafter(v);
        }
        else if(b instanceof InstanceInitializer && v.isInstanceVariable()) {
          InstanceInitializer ii = (InstanceInitializer)b;
          return ii.isDAafter(v);
        }
      }
    }
    return isDAbefore(v);
  }
}
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in NameCheck.jrag at line 366
    public boolean Define_boolean_insideSwitch(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_insideSwitch(this, caller);
    }

    // Declared in TypeCheck.jrag at line 393
    public TypeDecl Define_TypeDecl_returnType(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  typeVoid();
        }
        return getParent().Define_TypeDecl_returnType(this, caller);
    }

    // Declared in Modifiers.jrag at line 292
    public boolean Define_boolean_mayBeVolatile(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_mayBeVolatile(this, caller);
    }

    // Declared in NameCheck.jrag at line 293
    public BodyDecl Define_BodyDecl_enclosingBodyDecl(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
            return  getBodyDecl(i);
        }
        return getParent().Define_BodyDecl_enclosingBodyDecl(this, caller);
    }

    // Declared in Modifiers.jrag at line 295
    public boolean Define_boolean_mayBeSynchronized(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_mayBeSynchronized(this, caller);
    }

    // Declared in UnreachableStatements.jrag at line 148
    public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
        if(true) {
      int childIndex = this.getIndexOfChild(caller);
            return  true;
        }
        return getParent().Define_boolean_reportUnreachable(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 535
    public boolean Define_boolean_isLocalClass(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        return getParent().Define_boolean_isLocalClass(this, caller);
    }

    // Declared in TypeAnalysis.jrag at line 513
    public boolean Define_boolean_isNestedType(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  true;
        }
        return getParent().Define_boolean_isNestedType(this, caller);
    }

    // Declared in TypeHierarchyCheck.jrag at line 3
    public String Define_String_methodHost(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  typeName();
        }
        return getParent().Define_String_methodHost(this, caller);
    }

    // Declared in TypeCheck.jrag at line 429
    public TypeDecl Define_TypeDecl_enclosingInstance(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    if(getBodyDecl(childIndex) instanceof MemberTypeDecl && !((MemberTypeDecl)getBodyDecl(childIndex)).typeDecl().isInnerType())
      return null;
    if(getBodyDecl(childIndex) instanceof ConstructorDecl)
      return enclosingInstance();
    return this;
  }
}
        return getParent().Define_TypeDecl_enclosingInstance(this, caller);
    }

    // Declared in NameCheck.jrag at line 280
    public VariableScope Define_VariableScope_outerScope(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  this;
        }
        return getParent().Define_VariableScope_outerScope(this, caller);
    }

    // Declared in LookupType.jrag at line 211
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(caller == getBodyDeclListNoTransform()) { 
   int childIndex = caller.getIndexOfChild(child);
 {
    SimpleSet c = memberTypes(name);
    if(!c.isEmpty()) 
      return c;
    if(name().equals(name))
      return SimpleSet.emptySet.add(this);

    c = lookupType(name);
    // 8.5.2
    if(isClassDecl() && isStatic() && !isTopLevelType()) {
      SimpleSet newSet = SimpleSet.emptySet;
      for(Iterator iter = c.iterator(); iter.hasNext(); ) {
        TypeDecl d = (TypeDecl)iter.next();
        //if(d.isStatic() || d.isTopLevelType() || this.instanceOf(d.enclosingType())) {
          newSet = newSet.add(d);
        //}
      }
      c = newSet;
    }
    return c;
  }
}
        return getParent().Define_SimpleSet_lookupType(this, caller, name);
    }

    // Declared in Modifiers.jrag at line 289
    public boolean Define_boolean_mayBeStatic(ASTNode caller, ASTNode child) {
        if(caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return  false;
        }
        if(caller == getModifiersNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_mayBeStatic(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
