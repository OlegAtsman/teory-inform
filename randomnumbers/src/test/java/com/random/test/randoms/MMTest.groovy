package com.random.test.randoms

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.randoms.MM
import com.random.tests.AbstractTest
import com.random.tests.MonobitTest;

class MMTest extends AbstractUnitTest {
		
	@Override
	@Before
	void before() {
		this.random = new MM();		
	}
	
}
