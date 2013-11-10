package com.univer.teoryinform.randomnumbers.randoms;

public class QuadraticCongruentialMethod {
	
	private int x = 7;
	
	private int random(int d, int a, int c, int m) {
		this.x = (d*x*x + a*x + c) % m;
		return x;
	}
	
	public int random() {
		return random(0, 0, 0, 0);
	}
	
}
