package com.random.analyzers.impl

import com.random.analyzers.Analyzer

class PokerAnalyzer extends Analyzer {

	def blockLen = 1,
		blockNum = 1<<blockLen,
		blockMask = blockNum - 1,
		blockCounter = new int[blockNum] // Р§РёСЃР»Рѕ СЂР°Р·Р»РёС‡РЅС‹С… Р±РёС‚РѕРІС‹С… Р±Р»РѕРєРѕРІ
	
	def analyze(ints) {
		def	sequenceLength = 0
		
		for(int x : ints) {
			sequenceLength += SEQ_SL;
			
			for(int i = 0; i < BITS/blockLen; i++) {
				blockCounter[x & blockMask]++ // Р�Р·РјРµРЅСЏРµРј СЃС‡РµС‚С‡РёРє РѕС‡РµСЂРµРґРЅРѕРіРѕ Р±Р»РѕРєР°
				x = x >> blockLen // РџРµСЂРµС…РѕРґРёРј Рє СЃР»РµРґСѓСЋС‰РµРјСѓ Р±Р»РѕРєСѓ
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
