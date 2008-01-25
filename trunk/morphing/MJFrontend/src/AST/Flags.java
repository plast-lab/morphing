
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;



  public interface Flags {
    // Declared in BytecodeReader.jrag at line 835

    public int ACC_PUBLIC = 0x0001;

    // Declared in BytecodeReader.jrag at line 836

    public int ACC_PRIVATE = 0x0002;

    // Declared in BytecodeReader.jrag at line 837

    public int ACC_PROTECTED = 0x0004;

    // Declared in BytecodeReader.jrag at line 838

    public int ACC_STATIC = 0x0008;

    // Declared in BytecodeReader.jrag at line 839

    public int ACC_FINAL = 0x0010;

    // Declared in BytecodeReader.jrag at line 840

    public int ACC_SUPER = 0x0020;

    // Declared in BytecodeReader.jrag at line 841

    public int ACC_SYNCHRONIZED = 0x0020;

    // Declared in BytecodeReader.jrag at line 842

    public int ACC_VOLATILE = 0x0040;

    // Declared in BytecodeReader.jrag at line 843

    public int ACC_BRIDGE = 0x0040;

    // Declared in BytecodeReader.jrag at line 844

    public int ACC_TRANSIENT = 0x0080;

    // Declared in BytecodeReader.jrag at line 845

    public int ACC_VARARGS = 0x0080;

    // Declared in BytecodeReader.jrag at line 846

    public int ACC_NATIVE = 0x0100;

    // Declared in BytecodeReader.jrag at line 847

    public int ACC_INTERFACE = 0x0200;

    // Declared in BytecodeReader.jrag at line 848

    public int ACC_ABSTRACT = 0x0400;

    // Declared in BytecodeReader.jrag at line 849

    public int ACC_STRICT = 0x0800;

    // Declared in BytecodeReader.jrag at line 850

    public int ACC_SYNTHETIC = 0x1000;

    // Declared in BytecodeReader.jrag at line 851

    public int ACC_ANNOTATION = 0x2000;

    // Declared in BytecodeReader.jrag at line 852

    public int ACC_ENUM = 0x4000;

}
