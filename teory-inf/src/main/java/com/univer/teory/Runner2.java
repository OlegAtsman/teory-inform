package com.univer.teory;

public class Runner2 {
	
	public static void main(String[] args) {
		HaffmanService hs = new HaffmanService();
		hs.compressFile("text");
		hs.decompressFile("text.haffman");
	}
	
}
