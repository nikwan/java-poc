package com.java.poc.j8.lambda;

@FunctionalInterface
interface DefaultTest{
	
	String test();
	
	default String testDefault() {
		
		DefaultTest d = () -> "tested +ve";
		
		return d.test();
	}
}

public class LambdaDemo3 {
	
	public static void main(String[] args) {
		DefaultTest defaultTest = () -> {
			return "default test";
			};

			System.out.println(defaultTest.test());
			System.out.println(defaultTest.testDefault());
			
	}
	
	
}
