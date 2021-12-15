package com.java.poc.j8.util.stream;

import com.java.poc.j8.util.stream.StreamDemo2.Product;

public interface ICheckPrice {
	public static final float price_to_check = 100;
	public boolean test(Product p);
}
