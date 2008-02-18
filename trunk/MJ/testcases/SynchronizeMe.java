package testcases;

import java.util.*;

public class SynchronizeMe<interface T> implements T {
    final T me;
    final Object mutex;

    public SynchronizeMe (T t) {
	me = t;
	mutex = this;
    }

    <R>[m] for (R m () : T.methods) 
    public R m () {
	return me.m();
    }

    public static void main (String[] argv) {
	List myList = new ArrayList();
	SynchronizeMe<List> synchronizedList = 
	    new SynchronizeMe<List>(myList);
	System.out.println("size:" + synchronizedList.size());
    }
}
