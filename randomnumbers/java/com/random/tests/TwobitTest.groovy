package com.random.tests

class TwobitTest extends AbstractTest {
	
			'n0' : 0,
			'n00' : 0,
			'n01' : 0,
			'n10' : 0,
		
			resMap['n11'] += countBits(x&((x<<1)|prevBit));
			resMap['n01'] += countBits(~x&((x<<1)|prevBit));
			resMap['n10'] += countBits(x&~((x<<1)|prevBit));
			prevBit = x >> (BITS - 1);
		
		resMap['n0'] = BITS*resMap['sequenceLength'] - resMap['n1'];
		resMap['n00'] = BITS*resMap['sequenceLength'] - 1 - resMap['n11'] - resMap['n01'] - resMap['n10'];
	
	def test(filename, alef) {
		def resMap = analyzeFile(filename);

		def x2 = 4*(Math.pow(resMap['n00'], 2) + Math.pow(resMap['n01'], 2) + 
			Math.pow(resMap['n10'], 2) + Math.pow(resMap['n11'], 2))/(resMap['sequenceLength']-1) - 
			2*(Math.pow(resMap['n0'], 2) + Math.pow(resMap['n1'], 2))/resMap['sequenceLength'] + 1;
		
		resMap['x2'] = x2;
		resMap['res'] = "ok";
		if(x2 > alef) {
			resMap['res'] = "bad"
		}
		return resMap;
	}
}