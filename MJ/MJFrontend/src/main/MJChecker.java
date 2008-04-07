package main;
import AST.*;
import java.util.*;

public class MJChecker extends Frontend {
	public static void main(String args[]) {
		compile(args);
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

	public static Collection<Problem> collectProblems(String args[]) {
		MJChecker checker = new MJChecker();
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
		for (java.util.Iterator iter = checker.program.compilationUnitIterator(); iter.hasNext();) {
			CompilationUnit unit = (CompilationUnit) iter.next();
			
			if(unit.fromSource()) {
				problems.addAll(unit.parseErrors());			
			}
		}
		return problems;
	}
	
	protected String name() {
		return "MJ + Java1.4Frontend + Java1.5Extensions";
	}

	protected String version() {
		return "R20080124";
	}
}
