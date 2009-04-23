package testcases.junit;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import AST.Problem;
import org.junit.Before;

public class AcrossRangeUniquenessTest extends MJTestCase {

	@Before
	public void setUp() {
		super.testDir = "uniqueacrossrange" + File.separator;
	}

	@Test
	public void testInternalRangeUniqueness1() {
		actualProblems = checkTest("CopyTwoTypeVariableMethodsNotOkay.java",
				new String[0], true);
		clearExpected();
		addExpected(makeError("method with signature \n"
				+ "      <R,A*,E*>[m]for( public R m(A) throws E:T.methods;)\n"
				+ "      R m(A)\n" + "   conflicts with method\n"
				+ "      <R,A*,E*>[m]for( public R m(A) throws E:X.methods;)\n"
				+ "      R m(A)\n" + "   in type MultiClone."));
		
		addExpected(makeError("method with signature \n"
				+ "      <R,A*,E*>[m]for( public R m(A) throws E:X.methods;)\n"
				+ "      R m(A)\n" + "   conflicts with method\n"
				+ "      <R,A*,E*>[m]for( public R m(A) throws E:T.methods;)\n"
				+ "      R m(A)\n" + "   in type MultiClone."));
		compareProblems();
	}
}
