
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;
public class VariableArityParameterDeclaration extends ParameterDeclaration implements Cloneable {
    public void flushCache() {
        super.flushCache();
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        VariableArityParameterDeclaration node = (VariableArityParameterDeclaration)super.clone();
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          VariableArityParameterDeclaration node = (VariableArityParameterDeclaration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        VariableArityParameterDeclaration res = (VariableArityParameterDeclaration)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in VariableArityParameters.jrag at line 6

  // 8.4.1

  /* The last formal parameter in a list is special; it may be a variable arity
  parameter, indicated by an elipsis following the type.*/
  public void nameCheck() {
    super.nameCheck();
    if(!variableArityValid())
      error("only the last formal paramater may be of variable arity");
  }

    // Declared in VariableArityParameters.ast at line 3
    // Declared in VariableArityParameters.ast line 1

    public VariableArityParameterDeclaration() {
        super();

        setChild(null, 0);
        setChild(null, 1);
        setChild(new List(), 2);

    }

    // Declared in VariableArityParameters.ast at line 13


    // Declared in VariableArityParameters.ast line 1
    public VariableArityParameterDeclaration(Modifiers p0, Access p1, String p2, List p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setID(p2);
        setChild(p3, 2);
    }

    // Declared in VariableArityParameters.ast at line 20


  protected int numChildren() {
    return 3;
  }

    // Declared in VariableArityParameters.ast at line 23

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 83
    public void setModifiers(Modifiers node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(0);
    }

    // Declared in java.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 83
    public void setTypeAccess(Access node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Access getTypeAccess() {
        return (Access)getChild(1);
    }

    // Declared in java.ast at line 9


    public Access getTypeAccessNoTransform() {
        return (Access)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 83
    private String tokenString_ID;

    // Declared in java.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in java.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 83
    public void setEmptyBracketList(List list) {
        setChild(list, 2);
    }

    // Declared in java.ast at line 6


    public int getNumEmptyBracket() {
        return getEmptyBracketList().getNumChild();
    }

    // Declared in java.ast at line 10


    public EmptyBracket getEmptyBracket(int i) {
        return (EmptyBracket)getEmptyBracketList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addEmptyBracket(EmptyBracket node) {
        List list = getEmptyBracketList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setEmptyBracket(EmptyBracket node, int i) {
        List list = getEmptyBracketList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getEmptyBracketList() {
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getEmptyBracketListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in VariableArityParameters.jrag at line 21
    public TypeDecl type() {
        if(type_computed)
            return type_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        type_value = type_compute();
        if(isFinal && num == boundariesCrossed)
            type_computed = true;
        return type_value;
    }

    private TypeDecl type_compute() {  return  super.type().arrayType();  }

    // Declared in VariableArityParameters.jrag at line 27
    public boolean isVariableArity() {
        boolean isVariableArity_value = isVariableArity_compute();
        return isVariableArity_value;
    }

    private boolean isVariableArity_compute() {  return  true;  }

    // Declared in VariableArityParameters.jrag at line 17
    public boolean variableArityValid() {
        boolean variableArityValid_value = getParent().Define_boolean_variableArityValid(this, null);
        return variableArityValid_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
