package com.random.test.randoms

import org.junit.Before

import com.random.randoms.generators.impl.MM;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class MMTest extends AbstractUnitTest {
		
	@Override
	def getGeneratorService() {
		new GeneratorServiceImpl(new MM());
	}
	
}
