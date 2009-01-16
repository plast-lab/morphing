class OverwriteObjectMethods<X> {
    // OKAY.
    <R,A*>[m] for ( R m (A) : X.methods )
	void to#m(A args) { }
    
    public static void main (String[] argv) {
	// ERROR: expanded type has method:
	// void toString() {}
	// conflicts with String toString() in Object
	OverwriteObjectMethods<CauseConflict> oomcc;
    }
}

class CauseConflict {
    String String() { return ""; }
}
