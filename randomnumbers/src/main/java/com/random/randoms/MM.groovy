package com.random.randoms

/**
 * Marsaglia-Multicarry
 * @author Aleh_Atsman
 */
class MM implements Random {

	def long x=123456789, 
			 y=362436069,
			 z=77465321, 
			 c=13579,
			 t;
	
	def random() {
		t=916905990L*x+c;
		x=y; y=z;
		c=(t>>32);
		z=(t&0xffffffff);
		z = (z>0)?z:(-1)*z
		
		return  z as long; 
	}
}
