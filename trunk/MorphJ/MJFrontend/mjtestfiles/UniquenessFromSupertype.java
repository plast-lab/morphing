class Mixin<class X> extends X {
    // ERROR: may conflict with methods in X.
    <R,A*> [mm] for ( R mm (A) : X.methods )
    R mm (A args, String s) { return null; }
}
