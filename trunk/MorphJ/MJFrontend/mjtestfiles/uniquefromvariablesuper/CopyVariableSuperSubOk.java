class Mixin<class X, Y extends X> extends X {
    <R extends Object,A*> [m] for ( R m (A) : Y.methods )
	R m (A args) { return null; }
}
