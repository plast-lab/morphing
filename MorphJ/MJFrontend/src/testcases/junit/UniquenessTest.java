package testcases.junit;

import org.junit.Test;
import java.util.*;

import AST.*;
import main.*;
import java.io.File;

public class UniquenessTest extends MJTestCase {
    /*
     * @Test public void testInternalRangeUniqueness() { Collection<Problem>
     * actualProblems = checkTest( "InternalRangeUniqueness.java", new
     * String[0], true); Collection<Problem> expectedProblems = new ArrayList<Problem>();
     * expectedProblems .add(makeError("method with signature \n" + "<R,A*>[m]for(
     * R m(A):X.methods;)\n" + "R m()\n" + " could expand to conflicting or
     * duplicating method declarations.")); compareProblems(expectedProblems,
     * actualProblems); }
     */
    @Test
    public void testUniquenessFromSupertype() {
	Collection<Problem> actualProblems = checkTest(
		"UniquenessFromSupertype.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("the return type of method toString() in OverwriteObjectMethods2<CauseConflict> does not match the return type of method toString() in java.lang.Object and may thus not be overriden"));
	expectedProblems.add(makeError("overriding access modifier error"));
	expectedProblems
		.add(makeError("method with signature \n"
			+ "      <R,A*>[m]for( R m(A):X.methods;)\n"
			+ "      R m(A, java.lang.String)\n"
			+ "   conflicts with method\n"
			+ "      <,A* extends mj.lang.NonVoid,E* extends java.lang.Throwable>[m]for( R m(A) throws E:X.methods;)\n"
			+ "      R m(A)\n" 
			+ "   in type X."));
	compareProblems(expectedProblems, actualProblems);
    }
}
