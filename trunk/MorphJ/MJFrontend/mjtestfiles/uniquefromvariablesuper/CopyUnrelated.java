class Mixin<class X> extends X {
    <R,A*> [m] for ( R m (A) : Foo.methods )
	R m (A args) { return null; }
}

abstract class Foo {
    public int m1 () { return 0; }
    public Object m2 () { return null; }
    protected String m3 ( Number n ) { return ""; }
    public abstract Number m4 ( int i, Float f);
    private final Object m5 ( String s, int i, Object o) { return o ; }
}


