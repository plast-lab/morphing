package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.util.*;

import AST.*;

public class VectorMatchTest extends MJTestCase {
    static final String testDir = "vectormatch" + File.separator;

    @Test
    public void testBasicVectorMatchStaticFields() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "BasicVectorMatch.java", new String[0], true);
	this.noProblems(actualProblems);
    }

    // Test (A*,T) matches static list of types, where T is a regular type.
    @Test
    public void testVectorInFront() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFront.java", new String[0], true);
	this.noProblems(actualProblems);
    }

    // Test (A*,T) does not match a list that does not end in T
    @Test
    public void testVectorInFrontNoMatch() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontNoMatch.java", new String[0], true);

	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named m1() in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m2(int) in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m3(null) in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m4(int, null) in Foo<Bar> matches."));
	this.compareProblems(expectedProblems, actualProblems);
    }

    // Test (T, A*) matches static list of types, where T is regular type.
    @Test
    public void testVectorInBack() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInBack.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (T, A*) does not match a list that does not start with T
    @Test
    public void testVectorInBackNoMatch() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInBackNoMatch.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named m1() in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m2(int) in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m3(null) in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m4(int, null) in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m5(int, java.lang.String) in Foo<Bar> matches."));
	expectedProblems
		.add(makeError("no method named m6(null, int, java.lang.String, int) in Foo<Bar> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (A*) matches static list of types, where A is bound, A <: Number
    @Test
    public void testVectorWithBound() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorWithBound.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*) matches (B*)
    @Test
    public void testVectorMatchVector() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorMatchVector.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*) matches (B*,T)
    @Test
    public void testVectorMatchVectorInFront() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorMatchVectorInFront.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*) matches (T,B*)
    @Test
    public void testVectorMatchVectorInBack() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorMatchVectorInBack.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*) matches (T,B*,S)
    @Test
    public void testVectorMatchVectorInMiddle() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorMatchVectorInMiddle.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*,T) matches (B*,T)
    @Test
    public void testVectorInFrontMatchVectorInFront() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontMatchVectorInFront.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*,T) matches (B*,S,T)
    @Test
    public void testVectorInFrontMatchVectorInFront2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontMatchVectorInFront2.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*,T) matches (S,B*,T)
    @Test
    public void testVectorInFrontMatchVectorInMiddle() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontMatchVectorInMiddle.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (A*,T) does not match (B*)
    @Test
    public void testVectorInFrontNoMatchVector() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontNoMatchVector.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(B) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (A*,T) does not match (B*,S)
    @Test
    public void testVectorInFrontNoMatchVectorInFront() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontNoMatchVectorInFront.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(B, java.lang.Object) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (A*,T) does not match (B*,T,S)
    @Test
    public void testVectorInFrontNoMatchVectorInFront2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontNoMatchVectorInFront2.java", new String[0],
		true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(B, java.lang.String, java.lang.Object) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (A*,T) does not match (S,B*,S')
    @Test
    public void testVectorInFrontNoMatchVectorMiddle() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInFrontNoMatchVectorMiddle.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(java.lang.String, B, java.lang.Object) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (T,A*) matches (T,B*)
    @Test
    public void testVectorInBackMatchVectorInBack() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInBackMatchVectorInBack.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (T,A*) does not match (S,B*)
    @Test
    public void testVectorInBackNoMatchVectorInBack() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInBackNoMatchVectorInBack.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(java.lang.Object, B) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (T,A*) matches (T,S,B*)
    @Test
    public void testVectorInBackMatchVectorInBack2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInBackMatchVectorInBack2.java", new String[0], true);
	noProblems(actualProblems);
    }

    // Test (T,A*) does not match (S,T,B*)
    @Test
    public void testVectorInBackNoMatchVectorInBack2() {
	Collection<Problem> actualProblems = checkTest(testDir
		+ "VectorInBackNoMatchVectorInBack2.java", new String[0], true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(java.lang.Object, java.lang.String, java.lang.Object, B) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }
}
