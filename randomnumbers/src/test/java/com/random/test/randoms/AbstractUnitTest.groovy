package com.random.test.randoms

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.randoms.Random
import com.random.tests.AbstractTest
import com.random.tests.MonobitTest
import com.random.tests.TwobitTest

abstract class AbstractUnitTest {
	
	def Random random;
	
	@Before
	abstract void before();
	
	@Test
	def void monobitTest() {
		def AbstractTest monobitTest = new MonobitTest();
		def className = random.getMetaClass().getTheClass().getName();
		def fileName = className+"_monobit_test.txt";
		monobitTest.genBitSeq(random, fileName);
		def res = monobitTest.test(fileName, 3.8415);
		
		println("Monobit : " + className + " is " + res['res']);
		println("x1=" + res['x1'] + " n0=" + res['n0'] + " n1=" + res['n1'] + "\n");
		Assert.assertEquals(res['res'], "ok");
	}
	
	@Test
	def void twobitTest() {
		def AbstractTest twobitTest = new TwobitTest();
		def className = random.getMetaClass().getTheClass().getName();
		def fileName = className+"_twobit_test.txt";
		twobitTest.genBitSeq(random, fileName);
		def res = twobitTest.test(fileName, 5.9);
		
		println("Twobit : " + className + " is " + res['res']);
		println("x2= " + res['x2']);
		
		Assert.assertEquals(res['res'], "ok");
	}
	
	def print(testName, res) {
		
	}
	
}
