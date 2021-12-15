package com.java.poc.j8.lambda;

interface Display {
	void dipslay();
}
public class LambdaDemo1 {
	
	public static void main(String[] args) {
		
		Display display = new Display() {
			
			@Override
			public void dipslay() {
				System.out.println("inside display...");
				
			}
		};
		
		display.dipslay();
		
		//lambda implementation
		
		Display d = () ->{System.out.println("using lambda inside display");};
		
		d.dipslay();
		
		//String s = () ->{System.out.println("xxxx");};
		
		Fun f = (int a, int b) -> a + b;
		
		System.out.println("lambda test called: " + f.test(1, 2));
		
	}
	
	@FunctionalInterface
	interface Fun{
		
		int test(int a, int b);
		//void test2();
		
	}

}
