Class morphing is an abstraction mechanism that allows a class to abstract over the structure of other types. For instance, one can define a parametric class Log

&lt;X&gt;

 with the definition "for each method of X, provide an identical method that calls the original and logs the return value".

The main reference morphing language is MorphJ--an extension of Java.  It allows programmers to create classes "in the image of" other classes. MorphJ provides constructs for reflecting over the structure of types, and using values obtained through reflection to declare members of another types.