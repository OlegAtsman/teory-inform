package com.random.randoms.impl

import com.random.randoms.Generator

class JavaRandom implements Generator {

	def Random random = new Random();
	
	@Override
	def generate() {
		Math.abs(random.nextInt());
	}

}
