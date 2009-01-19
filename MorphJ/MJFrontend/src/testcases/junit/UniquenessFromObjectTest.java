package testcases.junit;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;

import AST.Problem;

public class UniquenessFromObjectTest extends MJTestCase {

    
    @Test
    public void testUniquenessFromObject() {
	Collection<Problem> actualProblems = checkTest("UniquenessFromObject.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("the return type of method toString() in OverwriteObjectMethods<CauseConflict> does not match the return type of method toString() in java.lang.Object and may thus not be overriden"));
	expectedProblems.add(makeError("overriding access modifier error"));
	compareProblems(expectedProblems, actualProblems);
    }

    @Test
    public void testUniquenessFromObject2() {
	Collection<Problem> actualProblems = checkTest("UniquenessFromObject2.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	noProblems(actualProblems);
    }

}
