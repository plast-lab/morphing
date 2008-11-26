// tests that reflective declarations are unique, or correctly overrides
// declarations in the supertype.
class OverwriteObjectMethods<X> {
    // OKAY.
    <R,A*> [m] for ( R m (A) : X.methods )
    void m (A args) { }
}

class OverwriteObjectMethods2<X> {
    // OKAY.
    <R,A*>[m] for ( R m (A) : X.methods )
	void to#m(A args) { }
    
    public static void main (String[] argv) {
	// ERROR: expanded type has method:
	// void toString() {}
	// conflicts with String toString() in Object
	OverwriteObjectMethods2<CauseConflict> oomcc;
    }
}

class CauseConflict {
    String String() { return ""; }
}

class Mixin<class X> extends X {
    // ERROR: may conflict with methods in X.
    <R,A*> [mm] for ( R mm (A) : X.methods )
    R mm (A args, String s) { return null; }
}