package com.java.poc.j8.oop;

class Test{
	
	public static void m1() {
		System.out.println("inside m1");
	}
	
	public void m2() {
		System.out.println("inside m2");
	}
}

public class StaticDemo1 extends Test{
	
	public static void m1() {
		System.out.println("inside m1 overloaded method");
	}
	
	public void m2() {
		System.out.println("inside m2 overrided method");
	}
	
	public static void main(String[] args) {
		Test staticDemo1 = new StaticDemo1();
		
		staticDemo1.m1(); //type reference
		staticDemo1.m2(); //object reference
		int i = 123_456;
		System.out.println(Integer.toString(42, 16));
		String s = new String("nikhil");
		String s1 = "Kablu";
		System.out.println(i);
		
		char c= '\u0032';
		char c1 = 's';
		
	}

}
