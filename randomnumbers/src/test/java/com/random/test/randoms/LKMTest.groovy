package com.random.test.randoms

import org.junit.Before

import com.random.randoms.generators.impl.LKM;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class LKMTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new LKM())
	}	
}
