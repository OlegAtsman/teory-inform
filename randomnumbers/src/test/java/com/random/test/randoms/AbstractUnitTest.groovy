package com.random.test.randoms

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.analyzers.impl.PokerAnalyzer
import com.random.factorys.AbstractTestsFactory
import com.random.factorys.impl.MonobitFactory
import com.random.factorys.impl.PokerFactory
import com.random.factorys.impl.TwobitFactory
import com.random.file.FileService
import com.random.file.impl.FileServiceImpl
import com.random.randoms.service.GeneratorService;

abstract class AbstractUnitTest {
	
	def GeneratorService generatorService;
	def FileService fs = new FileServiceImpl();
	
	@Before
	def void before() {
		generatorService = getGeneratorService();
		createFile(100000);
	}
	
	@Test
	def void monobitTest() {
		def res = test(new MonobitFactory(), 3.8415);
		println("X=" + res['x'] + " n0=" + res['n0'] + " n1=" + res['n1']);
		Assert.assertEquals(true, res['result']);
	}
	
	@Test
	def void twobitTest() {
		def res = test(new TwobitFactory(), 5.9);
		println('X= ' + res['x'] + ' n0=' + res['n0'] + " n1=" + res['n1'] + ' n00=' + res['n00']);
		Assert.assertEquals(true, res['result']);
	}
	
	@Test
	def void pokerTest() {
		def res = test(new PokerFactory(), 30.6)
		println("X= " + res['x']);
		Assert.assertEquals(true, res['result']);
	}
	
	def abstract getGeneratorService();
	
	def createFile (n) {
		def className = generatorService.getGenerator().getMetaClass().getTheClass().getName();
		def fileName = className + '.txt';
		fs.writeInts(fileName, generatorService.generate(n));
	}
	
	def test(testFactory, coefficient) {
		def test = testFactory.makeTest()
		def analyzer = testFactory.makeAnalyzer()
		
		def className = generatorService.getGenerator().getMetaClass().getTheClass().getName()
		def testName = test.getMetaClass().getTheClass().getName()
		def fileName = className + '.txt'
		
		def analyticMap = analyzer.analyze(fs.readInts(fileName))
		def res = test.test(analyticMap, coefficient)
		
		println(testName + " : " + className + " is " + res['result'])
		res
	}
	
}
