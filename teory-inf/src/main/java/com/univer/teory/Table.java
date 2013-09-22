package com.univer.teory;

import java.util.HashMap;
import java.util.Map;

public class Table {
	
	private Map<Character, Integer> table = new HashMap<Character, Integer>();

	public Table(String source) {
		
		for(char ch : source.toCharArray()) {
			if(!table.containsKey(ch)) {
				table.put(ch, 1);
			}else {
				Integer fq = table.get(ch);
				table.remove(ch);
				table.put(ch, fq + 1);
			}		table.
		}
	}
}
