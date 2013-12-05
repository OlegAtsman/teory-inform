package com.random.randoms.impl

import com.random.randoms.Generator

class XorShift implements Generator {
	
	def long x=123456789,
		y=362436069,
		z=521288629,
		w=88675123,
		t;
	
	def generate() {
		t=(x^(x<<11));
		x=y;
		y=z;
		z=w;
		return Math.abs((w=(w^(w>>19))^(t^(t>>8))));
	}
	
}
