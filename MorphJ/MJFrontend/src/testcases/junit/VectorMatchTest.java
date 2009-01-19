package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.util.*;

import AST.*;

public class VectorMatchTest extends MJTestCase {
    @Before
    public void setUp() {
	super.testDir = "vectormatch" + File.separator;
    }

    @Test
    public void testBasicVectorMatchStaticFields() {
	Collection<Problem> actualProblems = checkTest("BasicVectorMatch.java");
	this.noProblems(actualProblems);
    }

    // Test (A*,T) matches static list of types, where T is a regular type.
    @Test
    public void testVectorInFront() {
	Collection<Problem> actualProblems = checkTest("VectorInFront.java");
	this.noProblems(actualProblems);
    }

    // Test (A*,T) does not match a list that does not end in T
    @Test
    public void testVectorInFrontNoMatch() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontNoMatch.java");

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
	Collection<Problem> actualProblems = checkTest("VectorInBack.java");
	noProblems(actualProblems);
    }

    // Test (T, A*) does not match a list that does not start with T
    @Test
    public void testVectorInBackNoMatch() {
	Collection<Problem> actualProblems = checkTest("VectorInBackNoMatch.java");
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
	Collection<Problem> actualProblems = checkTest("VectorWithBound.java");
	noProblems(actualProblems);
    }

    // Test (A*) matches (B*)
    @Test
    public void testVectorMatchVector() {
	Collection<Problem> actualProblems = checkTest("VectorMatchVector.java");
	noProblems(actualProblems);
    }

    // Test (A*) matches (B*,T)
    @Test
    public void testVectorMatchVectorInFront() {
	Collection<Problem> actualProblems = checkTest("VectorMatchVectorInFront.java");
	noProblems(actualProblems);
    }

    // Test (A*) matches (T,B*)
    @Test
    public void testVectorMatchVectorInBack() {
	Collection<Problem> actualProblems = checkTest("VectorMatchVectorInBack.java");
	noProblems(actualProblems);
    }

    // Test (A*) matches (T,B*,S)
    @Test
    public void testVectorMatchVectorInMiddle() {
	Collection<Problem> actualProblems = checkTest("VectorMatchVectorInMiddle.java");
	noProblems(actualProblems);
    }

    // Test (A*,T) matches (B*,T)
    @Test
    public void testVectorInFrontMatchVectorInFront() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontMatchVectorInFront.java");
	noProblems(actualProblems);
    }

    // Test (A*,T) matches (B*,S,T)
    @Test
    public void testVectorInFrontMatchVectorInFront2() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontMatchVectorInFront2.java");
	noProblems(actualProblems);
    }

    // Test (A*,T) matches (S,B*,T)
    @Test
    public void testVectorInFrontMatchVectorInMiddle() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontMatchVectorInMiddle.java");
	noProblems(actualProblems);
    }

    // Test (A*,T) does not match (B*)
    @Test
    public void testVectorInFrontNoMatchVector() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontNoMatchVector.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(B) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (A*,T) does not match (B*,S)
    @Test
    public void testVectorInFrontNoMatchVectorInFront() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontNoMatchVectorInFront.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(B, java.lang.Object) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (A*,T) does not match (B*,T,S)
    @Test
    public void testVectorInFrontNoMatchVectorInFront2() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontNoMatchVectorInFront2.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(B, java.lang.String, java.lang.Object) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (A*,T) does not match (S,B*,S')
    @Test
    public void testVectorInFrontNoMatchVectorMiddle() {
	Collection<Problem> actualProblems = checkTest("VectorInFrontNoMatchVectorMiddle.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(java.lang.String, B, java.lang.Object) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (T,A*) matches (T,B*)
    @Test
    public void testVectorInBackMatchVectorInBack() {
	Collection<Problem> actualProblems = checkTest("VectorInBackMatchVectorInBack.java");
	noProblems(actualProblems);
    }

    // Test (T,A*) does not match (S,B*)
    @Test
    public void testVectorInBackNoMatchVectorInBack() {
	Collection<Problem> actualProblems = checkTest("VectorInBackNoMatchVectorInBack.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(java.lang.Object, B) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }

    // Test (T,A*) matches (T,S,B*)
    @Test
    public void testVectorInBackMatchVectorInBack2() {
	Collection<Problem> actualProblems = checkTest("VectorInBackMatchVectorInBack2.java");
	noProblems(actualProblems);
    }

    // Test (T,A*) does not match (S,T,B*)
    @Test
    public void testVectorInBackNoMatchVectorInBack2() {
	Collection<Problem> actualProblems = checkTest("VectorInBackNoMatchVectorInBack2.java");
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	expectedProblems
		.add(makeError("no method named n(java.lang.Object, java.lang.String, java.lang.Object, B) in Foo<Bar@Y> matches."));
	compareProblems(expectedProblems, actualProblems);
    }
}
