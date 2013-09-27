package com.univer.teory.haffman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.univer.teory.haffman.parts.Node;
import com.univer.teory.haffman.parts.Table;

public class Haffman {

	private Table table;
	
	private Map<Character, String> codeTable = new HashMap<Character, String>();
	
	private static String PRELAST_CODE = "1";
	private static String LAST_CODE = "0";

	public Haffman(Table table) {
		this.table = table;
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
				codeTable.put(ch, symbol+code);
			}
		}
		Iterator<Entry<Character, String>> it = codeTable.entrySet().iterator();
		
		
		/*codeTable = new HashMap<Character, String>();
		while(it.hasNext()) {
			Entry e = it.next();
			String value = (String) e.getValue();
			value = new StringBuilder(value).reverse().toString();
			codeTable.put((Character) e.getKey(), value);
		}*/
	}
	
	public Map<Character, String> getCodeTable() {
		return codeTable;
	}
	
	public Table getTable() {
		return table;
	}
}
