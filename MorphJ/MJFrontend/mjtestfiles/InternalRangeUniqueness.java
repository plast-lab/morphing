// test that ranges are internally consistent
class Foo<X> {
    // OKAY
    <R,A*>[m] for ( R m (A) : X.methods )
	R m (A args) {
	    return null;
	}
}

class Bar<X> {
    // ERROR: range could produce duplicate method declarations.
    <R,A*>[m] for ( R m (A) : X.methods )
	R m () {
	    return null;
	}    
}

class Bar2<X> {
    // OKAY
    <R,A*>[m] for ( R m (A) : X.methods )
	R m (A args, String s) {
	    return null;
	}    
}

