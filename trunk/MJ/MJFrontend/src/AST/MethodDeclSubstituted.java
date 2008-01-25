
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class MethodDeclSubstituted extends MethodDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        MethodDeclSubstituted node = (MethodDeclSubstituted)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          MethodDeclSubstituted node = (MethodDeclSubstituted)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        MethodDeclSubstituted res = (MethodDeclSubstituted)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 30

    public MethodDeclSubstituted() {
        super();

        setChild(null, 0);
        setChild(null, 1);
        setChild(new List(), 2);
        setChild(new List(), 3);
        setChild(new List(), 4);
        setChild(new Opt(), 5);

    }

    // Declared in Generics.ast at line 16


    // Declared in Generics.ast line 30
    public MethodDeclSubstituted(Modifiers p0, Access p1, String p2, List p3, List p4, List p5, Opt p6, MethodDecl p7) {
        setChild(p0, 0);
        setChild(p1, 1);
        setID(p2);
        setChild(p3, 2);
        setChild(p4, 3);
        setChild(p5, 4);
        setChild(p6, 5);
        setOriginal(p7);
    }

    // Declared in Generics.ast at line 27


  protected int numChildren() {
    return 6;
  }

    // Declared in Generics.ast at line 30

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
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
    // Declared in java.ast line 89
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
    // Declared in java.ast line 89
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
    // Declared in java.ast line 89
    public void setParameterList(List list) {
        setChild(list, 2);
    }

    // Declared in java.ast at line 6


    public int getNumParameter() {
        return getParameterList().getNumChild();
    }

    // Declared in java.ast at line 10


    public ParameterDeclaration getParameter(int i) {
        return (ParameterDeclaration)getParameterList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addParameter(ParameterDeclaration node) {
        List list = getParameterList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setParameter(ParameterDeclaration node, int i) {
        List list = getParameterList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getParameterList() {
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getParameterListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setEmptyBracketList(List list) {
        setChild(list, 3);
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
        return (List)getChild(3);
    }

    // Declared in java.ast at line 27


    public List getEmptyBracketListNoTransform() {
        return (List)getChildNoTransform(3);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setExceptionList(List list) {
        setChild(list, 4);
    }

    // Declared in java.ast at line 6


    public int getNumException() {
        return getExceptionList().getNumChild();
    }

    // Declared in java.ast at line 10


    public Access getException(int i) {
        return (Access)getExceptionList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addException(Access node) {
        List list = getExceptionList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setException(Access node, int i) {
        List list = getExceptionList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getExceptionList() {
        return (List)getChild(4);
    }

    // Declared in java.ast at line 27


    public List getExceptionListNoTransform() {
        return (List)getChildNoTransform(4);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 89
    public void setBlockOpt(Opt opt) {
        setChild(opt, 5);
    }

    // Declared in java.ast at line 6


    public boolean hasBlock() {
        return getBlockOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Block getBlock() {
        return (Block)getBlockOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setBlock(Block node) {
        getBlockOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getBlockOpt() {
        return (Opt)getChild(5);
    }

    // Declared in java.ast at line 21


    public Opt getBlockOptNoTransform() {
        return (Opt)getChildNoTransform(5);
    }

    // Declared in Generics.ast at line 2
    // Declared in Generics.ast line 30
    private MethodDecl tokenMethodDecl_Original;

    // Declared in Generics.ast at line 3

    public void setOriginal(MethodDecl value) {
        tokenMethodDecl_Original = value;
    }

    // Declared in Generics.ast at line 6

    public MethodDecl getOriginal() {
        return tokenMethodDecl_Original;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
