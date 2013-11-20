package com.random.tests

class TwobitTest extends AbstractTest {
	def readBitSeq(fname) {		def resMap = [
			'n0' : 0,
			'n00' : 0,			'n1' : 0,			'n11' : 0,
			'n01' : 0,
			'n10' : 0,			'sequenceLength' : 0		]		def prevBit;		new File(fname).eachByte(4) { buffer, nReads ->			def int x = new BigInteger(buffer);			resMap['sequenceLength'] += 4;			resMap['n1'] += countBits(x);
			resMap['n11'] += countBits(x&((x<<1)|prevBit));
			resMap['n01'] += countBits(~x&((x<<1)|prevBit));
			resMap['n10'] += countBits(x&~((x<<1)|prevBit));
			//prevBit = x >> (INT BITS - 1);		}
		
		resMap['n0'] = resMap['sequenceLength'] - resMap['n1'];
		resMap['n00'] = resMap['sequenceLength'] - 1 - resMap['n11']
			- resMap['n01'] - resMap['n10'];				return resMap;	}
	@Override
	def test(fname, alef) {
		// TODO Auto-generated method stub
		return null;
	}

}
