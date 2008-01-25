
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class ElementArrayValue extends ElementValue implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        ElementArrayValue node = (ElementArrayValue)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ElementArrayValue node = (ElementArrayValue)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ElementArrayValue res = (ElementArrayValue)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Annotations.ast at line 3
    // Declared in Annotations.ast line 13

    public ElementArrayValue() {
        super();

        setChild(new List(), 0);

    }

    // Declared in Annotations.ast at line 11


    // Declared in Annotations.ast line 13
    public ElementArrayValue(List p0) {
        setChild(p0, 0);
    }

    // Declared in Annotations.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in Annotations.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 13
    public void setElementValueList(List list) {
        setChild(list, 0);
    }

    // Declared in Annotations.ast at line 6


    public int getNumElementValue() {
        return getElementValueList().getNumChild();
    }

    // Declared in Annotations.ast at line 10


    public ElementValue getElementValue(int i) {
        return (ElementValue)getElementValueList().getChild(i);
    }

    // Declared in Annotations.ast at line 14


    public void addElementValue(ElementValue node) {
        List list = getElementValueList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in Annotations.ast at line 19


    public void setElementValue(ElementValue node, int i) {
        List list = getElementValueList();
        list.setChild(node, i);
    }

    // Declared in Annotations.ast at line 23

    public List getElementValueList() {
        return (List)getChild(0);
    }

    // Declared in Annotations.ast at line 27


    public List getElementValueListNoTransform() {
        return (List)getChildNoTransform(0);
    }

    // Declared in Annotations.jrag at line 52
    public boolean validTarget(Annotation a) {
        boolean validTarget_Annotation_value = validTarget_compute(a);
        return validTarget_Annotation_value;
    }

    private boolean validTarget_compute(Annotation a)  {
    for(int i = 0;  i < getNumElementValue(); i++)
      if(getElementValue(i).validTarget(a))
        return true;
    return false;
  }

    // Declared in Annotations.jrag at line 176
    public ElementValue definesElementTypeValue(String name) {
        ElementValue definesElementTypeValue_String_value = definesElementTypeValue_compute(name);
        return definesElementTypeValue_String_value;
    }

    private ElementValue definesElementTypeValue_compute(String name)  {
    for(int i = 0; i < getNumElementValue(); i++)
      if(getElementValue(i).definesElementTypeValue(name) != null)
        return getElementValue(i).definesElementTypeValue(name);
    return null;
  }

    // Declared in Annotations.jrag at line 296
    public boolean hasValue(String s) {
        boolean hasValue_String_value = hasValue_compute(s);
        return hasValue_String_value;
    }

    private boolean hasValue_compute(String s)  {
    for(int i = 0;  i < getNumElementValue(); i++)
      if(getElementValue(i).hasValue(s))
        return true;
    return false;
  }

    // Declared in Annotations.jrag at line 491
    public boolean commensurateWithArrayDecl(ArrayDecl type) {
        boolean commensurateWithArrayDecl_ArrayDecl_value = commensurateWithArrayDecl_compute(type);
        return commensurateWithArrayDecl_ArrayDecl_value;
    }

    private boolean commensurateWithArrayDecl_compute(ArrayDecl type)  {
    for(int i = 0; i < getNumElementValue(); i++)
      if(!type.componentType().commensurateWith(getElementValue(i)))
        return false;
    return true;
  }

    // Declared in Annotations.jrag at line 166
    public ElementValue Define_ElementValue_lookupElementTypeValue(ASTNode caller, ASTNode child, String name) {
        if(caller == getElementValueListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return 
    definesElementTypeValue(name);
        }
        return getParent().Define_ElementValue_lookupElementTypeValue(this, caller, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
