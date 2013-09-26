package com.univer.teory;

import com.univer.teory.file.FileReader;
import com.univer.teory.haffman.Haffman;

public class Runner {
	
	public static void main(String[] args) {
		
		FileReader fr = new FileReader();
		
		Haffman haffman = new Haffman(fr.readFromFile("testFile.txt"));
		haffman.buildCodeTable();
		
		System.out.println("und");
		
			
	}
	
}
