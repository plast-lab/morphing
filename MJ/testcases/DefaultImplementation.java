package testcases;

public class DefaultImplementation<X, interface I> implements I {
    X x;
    public DefaultImplementation(X x) { this.x = x; }

    // for all methods in I, if the same method does
    // not appear in X, provide default implementation.
    <R extends Object,A*>[m]for( R m (A) : I.methods ; no R m (A) : X.methods )
    public R m (A a) { return null; }

    <A1*>[m]for( void m (A1) : I.methods ; no void m (A1) : X.methods )
    public void m (A1 a) { }

    <A2*>[m]for( boolean m (A2) : I.methods ; no boolean m (A2) : X.methods )
    boolean m (A2 a) { return false; }

    <A3*>[m]for( int m (A3) : I.methods ; no int m (A3) : X.methods )
    public int m (A3 a) { return 0; }

    <A*>[m]for( byte m (A) : I.methods ; no byte m (A) : X.methods )
    byte m (A a) { return 0; }

    <A*>[m]for( short m (A) : I.methods ; no short m (A) : X.methods )
    short m (A a) { return 0; }

    <A*>[m]for( long m (A) : I.methods ; no long m (A) : X.methods )
    long m (A a) { return 0; }

    <A*>[m]for( char m (A) : I.methods ; no char m (A) : X.methods )
    char m (A a) { return 0; }

    <A*>[m]for( float m (A) : I.methods ; no float m (A) : X.methods )
    float m (A a) { return 0; }

    <A*>[m]for( double m (A) : I.methods ; no double m (A) : X.methods )
    double m (A a) { return 0; }

    // for all methods in X that *do* correctly override
    // methods in I, we need to copy them. 
    <R,A*>[m]for( R m (A) : I.methods ; some R m (A) : X.methods )
    public R m (A a) { return x.m(a); }


    <A*>[m]for( void m (A) : I.methods ; some void m (A) : X.methods )
    public void m (A a) { x.m(a); }

    // for all methods in X, such that there is no method
    // in I with the same name and arguments, copy method.
    <R,A*>[m]for( R m (A) : X.methods; no m (A) : I.methods)
    R m (A a) { return x.m(a); }

}
