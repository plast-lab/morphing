package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import AST.*;
import java.io.File;
import main.*;

public abstract class MJTestCase extends TestCase {

    final String MJ_ROOT;
    final String MJ_BACK;
    final String MJ_EXAMPLES;

    final String MJ_BACK_TEST_DIR;

    final boolean MJ_PRINT_ERROR;

    final String MJ_JUNIT_DIR;
    final String JUNIT_JAR;

    String testDir = "";
    String exampleTestClassPath = "";

    Collection<Problem> actualProblems = new ArrayList<Problem>();
    Collection<Problem> expectedProblems = new ArrayList<Problem>();

    public MJTestCase() {
	// root of MJFrontend, MJBackend, and examples: ../
	String rootDir = ".." + File.separator;
	MJ_ROOT = setEnvVariable("MJ_ROOT", rootDir);

	MJ_BACK = setEnvVariable("MJ_BACK", rootDir + "MJBackend");
	MJ_EXAMPLES = setEnvVariable("MJ_EXAMPLES", rootDir + "examples");

	MJ_BACK_TEST_DIR = MJ_BACK + "mjtestfiles" + File.separator;

	MJ_PRINT_ERROR = new Boolean(System.getenv("MJ_PRINT_ERROR"))
		.booleanValue();
	MJ_JUNIT_DIR = setEnvVariable("MJ_JUNIT_DIR", MJ_BACK + "src"
		+ File.separator + "testcases" + File.separator + "mjunit"
		+ File.separator);

	// /home/shuang/lib/eclipse/plugins/org.junit4_4.3.1/junit.jar
	String defaultJunitJar = File.separator + "home" + File.separator
		+ "shuang" + File.separator + "lib" + File.separator
		+ "eclipse" + File.separator + "plugins" + File.separator
		+ "org.junit4_4.3.1" + File.separator + "junit.jar";

	JUNIT_JAR = setEnvVariable("JUNIT_JAR", defaultJunitJar);

	exampleTestClassPath = MJ_ROOT + File.pathSeparator + JUNIT_JAR;
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

    protected boolean compileMJTest(String fileName) {
	return compileMJTest(fileName, new String[] { "-classpath",
		exampleTestClassPath });
    }

    protected boolean compileMJTest(String fileName, String[] compilerOpts) {
	return MJCompiler.compile(compilerArgs(MJ_JUNIT_DIR + fileName,
		compilerOpts));
    }

    protected boolean compileTest(String fileName) {
	return compileTest(fileName, new String[0]);
    }

    protected boolean compileTest(String fileName, String[] compilerOpts) {
	boolean b = MJCompiler.compile(compilerArgs(MJ_BACK_TEST_DIR + testDir
		+ fileName, compilerOpts));
	return b;
    }

    protected boolean compileExample(String fileName) {
	return MJCompiler.compile(new String[] { MJ_EXAMPLES + fileName });
    }

    protected boolean compileExample(String fileName, String[] compilerOpts,
	    boolean printErrors) {
	return MJCompiler.compile(compilerArgs(MJ_EXAMPLES + fileName,
		compilerOpts));
    }

    protected boolean compileExample(String[] files, String[] compilerOpts,
	    boolean printErrors) {
	boolean b = true;
	for (int i = 0; i < files.length; i++) {
	    if (!compileExample(files[i], compilerOpts, printErrors))
		b = false;
	}
	return b;
    }

}
