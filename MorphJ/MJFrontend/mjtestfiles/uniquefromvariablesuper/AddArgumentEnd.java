class Mixin<class X> extends X {
    <R extends Object,A*> [m] for ( R m (A) : X.methods )
	R m (A args, String t) { return null; }
}
