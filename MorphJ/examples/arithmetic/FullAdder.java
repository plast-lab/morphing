package arithmetic;

import java.util.*;

class TruthMethods<class T> {
	T instance;
	<R,A*,E*>[m] for(R proposition_#m(A) throws E : T.methods)
	public R proposition_#m(A args) throws E {
		return instance.proposition_#m(args);
	}
}

class ForceFalse<class T> {
	T instance;
	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; no R m(A) throws E : TruthMethods<T>.methods)
	public R m(A args) throws E {
		return instance.m(args);
	}
}

class ForceTrue<class T> {
	T instance;
	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; no boolean proposition_true() : T.methods)
	public R m(A args) throws E {
		return instance.m(args);
	}
	public boolean proposition_true() {
		return true;
	}
}

class And<class T,class U> {
	T instance;

	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; some R m(A) throws E : U.methods)
	public R m(A args) throws E {
		return instance.m(args);
	}
}

class Or<class T,class U> {
	T x;
	U y;

	<R,A*,E*>[l] for(R l(A) throws E : T.methods ; some R l(A) throws E : U.methods)
	public R l(A args) throws E {
		return x.l(args);
	}

	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; no R m(A) throws E : U.methods)
	public R m(A args) throws E {
		return x.m(args);
	}

	<R,A*,E*>[n] for(R n(A) throws E : U.methods ; no R n(A) throws E : T.methods)
	public R n(A args) throws E {
		return y.n(args);
	}
}

class Complement<class T> {
	T instance;
	//If T lacks a "proposition_####" method to make it TRUE, add one.
	<R,A*,E*>[m] for(R proposition_#m(A) throws E : ForceTrue<T>.methods ; no R proposition_#m(A) throws E : T.methods)
	public boolean proposition_true() {
		return true;
	}

	//If T has at least one "proposition_####" method remove all of them.
	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; no R m(A) throws E : TruthMethods<T>.methods)
	public R m(A args) throws E {
		return instance.m(args);
	}
}

class Ident<class T> extends Complement<Complement<T>> { }

class Implication<class T,class U> extends Or<Complement<T>,U> { }

class XOr<class T,class U> extends And<Or<T,U>,Complement<And<T,U>>> { }

class Sum<class X,class Y> extends XOr<X,Y> { }
class Carry<class X,class Y> extends And<X,Y> { }

class HalfAdder<class X,class Y> {
	Sum<X,Y> my_sum;
	Carry<X,Y> my_carry;

	<R,A*,E*>[m] for(R m(A) throws E : Sum<X,Y>.methods)
	public R sum_#m(A args) throws E {
		return my_sum.m(args);
	}

	<R,A*,E*>[m] for(R m(A) throws E : Carry<X,Y>.methods)
	public R carry_#m(A args) throws E {
		return my_carry.m(args);
	}
}

class FullAdder<class A,class B,class C> {
	Sum<Sum<A,B>,C> my_sum;
	Or<Carry<A,B>,Carry<Sum<A,B>,C>> my_carry;

	<R,W*,E*>[m] for(R m(W) throws E : Sum<Sum<A,B>,C>.methods)
	public R sum_#m(W args) throws E {
		return my_sum.m(args);
	}

	<R,W*,E*>[m] for(R m(W) throws E : Or<Carry<A,B>,Carry<Sum<A,B>,C>>.methods)
	public R carry_#m(W args) throws E {
		return my_carry.m(args);
	}
}