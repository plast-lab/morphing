class Foo<X> {
    X x;

    <R,A*>[m] for ( public R m (A) : X.methods )
	R m (A args) {
	    return x.m(args);
	}
}

class Bar<Y> {
    Foo<Y> fooy;

    <R2,B*>[n] for ( public R2 n (Number, B, String) : Y.methods )
	 R2 n (Number a, B args, String s) {
	     return fooy.n(a, args, s);
	}
}