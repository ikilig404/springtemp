package com.dgut.spring.aop.xml;

public class Calculator implements CalculatorInterface{
	
	public int add(int x, int y) {
		return x+y;
	}
	
	public int sub(int x, int y) {
		return x-y;
	}
	
	public int mul(int x, int y) {
		return x*y;
	}
	
	public int div(int x, int y) {
		return x/y;
	}

}
