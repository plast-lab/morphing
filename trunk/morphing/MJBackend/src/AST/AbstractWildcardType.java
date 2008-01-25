
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public abstract class AbstractWildcardType extends TypeDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        needsSignatureAttribute_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        AbstractWildcardType node = (AbstractWildcardType)super.clone();
        node.needsSignatureAttribute_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 25

    public AbstractWildcardType() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);

    }

    // Declared in Generics.ast at line 12


    // Declared in Generics.ast line 25
    public AbstractWildcardType(Modifiers p0, String p1, List p2) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
    }

    // Declared in Generics.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in Generics.ast at line 21

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 37
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
    // Declared in java.ast line 37
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
    // Declared in java.ast line 37
    public void setBodyDeclList(List list) {
        setChild(list, 1);
    }

    // Declared in java.ast at line 6


    public int getNumBodyDecl() {
        return getBodyDeclList().getNumChild();
    }

    // Declared in java.ast at line 10


    public BodyDecl getBodyDecl(int i) {
        return (BodyDecl)getBodyDeclList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addBodyDecl(BodyDecl node) {
        List list = getBodyDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setBodyDecl(BodyDecl node, int i) {
        List list = getBodyDeclList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getBodyDeclList() {
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in GenericsSubtype.jrag at line 94
    public boolean isWildcard() {
        boolean isWildcard_value = isWildcard_compute();
        return isWildcard_value;
    }

    private boolean isWildcard_compute() {  return  true;  }

    // Declared in GenericsCodegen.jrag at line 305
    public boolean needsSignatureAttribute() {
        if(needsSignatureAttribute_computed)
            return needsSignatureAttribute_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        needsSignatureAttribute_value = needsSignatureAttribute_compute();
        if(isFinal && num == boundariesCrossed)
            needsSignatureAttribute_computed = true;
        return needsSignatureAttribute_value;
    }

    private boolean needsSignatureAttribute_compute() {  return  true;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
