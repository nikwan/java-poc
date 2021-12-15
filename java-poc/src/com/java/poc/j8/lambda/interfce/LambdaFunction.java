package com.java.poc.j8.lambda.interfce;

import java.util.Objects;
import java.util.function.Function;

public class LambdaFunction implements Function<String, Integer>{

	@Override
	public Integer apply(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		Function<String, String> function = (String s) -> "ok";
		
		Function<String, String> function1 = (String s) -> "okkkk";
		
		System.out.println(function.andThen(function1).apply("testing"));
		
		//Objects.requireNonNull(null);
		
	}

}
