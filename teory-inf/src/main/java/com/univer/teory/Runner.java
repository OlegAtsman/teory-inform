package com.univer.teory;

import java.util.ArrayList;
import java.util.List;

import com.univer.teory.file.FileReader;
import com.univer.teory.haffman.Haffman;
import com.univer.teory.haffman.parts.Node;
import com.univer.teory.haffman.parts.Table;

public class Runner {

	public static void main(String[] args) {

		FileReader fr = new FileReader();
		String source = fr.readFromFile("testFile.txt");
		Table table = new Table();
		List<Node> pro = new ArrayList<Node>();
		pro.add(new Node("a", 27, 27 / 64));
		pro.add(new Node("b", 9, 9/64));
		pro.add(new Node("c", 9, 9/64));
		pro.add(new Node("d", 9, 9/64));
		pro.add(new Node("f", 3, 3/64));
		pro.add(new Node("h", 3, 3/64));
		pro.add(new Node("j", 3, 3/64));
		pro.add(new Node("k", 1, 1/64));
		table.setProbList(pro);

		System.out.println("----------------------NODES----------------------");
		for (Node node : table.getProbList()) {
			System.out.println("Node: " + node.getSymbol() + " " + " prob: " + node.getProb() + " freq: " + node.getFreq());
		}

		Haffman haffman = new Haffman(table);
		haffman.buildCodeTable();

		System.out.println("------------------ENDS OF NODES----------------------");
		System.out.println(haffman.getCodeTable());
	}

}
