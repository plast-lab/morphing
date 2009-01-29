// Test that (A*,String) does not match any vector that does not
// end in String.

class Foo<X> {
    X x;
    <R,A*>[m] for ( public R m (A, String) : X.methods )
	R m (A arg, String s) {
	    return x.m(arg, s);
	}
}

class Bar {
    int m1() { return 0; }
    int m2(int i) { return i; }
    int m3(Object o) { return 0; }
    int m4(int i, Object o) { return 0; }

    public static void main (String[] argv) {
	Foo<Bar> foobar = new Foo<Bar>();
	foobar.x = new Bar();

	int i = foobar.m1();
	int i2 = foobar.m2(0);
	int i3 = foobar.m3(null);
	int i4 = foobar.m4(0,null);
    }
}