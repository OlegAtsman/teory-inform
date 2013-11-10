package com.univer.teory;

import java.io.IOException;

import com.univer.teory.file.FileService;

public class Runner2 {
	
	public static void main(String[] args) throws IOException {
		HaffmanService hs = new HaffmanService();
		FileService fs = new FileService();
		
		String compressed = hs.compress(fs.readFromFile("text"));
		System.out.println(compressed);
		fs.writeToFile("compressed", compressed);
		
		String comFromFile = fs.readFromFile("compressed");
		
		fs.writeToFile("decompressed", hs.decompress(comFromFile));
	}
	
}
