package testcases.junit;

import java.io.File;

import org.junit.Test;


public class CompileBooleanExpressionSeparately extends MJTestCase {

    @Test
    public void testBooleanExpr() {
	assertTrue(compileExample("booleanexpr" + File.separator + "BooleanExpression.java"));
	assertTrue(compileMJTest("BooleanExprTest.java"));
    }
}
