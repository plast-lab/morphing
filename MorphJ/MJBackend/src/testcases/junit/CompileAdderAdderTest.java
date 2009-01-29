package testcases.junit;

import java.io.File;

import org.junit.Test;

public class CompileAdderAdderTest extends MJTestCase {

    @Test
    public void testAdder() {
	assertTrue(compileExample("arithmetic" + File.separator + "Adder.java"));
	assertTrue(compileMJTest("AdderTest.java"));
    }
    
}
