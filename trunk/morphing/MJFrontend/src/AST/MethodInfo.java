
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public class MethodInfo extends java.lang.Object {
    // Declared in BytecodeDescriptor.jrag at line 114
    private BytecodeParser p;

    // Declared in BytecodeDescriptor.jrag at line 115
    String name;

    // Declared in BytecodeDescriptor.jrag at line 116
    int flags;

    // Declared in BytecodeDescriptor.jrag at line 117
    private MethodDescriptor methodDescriptor;

    // Declared in BytecodeDescriptor.jrag at line 118
    private Attributes.MethodAttributes attributes;

    // Declared in BytecodeDescriptor.jrag at line 120

    public MethodInfo(BytecodeParser parser) {
      p = parser;
      flags = p.u2();
      if(BytecodeParser.VERBOSE)
        p.print("  Flags: " + Integer.toBinaryString(flags));
      int name_index = p.u2();
      CONSTANT_Info info = p.constantPool[name_index];
      if(info == null || !(info instanceof CONSTANT_Utf8_Info)) {
        System.err.println("Expected CONSTANT_Utf8_Info but found: " + info.getClass().getName());
        //if(info instanceof CONSTANT_Class_Info) {
        //  System.err.println(" found CONSTANT_Class_Info: " + ((CONSTANT_Class_Info)info).name());
        //  name = ((CONSTANT_Class_Info)info).name();
        //}
      } 
      name = ((CONSTANT_Utf8_Info)info).string();
      methodDescriptor = new MethodDescriptor(p, name);
      attributes = new Attributes.MethodAttributes(p);
    }

    // Declared in BytecodeDescriptor.jrag at line 138
    public BodyDecl bodyDecl() {
      Signatures.MethodSignature s = attributes.methodSignature;
      Access returnType = (s != null && s.hasReturnType()) ? s.returnType() : methodDescriptor.type();
      List parameterList;
      if(isConstructor() && p.isInnerClass) {
        parameterList = methodDescriptor.parameterListSkipFirst();
        if(s != null) {
          Iterator iter = s.parameterTypes().iterator();
          if(iter.hasNext()) iter.next();
          for(int i = 0; iter.hasNext(); i++) {
            Access a = (Access)iter.next();
            ((ParameterDeclaration)parameterList.getChildNoTransform(i)).setTypeAccess(a);
          }
        }
      }
      else {
        parameterList = methodDescriptor.parameterList();
        if(s != null) {
          int i = 0;
          for(Iterator iter = s.parameterTypes().iterator(); iter.hasNext(); i++) {
            Access a = (Access)iter.next();
            ((ParameterDeclaration)parameterList.getChildNoTransform(i)).setTypeAccess(a);
          }
        }
      }
      if((flags & Flags.ACC_VARARGS) != 0) {
        int lastIndex = parameterList.getNumChild() - 1;
        ParameterDeclaration p = (ParameterDeclaration)parameterList.getChildNoTransform(lastIndex);
        parameterList.setChild(
            new VariableArityParameterDeclaration(
              p.getModifiersNoTransform(),
              ((ArrayTypeAccess)p.getTypeAccessNoTransform()).getAccessNoTransform(),
              p.getID(),
              p.getEmptyBracketListNoTransform()
              ),
            lastIndex
            );
      }
      List exceptionList = (s != null && s.hasExceptionList()) ? s.exceptionList() : attributes.exceptionList();

      if(isConstructor()) {
        return new ConstructorDecl(p.modifiers(flags), name, parameterList, 
            exceptionList, new Opt(), new Block());
      }
      else if(attributes.elementValue() != null) {
        return new AnnotationMethodDecl(p.modifiers(flags), returnType, name, 
            parameterList, new List(), exceptionList, 
            new Opt(new Block()), new Opt(attributes.elementValue()));
      }
      else if(s != null && s.hasFormalTypeParameters()) {
        return new GenericMethodDecl(p.modifiers(flags), returnType, name, parameterList, 
            new List(), exceptionList, new Opt(new Block()), s.typeParameters(), new List());
      }
      else {
        return new MethodDecl(p.modifiers(flags), returnType, name, parameterList, 
            new List(), exceptionList, new Opt(new Block()));
      }
    }

    // Declared in BytecodeDescriptor.jrag at line 197

    private boolean isConstructor() {
      return name.equals("<init>");
    }

    // Declared in BytecodeDescriptor.jrag at line 201

    public boolean isSynthetic() {
      return attributes.isSynthetic() || (flags & 0x1000) != 0;
    }


}
