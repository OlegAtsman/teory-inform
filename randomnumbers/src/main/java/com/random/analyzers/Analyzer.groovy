package com.random.analyzers

abstract class Analyzer {
	
	def BITS = 32
	
	def SEQ_SL = 1
	
	def countBits(x) {
		x = x - ((x >> 1) & 0x55555555)
		x = (x & 0x33333333) + ((x >> 2) & 0x33333333)
		x = (x + (x >> 4)) & 0x0F0F0F0F
		x = x + (x >> 8)
		x = x + (x >> 16)
		x = x & 0x3F
		x
	}
	
	abstract analyze(ints)
	
}
