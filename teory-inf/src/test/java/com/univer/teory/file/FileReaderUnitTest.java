package com.univer.teory.file;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderUnitTest extends Assert {
	
	private FileReader fr = new FileReader();
	
	@Test
	public void testWriteToFile() throws IOException {
		fr.writeToFile("testFile.txt", "Test test text");
	}
	
	@Test
	public void testReadFromFile() {
		String filetext = fr.readFromFile("testFile.txt");
		assertEquals(filetext, "Test test text");
	}
}
