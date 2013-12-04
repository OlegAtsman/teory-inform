package com.random.analyzers.impl

import com.random.analyzers.AbstractFileAnalyzer

class PokerFileAnalyzer extends AbstractFileAnalyzer {

	def blockLen = 4,
		blockNum = 1<<blockLen,
		blockMask = blockNum - 1,
		blockCounter = new int[blockNum],
		x3 = 0;
	
	def analyzeFile(filename) {
		def n0 = 0,
			n1 = 0,
			sequenceLength = 0;
		
		new File(filename).eachByte(4) { buffer, nReads ->
			def x = new BigInteger(buffer);
			sequenceLength += 4;
			blockCounter[x & blockMask]++;
			
			for(int i = 0; i < 8/blockLen; i++) {
				x = x >> blockLen;
			}	
		}
			
		for(int i = 0; i < blockLen; i++) {
			x3 += Math.pow(blockCounter[i], 2);
		}
		
		x3 = x3 * blockNum * blockLen / sequenceLength - sequenceLength / blockLen;
	
		['x3':x3] 
	}

}
