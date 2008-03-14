package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import testcases.*;

public class BasicTest extends TestCase {

    @Test public void testSynchronizedList () {
	List myList = new ArrayList();
	SynchronizeMe<List> synchronizedList = 
	    new SynchronizeMe<List>(myList);
	synchronizedList.add("a");
	synchronizedList.add("b");

	int lsize = synchronizedList.size();
	assertTrue(lsize == 2);

	List sublist = synchronizedList.subList(0,1);
	int newsize = sublist.size();
	assertTrue(newsize == 1);

	myList.clear();
	assertTrue(myList.size() == 0 );
    }

}
