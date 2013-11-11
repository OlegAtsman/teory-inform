package com.univer.teoryinform.randomnumbers.randoms.lcm

import com.univer.teoryinform.randomnumbers.randoms.LKM
import com.univer.teoryinform.randomnumbers.randoms.QCM
import com.univer.teoryinform.randomnumbers.tests.MonobitTest

QCM lkm = new QCM();

def genBitSeq(fname) {
	LKM lkm = new LKM();
	new File(fname).withOutputStream { os ->
		for (i in 0..100000) {
			BigInteger x = lkm.random();
			os << (x.toByteArray());
		}
	}
}

genBitSeq('massive.txt');

MonobitTest rt =  new MonobitTest()
def res = rt.monobit('massive.txt', 3.8415);

println("Rans test. Monobit is " + res.res);
println("x1=" + res.x1 + " n0=" + res.n0 + " n1=" + res.n1 + "\n");