package com.java.poc.j8.oop;

public class StringDemo1 {

	public static void main(String[] args) {
		String s1 = new String("Nikhil"); //heap
		String s2 = new String("Kablu"); //heap
		
		String s3 = "Darshan"; // string pool constant
		
		String refTopool = s3.intern();
		
		

	}

}
