package com.random.tests

class MonobitTest extends AbstractTest {
	
	def test(fname, alef) {
		
		def paramMap = readBitSeq(fname);
		def n0 = 8*paramMap['sequenceLength'] - paramMap['n1'];
		def x1 = (n0 - paramMap['n1'])*(n0 - paramMap['n1'])/(8.0*paramMap['sequenceLength']);
		
		def res = "ok";
		if(x1 > alef) {
			res = "bad"
		}
		return ['res':res, 'n0':n0, 'n1':paramMap['n1'], 'x1':x1];
	}	
}
