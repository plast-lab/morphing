package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import AST.*;
import java.io.File;
import main.*;

public abstract class MJTestCase extends TestCase {

    final String MJ_FRONT;
    final String MJ_BACK;
    final String MJ_EXAMPLES;

    final String MJ_FRONT_TEST_DIR;
    final String MJ_BACK_TEST_DIR;

    public MJTestCase() {
	MJ_FRONT = setEnvVariable("MJ_FRONT");
	MJ_BACK = setEnvVariable("MJ_BACK");
	MJ_EXAMPLES = setEnvVariable("MJ_EXAMPLES");
	MJ_FRONT_TEST_DIR = MJ_FRONT + "mjtestfiles" + File.separator;
	MJ_BACK_TEST_DIR = MJ_BACK + "mjtestfiles" + File.separator;
    }

    protected String setEnvVariable(String varName) {
	String value = System.getenv(varName);

	if (value == null)
	    value = "." + File.separator;
	else if (!value.endsWith(File.separator))
	    value = value + File.separator;
	return value;
    }

    protected String[] compilerArgs(String fileName, String[] rest) {
	String[] args = new String[rest.length + 1];
	args[0] = fileName;
	for (int i = 1; i < args.length; i++)
	    args[i] = rest[i - 1];
	return args;
    }

    protected Collection<Problem> checkTest(String fileName,
	    String[] compilerOpts, boolean printErrors) {
	Collection<Problem> actualProblems = MJChecker.collectProblems(
		compilerArgs(MJ_FRONT_TEST_DIR + fileName, compilerOpts),
		printErrors);
	return actualProblems;
    }

    protected Collection<Problem> checkExample(String fileName,
	    String[] compilerOpts, boolean printErrors) {
	Collection<Problem> actualProblems = MJChecker
		.collectProblems(compilerArgs(MJ_EXAMPLES + fileName,
			compilerOpts), printErrors);
	return actualProblems;
    }

    protected java.util.List<Collection<Problem>> checkExample(String[] files,
	    String[] compilerOpts, boolean printErrors) {
	ArrayList<Collection<Problem>> actualProblems = new ArrayList<Collection<Problem>>();

	for (int i = 0; i < files.length; i++) {
	    Collection<Problem> p = checkExample(files[i], compilerOpts,
		    printErrors);
	    actualProblems.add(p);
	}

	return actualProblems;
    }

    protected Problem makeError(String errorMsg) {
	return new Problem(null, errorMsg, 6, Problem.Severity.ERROR);
    }

    protected void compareProblems(Collection<Problem> expectedProblems,
	    Collection<Problem> actualProblems) {

	Collection<Problem> removedProblems = new ArrayList<Problem>();
	for (Problem p : actualProblems) {
	    // find p in known Problems.
	    for (Problem k : expectedProblems) {
		if (k.severity() == p.severity()
			&& k.message().equals(p.message())) {
		    expectedProblems.remove(k);
		    removedProblems.add(p);
		    break;
		}
	    }
	}

	if (removedProblems.size() > 0 && actualProblems.size() > 0)
	    actualProblems.removeAll(removedProblems);

	// print out which errors are expected but not caught.
	if (expectedProblems.size() > 0) {
	    System.err.println("Errors expected but not thrown:");
	    for (Problem p : expectedProblems)
		System.err.println(p);
	}
	// print out which errors are caught but not expected.
	if (actualProblems.size() > 0) {
	    System.err.println("Errors caught but not expected:");
	    for (Problem p : actualProblems)
		System.err.println(p);
	}

	assertTrue(actualProblems.size() == expectedProblems.size()
		&& actualProblems.size() == 0);
    }
}
