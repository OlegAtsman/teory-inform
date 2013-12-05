package com.random.test.randoms

import com.random.randoms.impl.GeneratorServiceImpl
import com.random.randoms.impl.JavaRandom;

class JavaRandomTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new JavaRandom())
	}

}
