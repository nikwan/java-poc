package com.java.poc.j8.object.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashCodeDemo3 {

	public static void main(String[] args) {
		String r = null;
		Map<Emp, String> m = new HashMap<Emp, String>();
		Address a1 = new Address("pashan");
		Address a2 = new Address("sai");
		r = m.put(new Emp(1, "kablu", a1), "nikhil val");
		System.out.println("put1:" + r);
		
		r = m.put(new Emp(1, "darshan", a2), "darshan val");
		System.out.println("put2:" + r);
		
		
		
		//a2.city = "XX";
		
		m.forEach((k, v) -> System.out.println(k));
		
		//System.out.println("add1 hashcode:" + a1.hashCode());
		//System.out.println("add2 hashcode:" + a2.hashCode());
		
		/*
		 * Map<String, String> m1 = new HashMap<String, String>(); m1.put("1", "niks");
		 * m1.put("1", "kablu"); System.out.println(m1);
		 */

	}

}

class Emp {
	String name;
	Address address;
	int id;

	Emp(int id, String name, Address address) {
		this.name = name;
		this.address = address;
		this.id = id;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public String toString() {
		return "name " + name + " address:" + this.address;
	}
}

class Address {
	String city;
	
	
	Address(String city) {
		this.city = city;
	}

	public String toString() {
		return "city:" + city;
	}
}
