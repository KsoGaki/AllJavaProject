package main;

import java.lang.reflect.Field;

import objects.Private;

public class Main {
	
	private static Class<?> classPrivate;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		classPrivate = Private.class;
		Private privateObject = (Private) classPrivate.newInstance();
		
		Field field = privateObject.getClass().getDeclaredField("number");
		field.setAccessible(true);
		field.set(privateObject, 50);
		System.out.println("field: " +  privateObject.getNumber());
		
	}

}
