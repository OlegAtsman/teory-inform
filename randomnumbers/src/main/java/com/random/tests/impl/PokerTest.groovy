package com.random.tests.impl

import com.random.tests.AbstractTest


class PokerTest extends AbstractTest {
	
	@Override
	def test(analyticMap, coefficient) {
		def blockLen = analyticMap['blockLen'],
			blockNum = analyticMap['blockNum'],
			blockCounter = analyticMap['blockCounter'],
			sequenceLength = analyticMap['sequenceLength'],
			x = 0
			
		
		for(int i = 0; i < blockLen; i++) {
			x += Math.pow(blockCounter[i], 2);
		}
		
		x = x * blockNum * blockLen / sequenceLength - sequenceLength / blockLen;
		
		['result':x < coefficient, 'x':x];
	}

}
