package testcases.junit;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import AST.*;
import main.Modifiables;

public class ModifierUnificationTest extends TestCase {

    @Test
    public void testMaybeModifiers() {
	Modifiers mod1 = new Modifiers(new AST.List().add(
		new Modifier("public")).add(new Modifier("static")));
 	mod1 = mod1.enhanceWithMaybes(Modifiables.METHOD);
	assertTrue(mod1
		.toString()
		.equals(
			"public static *abstract *strictfp *final *native *synchronized"));
    }

    @Test
    public void testMaybeModifiers2() {
	// Having abstract means final is not an option
	Modifiers mod = new Modifiers(new AST.List().add(new Modifier(
		"abstract")));
	mod = mod.enhanceWithMaybes(Modifiables.METHOD);

	assertFalse(mod.isFinal());
    }

    // "public static" subsumed by "public" 
    @Test
    public void testBasic() {
	// "public static"
	Modifiers mod1 = new Modifiers(new AST.List().add(
		new Modifier("public")).add(new Modifier("static")))
		.enhanceWithMaybes(Modifiables.METHOD);
	;
	// "public"
	Modifiers mod2 = new Modifiers(new AST.List<Modifier>()
		.add(new Modifier("public")))
		.enhanceWithMaybes(Modifiables.METHOD);

	Map uniMap = new HashMap();
	assertTrue(mod1.subsumedBy(mod2, uniMap));

	Modifiers mod2Sub = mod2.substitute(uniMap);
	assertTrue(mod2Sub.isPublic());
	assertTrue(mod2Sub.isStatic());
	assertFalse(mod2Sub.isPrivate());
    }

    // private subsumed by !public
    @Test
    public void testBasicNeg() {
	// !public
	Modifiers mod1 = new Modifiers(new AST.List<Modifier>()
		.add(new NegativeModifier("public")))
		.enhanceWithMaybes(Modifiables.METHOD);
	// private
	Modifiers mod2 = new Modifiers(new AST.List<Modifier>()
		.add(new Modifier("private")))
		.enhanceWithMaybes(Modifiables.METHOD);

	Map uniMap = new HashMap();
	assertTrue(mod2.subsumedBy(mod1, uniMap));

	Modifiers mod1Sub = mod1.substitute(uniMap);
	assertTrue(mod1Sub.isPrivate());
    }

    // !final subsumed by ANY.  
    @Test
    public void testNeg2() {
	// !final
	Modifiers mod1 = new Modifiers(new AST.List<Modifier>()
		.add(new NegativeModifier("final")))
		.enhanceWithMaybes(Modifiables.METHOD);

	// anything
	Modifiers mod2 = new Modifiers().enhanceWithMaybes(Modifiables.METHOD);
	
	Map uniMap = new HashMap();
	assertTrue(mod1.subsumedBy(mod2, uniMap));
	
	Modifiers mod2sub = mod2.substitute(uniMap);
	assertFalse(mod2sub.isFinal());
    }
}
