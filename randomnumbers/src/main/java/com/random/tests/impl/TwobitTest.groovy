package com.random.tests.impl

import com.random.tests.AbstractTest


class TwobitTest extends AbstractTest {
	
	def test(analyticMap, coefficient) {
		def L = analyticMap['sequenceLength'];
		def n00 = analyticMap['n00'];
		def n01 = analyticMap['n01'];
		def n10 = analyticMap['n10'];
		def n11 = analyticMap['n11'];
		def n0 = analyticMap['n0'];
		def n1 = analyticMap['n1'];
		
		def m1 = 4/(L-1);
		def squaresSum1 = pow(n00) + pow(n01) + pow(n10) + pow(n11);
		def m2 = 2/L;
		def squaresSum2 = pow(n0) + pow(n1);
		
		def x = m1 * squaresSum1 - m2 * squaresSum2 + 1;
		
		[
			'result' : x<coefficient, 
			'x' : x,
			'n0' : n0,
			'n1' : n1,
			'n00' : n00,
			'n01' : n01,
			'n10' : n10,
			'n11' : n11
		];
	}
	
	def pow(x) {
		Math.pow(x, 2);
	}
}
