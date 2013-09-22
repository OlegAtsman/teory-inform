package com.univer.teory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Haffman {

	private Table table;
	
	private Map<Character, String> codeTable = new HashMap<Character, String>();
	
	private static String PRELAST_CODE = "1";
	private static String LAST_CODE = "0";

	public Haffman(String source) {
		table = new Table(source);
	}

	public void buildCodeTable() {

		List<Node> probList = table.getProbList();

		while (probList.size() > 1) {

			Node preLast = probList.get(probList.size() - 2);
			Node last = probList.get(probList.size()-1);

			codeNode(preLast, PRELAST_CODE);
			codeNode(last, LAST_CODE);

			probList.add(new Node(preLast.getSymbol() + last.getSymbol(),
					preLast.getFreq() + last.getFreq(),
					preLast.getProb() + last.getProb()));

			probList.remove(preLast);
			probList.remove(last);
			
			table.sortProbList();
		}

	}

	public void codeNode(Node node, String symbol) {
		String name = node.getSymbol();
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!codeTable.containsKey(ch)) {
				codeTable.put(ch, symbol);
			} else {
				String code = codeTable.get(ch);
				codeTable.remove(ch);
				codeTable.put(ch, code + symbol);
			}
		}
		System.out.println(codeTable);
	}
}
