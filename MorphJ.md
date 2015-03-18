# MorphJ: Compile-Time Reflection #

MorphJ is a Java-derived programming language based upon the concept of class morphing. Class morphing is an abstraction mechanism that allows a class to abstract over the structure of other types. For instance, one can define a parametric class `Log<X>` with the definition "for each method of X, provide an identical method that calls the original and logs the return value".

MorphJ is the reference implementation and example of class morphing, and the compiler for it can be found [here](http://code.google.com/p/morphing/downloads/list) for download or in our SVN repository.  It requires an up-to-date Sun Java installation, JUnit 4, and ANT to build.

# Building Instructions #

Once you've downloaded the MorphJ compiler source or checked it out of Subversion, start to build it by setting your $CLASSPATH environment variable to the following, where $mj is the path to your copy of the MorphJ source.

```
bash$ export CLASSPATH=$mj/MorphJ/MJBackend/src:$mj/MorphJ/MJBackend/thirdparty/asm-all-3.1.jar:/usr/share/java/junit4.jar
```

Then proceed to change directories into $mj/MorphJ/MJBackend/src and type `ant build` to build the compiler.  To produce a JAR file for your system, replace the build command with `and jar`.

# Documentation #

Some documentation can be found on this wiki, but you should also read the papers on MorphJ.

  * [Expressive and Safe Static Reflection with MorphJ](http://www.cs.umass.edu/~yannis/morphj-pldi08.pdf)
  * [Morphing: Safely Shaping a Class in the Image of Others](http://www.cs.umass.edu/~yannis/mj.pdf)
  * [Morphing Software for Easier Evolution](http://www.cs.umass.edu/~yannis/ramse07.pdf)

This wiki can tell you about:
  * DesignPatterns used in MorphJ code.
  * DosAndDonts of working with the MorphJ language.

# People #

MorphJ is under development by [Yannis Smaragdakis](http://www.cs.umass.edu/~yannis/) and [Shan-Shan Huang](http://www.freeflygeek.com/), and both will appreciate any comments, tips, or ideas you might have for the MorphJ language.


<a href='Hidden comment: 
= See Also =

* [http://www.eclipse.org/aspectj/ AspectJ]
'></a>