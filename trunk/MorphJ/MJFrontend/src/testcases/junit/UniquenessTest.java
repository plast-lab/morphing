package testcases.junit;

import org.junit.Test;
import java.util.*;

import AST.*;
import main.*;
import java.io.File;

public class UniquenessTest extends MJTestCase {

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

    // ERROR: pattern: R m (A*); decl: R m(A*,A*)
    
    // OK: pattern: R m(A*); decl: R m (T, A*, S), T and S are not pattern type variables.
    @Test
    public void testAddArgType2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "AddArgTypeOk2.java", new String[0], true);
	noProblems(actualProblems);
    }        

    // ERROR: pattern: R m(A*); decl: R m(R,A*,R)

    // ERROR: pattern: R m (A*); decl: R m ()
    @Test
    public void testInternalRangeUniqueness2() {
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

    // OK: pattern: R m (T); decl: R m (S), T and S are not pattern type variables.

    // ERROR: pattern: R m (T); decl: R m (S), T is a pattern type variable
    
    // OK: pattern: R m(A*,T); decl: R m (A*), T is not a pattern type variable.

    // ERROR: pattern: R m(A*,T); decl: R m(A*), T is a pattern type variable
    
    // ERROR: pattern: R m (A*,T); decl: R m (T)
       
    // OK: pattern: R m (A*,T); decl: R m(A*,S); T and S are not pattern type variables.
    
    // ERROR: pattern: R m(A*,T); decl: R m (A*,S), T is a pattern type variable.

    // OK: pattern R m (T,A*); decl: R m (A*), T not a pattern type variable.
   
    // ERROR: pattern R m (T,A*); decl: R m (A*), T is a pattern type variable
    
    // ERROR: pattern R m (T,A*); decl: R m(T)
    
    // OK: pattern: R m(T, A*, S); decl: R m (A*), T and S cannot be pattern type variables

    // OK: pattern: R m (T,A*,S); decl: R m(T,A*);  S is not a pattern type variable.

    // OK: pattern: R m (T,A*,S); decl: R m(A*,S);  T is not a pattern type variable.   
    
    // ERROR: pattern: R m (T,A*,S); decl: R m(T,S);
    
    // OK: pattern: R m (T,S); decl: R m (S,T)  i.e. switching order of the argument is fine    

    // OK: pattern: R m (T,V,S); decl: R m(S,T), V is not a pattern variable

    // OK: pattern: R m (A*); decl: R m (A[])
    
    // OK: pattern: R m (A*, T); decl: R m (A, T[])
    
    // OK: pattern: R m (T, A*); decl: R m (T[], A);
    
    // OK: pattern: R m (A); decl: R get#m (A)

    // OK: pattern: R get#m(A); decl: R m (A)
   
    // ERROR pattern: R m (A);  decl: R 'foo' (A), m is a name variable, foo is a literal
    
    // ERROR pattern: R get#m(A);  decl: R 'get' (A)
    
    // OK: pattern: F f; decl: F f;

    // ERROR: pattern: F f; decl: S f;

    // OK: pattern: F get#f; decl: F f;

    // OK: pattern: F f; decl: F get#f

    /*
     * @Test public void testInternalRangeUniqueness3() { Collection<Problem>
     * actualProblems = checkTest( "InternalRangeUniqueness3.java", new
     * String[0], true); noProblems(actualProblems); }
     * 
     * @Test public void testInternalRangeUniqueness4() { Collection<Problem>
     * actualProblems = checkTest( "InternalRangeUniqueness4.java", new
     * String[0], true); noProblems(actualProblems); }
     * 
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
