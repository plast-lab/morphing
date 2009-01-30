package examples.booleanexpr;

import java.util.*;

class TruthMethods<class T> {
	T instance;
	<R,A*,E*>[m] for(public R proposition_#m(A) throws E : T.methods)
	public R proposition_#m(A args) throws E {
		return instance.proposition_#m(args);
	}
}

class ForceFalse<class T> {
	T instance;
	<R,A*,E*>[m] for(public R m(A) throws E : T.methods ; 
			 no R m(A) throws E : TruthMethods<T>.methods)
	public R m(A args) throws E {
		return instance.m(args);
	}
}

class ForceTrue<class T> {
    T instance;
    <R,A*,E*>[m] for(public R m(A) throws E : T.methods ; 
		     no boolean proposition_true() : T.methods)
	 public R m(A args) throws E {
	     return instance.m(args);
	 }
    public boolean proposition_true() {
	return true;
    }
}
class Complement<class T> {
    T instance;

    public Complement(T t ) { instance = t; }
    public Complement() { }

    //If T lacks a "proposition_####" method to make it TRUE, add one.
    <R,A*,E*>[m] for(public R proposition_#m(A) throws E :ForceTrue<T>.methods;
		     no R proposition_#m(A) throws E : T.methods)
	 public boolean proposition_true() {
	     return true;
	 }
    
    //If T has at least one "proposition_####" method remove all of them.
    <R,A*,E*>[m] for(public R m(A) throws E : T.methods ; 
		     no R m(A) throws E : TruthMethods<T>.methods)
	 public R m(A args) throws E {
	     return instance.m(args);
	 }
}

class And<class T,class U> {
    T instance;
    
    <R,A*,E*>[m] for(public R m(A) throws E : T.methods ; 
		     some R m(A) throws E : U.methods)
	 public R m(A args) throws E {
	     return instance.m(args);
	 }
}

class Or<class T,class U> {
    T x;
    U y;
    
    public Or(T t, U u) { x = t; y = u; }
    
    <R,A*,E*>[l] for(public R l(A) throws E : T.methods ; 
		     some R l(A) throws E : U.methods)
	 public R l(A args) throws E {
	     return x.l(args);
	 }
    
    <R,A*,E*>[m] for(public R m(A) throws E : T.methods ; 
		     no R m(A) throws E : U.methods)
	 public R m(A args) throws E {
	     return x.m(args);
	 }
    
    <R,A*,E*>[n] for(public R n(A) throws E : U.methods ; 
		     no R n(A) throws E : T.methods)
	 public R n(A args) throws E {
	     return y.n(args);
	 }
}

class Ident<class T> extends Complement<Complement<T>> { }

class Implication<class T,class U> extends Or<Complement<T>,U> { 
    public Implication(T t, U u) {
	super(new Complement<T>(t), u);
    }
}

class XOr<class T,class U> extends And<Or<T,U>,Complement<And<T,U>>> { }

class AClass {
    public int stuff() {
	return 4;
    }
}

public class BooleanExpression {
    // true
    public boolean trueIdent() {
	return (new Ident<ForceTrue<AClass>>()).proposition_true();
    }

    // true
    public boolean trueOrFalse() {
	Or<ForceTrue<AClass>,ForceFalse<AClass>> trueOrFalse = 
	    new Or<ForceTrue<AClass>,ForceFalse<AClass>>(new ForceTrue<AClass>(), new ForceFalse<AClass>());
	return trueOrFalse.proposition_true();
    }

    // true
    public boolean falseOrTrue() {
	Or<ForceFalse<AClass>,ForceTrue<AClass>> falseOrTrue = 
	    new Or<ForceFalse<AClass>,ForceTrue<AClass>>(new ForceFalse<AClass>(), new ForceTrue<AClass>());
	return falseOrTrue.proposition_true();
    }

    public boolean falseImpliesTrue() {
	Implication<ForceFalse<AClass>,ForceTrue<AClass>> falseImpliesTrue 
	    = new Implication<ForceFalse<AClass>,ForceTrue<AClass>>(new ForceFalse<AClass>(), new ForceTrue<AClass>());
	return falseImpliesTrue.proposition_true();
    }

}