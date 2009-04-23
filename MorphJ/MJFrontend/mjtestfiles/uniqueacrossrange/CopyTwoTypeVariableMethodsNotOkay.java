class MultiClone<class T,class X> {
	T t;
	X x;

	<R,A*,E*>[m] for(public R m(A) throws E : T.methods)
	public R m(A args) throws E {
		return t.m(args);
	}
	
	<R,A*,E*>[m] for(public R m(A) throws E : X.methods)
	public R m(A args) throws E {
		return x.m(args);
	}
}