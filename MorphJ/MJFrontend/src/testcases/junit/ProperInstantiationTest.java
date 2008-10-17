package testcases.junit;

import org.junit.Test;
import java.util.*;

import AST.*;
import main.*;
import java.io.File;

public class ProperInstantiationTest extends MJTestCase {

    @Test
    public void testSupertypeInstantiation() {
	Collection<Problem> actualProblems = checkTest(
		"VariableSupertypeInstantiation.java", new String[0], false);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("ClassExtendsVariable<java.lang.String> declares final class java.lang.String as a superclass."));
	expectedProblems
		.add(makeError("type argument java.util.Collection is not a class."));

	compareProblems(expectedProblems, actualProblems);
    }
}
