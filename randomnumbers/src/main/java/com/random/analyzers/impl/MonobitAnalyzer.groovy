package com.random.analyzers.impl

import com.random.analyzers.Analyzer

class MonobitAnalyzer extends Analyzer {
		
	def analyze(ints) {
		def n0 = 0, 
			n1 = 0, 
			sequenceLength = 0
		
		for(int i : ints) {
			sequenceLength += 4
			n1 += countBits(i)
		}
		
		n0 = sequenceLength * 8 - n1;
		
		[	
			'n0':n0, 
			'n1':n1, 
			'sequenceLength':sequenceLength
		]
	}
	
}
