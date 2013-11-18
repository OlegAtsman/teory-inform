package com.random.test.randoms

import com.random.randoms.XorShift
import org.junit.Before;

class XorShiftTest extends AbstractUnitTest {

	@Override
	@Before
	void before() {
		this.random = new XorShift();
	}

}
