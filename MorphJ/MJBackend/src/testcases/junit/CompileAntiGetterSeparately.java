package testcases.junit;

import java.io.File;

import org.junit.Test;


public class CompileAntiGetterSeparately extends MJTestCase {

    @Test
    public void testAntiGetter() {
	assertTrue(compileMJTest("AntiGetterTest.java"));
    }
}
