
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

  
  public class CodeGeneration extends java.lang.Object {
    // Declared in CodeGeneration.jrag at line 43
    private ByteArray bytes = new ByteArray();

    // Declared in CodeGeneration.jrag at line 44
    private ConstantPool constantPool;

    // Declared in CodeGeneration.jrag at line 46

    public void clearCodeGeneration() {
      bytes = null;
      constantPool = null;
      variableScopeLabelAddress = null;
      variableScopeLabelUses = null;
      localVariableTable = null;
      lineNumberTable = null;
      exceptions = null;
      address = null;
      uses = null;
    }

    // Declared in CodeGeneration.jrag at line 58
    
    public CodeGeneration(ConstantPool constantPool) {
      this.constantPool = constantPool;
    }

    // Declared in CodeGeneration.jrag at line 62

    public ConstantPool constantPool() {
      return constantPool;
    }

    // Declared in CodeGeneration.jrag at line 66
    
    private static int variableScopeLabel = 1;

    // Declared in CodeGeneration.jrag at line 67
    public int variableScopeLabel() {
      return variableScopeLabel++;
    }

    // Declared in CodeGeneration.jrag at line 70
    public void addVariableScopeLabel(int label) {
      Integer label_object = new Integer(label);
      variableScopeLabelAddress.put(label_object, new Integer(pos()));
      // Update all reference to this label
      if(variableScopeLabelUses.containsKey(label_object)) {
        ArrayList array = (ArrayList)variableScopeLabelUses.get(label_object);
        for(Iterator iter = array.iterator(); iter.hasNext(); ) {
          LocalVariableEntry e = (LocalVariableEntry)iter.next();
          e.length = pos() - e.start_pc;
        }
      }
    }

    // Declared in CodeGeneration.jrag at line 82 
    private HashMap variableScopeLabelAddress = new HashMap();

    // Declared in CodeGeneration.jrag at line 83
    private HashMap variableScopeLabelUses = new HashMap();

    // Declared in CodeGeneration.jrag at line 85

    class LocalVariableEntry {
      int start_pc;
      int length;
      int name_index;
      int descriptor_index;
      int index;
    }

    // Declared in CodeGeneration.jrag at line 92
    public Collection localVariableTable = new ArrayList();

    // Declared in CodeGeneration.jrag at line 93
    public void addLocalVariableEntryAtCurrentPC(String name, String typeDescriptor, int localNum, int variableScopeEndLabel) {
      LocalVariableEntry e = new LocalVariableEntry();
      e.start_pc = pos();
      e.length = 0;
      e.name_index = constantPool().addUtf8(name);
      e.descriptor_index = constantPool().addUtf8(typeDescriptor);
      e.index = localNum;
      localVariableTable.add(e);
      Integer label_object = new Integer(variableScopeEndLabel);
      if(!variableScopeLabelUses.containsKey(label_object))
        variableScopeLabelUses.put(label_object, new ArrayList());
      Collection c = (Collection)variableScopeLabelUses.get(label_object);
      c.add(e);
    }

    // Declared in CodeGeneration.jrag at line 114

    // at each variable declaration and parameter declaration
    // inh int VariableDeclaration.variableScopeEndLabel(CodeGeneration gen); 
    // addLocalVariableEntryAtCurrentPC(this, variableScopeEndLabel());
    // syn lazy int Block.variableScopeEndLabel(CodeGeneration gen) = gen.variableScopeLabel();
    //  Block.createBCode() { ... gen.addLabel(variableScopeLabel());
    
    class LineNumberEntry {
      int start_pc;
      int line_number;
    }

    // Declared in CodeGeneration.jrag at line 118
    public Collection lineNumberTable = new ArrayList();

    // Declared in CodeGeneration.jrag at line 119
    public void addLineNumberEntryAtCurrentPC(ASTNode node) {
      LineNumberEntry e = new LineNumberEntry();
      e.start_pc = pos();
      e.line_number = node.sourceLineNumber();
      if(e.line_number != -1 && e.line_number != 65535)
        lineNumberTable.add(e);
    }

    // Declared in CodeGeneration.jrag at line 127
    
    public Collection exceptions = new ArrayList();

    // Declared in CodeGeneration.jrag at line 128
    public void addException(int start_pc, int end_pc, int handler_pc, int catch_type) {
      ExceptionEntry e = new ExceptionEntry();
      e.start_pc = start_pc;
      e.end_pc = end_pc;
      e.handler_pc = handler_pc;
      e.catch_type = catch_type;
      if(e.start_pc != e.end_pc)
        exceptions.add(e);
    }

    // Declared in CodeGeneration.jrag at line 137
    class ExceptionEntry {
      int start_pc;
      int end_pc;
      int handler_pc;
      int catch_type;
    }

    // Declared in CodeGeneration.jrag at line 143
    public void createExceptionTable(TryStmt tryStmt) {  
      for(int i = 0; i < tryStmt.getNumCatchClause(); i++) {
        addException(
            addressOf(tryStmt.label_begin()),
            addressOf(tryStmt.label_block_end()),
            addressOf(tryStmt.getCatchClause(i).label()),
            constantPool().addClass(tryStmt.getCatchClause(i).getParameter().type().constantPoolName())
            );
      }
      if(tryStmt.hasFinally()) {
        addException(
            addressOf(tryStmt.label_begin()),
            addressOf(tryStmt.label_finally()),
            addressOf(tryStmt.label_exception_handler()),
            0
            );
      }
    }

    // Declared in CodeGeneration.jrag at line 161
    public void createExceptionTable(SynchronizedStmt stmt) {  
      addException(
          addressOf(stmt.label_begin()),
          addressOf(stmt.label_finally()),
          addressOf(stmt.label_exception_handler()),
          0
          );
    }

    // Declared in CodeGeneration.jrag at line 170

    public int maxLocals() {
      return maxLocals+1;
    }

    // Declared in CodeGeneration.jrag at line 173
    int maxLocals = 0;

    // Declared in CodeGeneration.jrag at line 181

    /*
    public int label() {
      return labelCounter++;
    }
    private static int labelCounter = 1;
    */
    private HashMap address = new HashMap();

    // Declared in CodeGeneration.jrag at line 182
    private HashMap uses = new HashMap();

    // Declared in CodeGeneration.jrag at line 183
    public void addLabel(int label) {
      Integer label_object = new Integer(label);
      /*
      if(pos() - 3 == bytes.lastGotoPos() && bytes.get(pos() - 3) == Bytecode.GOTO) {
        if(uses.containsKey(label_object)) {
          ArrayList array = (ArrayList)uses.get(label_object);
          for(int i = 0; i < array.size(); i++) {
            int p = ((Integer)array.get(i)).intValue();
            if(pos() - 3 == p) {
              //System.out.println("Found direct branch");
              array.remove(i);
              i--;
            }
          }
          bytes.setPos(pos() - 3);
        }
      }
      */
      address.put(label_object, new Integer(pos()));
      // Update all reference to this label
      if(uses.containsKey(label_object)) {
        ArrayList array = (ArrayList)uses.get(label_object);
        for(int i = 0; i < array.size(); i++) {
          int p = ((Integer)array.get(i)).intValue();          
          setAddress(p + 1, pos() -  p);
        }
      }
    }

    // Declared in CodeGeneration.jrag at line 211 
    public int addressOf(int label) {
      Integer label_object = new Integer(label);
      if(!address.containsKey(label_object))
        throw new Error("Can not compute address of unplaced label");
      return ((Integer)address.get(label_object)).intValue();
    }

    // Declared in CodeGeneration.jrag at line 217
    private int jump(int label) {
      Integer label_object = new Integer(label);
      if(!uses.containsKey(label_object))
        uses.put(label_object, new ArrayList());
      ArrayList a = (ArrayList)uses.get(label_object);
      a.add(new Integer(pos())); // position of the 16-bits reference
      Integer val = (Integer)address.get(label_object);
      if(val != null)
        return val.intValue() - pos();
      return 0; // a position of 0 means not calculated yet
    }

    // Declared in CodeGeneration.jrag at line 228
    private void setAddress(int position, int address) {
      bytes.set(position + 0, (byte)((address&0xff00)>>8));
      bytes.set(position + 1, (byte)(address&0xff));
    }

    // Declared in CodeGeneration.jrag at line 233

    public void emitStoreReference(int pos) {
      maxLocals = Math.max(maxLocals, pos+1);
      if(pos == 0) emit(Bytecode.ASTORE_0);
      else if(pos == 1) emit(Bytecode.ASTORE_1);
      else if(pos == 2) emit(Bytecode.ASTORE_2);
      else if(pos == 3) emit(Bytecode.ASTORE_3);
      else if(pos < 256) emit(Bytecode.ASTORE).add(pos);
      else emit(Bytecode.WIDE).emit(Bytecode.ASTORE).add2(pos);
    }

    // Declared in CodeGeneration.jrag at line 242
    public void emitLoadReference(int pos) {
      maxLocals = Math.max(maxLocals, pos+1);
      if(pos == 0) emit(Bytecode.ALOAD_0);
      else if(pos == 1) emit(Bytecode.ALOAD_1);
      else if(pos == 2) emit(Bytecode.ALOAD_2);
      else if(pos == 3) emit(Bytecode.ALOAD_3);
      else if(pos < 256) emit(Bytecode.ALOAD).add(pos);
      else emit(Bytecode.WIDE).emit(Bytecode.ALOAD).add2(pos);
    }

    // Declared in CodeGeneration.jrag at line 252

    public void emitReturn() {
      bytes.emit(Bytecode.RETURN);
    }

    // Declared in CodeGeneration.jrag at line 256	

    public void emitThrow() {
      bytes.emit(Bytecode.ATHROW);
    }

    // Declared in CodeGeneration.jrag at line 260

    public void emitInstanceof(TypeDecl type) {
      int p = constantPool().addClass(type.isArrayDecl() ? type.typeDescriptor() : type.constantPoolName());
      bytes.emit(Bytecode.INSTANCEOF).add2(p);
    }

    // Declared in CodeGeneration.jrag at line 264
    public void emitCheckCast(TypeDecl type) {
      int p = constantPool().addClass(type.isArrayDecl() ? type.typeDescriptor() : type.constantPoolName());
      bytes.emit(Bytecode.CHECKCAST).add2(p);
    }

    // Declared in CodeGeneration.jrag at line 269

    public void emitDup() {
      bytes.emit(Bytecode.DUP);
    }

    // Declared in CodeGeneration.jrag at line 272
    public void emitDup2() {
      bytes.emit(Bytecode.DUP2);
    }

    // Declared in CodeGeneration.jrag at line 276

    public void emitPop() {
      bytes.emit(Bytecode.POP);
    }

    // Declared in CodeGeneration.jrag at line 280
    
    public void emitSwap() {
      bytes.emit(Bytecode.SWAP);
    }

    // Declared in CodeGeneration.jrag at line 284

    public void emitBranchNonNull(int label) {
      int p = jump(label);
      bytes.emit(Bytecode.IFNONNULL).add2(p);
    }

    // Declared in CodeGeneration.jrag at line 289

    public void emitGoto(int label) {
      int p = jump(label);
      bytes.emitGoto(Bytecode.GOTO).add2(p);
    }

    // Declared in CodeGeneration.jrag at line 294

    public void emitJsr(int label) {
      int p = jump(label);
      bytes.emit(Bytecode.JSR).add2(p);
    }

    // Declared in CodeGeneration.jrag at line 299

    public void emitCompare(byte bytecode, int label) {
      int p = jump(label);
      bytes.emit(bytecode).add2(p);
    }

    // Declared in CodeGeneration.jrag at line 304

    public String toString() {
      return bytes.toString();
    }

    // Declared in CodeGeneration.jrag at line 307
    public int size() {return bytes.size();}

    // Declared in CodeGeneration.jrag at line 308
    public int pos() {return bytes.pos();}

    // Declared in CodeGeneration.jrag at line 309
    public byte[] toArray() {return bytes.toArray();}

    // Declared in CodeGeneration.jrag at line 310
    CodeGeneration add(int i) { return add((byte)i); }

    // Declared in CodeGeneration.jrag at line 311
    CodeGeneration add(byte b) { bytes.add(b); return this; }

    // Declared in CodeGeneration.jrag at line 312
    CodeGeneration add2(int index) { bytes.add2(index); return this; }

    // Declared in CodeGeneration.jrag at line 313
    CodeGeneration add4(int i) {
      bytes.add(i >> 24 & 0xff);
      bytes.add(i >> 16 & 0xff);
      bytes.add(i >> 8 & 0xff);
      bytes.add(i & 0xff);
      return this;
    }

    // Declared in CodeGeneration.jrag at line 320
    CodeGeneration emit(byte b) {
      bytes.emit(b);
      return this;
    }

    // Declared in CodeGeneration.jrag at line 324
    CodeGeneration emit(byte b, int stackChange) {
      bytes.emit(b, stackChange);
      return this;
    }

    // Declared in CodeGeneration.jrag at line 328
    public int maxStackDepth() {
      return bytes.maxStackDepth();
    }

    // Declared in CodeGeneration.jrag at line 331
    public int stackDepth() {
      return bytes.stackDepth();
    }

    // Declared in CodeGeneration.jrag at line 334
    public void changeStackDepth(int i) {
      bytes.changeStackDepth(i);
    }


}
