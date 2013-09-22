package com.univer.teory;

import java.util.List;
import java.util.Map;

public class Haffman {

	private Table table;

	public Haffman(String source) {
		table = new Table(source);
	}

	public void buildCodeTable() {
		
		//SORT
		List<Node> probList = table.getProbList();

		Node preLast = probList.get(probList.size() - 1);
		Node last = probList.get(probList.size());
		
		String preString = preLast.getSymbol();
		Map<Character, String> codeTable = table.getCodeTable();
		for(int i = 0; i < preString.length(); i++) {
			char ch = preString.charAt(i);
			
			if(!codeTable.containsKey(ch)){	
				codeTable.put(ch, "1");
			} else{
				String code = codeTable.get(ch);
				codeTable.remove(ch);
				codeTable.put(ch, code + "1");
			}
		}
		
		for(int i = 0; i < preString.length(); i++) {
			char ch = preString.charAt(i);
			
			if(!codeTable.containsKey(ch)){	
				codeTable.put(ch, "0");
			} else{
				String code = codeTable.get(ch);
				codeTable.remove(ch);
				codeTable.put(ch, code + "0");
			}
		}
	}
}
