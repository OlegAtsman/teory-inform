package com.univer.teory;


public class Node implements Comparable<Node> {
	
	private char symbol;
	private int freq;
	private double prob;
	
	public Node(char symbol, int freq, double prob) {
		super();
		this.symbol = symbol;
		this.freq = freq;
		this.prob = prob;
	}
	
	public double getProb() {
		return prob;
	}

	public int compareTo(Node that) {
		return that.freq - this.freq;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
