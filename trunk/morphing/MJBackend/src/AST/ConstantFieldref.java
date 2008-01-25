
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public class ConstantFieldref extends CPInfo {
    // Declared in ConstantPool.jrag at line 256
    private int classname;

    // Declared in ConstantPool.jrag at line 257
    private int nameandtype;

    // Declared in ConstantPool.jrag at line 258
    public ConstantFieldref(int classname, int nameandtype) {
      this.classname = classname;
      this.nameandtype = nameandtype;
    }

    // Declared in ConstantPool.jrag at line 262
    public void emit(DataOutputStream out) throws IOException {
      out.writeByte(ConstantPool.CONSTANT_Fieldref);
      out.writeChar(classname);
      out.writeChar(nameandtype);
    }

    // Declared in ConstantPool.jrag at line 267
    public String toString() {
      return pos + " ConstantFieldref: tag " + ConstantPool.CONSTANT_Fieldref + ", class_index: " + classname + ", name_and_type_index: " + nameandtype;
    }


}
