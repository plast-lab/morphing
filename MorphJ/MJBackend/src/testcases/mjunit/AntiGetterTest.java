package testcases.mjunit;

import junit.framework.TestCase;
import org.junit.Test;

import examples.*;

public class AntiGetterTest extends TestCase {

    @Test public void testAntiGetter() {
	AntiGetter<Foo> fooNoGetter = new AntiGetter<Foo>(new Foo());
	assertTrue(fooNoGetter.givefour() == 4);
    }
}


public class Foo {
    public int get_bar() {
	return 4;
    }
    public int givefour() {
	return 4;
    }
}

