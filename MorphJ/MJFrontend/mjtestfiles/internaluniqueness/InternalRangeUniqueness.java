// test that ranges are internally consistent
class Foo<X> {
    // OKAY
    <R extends Object,A*>[m] for ( R m (A) : X.methods )
	R m (A args) {
	    return null;
	}
}
