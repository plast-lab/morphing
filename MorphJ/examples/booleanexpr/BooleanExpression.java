package booleanexpr;

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
	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; 
			 no R m(A) throws E : TruthMethods<T>.methods)
	public R m(A args) throws E {
		return instance.m(args);
	}
}

class ForceTrue<class T> {
	T instance;
	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; 
			 no boolean proposition_true() : T.methods)
	public R m(A args) throws E {
		return instance.m(args);
	}
	public boolean proposition_true() {
		return true;
	}
}

class And<class T,class U> {
	T instance;

	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; 
			 some R m(A) throws E : U.methods)
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

class AClass {
	public int stuff() {
		return 4;
	}
}

public class BooleanExpression {
	public static void main(String argv[]) {
	    boolean x = (new Ident<ForceTrue<AClass>>()).proposition_true();

		//Should compile, true.
		boolean e1 = (new Or<ForceTrue<AClass>,ForceFalse<AClass>>()).proposition_true();
		//Should not compile, false.
		//boolean e2 = (new And<ForceTrue<AClass>,ForceFalse<AClass>>()).proposition_true();

		//Just testing operator order.
		//Should compile, true.
		boolean e3 = (new Or<ForceFalse<AClass>,ForceTrue<AClass>>()).proposition_true();
		//Should not compile, false.
		//boolean e4 = (new And<ForceFalse<AClass>,ForceTrue<AClass>>()).proposition_true();
		

		//A nice, complex expression.  An implication encoded as (~p OR q).
		
		boolean e5 = (new Implication<ForceFalse<AClass>,ForceTrue<AClass>>()).proposition_true();

		// TruthMethods<Aclass> : nothing.
		// ForceFalse<AClass> : int stuff() 
		// ForceTrue<AClass> : int stuff(); boolean proposition_true()
		// Complement<ForceFalse<AClass> : 
		//   int stuff(); boolean proposition_true() 
		// Or<Complement<ForceFalse<AClass>>, ForceTrue<AClass>> :
		//   int stuff(); boolean proposition_true()
		System.out.println(e1);
	}
}