class Mixin<class X> extends X {
    <R extends Object,A*> [m] for ( !final R m (A) : X.methods )
	R get#m (A args) { return null; }
}
