package com.java.poc.j8.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComparatorDemo1 {
	
	public static void main(String[] args) {
		
		List<User> list = new ArrayList<User>();
		
		list.add(new User("Nikhil", "n1@gmail.com", 1));
		list.add(new User("Kablu", "kablu@gmail.com", 2));
		list.add(new User("Darshan", "darshan@gmail.com", 4));
		list.add(new User("Piyush", "piyush@gmail.com", 5));
		list.add(new User("Sachin", "sachin@gmail.com", 3));
		
		List<User> sorList = list.stream()
				.sorted( (a, b) -> a.getName().compareTo(b.getName()))
				.collect(Collectors.toList());
		
		System.out.println(sorList);
		
	}
	
public  void User(String s, int i) {}

static class User {
	
	String name;
	String email;
	int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User(String name, String email, int id) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", id=" + id + "]";
	}

}
}