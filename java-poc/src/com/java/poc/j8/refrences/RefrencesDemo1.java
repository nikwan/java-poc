package com.java.poc.j8.refrences;


interface MyTest<T> {
	void test(T t);
	
	default String disp(String s) {
		
		new RefrencesDemo1<String>("dddddddd");
		
		return "xxxxxxxxxxxxxxxx";
	}
}
public class RefrencesDemo1<T> {
	
	T t;
	
	public RefrencesDemo1(T t) {
		this.t = t;
		
		System.out.println("para constructor called...");
	}
	
	public RefrencesDemo1() {
		System.out.println("default called...");
		
		t = null;
	}
	
	
	
	public static void main(String[] args) {
		
		MyTest<String> d = RefrencesDemo1<String>::new;
		
		
		
		System.out.println(d.disp("xxxxxxxxxxxxxx"));
		
		d = (s) -> System.out.println(s + "xxxxxdddddddddddddddddddd");
		
		d.test("hiiiiiiiiiii");
		
	}

}
