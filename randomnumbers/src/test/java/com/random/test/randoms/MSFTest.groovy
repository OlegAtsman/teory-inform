package com.random.test.randoms

import com.random.randoms.impl.GeneratorServiceImpl
import com.random.randoms.impl.MSF

class MSFTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new MSF());
	}

}
