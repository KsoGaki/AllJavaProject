package main;

import junit.framework.TestCase;

public class TestMathObject extends TestCase {
	
	public void testSqr() {
		int i = 1;
		int j = new MathObject().sqr(i);
		assertEquals(j,i*i);
	}
	
	
}
