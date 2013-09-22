package com.univer.teory;

import java.util.List;

public class Haffman {

	private Table table;

	public Haffman(String source) {
		table = new Table(source);
	}

	public void buildCodeTable() {
		List<Node> probList = table.getProbList();

		Node preLast = probList.get(probList.size() - 1);
		Node last = probList.get(probList.size());
		
		
	}
}
