package recref;

import java.util.*;

class Matrix<X> {
	X contents[][];
	String xaxis,yaxis;
	Matrix(int x,int y,String horizontal,String vertical) {
		contents = new X[x][y];
		xaxis = horizontal;
		yaxis = vertical;
	}
}

class FilterOut<class X> {
	for(String toString() : X.methods)
	public String toString() {
		return "";
	}
}

class SelfLogger<class X> extends X {

	public String toString() {
		String result = "";
		<T extends Object>[f] for(!static T f : X.fields)
		result.concat(f.toString());
		return result;
	}

	<R,A*,E*>[m] for(!final !private R m(A) throws E : X.methods ; 
			 no R m(A) throws E : FilterOut<X>.methods)
	public R m(A args) throws E {
	    R result = super.m(args);
	    System.out.println(toString());
	    return result;
	}
}
