package com.random.randoms.generators.impl
import com.random.randoms.generators.Generator;

class LKM implements Generator {
	def x = 1,
		m = Integer.MAX_VALUE,
		a = 16807,
		c = 0;		
	
	def generate() {
		x = (a*x + c) % m;
		return Math.abs(x);
	}
}
