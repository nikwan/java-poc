package com.java.poc.j8.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapDemo1 {
	
	public static void main(String[] args) {
		
		List<Bean> list = new ArrayList<Bean>();
		
		list.add(new Bean("Nikhil", 1, new String[] {"9372512233", "93725122377"}));
		list.add(new Bean("Kablu", 2, new String[] {"9373312233", "93725122344"}));
		list.add(new Bean("Darshan", 2, new String[] {"77777777777", "5555555555555"}));
		
		list.stream().map( m -> m.getName() + " s:" + m.getName().length()).forEach(System.out::println);
		
		list.stream().map( (s) -> {
			System.out.println(s);
			return s.getName();
		}).forEach(System.out::println);
		
		List<String> collect = list.stream().flatMap( l -> Arrays.stream(l.getPhones()))
		.collect(Collectors.toList());
		
		collect.forEach( (s) -> System.out.println(s));
		
		System.out.println("+++++++++++++++++++");
		
		Predicate<Bean> p = s -> s.getName().startsWith("N");
		
		list.stream().filter( p.or( t -> t.getName().startsWith("K")))
		.map( t -> t.getName().toUpperCase())
		.forEach(System.out::println);
		
		
		
				
		
	}
	
	public static class Bean {
		
		String name;
		int id;
		String[] phones;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String[] getPhones() {
			return phones;
		}
		public void setPhones(String[] phones) {
			this.phones = phones;
		}
		public Bean(String name, int id, String[] phones) {
			super();
			this.name = name;
			this.id = id;
			this.phones = phones;
		}
		@Override
		public String toString() {
			return "Bean [name=" + name + ", id=" + id + ", phones=" + Arrays.toString(phones) + "]";
		}
		
		
		
		
	} 

}
