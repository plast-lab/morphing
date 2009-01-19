class Mixin<X, class Y extends X> extends Y {
    <R extends Object,A*> [m] for ( !final R m (A) : X.methods )
	R m (A args) { return null; }
}
