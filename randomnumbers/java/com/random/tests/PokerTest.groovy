package com.random.tests

class PokerTest extends AbstractTest {
	
	def blockLen = 4,
		blockNum = 1<<blockLen,
		blockMask = blockNum - 1,
		blockCounter,
		x3 = 0;
	
	def analyzeFile(fname) {
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
	
	@Override
	def test(filename, alef) {
		def resMap = analyzeFile(filename);
		
		
	}

}
