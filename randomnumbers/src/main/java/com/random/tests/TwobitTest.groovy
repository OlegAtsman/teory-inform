package com.random.tests

class TwobitTest extends AbstractTest {

			'n0' : 0,
			'n00' : 0,
			'n01' : 0,
			'n10' : 0,
			resMap['n11'] += countBits(x&((x<<1)|prevBit));
			resMap['n01'] += countBits(~x&((x<<1)|prevBit));
			resMap['n10'] += countBits(x&~((x<<1)|prevBit));
			//prevBit = x >> (INT BITS - 1);
		
		resMap['n0'] = resMap['sequenceLength'] - resMap['n1'];
		resMap['n00'] = resMap['sequenceLength'] - 1 - resMap['n11']
			- resMap['n01'] - resMap['n10'];
	@Override
	def test(fname, alef) {
		// TODO Auto-generated method stub
		return null;
	}

}