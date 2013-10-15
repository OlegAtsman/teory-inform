package com.univer.teory.file;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.univer.teory.utils.MapConverter;

public class CompressedSourceParcer {
	
	private String source;
	
	private Gson gson = new Gson();
	
	private int endOfCodeTable;
	
	public CompressedSourceParcer(String source) {
		this.source = source;
	}
	
	public Map<String, String> getCodeMap() {
		endOfCodeTable = source.indexOf('}');
		String codeTable = source.substring(0, endOfCodeTable + 1);
		Map<String, String> codeMap = gson.fromJson(codeTable, HashMap.class);
		codeMap = MapConverter.convertCodeTableToStrStr(codeMap);
		codeMap = MapConverter.revertMap(codeMap);
		return codeMap;
	}
	
	public String getCompressedSource() {
		String compressedSource = source.substring(endOfCodeTable + 1, source.length() - 1);
		return compressedSource;
	}
	
	public int getLastAddedZeros() {
		String s = source.substring(source.length() - 1, source.length());
		int lastAddedZero = Integer.parseInt(s);
		return lastAddedZero;
	}
		
}
