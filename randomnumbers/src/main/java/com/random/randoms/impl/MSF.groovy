package com.random.randoms.impl

import com.random.randoms.Random

class MSF implements Random {

	def x=Integer.MAX_VALUE,
		a = 48271,
		m = Integer.MAX_VALUE;
	
	def random() {
		x = a*x%m;
		return Math.abs(x);
	}

}
