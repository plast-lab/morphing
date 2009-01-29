package testcases.junit;

import java.io.File;

import org.junit.Test;


public class CompileAntiGetter extends MJTestCase {

    @Test
    public void testAntiGetter() {
	assertTrue(compileExample("AntiGetter.java"));
	assertTrue(compileMJTest("AntiGetterTest.java"));
    }
}
