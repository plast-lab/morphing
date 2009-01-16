class Foo<X> {
    X x;

    <R,A*>[m] for ( R m(A) : X.methods)
	R m (A args) {
	    return x.m(args);
	}
}

class Bar {

    // vary argument types.
    int m1() { return 0; }
    int m2(int a1) { return 0; }
    int m3(String s) { return 0; }
    int m4(int a, String s) { return 0; }
    int m5(Object o, String s) { return 0; }

    public static void main ( String[] argv) {
	Foo<Bar> foobar = new Foo<Bar>();
	foobar.x = new Bar();

	int i = foobar.m1();
	int i2 = foobar.m2(0);
	int i3 = foobar.m3("");
	int i4 = foobar.m4(0, "");
	int i5 = foobar.m5("", "");
    }
}