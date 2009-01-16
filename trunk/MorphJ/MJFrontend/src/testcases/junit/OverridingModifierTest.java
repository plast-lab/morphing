package testcases.junit;

import java.util.Collection;

import org.junit.Test;

import AST.Problem;


public class OverridingModifierTest extends MJTestCase {

    @Test
    public void testInternalRangeUniqueness1() {
	Collection<Problem> actualProblems = checkTest(
		"OverridingModifier.java", new String[0], true);
	noProblems(actualProblems);
    }
}
