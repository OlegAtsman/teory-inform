package com.random.factorys.impl

import com.random.analyzers.impl.PokerAnalyzer
import com.random.factorys.AbstractTestsFactory
import com.random.tests.impl.PokerTest

class PokerFactory implements AbstractTestsFactory {

	@Override
	def makeAnalyzer() {
		new PokerAnalyzer()
	}

	@Override
	def makeTest() {
		new PokerTest()
	}

}
