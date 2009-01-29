package main;

import AST.*;
import java.util.*;

public class MJChecker extends Frontend {
    public static void main(String args[]) {
	compile(args);
    }

    public MJChecker() {}
    public MJChecker(boolean print) {
	printErrors = print;
    }
    boolean printErrors = true;

    @Override
    protected String name() {
      return "MorphJFrontend";
    }

    @Override
    protected String url() {
      return "(http://code.google.com/p/morphing/)";
    }


    protected void processErrors(Collection errors, CompilationUnit unit) {
	if (printErrors) {
	    System.out.println("Errors:");
	    for (Iterator iter2 = errors.iterator(); iter2.hasNext();) {
		System.out.println(iter2.next());
	    }
	}
    }

    // Declared in FrontendMain.jrag at line 104

    protected void processWarnings(Collection warnings, CompilationUnit unit) {
	if (printErrors) {
	    for (Iterator iter2 = warnings.iterator(); iter2.hasNext();) {
		System.out.println(iter2.next());
	    }
	}
    }

    // Declared in FrontendMain.jrag at line 109

    protected void processNoErrors(CompilationUnit unit) {
    }

    public static boolean compile(String args[]) {
	MJChecker checker = new MJChecker();
	boolean b = checker.process(args, new BytecodeParser(),
		new JavaParser() {
		    public CompilationUnit parse(java.io.InputStream is,
			    String fileName) throws java.io.IOException,
			    beaver.Parser.Exception {
			return new parser.JavaParser().parse(is, fileName);
		    }
		});
	return b;
    }

    public static Collection<Problem> collectProblems(String args[], boolean print) {
	MJChecker checker = new MJChecker(print);
	
	boolean b = checker.process(args, new BytecodeParser(),
		new JavaParser() {
		    public CompilationUnit parse(java.io.InputStream is,
			    String fileName) throws java.io.IOException,
			    beaver.Parser.Exception {
			return new parser.JavaParser().parse(is, fileName);
		    }
		});

	Collection problems = new ArrayList();

	// generate the expanded classes.
	for (java.util.Iterator iter = checker.program
		.compilationUnitIterator(); iter.hasNext();) {
	    CompilationUnit unit = (CompilationUnit) iter.next();

	    if (unit.fromSource()) {
		problems.addAll(unit.parseErrors());
	    }
	}
	return problems;
    }

    @Override
    protected String version() {
	return "0.32";
    }
}
