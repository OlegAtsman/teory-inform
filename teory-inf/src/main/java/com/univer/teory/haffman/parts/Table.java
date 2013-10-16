package com.univer.teory.haffman.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *	Table, class work with source text. 
 *	Build frequency table, probability list and etc.
 */
public class Table {

	/**
	 * Builds probability list of @see Node.
	 * After build, method sort list.
	 * @param source
	 * @return
	 */
	public List<Node> buildProbList(String source) {
		List<Node> probList = new ArrayList<Node>();
		Map<Character, Integer> freqTable = buildFreqTable(source);
		for(Entry<Character, Integer> entry: freqTable.entrySet()) {
			Character ch = (Character) entry.getKey();
			Integer freq = (Integer) entry.getValue();
			Double prob = freq.doubleValue() / source.length();

			probList.add(new Node(ch.toString(), freq, prob));
		}

		Collections.sort(probList);
		return probList;
	}
	
	private Map<Character, Integer> buildFreqTable(String source) {
		Map<Character, Integer> freqTable = new HashMap<Character, Integer>();
		for (char ch : source.toCharArray()) {
			if (!freqTable.containsKey(ch)) {
				freqTable.put(ch, 1);
			} else {
				Integer fq = freqTable.get(ch);
				freqTable.remove(ch);
				freqTable.put(ch, fq + 1);
			}
		}
		return freqTable;
	}
}
