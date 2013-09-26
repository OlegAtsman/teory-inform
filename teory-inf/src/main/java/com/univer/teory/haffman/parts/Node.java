package com.univer.teory.haffman.parts;

/**
 * Node - created for all characters in source file.
 * It contains character, probability, frequency.
 */
public class Node implements Comparable<Node> {
	
	private String symbol;
	private int freq;
	private double prob;
	
	public Node(String symbol, int freq, double prob) {
		super();
		this.symbol = symbol;
		this.freq = freq;
		this.prob = prob;
	}
	
	public int getFreq() {
		return freq;
	}
	
	public double getProb() {
		return prob;
	}

	public int compareTo(Node that) {
		return that.freq - this.freq;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
