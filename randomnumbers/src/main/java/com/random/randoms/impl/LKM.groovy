package com.random.randoms.impl
import com.random.randoms.Random
/**
 * Линейный конгруэнтный метод
 * @author Aleh_Atsman
 */
class LKM implements Random {
	def x = Integer.MAX_VALUE,
		m = Integer.MAX_VALUE,
		a = 16807,
		c = 0;		
	
	def random() {
		x = (a*x + c) % m;
		return Math.abs(x);
	}
}
