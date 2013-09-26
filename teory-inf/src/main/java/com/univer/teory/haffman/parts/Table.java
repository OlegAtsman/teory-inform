package com.univer.teory.haffman.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *	Table, class work with source text. 
 *	Build frequency table, probability list and etc.
 */
public class Table {

	private Map<Character, Integer> freqTable = new HashMap<Character, Integer>();
	
	private List<Node> probList = new ArrayList<Node>();

	public Table(String source) {
		buildFreqTable(source);
		buildProbList(source);
	}
	
	private Map<Character, Integer> buildFreqTable(String source) {
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

	/**
	 * Builds probability list of @see Node.
	 * After build, method sort list.
	 * @param source
	 * @return
	 */
	private List<Node> buildProbList(String source) {
		Iterator<Entry<Character, Integer>> it = freqTable.entrySet().iterator();
		while (it.hasNext()) {
			Entry current = it.next();
			Character ch = (Character) current.getKey();
			Integer freq = (Integer) current.getValue();

			Double prob = freq.doubleValue() / source.length();

			probList.add(new Node(ch.toString(), freq, prob));
		}
		sortProbList();
		return probList;
	}
	
	public void sortProbList() {
		if(probList!=null) {
			Collections.sort(probList);
		}else {
			System.out.println("Table, probList is null");
		}
	}
	
	/* GETERS AND SETTERS */

	public Map<Character, Integer> getFreqTable() {
		return freqTable;
	}

	public List<Node> getProbList() {
		return probList;
	}

	public void setFreqTable(Map<Character, Integer> freqTable) {
		this.freqTable = freqTable;
	}
	
	public void setProbList(List<Node> probList) {
		this.probList = probList;
	}

	
}
