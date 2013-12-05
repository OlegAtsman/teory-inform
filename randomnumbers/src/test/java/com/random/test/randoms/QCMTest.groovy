package com.random.test.randoms

import org.junit.Before

import com.random.randoms.generators.impl.QCM;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class QCMTest extends AbstractUnitTest {

	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new QCM());
	}

}
