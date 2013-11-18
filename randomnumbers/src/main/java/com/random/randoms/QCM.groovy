package com.random.randoms

/**
 * Квадратичный конгруэнтный метод 
 * @author Aleh_Atsman
 */
class QCM implements Random {
	int x = 0;
	def m = 1 << 32 - 2;
	
	def random() {
		x = (1664525*x*x + 1664525*x + 1013904223) % m;
		return x;
	}
}
