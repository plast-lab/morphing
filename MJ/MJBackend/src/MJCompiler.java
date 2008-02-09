import AST.*;

class MJCompiler extends Frontend {
	public static void main(String args[]) {
		if (!compile(args))
			System.exit(1);
	}

	static java.util.Set expansionTypes = new java.util.HashSet();

	public static boolean compile(String args[]) {
		MJCompiler compiler = new MJCompiler();
		boolean b = compiler.process(args, new BytecodeParser(),
				new JavaParser() {
					public CompilationUnit parse(java.io.InputStream is,
							String fileName) throws java.io.IOException,
							beaver.Parser.Exception {
						return new parser.JavaParser().parse(is, fileName);
					}
				});
		if (b) {
			// generate the expanded classes.
			for (java.util.Iterator etIt = expansionTypes.iterator(); etIt
					.hasNext();) {
				TypeDecl t = (TypeDecl) etIt.next();
				t.generateClassfile();
				t.clear();
			}
		}
		return b;
	}

	protected void processNoErrors(CompilationUnit unit) {
		expansionTypes.addAll(unit.collectExpansionTypes());
		unit.java2Transformation();
		unit.generateClassfile();
	}

	protected String name() {
		return "MJCompiler";
	}

	protected String version() {
		return "R20080124";
	}
}
