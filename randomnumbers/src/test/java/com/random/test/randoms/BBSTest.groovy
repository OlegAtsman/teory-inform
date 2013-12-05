package com.random.test.randoms

import com.random.randoms.generators.impl.BBS;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class BBSTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new BBS());
	}

}
