package testcases.junit;

import org.junit.Test;
import java.util.*;

import AST.*;
import main.*;
import java.io.File;

public class ExamplesTest extends MJTestCase {
    
    @Test
    public void testAdder () {
	checkExample("arithmetic" + File.separator + "Adder.java");
	noProblems();
    }
    
    @Test
    public void testAntiGetter() {
	checkExample("AntiGetter.java");
	noProblems();
    }
    
    @Test
    public void testBooleanExpr() {
	checkExample("booleanexpr" + File.separator + "BooleanExpression.java");
	noProblems();
    }
    
    @Test
    public void testFullAdder() {
	checkExample("arithmetic" + File.separator + "FullAdder.java");
	noProblems();
    }
    
    @Test
    public void testLogMe() {
	checkExample("LogMe.java");
	noProblems();
    }
    
    @Test
    public void testMatrix() {
	checkExample("recref" + File.separator + "Matrix.java");
	noProblems();
    }
    
    @Test
    public void testMergeSort() {
	checkExample("mergesort" + File.separator + "MergeSort.java");
	noProblems();
    }
    
    @Test
    public void testSychronizeMe() {
	checkExample("SynchronizeMe.java");
	noProblems();
    }
  
    @Test
    public void testSynchronized() {
	checkExample("Synchronized.java");
	noProblems();
    }

    @Test
    public void testRecursiveMorph() {
	checkExample("RecursiveMorph.java");
	noProblems();
    }
    
    @Test
    public void testVisitor() {
	checkExample("visitor" + File.separator + "Visitor.java");
	clearExpected();
	addExpected(makeError("the return type of method accept(visitor.Visitor) in visitor.Acceptor may not match the return type of method it may override in X and may thus not be overriden"));
	addExpected(makeError("no method named visit(visitor.Acceptor) in V matches. However, there is a method visit(java.lang.Object)"));
	
	compareProblems();
    }
    /*
    @Test
    public void testDefaultImpelmentation() {
	Collection<Problem> actualProblems = checkExample(
		"DefaultImplementation.java", new String[] {  }, true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	compareProblems(expectedProblems, actualProblems);
    }
*/
/*
    @Test
    public void testGetterSetter() {
	Collection<Problem> actualProblems = checkExample("GetterSetter.java",
		new String[] { "-verbose" }, true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();
	compareProblems(expectedProblems, actualProblems);
    }
*/
    /*
    @Test
    public void testDstm2() {
	java.util.List<Collection<Problem>> actualProblems = checkExample(
		new String[] { "dstm2fromClass/AtomicBase.java",
			"dstm2fromClass/shadow/Recoverable.java"
		// ,"dstm2fromClass/shadow/ShadowGetterSetter.java" 
		}, new String[] {}, true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();

	for (Collection<Problem> p : actualProblems)
	    compareProblems(expectedProblems, p);
    }
    
    */
}
