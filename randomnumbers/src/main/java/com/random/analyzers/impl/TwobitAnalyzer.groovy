package com.random.analyzers.impl

import com.random.analyzers.Analyzer

class TwobitAnalyzer extends Analyzer {
	
	def analyze(ints) {
		def n0 = 0,
			n1 = 0,
			n00 = 0,
			n01 = 0,
			n10 = 0,
			n11 = 0,
			sequenceLength = 0
		
		def prevBit=0
		for(int x : ints) {
			sequenceLength += SEQ_SL
			n1 += countBits(x)
			n11 += countBits(x&((x<<1)|prevBit))
			n01 += countBits(~x&((x<<1)|prevBit))
			n10 += countBits(x&~((x<<1)|prevBit))
			prevBit = x >> (BITS - 1)
		}
		
		n0 = sequenceLength * BITS - n1
		n00 = BITS * sequenceLength - 1 - n11 - n01 - n10
		
		[	
			'n0' : n0,
			'n1' : n1,
			'n00' : n00,
			'n11' : n11,
			'n01' : n01,
			'n10' : n10,
			'sequenceLength' : sequenceLength
		]
	}
	
}
