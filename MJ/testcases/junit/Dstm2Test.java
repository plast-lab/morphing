package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import testcases.dstm2.*;
import testcases.GetterSetter;

public class Dstm2Test extends TestCase {
    GetterSetter<Recoverable<NonAtomicBean>> atomicbean = 
	new GetterSetter<Recoverable<NonAtomicBean>>();
    
    @Test public void testBackupRecover() {
	atomicbean.setfoo1(3);
	atomicbean.backup();
	atomicbean.setfoo1(7);

	atomicbean.recover();
	assertTrue(atomicbean.getfoo1() == 3);
    }

    @Test public void testBackupRecover2() {
	atomicbean.setfoo2(7.2f);

	// foo2 is not atomic and this should have no effect.
	atomicbean.backup();

	atomicbean.setfoo2(8.4f);
	atomicbean.recover();

	assertTrue(atomicbean.getfoo2() == 8.4f);
    }

}

class NonAtomicBean {
    @atomic int foo1;
    float foo2;
    @atomic double foo3;
}