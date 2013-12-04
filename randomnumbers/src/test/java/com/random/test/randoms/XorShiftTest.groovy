package com.random.test.randoms

import org.junit.Before

import com.random.randoms.impl.XorShift

class XorShiftTest extends AbstractUnitTest {

	@Override
	@Before
	void before() {
		this.random = new XorShift();
	}

}
