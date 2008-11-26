package testcases.junit;

import org.junit.Test;
import java.util.*;

import AST.*;
import main.*;
import java.io.File;

public class UniquenessTest extends MJTestCase {

    @Test
    public void testInternalRangeUniqueness() {
	Collection<Problem> actualProblems = checkTest(
		"InternalRangeUniqueness.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R,A*>[m]for( R m(A):X.methods;)\n"
			+ "R m()"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    @Test
    public void testUniquenessFromSupertype() {
	Collection<Problem> actualProblems = checkTest(
		"UniquenessFromSupertype.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
		
	expectedProblems.add(makeError("method with signature toString() is multiply declared in type OverwriteObjectMethods2<CauseConflict>"));
//	expectedProblems.add(makeError("the return type of method toString() in OverwriteObjectMethods2<CauseConflict> does not match the return type of method toString() in java.lang.Object and may thus not be overriden"));
//	expectedProblems.add(makeError("overriding access modifier error"));
		
	expectedProblems.add(makeError("the return type of method mm(A, java.lang.String) in Mixin does not match the return type of method it may override in X and may thus not be overriden"));
	expectedProblems.add(makeError("method mm(A, java.lang.String) in Mixin could potentially override a final method in X"));

	compareProblems(expectedProblems, actualProblems);
    }
}
