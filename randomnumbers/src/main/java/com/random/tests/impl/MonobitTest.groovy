package com.random.tests.impl

import com.random.tests.AbstractTest;

class MonobitTest extends AbstractTest {

	def test(analyticMap, coefficient) {

		def sequenceLength = analyticMap['sequenceLength'];
		def sequenceLengthInBits = BITS * sequenceLength;

		def n1 = analyticMap['n1'];
		def n0 = sequenceLengthInBits - n1;

		def x1 = Math.pow((n0 - n1), 2) / sequenceLengthInBits;

		['result':x1 < coefficient, 'x1':x1, 'coefficient':coefficient, 'n0':n0, 'n1':analyticMap['n1']];
	}
}
