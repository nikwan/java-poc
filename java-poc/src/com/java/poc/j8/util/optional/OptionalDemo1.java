package com.java.poc.j8.util.optional;

import java.util.Optional;

class Person{
	
	String name;
	String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	
}

public class OptionalDemo1 {
	
	public static void main(String[] args) {
		
		Optional<String> noval = Optional.empty();
		
		Optional<String> val = Optional.of("XDES");
		
		System.out.println("noval.isPresent():" + noval.isPresent());
		
		if(val.isPresent()) {
			System.out.println(val.get());
		}
		
		System.out.println(noval.orElse("xxxxxxxxxxx"));
		
		Optional<Person> p = Optional.ofNullable(getPerson());
		
		String result = p
				.map(Person::getAddress)
				//.map(Person::getName)
				.orElse("not specified");
		
		System.out.println(result);
		
	}
	
	static Person getPerson() {
		
		Person p = new Person("Nikhil", "pune");
		
		return p;
	}

}
