package com.random.analyzers.impl

import com.random.analyzers.AbstractFileAnalyzer

class TwobitFileAnalyzer extends AbstractFileAnalyzer {
	
	def analyzeFile(filename) {
		def n0 = 0,
			n1 = 0,
			n00 = 0,
			n01 = 0,
			n10 = 0,
			n11 = 0,
			sequenceLength = 0;
		
		def prevBit=0;
		new File(filename).eachByte(4) { buffer, nReads ->
			def int x = new BigInteger(buffer);
			sequenceLength += 4;
			n1 += countBits(x);
			n11 += countBits(x&((x<<1)|prevBit));
			n01 += countBits(~x&((x<<1)|prevBit));
			n10 += countBits(x&~((x<<1)|prevBit));
			prevBit = x >> (8 - 1);
		};
		
		n0 = 8 * sequenceLength - n1;
		n00 = 8 * sequenceLength - 1 - n11 - n01 - n10;
		
		['n0' : n0, 
		'n1' : n1, 
		'n00' : n00, 
		'n11' : n11, 
		'n01' : n01, 
		'n10' : n10, 
		'sequenceLength' : sequenceLength]
	}
	
}
