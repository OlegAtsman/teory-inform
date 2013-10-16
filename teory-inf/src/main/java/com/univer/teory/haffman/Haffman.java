package com.univer.teory.haffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.univer.teory.haffman.parts.Node;

public class Haffman {
	
	public static String ONE = "1";
	public static String ZERO = "0";

	public Map<Character, String> buildCodeTable(List<Node> probList) {
		List<Node> privateProbList = new ArrayList<Node>(probList);
		
		Map<Character, String> codeTable = new HashMap<Character, String>();
		while (privateProbList.size() > 1) {

			Node preLast = privateProbList.get(privateProbList.size() - 2);
			Node last = privateProbList.get(privateProbList.size()-1);

			codeNode(codeTable, preLast, ONE);
			codeNode(codeTable, last, ZERO);

			privateProbList.add(new Node(preLast.getSymbol() + last.getSymbol(),
					preLast.getFreq() + last.getFreq(),
					preLast.getProb() + last.getProb()));

			privateProbList.remove(preLast);
			privateProbList.remove(last);
			
			Collections.sort(privateProbList);
		}
		
		return codeTable;
	}

	private void codeNode(Map<Character, String> codeTable, Node node, String symbol) {
		String name = node.getSymbol();
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!codeTable.containsKey(ch)) {
				codeTable.put(ch, symbol);
			} else {
				String code = codeTable.get(ch);
				codeTable.remove(ch);
				codeTable.put(ch, symbol+code);
			}
		}		
	}
}
