package testcases.junit;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import AST.Problem;


public class UniquenessFromObjectTest extends MJTestCase {

    @Test
    public void testUniquenessFromObject() {
	Collection<Problem> actualProblems = checkTest(
		"UniquenessFromObject.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature toString() is multiply declared "
			+ "in type OverwriteObjectMethods<CauseConflict>"));
	compareProblems(expectedProblems, actualProblems);
    }
    
    @Test
    public void testUniquenessFromObject2() {
	Collection<Problem> actualProblems = checkTest(
		"UniquenessFromObject2.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();	
	noProblems(actualProblems);
    }

}
