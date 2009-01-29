package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import AST.*;
import java.io.File;
import main.*;

public abstract class MJTestCase extends TestCase {

    final String MJ_ROOT;
    final String MJ_FRONT;
    final String MJ_EXAMPLES;

    final String MJ_FRONT_TEST_DIR;

    final boolean MJ_PRINT_ERROR;

    String testDir = "";

    Collection<Problem> actualProblems = new ArrayList<Problem>();
    Collection<Problem> expectedProblems = new ArrayList<Problem>();

    public MJTestCase() {
	// root of MJFrontend, MJBackend, and examples: ../
	String rootDir = ".." + File.separator;
	MJ_ROOT = setEnvVariable("MJ_ROOT", rootDir);

	MJ_FRONT = setEnvVariable("MJ_FRONT", rootDir + "MJFrontend");
	MJ_EXAMPLES = setEnvVariable("MJ_EXAMPLES", rootDir + "examples");

	MJ_FRONT_TEST_DIR = MJ_FRONT + "mjtestfiles" + File.separator;
	MJ_PRINT_ERROR = new Boolean(System.getenv("MJ_PRINT_ERROR"))
		.booleanValue();
    }
    
    protected String setEnvVariable(String varName, String defaultVal) {
	String value = System.getenv(varName);
	if (value == null) {
	    System.out.println("WARNING: No environment variable " + varName
		    + " set. Using default: " + defaultVal);
	    value = defaultVal;
	}

	if (!value.endsWith(File.separator) && !value.endsWith(".jar")
		&& !value.endsWith(".zip"))
	    value = value + File.separator;
	return value;
    }

    protected String setEnvVariable(String varName) {
	return setEnvVariable(varName, "." + File.separator);
    }

    protected String[] compilerArgs(String fileName, String[] rest) {
	String[] args = new String[rest.length + 1];
	args[0] = fileName;
	for (int i = 1; i < args.length; i++)
	    args[i] = rest[i - 1];
	return args;
    }

    protected Collection<Problem> checkTest(String fileName) {
	return checkTest(fileName, new String[0], MJ_PRINT_ERROR);
    }

    protected Collection<Problem> checkTest(String fileName,
	    String[] compilerOpts, boolean printErrors) {
	Collection<Problem> actualProblems = MJChecker.collectProblems(
		compilerArgs(MJ_FRONT_TEST_DIR + testDir + fileName,
			compilerOpts), printErrors);
	return actualProblems;
    }

    protected void checkExample(String fileName) {
	actualProblems = MJChecker.collectProblems(new String[] { MJ_EXAMPLES
		+ fileName }, false);
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

    protected Problem makeWarning(String errorMsg) {
	return new Problem(null, errorMsg, 6, Problem.Severity.WARNING);
    }

    protected void noProblems(Collection<Problem> actualProblems) {
	if (actualProblems.size() > 0) {
	    System.err.println("Errors caught but not expected:");
	    for (Problem p : actualProblems)
		System.err.println(p);
	}
	assertTrue(actualProblems.size() == 0);
    }

    protected void compareProblems() {
	compareProblems(expectedProblems, actualProblems);
    }

    protected void noProblems() {
	noProblems(actualProblems);
    }

    protected void clearExpected() {
	expectedProblems.clear();
    }

    protected void addExpected(Problem p) {
	expectedProblems.add(p);
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
