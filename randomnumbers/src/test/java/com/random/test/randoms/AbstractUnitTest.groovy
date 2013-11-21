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
		monobitTest.genBitSeq(random, "monobit_test.txt");
		def res = monobitTest.test("monobit_test.txt", 3.8415);
		
		print("Monobit", res);
		Assert.assertEquals(res['res'], "ok");
	}
	
	def void twobitTest() {
		def AbstractTest twobitTest = new TwobitTest();
		twobitTest.genBitSeq(random, "twobit_test.txt");
		
		def res = twobitTest.test("twobit_test.txt", 3.8415);
		
		
	}
	
	def print(testName, res) {
		println(testName + " is " + res['res']);
		println("x1=" + res['x1'] + " n0=" + res['n0'] + " n1=" + res['n1'] + "\n");
	}
	
}
