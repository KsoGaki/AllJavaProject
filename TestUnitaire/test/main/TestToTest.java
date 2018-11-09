package main;

import junit.framework.TestCase;

public class TestToTest extends TestCase {
	
	public void testIncValue() {
		int i = 1;
		int j = new ToTest().incValue(i);
		assertEquals(j,i+1);
	}
	
}
