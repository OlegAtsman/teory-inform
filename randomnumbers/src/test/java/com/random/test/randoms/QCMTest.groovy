package com.random.test.randoms

import org.junit.Before

import com.random.randoms.impl.GeneratorServiceImpl
import com.random.randoms.impl.QCM

class QCMTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new QCM());
	}

}
