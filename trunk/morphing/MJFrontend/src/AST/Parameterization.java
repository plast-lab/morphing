
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public interface Parameterization {
    // Declared in Generics.jrag at line 555

    boolean isRawType();

    // Declared in Generics.jrag at line 556

    int numTypeParameter();

    // Declared in Generics.jrag at line 557

    TypeVariable typeParameter(int index);

    // Declared in Generics.jrag at line 558

    int numTypeArgument();

    // Declared in Generics.jrag at line 559

    TypeDecl typeArgument(int index);

}
