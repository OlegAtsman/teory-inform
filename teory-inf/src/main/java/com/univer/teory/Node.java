package com.univer.teory;


public class Node implements Comparable<Node> {
	
	private char symbol;
	private int freq;
	
	public Node(char symbol, int freq) {
		super();
		this.symbol = symbol;
		this.freq = freq;
	}

	public int compareTo(Node that) {
		return this.freq = that.freq;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
