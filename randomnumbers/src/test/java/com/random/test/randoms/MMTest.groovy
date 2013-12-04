package com.random.test.randoms

import org.junit.Before

import com.random.randoms.impl.MM

class MMTest extends AbstractUnitTest {
		
	@Override
	@Before
	void before() {
		this.random = new MM();		
	}
	
}
