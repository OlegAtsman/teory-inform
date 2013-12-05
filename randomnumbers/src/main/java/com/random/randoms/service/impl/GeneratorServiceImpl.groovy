package com.random.randoms.service.impl


import com.random.randoms.generators.Generator;
import com.random.randoms.service.GeneratorService;

class GeneratorServiceImpl implements GeneratorService {
	
	def Generator generator;
	
	def GeneratorServiceImpl(generator) {
		this.generator = generator
	}
	
	def generate(int n) {
		def ints = []
		
		for (i in 1..n) {
			int x = generator.generate()
			ints.add(x)
		}
		ints
	}
	
	def getGenerator() {
		generator
	}
	
}
