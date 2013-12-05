package com.random.randoms.impl
import com.random.randoms.Generator

class BBS implements Generator {
	
	def x=9,
		m=209;
		
	def generate() {
		x = Math.pow(x, 2)%m;
		return Math.abs(x);
	}
	
}
