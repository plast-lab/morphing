package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import testcases.*;

public class BasicTest2 extends TestCase {

    @Test public void testDefaultImplementation() {
	IncompleteList il = new IncompleteList();

	DefaultImplementation<IncompleteList, List> l =
	    new DefaultImplementation<IncompleteList, List>(il);

	// calling remove(int) should be fine.
	l.remove(0);

	l.clear(); // OK.
    }
}

class IncompleteList {
    // only implement clear() and size()
    public void clear() {}
    public int size() { return 7; }

    public String foo() { return "foo"; }
}
