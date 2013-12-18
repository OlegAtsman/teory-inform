package com.random.tests

import com.random.randoms.Random;

abstract class AbstractTest {
	
	def int BITS = 8;
	
	def generateAndWriteToFile(Random random, fname) {
		new File(fname).withOutputStream { os ->
			for (i in 0..100000) {
				BigInteger x = random.random();
				os << (x.toByteArray());
			}
		}
	}
	
	def countBits(x) {
		x = x - ((x >> 1) & 0x55555555);
		x = (x & 0x33333333) + ((x >> 2) & 0x33333333);
		x = (x + (x >> 4)) & 0x0F0F0F0F;
		x = x + (x >> BITS);
		x = x + (x >> 16);
		x = x & 0x3F;
		return x;
	}
	
	abstract test(fname, alef);
	
}
