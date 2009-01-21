package arithmetic;

import java.util.*;

class Adder<class X,class Y> {
	X my_x;
	Y my_y;

	<R,A*,E*>[mx] for(R mx(A) throws E : X.methods)
	public R X_#mx(A args) throws E {
		return my_x.mx(args);
	}

	<R,A*,E*>[my] for(R my(A) throws E : Y.methods)
	public R Y_#my(A args) throws E {
		return my_y.my(args);
	}
}

class OnlyOne<class T> {
	<R,A*,E*>[m] if(some R m(A) throws E : T.methods)
	public int method() {
		return 1;
	}
}

class MinusOne<class T> {
	T my_t;

	<R,A*,E*>[m] for(R m(A) throws E : T.methods ; no R m(A) throws E : OnlyOne<T>.methods)
	public R m(A args) throws E {
	    return my_t.m(args);
	}
}

class Subtracter<class X,class Y> {
	X my_x;
	Y my_y;

	<R,A*,E*>[my] if(no R my(A) throws E : Y.methods)
	<R2,A2*,E2*>[mx] for(R2 mx(A2) throws E2 : X.methods)
	public R2 mx(A2 args) throws E2 {
	    return my_x.mx(args);
	}
}
