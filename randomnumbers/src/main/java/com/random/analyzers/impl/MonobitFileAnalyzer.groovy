package com.random.analyzers.impl

import com.random.analyzers.AbstractFileAnalyzer

class MonobitFileAnalyzer extends AbstractFileAnalyzer {
	
	def analyzeFile(filename) {
		def resMap = [
			'n0' : 0,
			'n1' : 0,
			'sequenceLength' : 0
		]
		
		new File(filename).eachByte(4) { buffer, nReads ->
			def x = new BigInteger(buffer);
			resMap['sequenceLength'] += 4;
			resMap['n1'] += countBits(x as int);
		}
		
		return resMap;
	}
	
}
