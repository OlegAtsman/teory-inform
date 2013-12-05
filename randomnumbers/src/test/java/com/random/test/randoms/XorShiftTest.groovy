package com.random.test.randoms

import org.junit.Before

import com.random.randoms.impl.GeneratorServiceImpl
import com.random.randoms.impl.XorShift

class XorShiftTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new XorShift());
	}

}
