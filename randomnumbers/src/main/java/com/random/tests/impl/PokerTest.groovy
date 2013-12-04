package com.random.tests.impl

import com.random.tests.AbstractTest;

class PokerTest extends AbstractTest {
	
	@Override
	def test(analyticMap, coefficient) {
		['x3':analyticMap['x3'] < coefficient, 'coefficient':coefficient];
	}

}
