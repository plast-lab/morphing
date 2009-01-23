package examples;

import java.util.*;

public class SynchronizeMe<interface T> implements T {
    final T me;
    final Object mutex;


    public SynchronizeMe (T t) {
	if ( t == null )
	    throw new NullPointerException();
	me = t;
	mutex = this;
    }

    public SynchronizeMe (T t, Object mutex) {
	if ( t == null )
	    throw new NullPointerException();
	me = t;
	this.mutex = mutex;
    }

    <R1,A1*,E1*>[m1] for ( R1 m1 (A1) throws E1 : T.methods) 
    public R1 m1 (A1 args) throws E1 {
	return me.m1(args);
    }

    <A2*,E2*>[m2] for ( void m2 (A2) throws E2 : T.methods )
    public void m2 (A2 args) throws E2 {
	me.m2(args);
    }
}
