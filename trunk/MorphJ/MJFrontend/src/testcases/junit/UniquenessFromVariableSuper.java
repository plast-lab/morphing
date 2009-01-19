package testcases.junit;

import java.util.*;
import java.io.*;

import org.junit.Test;

import AST.*;
import main.*;
import org.junit.Before;

public class UniquenessFromVariableSuper extends MJTestCase {

    @Before
    public void setUp() {
	super.testDir = "uniquefromvariablesuper" + File.separator;
    }

    // OK: Foo<X> extends X,
    // <R,A*>[m] for ( R m (A) : X.methods) R m (A) { }
    @Test
    public void testCopyAll() {
	Collection<Problem> actualProblems = checkTest("CopyAllOk.java");
	noProblems(actualProblems);
    }

    // OK: change return type to a subtype.
    // <A*>[m] for ( Number m (A) : X.methods ) Integer m (A) { }
    @Test
    public void testChangeReturnToSubtype() {
	Collection<Problem> actualProblems = checkTest("ChangeReturnSubtypeOk.java");
	noProblems(actualProblems);
    }

    // OK: copying supertype's supertype's methods
    // Foo<X extends Number> extends X
    // <R,A*>[m] for ( R m (A) : Number.methods) R m (A) { ... }
    @Test
    public void testCopySuperSuper() {
	Collection<Problem> actualProblems = checkTest("CopySuperSuperOk.java");
	noProblems(actualProblems);
    }

    // OK: copying methods of a subclass of superclass
    // Foo<X,Y extends X> extends X
    // <R,A*>[m] for ( R m (A) : Y.methods )
    @Test
    public void testCopyVariableSuperSub() {
	Collection<Problem> actualProblems = checkTest("CopyVariableSuperSubOk.java");
	noProblems(actualProblems);
    }

    // OK: copying methods of a variable superclass of superclass
    // Foo<X,Y extends X> extends Y
    // <R,A*>[m] for ( R m (A) : X.methods )
    @Test
    public void testCopyVariableSuperSuper() {
	Collection<Problem> actualProblems = checkTest("CopyVariableSuperSuperOk.java");
	noProblems(actualProblems);
    }

    // ERROR: copy from unrelated type.
    // Foo<X extends Number> extends X
    // <R,A*>[m] for (R m (A) : T.methods) R m (A) { }
    @Test
    public void testCopyUnrelatedMethods() {
	Collection<Problem> actualProblems = checkTest("CopyUnrelated.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("the return type of method m1() in Mixin may not match the return type of method it may override in X and may thus not be overriden"));
	expectedProblems
		.add(makeError("method m1() in Mixin could potentially override a final method in X"));
	expectedProblems
		.add(makeError("the return type of method m5(java.lang.String, int, java.lang.Object) in Mixin may not match the return type of method it may override in X and may thus not be overriden"));
	expectedProblems
		.add(makeError("method m5(java.lang.String, int, java.lang.Object) in Mixin could potentially override a final method in X"));
	expectedProblems
		.add(makeError("the return type of method m2() in Mixin may not match the return type of method it may override in X and may thus not be overriden"));
	expectedProblems
		.add(makeError("method m2() in Mixin could potentially override a final method in X"));
	expectedProblems
		.add(makeError("the return type of method m3(java.lang.Number) in Mixin may not match the return type of method it may override in X and may thus not be overriden"));
	expectedProblems
		.add(makeError("method m3(java.lang.Number) in Mixin could potentially override a final method in X"));
	expectedProblems
		.add(makeError("the return type of method m4(int, java.lang.Float) in Mixin may not match the return type of method it may override in X and may thus not be overriden"));
	expectedProblems
		.add(makeError("method m4(int, java.lang.Float) in Mixin could potentially override a final method in X"));

	compareProblems(expectedProblems, actualProblems);
    }

    // ERROR: copy from unrelated type variable
    // Foo<X,Y> extends X
    // <R,A*>[m] for (R m (A) : Y.methods) R m (A) { }
    @Test
    public void testCopyUnrelatedFromVariable() {
	Collection<Problem> actualProblems = checkTest("CopyUnrelatedVar.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "      <R extends java.lang.Object,A*>[m]for( R m(A):Y.methods;)\n"
			+ "      R m(A)"
			+ "\n  may conflict with methods in type X."));
	compareProblems(expectedProblems, actualProblems);
    }

    // ERROR: changing argument types.
    // Foo<X> extends X
    // <R,A*>[m] for ( R m (A) : X.methods) R m (A, T)
    @Test
    public void testAddArgumentToEnd() {
	Collection<Problem> actualProblems = checkTest("AddArgumentEnd.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("the return type of method m(A, java.lang.String) in Mixin may not match the return type of method it may override in X and may thus not be overriden"));
	expectedProblems
		.add(makeError("method m(A, java.lang.String) in Mixin could potentially override a final method in X"));
	expectedProblems
		.add(makeError("method with signature \n"
			+ "      <R extends java.lang.Object,A*>[m]for( R m(A):X.methods;)\n"
			+ "      R m(A, java.lang.String)"
			+ "\n  may conflict with methods in type X."));
	compareProblems(expectedProblems, actualProblems);
    }
    
    
    // ERROR:
    // <R,A*>[m] for ( R m (A) : X.methods) R m (T, A)
    @Test
    public void testAddArgumentToFront() {
	Collection<Problem> actualProblems = checkTest("AddArgumentBegin.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method m(java.lang.String, A) in Mixin could potentially override a final method in X"));
	expectedProblems
		.add(makeError("method with signature \n"
			+ "      <R extends java.lang.Object,A*>[m]for( R m(A):X.methods;)\n"
			+ "      R m(java.lang.String, A)"
			+ "\n  may conflict with methods in type X."));
	compareProblems(expectedProblems, actualProblems);
    }
    
    // ERROR:
    // <R,A*>[m] for (R m (A) : X.methods) R m ( T, A, S)

    // ERROR: Changing return type to supertype.
    // <R extends Number,A*>[m] for (R m (A): X.methods) Object m (A)

    // ERROR: changing return type to unrelated
    // <R,A*>[m] for ( R m (A) : X.methods) String m (A)

    // ERROR: changing name
    // <R,A*>[m] for (R m (A) : X.methods) R foo (A)

    // ERROR:
    // <R,A*>[m] for (R m (A): X.methods) R get#m (A)

    // ERROR:
    // <R,A*>[m] for (R get#m (A) : X.methods) R m (A)

    // ERROR
    // <R,A*>[m] for (R get#m (A): X.methods) R set#m (A)
}
