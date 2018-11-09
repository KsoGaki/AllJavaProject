package main;

import junit.framework.TestCase;

public class TestConcatement extends TestCase {

	public void testConcatage() {
		String a = "Saïd ";
		String b = "Oubram";
		String c = new Concatement().concatanage(a, b);
		assertEquals(c, a.concat(b));
		try {
			c = new Concatement().concatanage(null, b);
			assertNotNull(null);
			assertEquals(c, a.concat(b));
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

}
