package com.random.tests

import java.nio.ByteBuffer

import com.random.randoms.generators.Generator;

abstract class AbstractTest {
	
	def int BITS = 32;
	
	abstract test(analyticMap, coefficient);
	
}
