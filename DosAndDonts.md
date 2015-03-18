# Introduction #

Every language has a set of idioms that programmers find very useful, and a set of idioms that programmers know don't work.  Machine analysis cannot always detect these, and so we human programmers simply have to learn them.  Here are the ones applicable in MorphJ.

# Details #

```
public class DefaultImplementation<class X, interface I> extends X implements I {
   //class contents go here ...
}
```

Because `X` and `I` can, in general (rather than for specific `X`s and `I`s), have conflicting methods, this idiom will simply never work.  Either `X` and `I` conflict, or the programmer delineates their code enough to avoid a conflict in a way that will fail at implementing `I` completely.  While proving that such a problem _must_ occur is non-trivial, every attempt tried has resulted in either a conflict between `X` and `I` or a failure to properly implement `I`.

Instead, try using delegation.