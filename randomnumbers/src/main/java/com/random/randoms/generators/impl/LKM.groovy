package com.random.randoms.generators.impl
import com.random.randoms.generators.Generator;
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
