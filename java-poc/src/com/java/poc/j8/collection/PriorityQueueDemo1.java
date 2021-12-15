package com.java.poc.j8.collection;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueDemo1 {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("87");
		pq.add("Zamu");
		pq.add("Darshan");
		pq.add("Arvind");
		pq.add("100");
		pq.add("Piyush");
		
		pq.forEach( s -> System.out.println(s));
		
		String remove1 = pq.remove();
		String remove2 = pq.remove();
		String remove3 = pq.remove();
		String remove4 = pq.remove();
		
		System.out.println("[" + remove1 + "] removed");
		System.out.println("[" + remove2 + "] removed");
		System.out.println("[" + remove3 + "] removed");
		System.out.println("[" + remove4 + "] removed");
		
		System.out.println("==after remove===");
		
		Object[] array = pq.toArray();
		Arrays.sort(array);
						
		pq.forEach( s -> System.out.println(s));
		
		System.out.println("=========priority q comparator=======");
		PriorityQueue<Emp> pq1 = new PriorityQueue<Emp>();
		pq1.add(new Emp("Darshan"));
		pq1.add(new Emp("Arvind"));
		pq1.forEach( d -> System.out.println(d.getName()));

	}
	
	static class Emp implements Comparable<Emp>{
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public int compareTo(Emp o) {
			return name.compareTo(o.getName());
		}

		public Emp(String name) {
			super();
			this.name = name;
		}
		
	}

}
