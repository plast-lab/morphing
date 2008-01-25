
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

     
  public class Attribute extends java.lang.Object {
    // Declared in Attributes.jrag at line 5
    int attribute_name_index;

    // Declared in Attributes.jrag at line 6
    ByteArrayOutputStream buf = new ByteArrayOutputStream();

    // Declared in Attributes.jrag at line 7
    DataOutputStream output = new DataOutputStream(buf);

    // Declared in Attributes.jrag at line 9

    public Attribute(ConstantPool cp, String name) {
      attribute_name_index = cp.addUtf8(name);
    }

    // Declared in Attributes.jrag at line 13

    public void emit(DataOutputStream out) throws IOException {
      out.writeChar(attribute_name_index);
      out.writeInt(buf.size());
      buf.writeTo(out);
      output.close();
      buf.close();
    }

    // Declared in Attributes.jrag at line 20
    public int size() { return buf.size(); }

    // Declared in Attributes.jrag at line 21
    public void u1(int v) { try { output.writeByte(v); } catch(IOException e) {} }

    // Declared in Attributes.jrag at line 22
    public void u2(int v) { try { output.writeChar(v); } catch(IOException e) {} }

    // Declared in Attributes.jrag at line 23
    public void u4(int v) { try { output.writeInt(v); } catch(IOException e) {} }

    // Declared in Attributes.jrag at line 24
    public void append(byte[] data) { try { output.write(data, 0, data.length); } catch(IOException e) {} }

    // Declared in Attributes.jrag at line 25
    public void append(Attribute attribute) { try { attribute.emit(output); } catch(IOException e) {} }


}
