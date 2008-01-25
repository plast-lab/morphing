
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public class ConstantUtf8 extends CPInfo {
    // Declared in ConstantPool.jrag at line 325
    private String name;

    // Declared in ConstantPool.jrag at line 326
    public ConstantUtf8(String name) {
      this.name = name;
    }

    // Declared in ConstantPool.jrag at line 329
    public void emit(DataOutputStream out) throws IOException {
      out.writeByte(ConstantPool.CONSTANT_Utf8);
      out.writeUTF(name);
    }

    // Declared in ConstantPool.jrag at line 333
    public String toString() {
      return pos + " ConstantUtf8: tag " + ConstantPool.CONSTANT_Utf8 + ", length: " + name.length() + ", bytes: " + name;
    }


}
