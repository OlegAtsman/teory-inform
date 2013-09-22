package com.univer.teory;


public class Node implements Comparable<Node> {
	
	private char symbol;
	private int freq;
	private Node left;
	private Node right;
	
	public Node(char symbol, int freq, Node left, Node right) {
		super();
		this.symbol = symbol;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeaf() {
		return (left == null && right == null);
	}

	public int compareTo(Node that) {
		return this.freq = that.freq;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
