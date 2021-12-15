package com.java.poc.j7.executer.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpComparable {
	
	public static void main(String[] args) {
		List<Test> empList = new ArrayList<Test>();
		
		empList.add(new Test(3, "Nikhil"));
		empList.add(new Test(1, "Kablu"));
		empList.add(new Test(2, "Darshan"));
		
		Collections.sort(empList);
		
		System.out.println(empList);
	}
	
	static class Test implements Comparable<Test>{
		
		int id;
		String name;
		
		
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Test(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Test [id=" + id + ", name=" + name + "]";
		}
		@Override
		public int compareTo(Test o) {
			
			System.out.println("inside comapre to");
			
			if(o.getId() > 2) return 1;
			
			return -1;
		}
		
		
		
	}

}