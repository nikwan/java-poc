package com.java.poc.j8.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletoneDemo1 {
	
	private static SingletoneDemo1 singletoneDemo1;
	
	private SingletoneDemo1() {}
	
	public static SingletoneDemo1 getInstance() throws Exception{
		
		if(singletoneDemo1 == null)
			singletoneDemo1 = new SingletoneDemo1();
		else
			throw new Exception("illegal method invocation exception!");
			
		return singletoneDemo1;
	}
	
	public void display() {
		System.out.println("display called");
	}
	
	public static void main(String[] args) throws Exception {
		//SingletoneDemo1 ob = SingletoneDemo1.getInstance();
		
		//ob.display();
		
		Constructor<?>[] declaredConstructors = SingletoneDemo1.class.getDeclaredConstructors();
		
		for(Constructor<?> c: declaredConstructors) {
			System.out.println(c.getName());
			c.setAccessible(true);
			singletoneDemo1 = (SingletoneDemo1) c.newInstance(null);
			singletoneDemo1.display();
		}
		//System.out.println("hash code:" + ob.hashCode());
		System.out.println("hash code broken:" + singletoneDemo1.hashCode());
	}

}
