package com.random.randoms

class LKM implements Random {
	def x = Integer.MAX_VALUE,
		m = Integer.MAX_VALUE,
		a = 16807,
		c = 0;		
	
	def random() {
		x = (a*x + c) % m;
		return Math.abs(x);
	}
}
