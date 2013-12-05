package com.random.randoms.impl
import com.random.randoms.Generator
/**
 * Линейный конгруэнтный метод
 * @author Aleh_Atsman
 */
class LKM implements Generator {
	def x = Integer.MAX_VALUE,
		m = Integer.MAX_VALUE,
		a = 16807,
		c = 0;		
	
	def generate() {
		x = (a*x + c) % m;
		return Math.abs(x);
	}
}
