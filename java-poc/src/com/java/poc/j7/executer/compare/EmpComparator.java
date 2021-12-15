package com.java.poc.j7.executer.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e2.getId() - e1.getId();
	}
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		
		int i = 10;
		short s = 20;
		i = s;
		
		empList.add(new Employee(2, "Nikhil"));
		empList.add(new Employee(1, "Kablu"));
		empList.add(new Employee(3, "Darshan"));
		
		EmpComparator c = new EmpComparator();
		
		Collections.sort(empList, c);
		
		System.out.println(empList);
		
		int s1 = 2657860 & (16-1);
		
		System.out.println(s);
		
		System.out.println(i);
	}

}
