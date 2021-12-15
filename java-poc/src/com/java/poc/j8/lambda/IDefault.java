package com.java.poc.j8.lambda;

@FunctionalInterface
public interface IDefault {
	
	String test();
	
	default String testDefault() {
		
		DefaultTest d = () -> "tested +ve";
		
		return d.test();
	}

}
