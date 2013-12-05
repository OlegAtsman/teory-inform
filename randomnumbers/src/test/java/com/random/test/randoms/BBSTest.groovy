package com.random.test.randoms

import com.random.randoms.impl.BBS
import com.random.randoms.impl.GeneratorServiceImpl

class BBSTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new BBS());
	}

}
