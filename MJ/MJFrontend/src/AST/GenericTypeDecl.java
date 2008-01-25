
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;



  public interface GenericTypeDecl {
    // Declared in Generics.jrag at line 68

    int getNumTypeParameter();

    // Declared in Generics.jrag at line 69

    TypeVariable getTypeParameter(int index);

    // Declared in Generics.jrag at line 70

    List getTypeParameterList();

    // Declared in Generics.jrag at line 72

    public String fullName();

    // Declared in Generics.jrag at line 73

    public String typeName();

    // Declared in Generics.jrag at line 140

  public TypeDecl makeGeneric(Signatures.ClassSignature s);


    // Declared in Generics.jrag at line 345


  public SimpleSet addTypeVariables(SimpleSet c, String name);


    // Declared in Generics.jrag at line 543

  public List createArgumentList(ArrayList params);


    // Declared in Generics.jrag at line 66
    public boolean isGenericType();
    // Declared in Generics.jrag at line 67
    public GenericTypeDecl original();
    // Declared in Generics.jrag at line 71
    public TypeDecl rawType();
    // Declared in Generics.jrag at line 477
    public TypeDecl lookupParTypeDecl(ParTypeAccess p);
    // Declared in Generics.jrag at line 514
    public TypeDecl lookupParTypeDecl(ArrayList list);
}
