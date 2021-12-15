package com.java.poc.j8.lambda;

interface Gen<T> {
	
	T test(T t);
	
}
public class LambdaDemo2 {
	
	static String gentest(Gen<String> gen, String s){
		
		//System.out.println("gentest:" + );
		
		return gen.test(s);
	}
	
	public static void main(String[] args) {
		
		Gen<String> gen = (String s) -> {
			System.out.println("string:" + s);
			
			return s;
		};
		
		gen.test("hi");
		
		////
		
		Gen<Integer> gen1 = (s) -> {
			System.out.println("integer:" + s);
			
			return s;
		};
		
		gen1.test(123);
		
		//
		
		String gens;
		
		gens = gentest( (s) -> {
			System.out.println("string:" + s);
			//s = "Hi";
			
			return s.concat(" xxxx");
		}, "input string nikhil");
		
		System.out.println("gens:" + gens);
		
		
		
	}

}
