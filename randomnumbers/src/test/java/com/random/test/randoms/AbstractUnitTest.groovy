package com.random.test.randoms

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.analyzers.AbstractAnalyzer
import com.random.analyzers.impl.MonobitAnalyzer
import com.random.analyzers.impl.PokerAnalyzer
import com.random.analyzers.impl.TwobitAnalyzer
import com.random.file.FileService
import com.random.file.impl.FileWorker2
import com.random.randoms.GeneratorService
import com.random.tests.AbstractTest
import com.random.tests.impl.MonobitTest
import com.random.tests.impl.PokerTest
import com.random.tests.impl.TwobitTest

abstract class AbstractUnitTest {
	
	def GeneratorService generatorService;
	def FileService fs = new FileWorker2();
	
	@Before
	def void before() {
		generatorService = getGeneratorService();
		createFile(100000);
	}
	
	@Test
	def void monobitTest() {
		def res = test(new MonobitTest(), new MonobitAnalyzer(), 3.8415);
		println("X=" + res['x'] + " n0=" + res['n0'] + " n1=" + res['n1'] + "\n");
		Assert.assertEquals(true, res['result']);
	}
	
	@Test
	def void twobitTest() {
		def res = test(new TwobitTest(), new TwobitAnalyzer(), 5.9);
		println("X= " + res['x'] + " n0=" + res['n0'] + " n1=" + res['n1']);
		Assert.assertEquals(true, res['result']);
	}
	
	@Test
	def void pokerTest() {
		def res = test(new PokerTest(), new PokerAnalyzer(), 30.6)
		println("X= " + res['x']);
		Assert.assertEquals(true, res['result']);
	}
	
	def abstract getGeneratorService();
	
	def createFile (n) {
		def className = generatorService.getGenerator().getMetaClass().getTheClass().getName();
		def fileName = className + '.txt';
		fs.writeInts(fileName, generatorService.generate(n));
	}
	
	def test(AbstractTest test, AbstractAnalyzer analyzer, coefficient) {
		def className = generatorService.getGenerator().getMetaClass().getTheClass().getName();
		def testName = test.getMetaClass().getTheClass().getName();
		def fileName = className + '.txt';
		
		def analyticMap = analyzer.analyze(fs.readInts(fileName));
		def res = test.test(analyticMap, coefficient);
		
		println(testName + " : " + className + " is " + res['result']);
		res
	}
	
}
