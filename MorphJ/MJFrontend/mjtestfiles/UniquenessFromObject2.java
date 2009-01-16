class OverwriteObjectMethods<X> {
    // MAY cause conflict if X has method R Class() { ... }
    // ONLY produce warning.
    <R extends Object>[m] for ( R m() : X.methods )
	R get#m() { return null; }
}