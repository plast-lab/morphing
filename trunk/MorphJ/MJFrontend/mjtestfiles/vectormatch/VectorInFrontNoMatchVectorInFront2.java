class Foo<X> {
    X x;

    <R,A*>[m] for ( R m (A, String) : X.methods )
	 R m (A args, String s) {
	     return x.m(args, s);
	}
}

class Bar<Y> {
    Foo<Y> fooy;

    <R2,B*>[n] for ( R2 n (B, String, Object) : Y.methods )
	 R2 n (B args, String o, Object s) {
	     return fooy.n(args, o, s);
	 }
}