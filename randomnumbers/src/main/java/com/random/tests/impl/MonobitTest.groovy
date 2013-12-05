package com.random.tests.impl

import com.random.tests.AbstractTest


class MonobitTest extends AbstractTest {

	def test(analyticMap, coefficient) {
		
		// Число 1 и 0 в последовательности
		def n1 = analyticMap['n1'];
		def n0 = analyticMap['n0']
		
		//Длина последовательности
		def sequenceLength = analyticMap['sequenceLength'];
		def sequenceLengthInBits = BITS * sequenceLength;

		// Вычисляем статистическую функцию (длина последовательности считается в битах)
		def x = Math.pow((n0 - n1), 2) / sequenceLengthInBits;

		['result':x < coefficient, 'x':x, 'coefficient':coefficient, 'n0':n0, 'n1':analyticMap['n1']];
	}
}
