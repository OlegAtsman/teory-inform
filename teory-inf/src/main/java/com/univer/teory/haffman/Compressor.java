package com.univer.teory.haffman;

import java.util.Map;

public class Compressor {
	
	public String compress(String source, Map<Character, String> codeTable) {
		char[] sourceChar = source.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (char ch: sourceChar) {
			stringBuilder.append(codeTable.get(ch));
		}
		
		String sourceBinCode = stringBuilder.toString();
		String compressedSource = eightBit(sourceBinCode);
		
		return compressedSource;
	}
	
	public String decompress(String compressedSource, Map<String, String> codeTable, Integer lastAddedZero) {
		String binCode = bitEight(compressedSource, lastAddedZero);
		System.out.println(binCode);
		
		String buff = "";
		StringBuilder sb = new StringBuilder();
		
		for(Character ch: binCode.toCharArray()) {
			buff += ch.toString();
			if(codeTable.containsKey(buff)) {
				sb.append(codeTable.get(buff));
				buff = "";
			}
		}
		return sb.toString();
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
