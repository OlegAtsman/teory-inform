package com.univer.teoryinform.randomnumbers.randoms

class QCM {
	int x = 0;
	def m = 1 << 32 - 2;
	
	def int random() {
		x = (1664525*x*x + 1664525*x + 1013904223) % m;
		return x;
	}
}
