package com.univer.teory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.univer.teory.file.FileService;
import com.univer.teory.haffman.Haffman;
import com.univer.teory.haffman.parts.Node;
import com.univer.teory.haffman.parts.Table;

public class Runner {

	public static void main(String[] args) throws IOException {

		FileService fr = new FileService();
		String source = fr.readFromFile("testFile.txt");
		Table table = new Table();
		
		List<Node> probList = table.buildProbList(source);

		System.out.println("----------------------NODES----------------------");
		for (Node node : probList) {
			System.out.println("Node: " + node.getSymbol() + " " + " prob: " + node.getProb() + " freq: " + node.getFreq());
		}

		Haffman haffman = new Haffman();
		Map<Character, String> codeTable = haffman.buildCodeTable(probList);

		System.out.println("------------------ENDS OF NODES----------------------");
		System.out.println(codeTable);

	}

}
