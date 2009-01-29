class Foo<X> {
    X x;

    <R,A*>[m] for ( public R m (String, A) : X.methods )
	 R m (String s, A args) {
	     return x.m(s, args);
	}
}

class Bar<Y> {
    Foo<Y> fooy;

    <R2,B*>[n] for ( public R2 n (String, Object, B) : Y.methods )
	 R2 n (String s, Object o, B args) {
	     return fooy.n(s,o,args);
	 }
}