package com.random.tests

class MonobitTest extends AbstractTest {
	
	def readBitSeq(fname) {
		def resMap = [
			'n0' : 0,
			'n1' : 0,
			'sequenceLength' : 0
		]
		
		new File(fname).eachByte(4) { buffer, nReads ->
			def x = new BigInteger(buffer);
			resMap['sequenceLength'] += 4;
			resMap['n1'] += countBits(x as int);
		}
		
		return resMap;
	}
	
	def test(fname, alef) {
		def paramMap = readBitSeq(fname);
		def n0 = BITS*paramMap['sequenceLength'] - paramMap['n1'];
		def x1 = (n0 - paramMap['n1'])*(n0 - paramMap['n1'])/(8.0*paramMap['sequenceLength']);
		
		def res = "ok";
		if(x1 > alef) {
			res = "bad"
		}
		return ['res':res, 'n0':n0, 'n1':paramMap['n1'], 'x1':x1];
	}	
}
