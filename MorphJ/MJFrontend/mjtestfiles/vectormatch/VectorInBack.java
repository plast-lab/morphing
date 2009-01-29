// Test that (String, A*) matches list begin with String.

class Foo<X> {
    X x;
    <R,A*>[m] for ( public R m (String,A) : X.methods )
	 R m (String s, A args) {
	     return x.m(s,args);
	 }
}

class Bar {
    
    public int m1(String s) { return 0; }
    public int m2(String s, int i) { return i; }
    public int m3(String s, Object o) { return 0; }
    public int m4(String s, int i, Object o) { return 0; }

    public static void main (String[] argv) {
	Foo<Bar> foobar = new Foo<Bar>();
	foobar.x = new Bar();

	int i = foobar.m1("");
	int i2 = foobar.m2("",0);
	int i3 = foobar.m3("",null);
	int i4 = foobar.m4("",0,null);
    }
}