package com.java.poc.j8.lambda.interfce;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaPredicate implements Predicate<String>{

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public static void main(String[] args) {
		Predicate<String> predicate = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				return true;
			}
		};
		
		Predicate<String> pre = (s) -> true;
		
		List<Integer> list = Arrays.asList(12,10,23,33);
		
		System.out.println(predicate.and(pre).test("test"));
	}

}
