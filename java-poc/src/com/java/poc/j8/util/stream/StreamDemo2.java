package com.java.poc.j8.util.stream;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {
	
	List<String> brands;
	Product p1,p2,p3,p4;
	
	public StreamDemo2() {

		brands = Arrays.asList("Dhara", "Kali Much", "Raghuvir");
		
		p1 = new Product(343, "Lokvan", brands);
		p2 = new Product(68, "Kali Much", brands);
		p3 = new Product(145, "Solyabean Oil", brands);
		p4 = new Product(150, "Curd", brands);
	}
	
	public static void main(String[] args) {
		
		StreamDemo2 s = new StreamDemo2();
		
		
		//s.testAnonymousClass();
		s.testLambda((Product p) -> {
			return p.getPrice() > 300;
		});
		
		s.testLambda((p) -> p.getPrice() > 100);
		
		s.testStreamsReduction();
	}
	
	private void testLambda(ICheckPrice priceCondition) {
		List<Product> list = Arrays.asList(p1,p2,p3,p4);
		
		for(Product p: list) {
			if(priceCondition.test(p)) {
				System.out.println("price condition greater than Rs. " + ICheckPrice.price_to_check + " :" + p.getName());
			}
		}
				
	}

	private  void testAnonymousClass() {
		List<Product> list = Arrays.asList(p1,p2,p3,p4);
		
		ICheckPrice chk = new ICheckPrice() {
			
			@Override
			public boolean test(Product p) {
				return p.getPrice() > price_to_check;
			}
		};
		
		for(Product p: list) {
			if(chk.test(p)) {
				System.out.println("price condition greater than Rs. " + ICheckPrice.price_to_check + " :" + p.getName());
			}
		}
	}

	private void testStreamsReduction() {
		IntStream.range(1, 10)
		.filter( p -> p == 5)
		.forEach(s -> System.out.println(s));
		
		Stream.of("Sarang", "Ishu", "Bala", "Kablu", "Sanika")
		.filter( p -> p.toLowerCase().startsWith("sa"))
		.map( m -> m.length())
		.forEach(System.out::println);
		
		
		
		List<Product> list = Arrays.asList(p1,p2,p3,p4);
		
		list.stream()
		.filter( p -> p.getPrice() > 100.00)
		.flatMap( f -> f.getCompanies().stream().filter( p -> p.startsWith("Dh")))
		//.map(Product::getPrice)
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		/*map.reduce(p1, (a, b) -> {
			Product p = new Product();
			System.out.println("a:" + a.getPrice() + " b:" + b.getPrice());
			p.setPrice(a.getPrice());
			return p;
		});*/
		
		
				
		//empty list
		//list = Arrays.asList();
		
		System.out.println("reduction*******************");
		//total == 706
		Product i = new Product(1.0f, "Lokvan", brands);
		
		Product reduce = list.stream()
				//.peek( p -> list.add(p1))
		.reduce(i, (a,b) -> {
			Product p = new Product();
			System.out.println("a:" + a.getPrice() + " b:" + b.getPrice());
			p.setPrice(a.getPrice() + b.getPrice());
			p.setTotal(p.getPrice());
			return p;
		});
		//.ifPresent( p -> System.out.println("total:" + p.getPrice()));
		
		System.out.println("total:" + reduce.getTotal());
		
	}

	public static class Product{
		
		public enum User{
			ADMIN, USER
		}
		
		float price;
		String name;
		List<String> companies;
		float total;
		
		
		
		public Product() {
			super();
		}
		
		
		public float getTotal() {
			return total;
		}


		public void setTotal(float total) {
			this.total = total;
		}


		public List<String> getCompanies() {
			return companies;
		}
		public void setCompanies(List<String> companies) {
			this.companies = companies;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Product(float price, String name, List<String> companies) {
			super();
			this.price = price;
			this.name = name;
			this.companies = companies;
		}
		@Override
		public String toString() {
			return "Product [price=" + price + ", name=" + name + ", companies=" + companies + "]";
		}
		
		
	}

}
