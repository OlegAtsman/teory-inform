package com.univer.teoryinform.randomnumbers.randoms.lcm

class LKM {
	int x = 0;
	def m = 1 << 32 - 2;
	
	def int random() {
		x = Math.abs((int)((1664525*x + 1013904223) % m));
		return x;
	}
}
