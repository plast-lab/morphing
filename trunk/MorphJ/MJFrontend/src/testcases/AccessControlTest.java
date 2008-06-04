package testcases;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import AST.*;
import main.*;

public class AccessControlTest extends TestCase {

    // test that if a type variable is used as a superclass, then its
    // instantiation cannot be a final class.
    @Test
    public void testSuperclassNonFinal() {
	Collection<Problem> problems = MJChecker
		.collectProblems(new String[] { "../testcases/AccessControlTest.java" });

	Collection<Problem> knownProblems = new ArrayList();
	knownProblems
		.add(new Problem(
			null,
			"VariableSuperclass<java.lang.String> declares final class java.lang.String as a superclass.",
			6, Problem.Severity.ERROR));
	knownProblems.add(new Problem(null, "no field named f", 13,
		Problem.Severity.ERROR));

	for (Problem p : problems) {
	    // find p in known Problems.
	    for (Problem k : knownProblems) {
		if (k.severity() == p.severity()
			&& k.message().equals(p.message())) {
		    knownProblems.remove(k);
		    break;
		}
	    }
	}

	assertTrue(knownProblems.size() == 0);
    }
}
