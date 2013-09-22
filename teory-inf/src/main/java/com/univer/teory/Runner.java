package com.univer.teory;

import com.univer.teory.file.FileReader;

public class Runner {
	
	public static void main(String[] args) {
		
		FileReader fr = new FileReader();
		Table table = new Table(fr.readFromFile("testFile.txt"));
		
		System.out.println(table.toString());
			
	}
	
}
