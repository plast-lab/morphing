
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class AssignPlusExpr extends AssignAdditiveExpr implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        AssignPlusExpr node = (AssignPlusExpr)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          AssignPlusExpr node = (AssignPlusExpr)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        AssignPlusExpr res = (AssignPlusExpr)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in PrettyPrint.jadd at line 294


  public void printOp(StringBuffer s) {
    s.append(" += ");
  }

    // Declared in TypeCheck.jrag at line 62

  
  public void typeCheck() {
    if(!getDest().isVariable())
      error("left hand side is not a variable");
    else if(getDest().type().isString() && !(getSource().type().isVoid()))
      return;
    else if(getSource().type().isBoolean() || getDest().type().isBoolean())
      error("Operator + does not operate on boolean types");
    else if(getSource().type().isPrimitive() && getDest().type().isPrimitive())
      return;
    else
      error("can not assign " + getDest() + " of type " + getDest().type().typeName() +
            " a value of type " + sourceType().typeName());
  }

    // Declared in CreateBCode.jrag at line 233


  // string addition assign expression
  public void createBCode(CodeGeneration gen) {
    TypeDecl dest = getDest().type();
    TypeDecl source = getSource().type();
    if(dest.isString()) {
      getDest().createAssignLoadDest(gen);
      
      // new StringBuffer()
      TypeDecl stringBuffer = lookupType("java.lang", "StringBuffer");
      String classname = stringBuffer.constantPoolName();
      String desc;
      int index;
      TypeDecl argumentType;
      stringBuffer.emitNew(gen); // new StringBuffer
      gen.emitDup();             // dup
      desc = "()V";
      index = gen.constantPool().addMethodref(classname, "<init>", desc);
      gen.emit(Bytecode.INVOKESPECIAL, -1).add2(index); // invokespecial StringBuffer()

      gen.emitSwap();

      // append
      argumentType = dest.stringPromotion();
      desc = "(" + argumentType.typeDescriptor() + ")" + stringBuffer.typeDescriptor();
      index = gen.constantPool().addMethodref(classname, "append", desc);
      gen.emit(Bytecode.INVOKEVIRTUAL, -argumentType.variableSize()).add2(index); // StringBuffer.append
      
      getSource().createBCode(gen);

      // typed append
      argumentType = source.stringPromotion();
      desc = "(" + argumentType.typeDescriptor() + ")" + stringBuffer.typeDescriptor();
      index = gen.constantPool().addMethodref(classname, "append", desc);
      gen.emit(Bytecode.INVOKEVIRTUAL, -argumentType.variableSize()).add2(index); // StringBuffer.append
      
      // toString
      desc = "()" + type().typeDescriptor();
      index = gen.constantPool().addMethodref(classname, "toString", desc);
      gen.emit(Bytecode.INVOKEVIRTUAL, 0).add2(index); // StringBuffer.toString
      
      if(needsPush()) {
        getDest().createPushAssignmentResult(gen);
      }
      getDest().emitStore(gen);
    }
    else {
      super.createBCode(gen);
    }
  }

    // Declared in CreateBCode.jrag at line 374

  public void createAssignOp(CodeGeneration gen, TypeDecl type)    { type.add(gen); }

    // Declared in java.ast at line 3
    // Declared in java.ast line 110

    public AssignPlusExpr() {
        super();

        setChild(null, 0);
        setChild(null, 1);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 110
    public AssignPlusExpr(Expr p0, Expr p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in java.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in java.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 100
    public void setDest(Expr node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Expr getDest() {
        return (Expr)getChild(0);
    }

    // Declared in java.ast at line 9


    public Expr getDestNoTransform() {
        return (Expr)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 100
    public void setSource(Expr node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Expr getSource() {
        return (Expr)getChild(1);
    }

    // Declared in java.ast at line 9


    public Expr getSourceNoTransform() {
        return (Expr)getChildNoTransform(1);
    }

    // Declared in TypeCheck.jrag at line 100
    public TypeDecl sourceType() {
        TypeDecl sourceType_value = sourceType_compute();
        return sourceType_value;
    }

    private TypeDecl sourceType_compute()  {
    TypeDecl left = getDest().type();
    TypeDecl right = getSource().type();
    if(!left.isString() && !right.isString())
      return super.sourceType();
    if(left.isVoid() || right.isVoid())
      return unknownType();
    return left.isString() ? left : right;
  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
