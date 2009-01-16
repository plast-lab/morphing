class Foo<X> {
    X x;
    <R,A* extends Number>[m] for ( R m (A) : X.methods )
	R m (A args) {
	    return x.m(args);
	}
}

class Bar {

    int m1(Integer i) { return 0; }
    int m2(Float f, Integer i) { return 0; }
    int m3(Float f, Integer i, Number n) { return 0; }

    public static void main(String[] argv) {
	Foo<Bar> foobar = new Foo<Bar>();
	foobar.x = new Bar();

	foobar.m1(new Integer(3));
	foobar.m2(new Float(3.0f), new Integer(3));
	foobar.m3(null, null, new Double(4.0d));
    }
    
}