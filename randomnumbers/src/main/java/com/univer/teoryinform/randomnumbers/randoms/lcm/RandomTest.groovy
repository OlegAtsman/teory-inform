package com.univer.teoryinform.randomnumbers.randoms.lcm

class RandomTest {
	
	def countBits(x) {
		x = x - ((x >> 1) & 0x55555555);
		x = (x & 0x33333333) + ((x >> 2) & 0x33333333);
		x = (x + (x >> 4)) & 0x0F0F0F0F;
		x = x + (x >> 8);
		x = x + (x >> 16);
		x = x & 0x3F;
		return x;
	}
	
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
	
	def monobit(fname, alef) {
		def paramMap = readBitSeq(fname);
		def n0 = 8*paramMap['sequenceLength'] - paramMap['n1'];
		def x1 = (n0 - paramMap['n1'])*(n0 - paramMap['n1'])/(8.0*paramMap['sequenceLength']);
		def res = "ok";
		if(x1 > alef)
			res = "bad"
		return ['res':res, 'n0':n0, 'n1':paramMap['n1'], 'x1':x1];
	}
}
