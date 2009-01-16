package testcases.junit;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import AST.Problem;

public class RangeInternalUniquenessTest extends MJTestCase {

    static final String testDir = "internaluniqueness" + File.separator;

    // OK: pattern: R m (A*); decl: void m (A*)
    @Test
    public void testInternalRangeUniqueness() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "InternalRangeUniqueness.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (A*); decl: void m (A*)
    @Test
    public void testChangeReturnType() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "ChangeRetTypeOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m(A*); decl: R m(A*, T), T is not a pattern type variable
    @Test
    public void testAddArgType() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddArgTypeOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m(A*); decl: R m (T, A*, S), T and S are not pattern type
    // variables.
    @Test
    public void testAddArgType2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddArgTypeOk2.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (A*); decl: R m(A*,A*)
    @Test
    public void testAddMultiplePatternArg() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddMultiplePatternArgType.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (A*, T); decl: R m (A*, T, T, A*, String)
    @Test
    public void testAddMultiplePatternArgWithExtra() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddMultiplePatternArgTypeWithExtra.java", new String[0],
		true);
	noProblems(actualProblems);
    }

    // ERROR: pattern: R m(A*); decl: R m(A*,R)
    @Test
    public void testAddPatternArg() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddPatternArgType.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*>[m]for( R m(A):X.methods;)\n"
			+ "R m(A, java.lang.Object)"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // ERROR: pattern: R m (A*); decl: R m ()
    @Test
    public void testLeaveOffPatternArg() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "DidntCopyPatternArgs.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*>[m]for( R m(A):X.methods;)\n"
			+ "R m()"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // ERROR: pattern: R m (A*); decl: R m (S)
    @Test
    public void testSwitchArg() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "SwitchArgNotOk.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*>[m]for( R m(A):X.methods;)\n"
			+ "R m(java.lang.String)"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // OK: pattern: R m (T); decl: R m (S), T and S are not pattern type
    // variables.
    @Test
    public void testSwitchNonPatternArg() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "SwitchNonPatternVarArgOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m(A*,T); decl: R m (A*), T is not a pattern type variable.
    @Test
    public void testLeaveOffNonPatternArg() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "LeaveOffNonPatternArgOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // ERROR: pattern: R m(A*,T); decl: R m(A*), T is a pattern type variable
    @Test
    public void testLeaveOffPatternArg2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "LeaveOffPatternArgNotOk.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*,T>[m]for( R m(A, T):X.methods;)\n"
			+ "R m(A)"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // ERROR: pattern: R m (A*,T); decl: R m (T)
    @Test
    public void testLeaveOffPatternArgFront() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "LeaveOffPatternArgFrontNotOk.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*,T>[m]for( R m(A, T):X.methods;)\n"
			+ "R m(T)"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // OK: pattern: R m (A*,T); decl: R m(A*,S); T and S are not pattern type
    // variables.
    @Test
    public void testSwitchNonPatternArgTail() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "SwitchNonPatternVarArgOk2.java", new String[0], true);
	noProblems(actualProblems);
    }

    // ERROR: pattern: R m(A*,T); decl: R m (A*,S), T is a pattern type
    // variable.
    @Test
    public void testSwitchPatternArgTail() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "SwitchPatternArgTailNotOk.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*,T>[m]for( R m(A, T):X.methods;)\n"
			+ "R m(A, java.lang.String)"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // OK: pattern R m (T,A*); decl: R m (A*), T not a pattern type variable.
    @Test
    public void testLeaveOffNonPatternArgFront() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "LeaveOffNonPatternArgFrontOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m(T, A*, S); decl: R m (A*), T and S cannot be pattern
    // type variables
    @Test
    public void testLeaveOffNonPatternArgFrontBack() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "LeaveOffNonPatternArgFrontBack.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (T,A*,S); decl: R m(T,A*); S is not a pattern type
    // variable.
    @Test
    public void testLeaveOffNonPatternArgBack() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "LeaveOffNonPatternArgBack.java", new String[0], true);
	noProblems(actualProblems);
    }

    // ERROR: pattern: R m (T,A*,S); decl: R m(T,S);
    @Test
    public void testLeaveOffPatternArgMiddle() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "LeaveOffPatternArgMiddle.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*>[m]for( R m(String, A, Object):X.methods;)\n"
			+ "R m(java.lang.String, java.lang.Object)"
			+ "\n could expand to conflicting or duplicating method declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // OK: pattern: R m (T,S); decl: R m (S,T) i.e. switching order of the
    // argument is fine
    @Test
    public void testSwitchArgOrder() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "SwitchArgOrderOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (T,V,S); decl: R m(S,T), V is not a pattern variable
    @Test
    public void testSwitchArgOrder2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "SwitchArgOrderOk2.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (A*); decl: R m (A[])
    @Test
    public void testChangeArgToArray() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "ChangeArgToArrayOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (A*, T); decl: R m (A, T[])
    @Test
    public void testChangeArgToArrayTail() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "ChangeArgToArrayTail.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (T[], A*); decl: R m (T[][], A);
    @Test
    public void testChangeArgToMultiDArray() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "ChangeArgToMultiDArray.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R m (A); decl: R get#m (A)
    @Test
    public void testAddPrefixToName() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddPrefixNameOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: R get#m(A); decl: R m (A)
    @Test
    public void testRemovePrefixFromName() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "RemovePrefixNameOk.java", new String[0], true);
	noProblems(actualProblems);
    }

    // ERROR pattern: R m (A); decl: R 'foo' (A), m is a name variable, foo is a
    // literal
    @Test
    public void testChangeNameVarToFixed() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "ChangeNameVarToFixed.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*>[m]for( R m(A):X.methods;)\n"
			+ "R foo(A)"
			+ "\n could expand to conflicting or duplicating method declarations."));

	compareProblems(expectedProblems, actualProblems);
    }

    // ERROR pattern: R get#m(A); decl: R 'get' (A)
    @Test
    public void testDropNameVariable() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "DropNameVariable.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("method with signature \n"
			+ "<R extends java.lang.Object,A*>[m]for( R get#m(A):X.methods;)\n"
			+ "R get(A)"
			+ "\n could expand to conflicting or duplicating method declarations."));

	compareProblems(expectedProblems, actualProblems);
    }

    // OK: pattern: F f; decl: F f;
    @Test
    public void testCopyFields() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "CopyField.java", new String[0], true);
	noProblems(actualProblems);
    }

    // ERROR: pattern: F f; decl: F foo;
    @Test
    public void testChangeFieldName() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "ChangeFieldName.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("field with signature \n"
			+ "<F>[f]for( F f:X.fields;)\n"
			+ "F foo;\n"
			+ " could expand to conflicting or duplicating field declarations."));
	compareProblems(expectedProblems, actualProblems);
    }

    // OK: pattern: F f; decl: S f;
    @Test
    public void testChangeFieldType() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "ChangeFieldType.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: F get#f; decl: F f;
    @Test
    public void testDropFieldNamePrefix() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "DropPrefixField.java", new String[0], true);
	noProblems(actualProblems);
    }

    // OK: pattern: F f; decl: F get#f
    @Test
    public void testAddFieldNamePrefix() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddPrefixFieldName.java", new String[0], true);
	noProblems(actualProblems);
    }


    /*
     * @Test public void testUniquenessFromSupertype() { Collection<Problem>
     * actualProblems = checkTest( "UniquenessFromSupertype.java", new
     * String[0], true); Collection<Problem> expectedProblems = new ArrayList<Problem>();
     * 
     * expectedProblems .add(makeError("the return type of method mm(A,
     * java.lang.String) in Mixin does not match the return type of method it
     * may override in X and may thus not be overriden")); expectedProblems
     * .add(makeError("method mm(A, java.lang.String) in Mixin could potentially
     * override a final method in X"));
     * 
     * compareProblems(expectedProblems, actualProblems); }
     */
}
