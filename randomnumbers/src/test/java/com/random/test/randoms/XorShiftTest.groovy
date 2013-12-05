package com.random.test.randoms

import org.junit.Before

import com.random.randoms.generators.impl.XorShift;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class XorShiftTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new XorShift());
	}

}
