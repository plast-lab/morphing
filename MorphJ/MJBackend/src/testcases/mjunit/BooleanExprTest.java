package testcases.mjunit;

import junit.framework.TestCase;
import org.junit.Test;

import examples.booleanexpr.*;

public class BooleanExprTest extends TestCase {

    BooleanExpression be = new BooleanExpression();

    @Test public void testBooleanExpr() {
	assertTrue(be.trueIdent());
    }

    @Test public void testTrueOrFalseIsTrue() {
	assertTrue(be.trueOrFalse());
    }

    @Test public void testFalseOrTrueIsTrue() {
	assertTrue(be.falseOrTrue());
    }

    @Test public void testFalseImpliesTrue() {
	assertTrue(be.falseImpliesTrue());
    }
}


public class Foo {
    public int get_bar() {
	return 4;
    }
    public int givefour() {
	return 4;
    }
}

