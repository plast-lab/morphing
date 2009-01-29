package testcases.junit;

import org.junit.Test;


public class CompileAdderSeparately extends MJTestCase {

    @Test
    public void testAdderSeparateCompile() {
	assertTrue(compileMJTest("AdderTest.java"));	
    }
}
