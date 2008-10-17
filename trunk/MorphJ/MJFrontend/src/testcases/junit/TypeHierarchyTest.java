package testcases.junit;

import org.junit.Test;
import java.util.*;
import AST.*;
import main.*;
import java.io.File;

public class TypeHierarchyTest extends MJTestCase {

    // test that if a type variable is used as a superclass, it is declared to
    // required the right type.
    @Test
    public void testSupertypeDeclaration() {
	Collection<Problem> actualProblems = checkTest(
		"VariableSuperclass.java", new String[0], false);

	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("class declares type variable X as superclass. But X may not be instantiated by a non-final class."));
	expectedProblems
		.add(makeError("class ClassImplementsVariable tries to implement type variable X, but X may be instantiated by non-interface types."));
	expectedProblems
		.add(makeError("interface InterfaceExtendsVariable tries to extend type variable X, but X may be instantiated by non-interface types."));

	compareProblems(expectedProblems, actualProblems);
    }
}
