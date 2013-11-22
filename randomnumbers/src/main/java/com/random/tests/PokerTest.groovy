package com.random.tests

class PokerTest extends AbstractTest {
	
	def blockLen = 4,
		blockNum = 1<<blockLen,
		blockMask = blockNum - 1,
		blockCounter = 0,
		x3 = 0;
	
	def analyzeFile(fname) {
		def resMap = [
			'n0' : 0,
			'n1' : 0,
			'sequenceLength' : 0,
		]
		
		new File(fname).eachByte(4) { buffer, nReads ->
			def x = new BigInteger(buffer);
			resMap['sequenceLength'] += 4;
			blockCounter += 1;
			
			for(int i = 0; i < BITS/blockLen; i++) {
				x = x >> blockLen;
			}
			
			for(int i = 0; i < blockLen; i++) {
				x3 += Math.pow(blockCounter[i], 2);
			}
		}
		
		return resMap;
	}
	
	@Override
	def test(filename, alef) {
		def resMap = analyzeFile(filename);
		
		
	}

}
