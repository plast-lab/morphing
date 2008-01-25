
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public class ConstantInteger extends CPInfo {
    // Declared in ConstantPool.jrag at line 353
    private int val;

    // Declared in ConstantPool.jrag at line 354
    public ConstantInteger(int val) {
      this.val = val;
    }

    // Declared in ConstantPool.jrag at line 357
    public void emit(DataOutputStream out) throws IOException {
      out.writeByte(ConstantPool.CONSTANT_Integer);
      out.writeInt(val);
    }

    // Declared in ConstantPool.jrag at line 361
    public String toString() {
      return pos + " ConstantInteger: tag " + ConstantPool.CONSTANT_Integer + ", bytes: " + val;
    }


}
