package com.random.factorys.impl

import com.random.analyzers.impl.TwobitAnalyzer
import com.random.factorys.AbstractTestsFactory
import com.random.tests.impl.TwobitTest

class TwobitFactory implements AbstractTestsFactory {

	@Override
	def makeAnalyzer() {
		new TwobitAnalyzer()
	}

	@Override
	def makeTest() {
		new TwobitTest()
	}

}
