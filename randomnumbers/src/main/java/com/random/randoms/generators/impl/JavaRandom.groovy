package com.random.randoms.generators.impl

import com.random.randoms.generators.Generator;

class JavaRandom implements Generator {

	def Random random = new Random();
	
	@Override
	def generate() {
		Math.abs(random.nextInt());
	}

}
