// OK
class LogMixin<class X> extends X {
    <R,A*>[m] for(!final R m(A) : X.methods)
	public R m(A a) {
	    R result = super.m(a);
	    System.out.println(result);
	    return result;
	}
}