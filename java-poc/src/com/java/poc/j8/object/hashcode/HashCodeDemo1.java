package com.java.poc.j8.object.hashcode;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class HashCodeDemo1 {
	
	public static void main(String[] args) {
		String s1 = "str";
		String s2 = "str";
		
		LongAdder a = new LongAdder();
		AtomicLong at = new AtomicLong();
		LongAccumulator ac = new LongAccumulator( (a1, b1) -> a1 + b1, 0);
		
		StringBuffer sb = new StringBuffer();
		//sb.equals(obj);
		
		if(s1 == s2) {
			System.out.println("equals true");
		}
		if(s1.equals(s2)) {
			System.out.println("equals true");
		}
	}

}
