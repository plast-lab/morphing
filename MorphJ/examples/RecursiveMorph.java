package examples;

import java.util.*;

class ShouldWork<class T> {
	T delegate;
	
	<R,A*,E*>[m] for(public R m(A) throws E : T.methods)
	public R m(A args) throws E {
		return delegate.m(args);
	}

	<A*,E*>[m] for(public void m(A) throws E : T.methods)
	public void m(A args) throws E {
		delegate.m(args);
	}
}

class AlsoWorks<class T> {
	T delegate;

	<A*,E*> [m] for(public m(A) throws E : T.methods)
	public void m(A args) throws E {
		((T)delegate).m(args);
	}
}

class TestClass {
	public void something() {
		System.out.println("Doing something.");
	}

	public int something_else() {
		return 4; //Guaranteed random number chosen by d20 roll ;-).
	}
}

//Shanshan actually got the compiler to work with some limited unions.
class ActuallyWorks extends AlsoWorks<ShouldWork<TestClass>> { }