package com.univer.teory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.univer.teory.file.FileService;
import com.univer.teory.haffman.Compressor;
import com.univer.teory.haffman.Haffman;
import com.univer.teory.haffman.parts.Node;
import com.univer.teory.haffman.parts.Table;

public class HaffmanService {
	
	private Haffman haffman = new Haffman();
	
	private FileService fileService = new FileService();
	
	private Compressor compressor = new Compressor();
	
	private Gson gson = new Gson();
	
	public void compressFile(String fileName) {
		try {
			
			String source = fileService.readFromFile(fileName);
			
			Table table = new Table();
			List<Node> probList = table.buildProbList(source);
			
			System.out.println("----------------------NODES----------------------");
			for (Node node : probList) {
				System.out.println("Node: " + node.getSymbol() + " " + " prob: " + node.getProb() + " freq: " + node.getFreq());
			}
			System.out.println("------------------ENDS OF NODES----------------------");
						
			Map<Character, String> codeTable = haffman.buildCodeTable(probList);
			System.out.println(codeTable);
			String code = compressor.compress(source, codeTable);
			StringBuilder sb = new StringBuilder();
			sb.append(gson.toJson(convertCodeTableToIntStr(codeTable)));
			sb.append(code);
			
			fileService.writeToFile(fileName+".haffman", sb.toString());
		} catch (IOException e) {
			System.out.println("Wrong filename");
		}
	}
	
	public void decompressFile(String fileName) {
		try {
			String sourceString = fileService.readFromFile(fileName);
			
			int endOfCodeTable = sourceString.indexOf('}');
			String codeTable = sourceString.substring(0, endOfCodeTable + 1);
			Map<String, String> codeMap = gson.fromJson(codeTable, HashMap.class);
			codeMap = convertCodeTableToStrStr(codeMap);
			System.out.println("------------------DECOMPRESS MAP---------------------");
			System.out.println(codeMap);
			System.out.println("------------------ END DECOMPRESS MAP---------------------");
			String compressedSource = sourceString.substring(endOfCodeTable + 1, sourceString.length()-1);
			String s = sourceString.substring(sourceString.length()-1, sourceString.length());
			int lastAddedZero = Integer.parseInt(s);
			
			String decompressedSource = compressor.decompress(compressedSource, codeMap, lastAddedZero);
			System.out.println(decompressedSource);
		} catch (IOException e) {
			System.out.println("Wrong filename");
		}
	}
	
	private Map<Integer, String> convertCodeTableToIntStr(Map<Character, String> codeTableCharInt) {
		Map<Integer, String> codeTableIntStr = new HashMap<Integer, String>();
		for(Entry<Character, String> entry: codeTableCharInt.entrySet()) {
			codeTableIntStr.put((int) entry.getKey().charValue(), entry.getValue());
		}
		return codeTableIntStr;
	}
	
	private Map<String, String> convertCodeTableToStrStr(Map<String, String> codeTableIntStr) {
		Map<String, String> codeTableStrStr = new HashMap<String, String>();
		for(Entry<String, String> entry: codeTableIntStr.entrySet()) {
			int charIntCode = Integer.parseInt(entry.getKey());
			char ch = (char) charIntCode;
			codeTableStrStr.put(Character.toString(ch), entry.getValue());
		}
		return codeTableStrStr;
	}
	
}
