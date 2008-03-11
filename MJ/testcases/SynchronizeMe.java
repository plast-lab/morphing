package testcases;

import java.util.*;

public class SynchronizeMe<interface T> implements T {
    final T me;
    final Object mutex;

    public SynchronizeMe (T t) {
	me = t;
	mutex = this;
    }

    <R,A*,E*>[m] for ( !final R m (A) throws E : T.methods) 
    public R m (A args) throws E {
	return me.m(args);
    }

    <A*,E*>[m] for ( !final void m (A) throws E : T.methods )
    public void m (A args) throws E {
	me.m(args);
    }
}
