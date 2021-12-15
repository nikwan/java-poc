package com.java.poc.j8.object.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashCodeDemo2 {
	
	public static void main(String[] args) {
		
		HashCodeDemo2 d = new HashCodeDemo2();
		
		d.testHashCode();
	}

	private void testHashCode() {
		Map<Person, Integer> map = new HashMap<Person, Integer>(16);
		
		Person p1 = new Person(1, "Kablu M");
		Person p2 = new Person(2, "Nikhil W");
		Person p3 = null;
		Person p4 = new Person(3, "Darshan C");
		
		map.put(p1, 1);
		map.put(p2, 2);
		map.put(p3, 3);
		map.put(p4, 33);
		
		System.out.println("size:" + map.size());
		System.out.println(map.get(null));
		
		
		
	}
	
	class Person{
		int id;
		String name;

		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			
			System.out.println("result_hashcode:" + result);
			
			System.out.println("index:" + (result & (16-1)));
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
			Person other = (Person) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}



		public Person(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}



		private HashCodeDemo2 getEnclosingInstance() {
			return HashCodeDemo2.this;
		}
		
		
	}

}
