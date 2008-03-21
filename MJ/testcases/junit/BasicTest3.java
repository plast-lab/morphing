package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import testcases.*;

public class BasicTest3 extends TestCase {
    GetterSetter<MyBeanClass> gs = new GetterSetter<MyBeanClass>();

    @Test public void testGetterSetter() {
	assertTrue(gs.getf1() == 0);
	//	assertTrue(gs.foo() == 0 ); // ERROR
    }

    @Test public void testGetterSetter2() {
	assertTrue(gs.getf2() == null);
    }

    @Test public void testGetterSetter3() {
	assertTrue(gs.getf3() != null);
    }

    @Test public void testGetterSetter4() {
	gs.setf1(3);
	assertTrue(gs.getf1() == 3);
    }

    @Test public void testGetterSetter5() {
	gs.setf2(new HashMap());
	assertTrue(gs.getf2().get("foo").equals("bar"));
    }
}

class MyBeanClass {
    public int f1;
    protected HashMap f2;
    private List f3;
    HashMap f4;

    public List getf3() { return new ArrayList(); }
    public void setf2(HashMap m) {
	f2 = new HashMap();
	f2.put("foo", "bar");
    }
}

class GetterSetterMyBeanClass extends MyBeanClass {
    public List getf3() { return super.getf3(); }

    public void setf1(int i) { this.f1 = i; }
}