package com.random.test.randoms

import org.junit.Before

import com.random.randoms.QCM

class QCMTest extends AbstractUnitTest {

	@Override
	@Before
	void before() {
		this.random = new QCM();
	}

}
