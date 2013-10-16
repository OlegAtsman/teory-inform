package com.univer.teory.haffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Compressor {
	
	public String compress(String source, Map<Character, String> codeTable) {
		char[] sourceChar = source.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (char ch: sourceChar) {
			stringBuilder.append(codeTable.get(ch));
		}
		System.out.println(stringBuilder.toString());
		String code = eightBit(stringBuilder.toString());
		System.out.println(code);
		return code;
	}
	
	public String decompress(String compressedSource, Map<String, String> codeTable, Integer lastAddedZero) {
		String binCode = bitEight(compressedSource, lastAddedZero);
		System.out.println(binCode);
		List<Entry<String, String>> sortedList = new ArrayList<Entry<String, String>>();
		
		for(Entry<String, String> entry: codeTable.entrySet()) {
			sortedList.add(entry);
		}
		
		Comparator<Entry<String, String>> comparator = new Comparator<Entry<String, String>>() {
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o2.getValue().length() - o1.getValue().length();
			}
		};
		
		Collections.sort(sortedList, comparator);
		
		for(Entry<String, String> entry: sortedList) {
			binCode = binCode.replaceAll(entry.getValue(), entry.getKey());
		}
		return binCode;
	}
	
	public String bitEight(String compressedSource, Integer lastAddedZero) {
		StringBuilder sb = new StringBuilder();
		char[] compressedMassive = compressedSource.toCharArray();
		for(char ch: compressedMassive) {
			int decCharCode = (int) ch;
			String binCharCode = Integer.toBinaryString(decCharCode);
			while(binCharCode.length() < 8) {
				binCharCode = Haffman.ZERO + binCharCode;
			}
			sb.append(binCharCode);
		}
		String binCode = sb.toString();
		binCode = binCode.substring(0, binCode.length()-lastAddedZero);
		return binCode;
	}
	
	public String eightBit(String code) {
		StringBuilder sb = new StringBuilder();
		
		int count = 0; //added 0 in the end.
		while (code.length() % 8 != 0) {
			code = code + Haffman.ZERO;
			count++;
		}
		
		String gfx[] = code.split("(?<=\\G.{8})");
		for (String element : gfx) {
			sb.append((char)Integer.parseInt(element, 2));
		}
		System.out.println(sb.toString());
		sb.append(count);//write the last how many 0 we added.
		return sb.toString();
	}
	
}
