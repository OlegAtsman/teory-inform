package com.random.randoms
/**
 * Линейный конгруэнтный метод
 * @author Aleh_Atsman
 */
class LKM implements Random {
	int x = 0;
	def m = 1 << 32 - 2;
	
	def random() {
		x = Math.abs((int)((1664525*x + 1013904223) % m));
		return x;
	}
}
