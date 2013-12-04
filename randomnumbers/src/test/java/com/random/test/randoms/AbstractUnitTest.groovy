package com.random.test.randoms

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.analyzers.impl.MonobitFileAnalyzer
import com.random.analyzers.impl.PokerFileAnalyzer
import com.random.analyzers.impl.TwobitFileAnalyzer
import com.random.file.FileWorker
import com.random.randoms.Random
import com.random.tests.AbstractTest
import com.random.tests.impl.MonobitTest
import com.random.tests.impl.PokerTest
import com.random.tests.impl.TwobitTest

abstract class AbstractUnitTest {
	
	def Random random;
	def FileWorker fw = new FileWorker();
	
	@Before
	abstract void before();
	
	@Test
	def void monobitTest() {
		def AbstractTest test = new MonobitTest();
		def className = random.getMetaClass().getTheClass().getName();
		def fileName = className+"_monobit_test.txt";
		fw.generateAndWriteToFile(random, fileName, 100000);
		
		def fileAnalyzer = new MonobitFileAnalyzer();
		def analyticMap = fileAnalyzer.analyzeFile(fileName);
		def res = test.test(analyticMap, 3.8415);
		
		println("Monobit : " + className + " is " + res['result']);
		println("x1=" + res['x1'] + " n0=" + res['n0'] + " n1=" + res['n1'] + "\n");
		Assert.assertEquals(true, res['result']);
	}
	
	@Test
	def void twobitTest() {
		def AbstractTest test = new TwobitTest();
		def className = random.getMetaClass().getTheClass().getName();
		def fileName = className+"_twobit_test.txt";
		fw.generateAndWriteToFile(random, fileName, 100000);
		
		def fileAnalyzer = new TwobitFileAnalyzer();
		def analyticMap = fileAnalyzer.analyzeFile(fileName);
		def res = test.test(analyticMap, 5.9);
		
		println("Twobit : " + className + " is " + res['result']);
		println("x2= " + res['x2']);
		
		Assert.assertEquals(true, res['result']);
	}
	
	@Test
	def void pokerTest() {
		def AbstractTest test = new PokerTest();
		def className = random.getMetaClass().getTheClass().getName();
		def fileName = className+"_poker_test.txt";
		fw.generateAndWriteToFile(random, fileName, 100000);
		
		def fileAnalyzer = new PokerFileAnalyzer();
		def analyticMap = fileAnalyzer.analyzeFile(fileName);
		def res = test.test(analyticMap, 5.9);
		
		println("Poker : " + className + " is " + res['result']);
		println("x2= " + res['x2']);
		
		Assert.assertEquals(true, res['result']);
	}
}
