package com.univer.teoryinform.randomnumbers.tests

abstract class Test {
	
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
}
