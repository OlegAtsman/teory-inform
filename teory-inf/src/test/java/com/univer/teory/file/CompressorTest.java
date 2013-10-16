package com.univer.teory.file;

import org.junit.Assert;
import org.junit.Test;
import com.univer.teory.HaffmanService;
import com.univer.teory.haffman.Compressor;

public class CompressorTest extends Assert {

	Compressor c = new Compressor();
	
	@Test
	public void test() {
		String toBit = c.eightBit("1010101011111111111101010101011101110110110010110100000000");
		toBit = toBit.substring(0, toBit.length()-1);
		String from = c.bitEight(toBit, 6);
		
		assertEquals("1010101011111111111101010101011101110110110010110100000000", from);
	}
	
	@Test
	public void mainTest() {
		HaffmanService haffmanService = new HaffmanService();
		String source = "aaabbbbcccccdddddd";
		String compressedSource = haffmanService.compress(source);
		String decompressedSource = haffmanService.decompress(compressedSource);
		
		assertEquals(source, decompressedSource);
	}
}
