package com.random.test.analyzer

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.analyzers.Analyzer
import com.random.analyzers.impl.MonobitAnalyzer
import com.random.analyzers.impl.TwobitAnalyzer
import com.random.file.FileService
import com.random.file.impl.FileServiceImpl
import com.random.randoms.generators.impl.JavaRandom;
import com.random.randoms.service.GeneratorService;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class AnalyzerTest {
	
	def Analyzer analyzer
	def FileService fs;
	def GeneratorService generator;
	def n = 100000
	
	@Before
	void before() {
		this.analyzer = new MonobitAnalyzer()
		this.fs = new FileServiceImpl()
		this.generator = new GeneratorServiceImpl(new JavaRandom())
		
		fs.writeInts("analyzer_test.txt", generator.generate(n))
	}
	
	@Test
	void sequenceLengthTest() {
		def res = analyzer.analyze(fs.readInts("analyzer_test.txt"))
		Assert.assertEquals(n, res['sequenceLength'])
	}
	
	@Test
	void nTest() {
		def res = analyzer.analyze(fs.readInts("analyzer_test.txt"))
		def n0 = res['n0'],
			n1 = res['n1']
			
		def sum = n0 + n1;
		Assert.assertEquals(n*4*8, sum)
	}
	
	@Test
	void monoVstwobitTest() {
		def monoAnalyzer = new MonobitAnalyzer();
		def twoAnalyzer = new TwobitAnalyzer();
		
		def monoRes = monoAnalyzer.analyze(fs.readInts("analyzer_test.txt"))
		def twoRes = twoAnalyzer.analyze(fs.readInts("analyzer_test.txt"))
		
		Assert.assertEquals(monoRes['n1'], twoRes['n1'])
		Assert.assertEquals(monoRes['n0'], twoRes['n0'])
		
	}
}
