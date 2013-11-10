package com.univer.teoryinform.randomnumbers.randoms;


public class LinearCongruentialMethod {

	private int x = 7;
	
	private int random(int m, int a, int c) {
		this.x = (a*x + c) % m;
		return x;
	}
	
	public int random() {
		int number = random(Integer.MAX_VALUE, 16385, 0);
		return Math.abs(number);
	}
	
	public static void main(String[] args) {
		LinearCongruentialMethod lcm = new LinearCongruentialMethod();
		for(int i = 0; i<100000000; i++) {
			System.err.println(lcm.random());
		}
	}
}
