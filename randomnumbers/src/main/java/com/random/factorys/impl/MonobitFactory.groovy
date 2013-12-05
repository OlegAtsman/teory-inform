package com.random.factorys.impl

import com.random.analyzers.impl.MonobitAnalyzer
import com.random.factorys.AbstractTestsFactory
import com.random.tests.impl.MonobitTest

class MonobitFactory implements AbstractTestsFactory {

	@Override
	def makeAnalyzer() {
		new MonobitAnalyzer()
	}

	@Override
	def makeTest() {
		new MonobitTest()
	}

}
