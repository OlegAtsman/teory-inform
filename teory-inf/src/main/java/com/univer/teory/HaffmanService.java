package com.univer.teory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.univer.teory.haffman.Compressor;
import com.univer.teory.haffman.Haffman;
import com.univer.teory.haffman.parts.Node;
import com.univer.teory.haffman.parts.Table;

public class HaffmanService {

	private Haffman haffman = new Haffman();

	private Compressor compressor = new Compressor();

	private Gson gson = new Gson();

	public String compress(String source) {
		Table table = new Table();

		List<Node> probList = table.buildProbList(source);
		Map<Character, String> codeTable = haffman.buildCodeTable(probList);

		String code = compressor.compress(source, codeTable);
		StringBuilder sb = new StringBuilder();
		sb.append(gson.toJson(convertCodeTableToIntStr(codeTable)));
		sb.append(code);
		return sb.toString();
	}

	public String decompress(String source) {
		int endOfCodeTable = source.indexOf('}');
		String codeTable = source.substring(0, endOfCodeTable + 1);
		Map<String, String> codeMap = gson.fromJson(codeTable, HashMap.class);
		codeMap = convertCodeTableToStrStr(codeMap);
		codeMap = revertMap(codeMap);
		String compressedSource = source.substring(endOfCodeTable + 1, source.length() - 1);
		String s = source.substring(source.length() - 1, source.length());
		int lastAddedZero = Integer.parseInt(s);
		String decompressedSource = compressor.decompress(compressedSource, codeMap, lastAddedZero);
		
		return decompressedSource;
	}

	private Map<String, String> revertMap(Map<String, String> codeMap) {
		Map<String, String> revertMap = new HashMap<String, String>();
		for(Entry<String, String> entry: codeMap.entrySet()) {
			revertMap.put(entry.getValue(), entry.getKey());			
		}
		return revertMap;
	}
	
	private Map<Integer, String> convertCodeTableToIntStr(Map<Character, String> codeTableCharInt) {
		Map<Integer, String> codeTableIntStr = new HashMap<Integer, String>();
		for (Entry<Character, String> entry : codeTableCharInt.entrySet()) {
			codeTableIntStr.put((int) entry.getKey().charValue(), entry.getValue());
		}
		return codeTableIntStr;
	}

	private Map<String, String> convertCodeTableToStrStr(Map<String, String> codeTableIntStr) {
		Map<String, String> codeTableStrStr = new HashMap<String, String>();
		for (Entry<String, String> entry : codeTableIntStr.entrySet()) {
			int charIntCode = Integer.parseInt(entry.getKey());
			char ch = (char) charIntCode;
			codeTableStrStr.put(Character.toString(ch), entry.getValue());
		}
		return codeTableStrStr;
	}

}
