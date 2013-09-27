package com.univer.teory.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;


public class FileReader {

	public String readFromFile(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			String fileString = IOUtils.toString(inputStream);

			return fileString;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void writeToFile(String fileName, String data) throws IOException {
		File file = new File(fileName);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		try {
			out.print(data);
		} finally {
			out.flush();
			out.close();
		}
	}
}
