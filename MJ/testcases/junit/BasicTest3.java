package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import testcases.*;

public class BasicTest3 extends TestCase {
    GetterSetter<MyBeanClass> gs = new GetterSetter<MyBeanClass>();

    @Test public void testGetterSetter() {
	assertTrue(gs.f1() == 0);
	//	assertTrue(gs.foo() == 0 ); // ERROR
    }

    @Test public void testGetterSetter2() {
	assertTrue(gs.f2() == null);
    }
    
}

class MyBeanClass {
    public int f1;
    protected Object f2;
    private List f3;
    HashMap f4;
}

