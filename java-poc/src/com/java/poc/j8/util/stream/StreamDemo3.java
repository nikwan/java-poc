package com.java.poc.j8.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo3 {
	
	Person p1, p2, p3, p4, p5, p6;
	
	public StreamDemo3() {
		
		p1 = new Person("Nikhil W", "n1@gmail.com", "MALE", "ADMIN", 40);
		p2 = new Person("Kablu M", "k1@gmail.com", "MALE", "ADMIN", 35);
		p3 = new Person("Darshan C", "d1@gmail.com", "MALE", "ADMIN", 31);
		p4 = new Person("Piyush M", "p1@gmail.com", "MALE", "USER", 30);
		p5 = new Person("Bala W", "d1@gmail.com", "FEMALE", "USER", 35);
		p6 = new Person("Test1", "t1@gmail.com", "FEMALE", "USER", 41);
		
	}
	
	public static void main(String[] args) {
		
		StreamDemo3 s = new StreamDemo3();
		
		Test m = Test.MALE;
		System.out.println(m.name());
		System.out.println(StreamDemo3.Person.Sex.MALE.name());
		
		//s.testLambda();
		s.testLambdaEmail();
		s.testGroupBy();
		
	}
	
	private void testLambdaEmail() {
		List<Person> list = Arrays.asList(p1,p2,p3,p4, p5, p6);
		
		list.stream()
		.filter( m -> m.getSex() == StreamDemo3.Person.Sex.MALE.name())
		.filter( m -> m.getAge() > 35) //aggregate
		.forEach( e -> System.out.println(e.getEmail())); //terminal operation
		
	}
	
	private void testGroupBy() {
		System.out.println("group by sex**************");
		List<Person> list = Arrays.asList(p1,p2,p3,p4, p5 , p6);
		
		list.stream()
		.collect(Collectors.groupingBy(Person::getSex))
		.forEach( (a, b) -> {
			System.out.println(a + ":" + b);
			b.stream()
			.forEach(System.out::println);
		});
		
		System.out.println("group by sex with total ages**************");
		
		list.stream()
		.collect(
			Collectors.groupingBy(Person::getSex, Collectors.reducing(0, Person::getAge, Integer::sum)))
		.forEach( (a, b) -> {
			System.out.println(a + " age:" + b);
		});
		
	}

	private void testLambda() {
		List<Person> list = Arrays.asList(p1,p2,p3,p4);
		
		list.stream()
		.filter( m -> m.getSex() == StreamDemo3.Person.Sex.MALE.name())
		.mapToInt( m -> m.getAge()) //aggregate
		.forEach( e -> System.out.println(e)); //terminal operation
		
	}

	public static class Person{
		
		String name;
		String email;
		String sex;
		String userType;
		int age;
		
		public enum User{
			ADMIN, USER
		}
		
		public enum Sex{
			MALE, FEMALE, TRANS
		}

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

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", email=" + email + ", sex=" + sex + ", userType=" + userType + "]";
		}

		public Person(String name, String email, String sex, String userType, int age) {
			super();
			this.name = name;
			this.email = email;
			this.sex = sex;
			this.userType = userType;
			this.age = age;
		}
		
		
	}
	
	
}

