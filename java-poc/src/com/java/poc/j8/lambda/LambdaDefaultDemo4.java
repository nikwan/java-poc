package com.java.poc.j8.lambda;

public class LambdaDefaultDemo4  implements IDefault{

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String testDefault() {
		return IDefault.super.testDefault();
	}

}
