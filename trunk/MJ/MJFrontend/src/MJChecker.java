import AST.*;

class MJChecker extends Frontend {
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

		if (b) {
			// generate the expanded classes.
			for (java.util.Iterator iter = checker.program
					.compilationUnitIterator(); iter.hasNext();) {
				CompilationUnit unit = (CompilationUnit) iter.next();
				for (int i = 0; i < unit.getNumTypeDecl(); i++) {
					TypeDecl td = unit.getTypeDecl(i);
					if (td.isGenericType() && td.needsExpansion()) {						
						List list = null;
						if ( td instanceof GenericClassDecl )
							list = ((GenericClassDecl) td).getParTypeDeclList();
						if ( td instanceof GenericInterfaceDecl)
							list = ((GenericInterfaceDecl) td).getParTypeDeclList();
						for (int j = 0; j < list.getNumChild(); j++) {
							TypeDecl parTypeDecl = (TypeDecl) list.getChild(i);
							// TODO: need to check for timestamp of maybe
							// compiled file
							// to make sure this expanded class doesn't already
							// exist
							if (parTypeDecl.grounded())
								System.out.println("Expand: " + parTypeDecl.name());
						}
					}
				}
			}
		}
		return b;
	}

	protected String name() {
		return "MJ + Java1.4Frontend + Java1.5Extensions";
	}

	protected String version() {
		return "R20080124";
	}
}
