package com.random.test.randoms

import com.random.randoms.generators.impl.MSF;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class MSFTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new MSF());
	}

}
