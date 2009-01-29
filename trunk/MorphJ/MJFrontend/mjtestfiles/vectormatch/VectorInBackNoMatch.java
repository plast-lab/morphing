// Test that (String, A*) does not match list that doesn't begin with String.

class Foo<X> {
    X x;
    <R,A*>[m] for (public R m (String,A) : X.methods )
	 R m (String s, A args) {
	     return x.m(s,args);
	 }
}

class Bar {

    public int m1() { return 0; }
    public int m2(int i) { return i; }
    public int m3(Object o) { return 0; }
    public int m4(int i, Object o) { return 0; }
    public int m5(int i, String s) { return 0; }
    public int m6(Object o, int i, String s, int j) { return 0; }

    public static void main (String[] argv) {
	Foo<Bar> foobar = new Foo<Bar>();
	foobar.x = new Bar();

	int i = foobar.m1();
	int i2 = foobar.m2(0);
	int i3 = foobar.m3(null);
	int i4 = foobar.m4(0,null);
	int i5 = foobar.m5(0,"");
	int i6 = foobar.m6(null,0,"",0);
    }
}