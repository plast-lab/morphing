
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public class ConstantFloat extends CPInfo {
    // Declared in ConstantPool.jrag at line 367
    private float val;

    // Declared in ConstantPool.jrag at line 368
    public ConstantFloat(float val) {
      this.val = val;
    }

    // Declared in ConstantPool.jrag at line 371
    public void emit(DataOutputStream out) throws IOException {
      out.writeByte(ConstantPool.CONSTANT_Float);
      out.writeFloat(val);
    }

    // Declared in ConstantPool.jrag at line 375
    public String toString() {
      return pos + " ConstantFloat: tag " + ConstantPool.CONSTANT_Float + ", bytes: " + val;
    }


}
