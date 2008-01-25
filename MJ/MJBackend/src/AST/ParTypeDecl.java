
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;



  public interface ParTypeDecl extends  Parameterization {
    // Declared in Generics.jrag at line 147

    //syn String name();
    int getNumArgument();

    // Declared in Generics.jrag at line 148

    Access getArgument(int index);

    // Declared in Generics.jrag at line 151

    public String typeName();

    // Declared in Generics.jrag at line 563

  public int numTypeParameter();


    // Declared in Generics.jrag at line 566

  public TypeVariable typeParameter(int index);


    // Declared in Generics.jrag at line 569

  public int numTypeArgument();


    // Declared in Generics.jrag at line 572

  public TypeDecl typeArgument(int index);


    // Declared in Generics.jrag at line 606

  public Access substitute(Parameterization parTypeDecl);


    // Declared in GenericsParTypeDecl.jrag at line 76

  
  public Access createQualifiedAccess();


    // Declared in GenericsCodegen.jrag at line 267


  public void java2Transformation();


    // Declared in Generics.jrag at line 149
    public boolean isParameterizedType();
    // Declared in Generics.jrag at line 150
    public boolean isRawType();
    // Declared in Generics.jrag at line 248
    public boolean sameArgument(ParTypeDecl decl);
    // Declared in Generics.jrag at line 432
    public boolean sameSignature(Access a);
    // Declared in Generics.jrag at line 467
    public boolean sameSignature(ArrayList list);
    // Declared in Generics.jrag at line 773
    public HashMap localMethodsSignatureMap();
    // Declared in Generics.jrag at line 788
    public SimpleSet fields(String name);
    // Declared in Generics.jrag at line 803
    public SimpleSet memberTypes(String name);
    // Declared in Generics.jrag at line 833
    public Collection constructors();
    // Declared in GenericsParTypeDecl.jrag at line 21
    public String nameWithArgs();
    // Declared in GenericsParTypeDecl.jrag at line 36
    public TypeDecl genericDecl();
}
