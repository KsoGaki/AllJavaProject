package main;

import junit.framework.TestCase;

public class TestSetDevice extends TestCase {

	SetDevice setDevice;
	int initNb;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setDevice = new SetDevice();
		setDevice.add("AAA");
		setDevice.add("BBB");
		setDevice.add("CCC");
		initNb = 3;
	}

	public void testAdd() {
		
			setDevice.add("Saïd");
			assertEquals(setDevice.list().size(), initNb + 1);
			assertTrue(setDevice.list().contains("Saïd"));
		
		try {
			setDevice.add("Saïd");
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
		
		try {
			setDevice.add(null);
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
	}
	
	public void testList() {
		
			assertEquals(setDevice.list().size(), initNb);
			assertTrue(setDevice.list().contains("AAA"));
			assertTrue(setDevice.list().contains("BBB"));
			assertTrue(setDevice.list().contains("CCC"));
			
	}
	
	public void testRemove() {
		
			setDevice.remove("AAA");
			assertEquals(setDevice.list().size(), initNb - 1);
			assertFalse(setDevice.list().contains("AAA"));
			
		try {
			setDevice.remove("AAA");
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
		
		try {
			setDevice.remove(null);
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
	}
	
	public void testUpdate() {
		
			setDevice.update("AAA","DDD");
			assertFalse(setDevice.list().contains("AAA"));
			assertTrue(setDevice.list().contains("DDD"));		
			
		try {
			setDevice.update("EEE","AAA");
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}

		try {
			setDevice.update("AAA","BBB");
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
		try {
			setDevice.update(null,null);
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
		try {
			setDevice.update(null,"DDD");
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
		try {
			setDevice.update("AAA",null);
		}
		catch (Exception e) {
			assertNotNull(e);
			e.printStackTrace();
		}
		
	}

}
