package examples;

import java.util.*;

class AllGetters<class T> {
	T instance;

	public AllGetters ( T t ) { instance = t; }

	<R,A*,E*>[m] for(public R get_#m(A) throws E : T.methods)
	public R get_#m(A args) {
		return instance.get_#m(args);
	}
}

public class AntiGetter<class T> {
	T instance;

	public AntiGetter ( T t ) { instance = t; }

	<R,A*,E*>[m] for(public R m(A) throws E : T.methods; 
			 no R m(A) throws E : AllGetters<T>.methods)
	public R m(A args) {
		 return instance.m(args);
	}
	/*
	public static void main(String argv[]) {
	    AntiGetter<Foo> baz = new AntiGetter<Foo>(new Foo());
	    System.out.println(baz.givefour());
	    //This following line should cause compilation to fail if not commented out.
	    //System.out.println(baz.get_bar());
	}
	*/
}

class Foo {
    public int get_bar() {
	return 4;
    }
    public int givefour() {
	return 4;
    }
}

//Write classes that morph on various boolean combinations of patterns: and, or, not.  See what practical applications they may have.