package com.random.test.randoms

import com.random.randoms.generators.impl.JavaRandom;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class JavaRandomTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new JavaRandom())
	}

}
