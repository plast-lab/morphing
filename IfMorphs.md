If morphs only make a single declaration, based only upon whether or not at least one member of the morphed class exists that matches their patterns.  They can have secondary patterns in addition to their primary pattern exactly as for iterations can, but an if morph does not bind the iteration variables in the method or field declaration itself.  Formally speaking, if morphs output a declaration _if and only if_ their pattern, always a [nested pattern](PatternMatching.md) evaluates to a Boolean "true".  `some` patterns evaluate to true when their pattern binds a set of one or more declarations, and `no` patterns evaluate to true when the set they bind is empty.

If morphs can be used to provide class members that may be "missing" for the programmer's purpose in the original class upon which the new one is parametrized.

```
<R> if ( no public R restore() : X.methods ) 
public void restore() { ... }
```

This declaration will declare a restore method in the class if and only if a restore method returning some type R does not already exist in parameter class X.

MorphJ also has an `errorif` construct that allows programmers to make assertions about the details of the classes upon which they specialize their morphing classes.  `errorif` will throw a compile-time error if its "condition" evaluates to "true", but the compiler will acknowledge this as an error in the specialization of the morphing class rather than in its definition.

```
class SizeMixin<X> extends X {
 <F> errorif ( some F size : X.fields ) 
 int size = 0;
}
```

`errorif` here notifies the compiler that any X that already possesses a field named "size" is inappropriate to instantiate `SizeMixin<X>`.

Note that the patterns used in `if` and `errorif` declarations work like nested patterns: the type variables specified don't actually bind to anything.  Those type variables cannot be used in the resulting declaration.