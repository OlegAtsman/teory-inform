package com.univer.teory.file;

import org.junit.Assert;
import org.junit.Test;
import com.univer.teory.HaffmanService;
import com.univer.teory.haffman.Compressor;

public class CompressorTest extends Assert {

	Compressor c = new Compressor();
	
	@Test
	public void mainTest() {
		HaffmanService haffmanService = new HaffmanService();
		String source = "/n/n/n/n/n";
		
		String compressedSource = haffmanService.compress("oleg oleg privet mts");
		System.out.println(compressedSource);
		String decompressedSource = haffmanService.decompress(compressedSource);
		System.out.println(decompressedSource);
		assertEquals(source, decompressedSource);
	}
}
