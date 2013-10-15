package com.univer.teory.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapConverter {
	
	public static Map<String, String> revertMap(Map<String, String> codeMap) {
		Map<String, String> revertMap = new HashMap<String, String>();
		for(Entry<String, String> entry: codeMap.entrySet()) {
			revertMap.put(entry.getValue(), entry.getKey());			
		}
		return revertMap;
	}
	
	public static Map<Integer, String> convertCodeTableToIntStr(Map<Character, String> codeTableCharInt) {
		Map<Integer, String> codeTableIntStr = new HashMap<Integer, String>();
		for (Entry<Character, String> entry : codeTableCharInt.entrySet()) {
			codeTableIntStr.put((int) entry.getKey().charValue(), entry.getValue());
		}
		return codeTableIntStr;
	}

	public static Map<String, String> convertCodeTableToStrStr(Map<String, String> codeTableIntStr) {
		Map<String, String> codeTableStrStr = new HashMap<String, String>();
		for (Entry<String, String> entry : codeTableIntStr.entrySet()) {
			int charIntCode = Integer.parseInt(entry.getKey());
			char ch = (char) charIntCode;
			codeTableStrStr.put(Character.toString(ch), entry.getValue());
		}
		return codeTableStrStr;
	}
}
