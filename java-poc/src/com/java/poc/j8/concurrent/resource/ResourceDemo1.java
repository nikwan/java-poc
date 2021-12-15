package com.java.poc.j8.concurrent.resource;

public class ResourceDemo1 implements AutoCloseable{
	
	public static void main(String[] args) {
		System.out.println("MAINOK");
		
		testResource(new ResourceDemo1());
		
	}
	
	public static void testResource(ResourceDemo1 resource) {
		//try with automatic resource management, only work Jre compliance 9+
		//more improved try-with-resource ARM
		try (resource){
			resource.resource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(resource);
	}

	public void resource(){
		System.out.println("inside resource....");
	}
	
	
	@Override
	public void close() throws Exception {
		System.out.println("cleaning resources...");
		
	}
}
