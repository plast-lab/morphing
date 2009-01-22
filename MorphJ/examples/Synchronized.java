package examples;

import java.util.*;

class Synchronized<class T> extends T {
	<R1,A1*,E1*>[m1] for (R1 m1 (A1) throws E1 : T.methods ; no final R1 m1(A1) throws E1 : T.methods)
	synchronized public R1 m1(A1 args) throws E1 {
		return super.m1(args);
	}
	
	<A2*,E2*>[m2] for (void m2 (A2) throws E2 : T.methods ; no final void m2(A2) throws E2 : T.methods)
	synchronized public void m2(A2 args) throws E2 {
		super.m2(args);
	}
}

//MJCompiler has a bug wherein it assumes that methods explicitly patterned as not final are, in fact, final for some reason.  Shanshan knows why it happens.  The patterns are only masking method signatures and not the modifiers.  It can only pattern-match on things that *do* have a modifier rather than things that *don't*.
