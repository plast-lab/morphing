class ClassExtendsVariable<class X> extends X {
    public static void main(String[] argv) {
	// ERROR: String is final.
	ClassExtendsVariable<String> cs;

	// ERROR: Collection is not a class.
	ClassExtendsVariable<java.util.Collection> cc;

	// OK
	ClassExtendsVariable<java.util.ArrayList> ca;
    }
}
