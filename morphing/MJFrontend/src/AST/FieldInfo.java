
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;



  public class FieldInfo extends java.lang.Object {
    // Declared in BytecodeDescriptor.jrag at line 27
    private BytecodeParser p;

    // Declared in BytecodeDescriptor.jrag at line 28
    String name;

    // Declared in BytecodeDescriptor.jrag at line 29
    int flags;

    // Declared in BytecodeDescriptor.jrag at line 30
    private FieldDescriptor fieldDescriptor;

    // Declared in BytecodeDescriptor.jrag at line 31
    private Attributes.FieldAttributes attributes;

    // Declared in BytecodeDescriptor.jrag at line 33

    public FieldInfo(BytecodeParser parser) {
      p = parser;
      flags = p.u2();
      if(BytecodeParser.VERBOSE)
        p.print("Flags: " + flags);
      int name_index = p.u2();
      name = ((CONSTANT_Utf8_Info) p.constantPool[name_index]).string();

      fieldDescriptor = new FieldDescriptor(p, name);
      attributes = new Attributes.FieldAttributes(p);
    }

    // Declared in BytecodeDescriptor.jrag at line 45

    public BodyDecl bodyDecl() {
      FieldDeclaration f;
      if((flags & Flags.ACC_ENUM) != 0)
        //EnumConstant : FieldDeclaration ::= Modifiers <ID:String> Arg:Expr* BodyDecl* /TypeAccess:Access/ /[Init:Expr]/;
        f = new EnumConstant(
            this.p.modifiers(flags),
            name,
            new List(),
            new List()
            );
      else
        f = new FieldDeclaration(
            this.p.modifiers(flags),
            fieldDescriptor.type(),
            name,
            new Opt()
            );
      if(attributes.constantValue() != null)
        if(fieldDescriptor.isBoolean()) {
          f.setInit(attributes.constantValue().exprAsBoolean());
        }
        else {
          f.setInit(attributes.constantValue().expr());
        }
      return f;
    }

    // Declared in BytecodeDescriptor.jrag at line 72

    public boolean isSynthetic() {
      return attributes.isSynthetic();
    }


}
