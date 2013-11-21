package com.random.tests

class TwobitTest extends AbstractTest {
		def analyzeFile(filename) {		def resMap = [
			'n0' : 0,
			'n00' : 0,			'n1' : 0,			'n11' : 0,
			'n01' : 0,
			'n10' : 0,			'sequenceLength' : 0		];
				def prevBit=1;		new File(filename).eachByte(4) { buffer, nReads ->			def int x = new BigInteger(buffer);			resMap['sequenceLength'] += 4;			resMap['n1'] += countBits(x);	
			resMap['n11'] += countBits(x&((x<<1)|prevBit));
			resMap['n01'] += countBits(~x&((x<<1)|prevBit));
			resMap['n10'] += countBits(x&~((x<<1)|prevBit));
			prevBit = x >> (BITS - 1);		};
		
		resMap['n0'] = BITS*resMap['sequenceLength'] - resMap['n1'];
		resMap['n00'] = BITS*resMap['sequenceLength'] - 1 - resMap['n11'] - resMap['n01'] - resMap['n10'];				return resMap;	}
	
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
