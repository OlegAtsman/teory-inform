package com.random.test.randoms

import org.junit.Before

import com.random.randoms.impl.LKM

class LKMTest extends AbstractUnitTest {

	@Override
	@Before
	void before() {
		this.random = new LKM();
	}
	
}
