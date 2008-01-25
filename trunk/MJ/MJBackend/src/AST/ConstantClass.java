
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public class ConstantClass extends CPInfo {
    // Declared in ConstantPool.jrag at line 242
    private int name;

    // Declared in ConstantPool.jrag at line 243
    public ConstantClass(int name) {
      this.name = name;
    }

    // Declared in ConstantPool.jrag at line 246
    public void emit(DataOutputStream out) throws IOException {
      out.writeByte(ConstantPool.CONSTANT_Class);
      out.writeChar(name);
    }

    // Declared in ConstantPool.jrag at line 250
    public String toString() {
      return pos + " ConstantClass: tag " + ConstantPool.CONSTANT_Class + ", name_index: " + name;
    }


}
