package com.univer.teory.file;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderUnitTest extends Assert {
	
	private FileService fr = new FileService();
	
	@Test
	public void testWriteToFile() throws IOException {
		fr.writeToFile("unittest.txt", "Test test text");
	}
	
	@Test
	public void testReadFromFile() {
		String filetext = fr.readFromFile("testFile.txt");
		assertEquals(filetext, "Test test text");
	}
}
