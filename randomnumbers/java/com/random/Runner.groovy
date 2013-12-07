package com.random

import com.random.randoms.LKM
import com.random.randoms.MM
import com.random.randoms.QCM
import com.random.randoms.Random
import com.random.tests.MonobitTest


MM lkm = new MM();

def genBitSeq(Random random, fname) {
	new File(fname).withOutputStream { os ->
		for (i in 0..100000) {
			BigInteger x = random.random();
			os << (x.toByteArray());
		}
	}
}

genBitSeq(lkm, 'massive.txt');

MonobitTest rt =  new MonobitTest()
def res = rt.test('massive.txt', 3.8415);

println("Rans test. Monobit is " + res.res);
println("x1=" + res.x1 + " n0=" + res.n0 + " n1=" + res.n1 + "\n");