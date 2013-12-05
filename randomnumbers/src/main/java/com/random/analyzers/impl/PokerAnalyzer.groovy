package com.random.analyzers.impl

import com.random.analyzers.AbstractAnalyzer

class PokerAnalyzer extends AbstractAnalyzer {

	def blockLen = 4,
		blockNum = 1<<blockLen,
		blockMask = blockNum - 1,
		blockCounter = new int[blockNum]
	
	def analyze(ints) {
		def	sequenceLength = 0
		
		for(int x : ints) {
			sequenceLength += 4;
			blockCounter[x & blockMask]++
			
			for(int i = 0; i < 8/blockLen; i++) {
				x = x >> blockLen
			}
		}
	
		[	
			'blockLen' : blockLen,
			'blockNum' : blockNum,
			'blockCounter' : blockCounter,
			'sequenceLength': sequenceLength
		]
	}

}
