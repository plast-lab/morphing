class Bar<X> {
    // ERROR: range could produce duplicate method declarations.
    <R extends Object,A*>[m] for ( R m (A) : X.methods )
	R m () {
	    return null;
	}    
}
