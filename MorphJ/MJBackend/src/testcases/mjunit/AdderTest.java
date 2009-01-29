package testcases.mjunit;

import junit.framework.TestCase;
import org.junit.Test;

import examples.arithmetic.*;

public class AdderTest extends TestCase {
 
    @Test public void testAdder () {
	Adder<Foo,Bar> afb = new Adder<Foo,Bar>(new Foo(), new Bar());
	assertTrue(afb.X_m1() == 0);
	assertTrue(afb.Y_m4("foo", 4).equals("foo"));
    }
}

class Foo {
    public int m1() { return 0; }
    String m2() { return "foo"; }
    Integer m3 ( int i) { return new Integer(i); }
    String m4 ( String s, int i ) { return s; }
    Object m5 ( float f, Object o ) throws Exception { 
	if ( o == this )
	    throw new Exception("input o is this.");
	return new Float(f);
    }
}

class Bar {
    int m1() { return 0; }
    String m2() { return "foo"; }
    Integer m3 ( int i) { return new Integer(i); }
    public String m4 ( String s, int i ) { return s; }
    Object m5 ( float f, Object o ) throws Exception { 
	if ( o == this )
	    throw new Exception("input o is this.");
	return new Float(f);
    }    
}
