package com.random.analyzers.impl

import com.random.analyzers.Analyzer

class PokerAnalyzer extends Analyzer {

	def blockLen = 4,
		blockNum = 1<<blockLen,
		blockMask = blockNum - 1,
		blockCounter = new int[blockNum] // Число различных битовых блоков
	
	def analyze(ints) {
		def	sequenceLength = 0
		
		for(int x : ints) {
			sequenceLength += 4;
			
			for(int i = 0; i < BITS/blockLen; i++) {
				blockCounter[x & blockMask]++ // Изменяем счетчик очередного блока
				x = x >> blockLen // Переходим к следующему блоку
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
