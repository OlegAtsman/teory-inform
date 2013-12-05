package com.random.randoms.generators.impl

import com.random.randoms.generators.Generator;

class MSF implements Generator {

	def x=Integer.MAX_VALUE,
		a = 48271,
		m = Integer.MAX_VALUE;
	
	def generate() {
		x = a*x%m;
		return Math.abs(x);
	}

}
