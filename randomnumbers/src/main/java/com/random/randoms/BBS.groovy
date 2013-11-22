package com.random.randoms

class BBS implements Random {
	
	def x=9,
		m=209;
		
	def random() {
		x = Math.pow(x, 2)%m;
		return x;
	}
	
}
