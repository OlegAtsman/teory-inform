package com.univer.teory;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.univer.teory.file.CompressedSourceParcer;
import com.univer.teory.haffman.Compressor;
import com.univer.teory.haffman.Haffman;
import com.univer.teory.haffman.parts.Node;
import com.univer.teory.haffman.parts.Table;
import com.univer.teory.utils.MapConverter;

public class HaffmanService {

	private Haffman haffman = new Haffman();

	private Compressor compressor = new Compressor();

	private Gson gson = new Gson();

	public String compress(String source) {
		Table table = new Table();

		List<Node> probList = table.buildProbList(source);
		for(Node node: probList) {
			System.out.println(node.getSymbol() + ":" + node.getProb() + ":" + node.getFreq());
		}
		Map<Character, String> codeTable = haffman.buildCodeTable(probList);
		String code = compressor.compress(source, codeTable);
		StringBuilder sb = new StringBuilder();
		sb.append(gson.toJson(MapConverter.convertCodeTableToIntStr(codeTable)));
		sb.append(code);
		return sb.toString();
	}

	public String decompress(String source) {
		CompressedSourceParcer compressedSourceMeta = new CompressedSourceParcer(source);
		Map<String, String> codeMap = compressedSourceMeta.getCodeMap();
		String compressedSource = compressedSourceMeta.getCompressedSource();
		int lastAddedZero = compressedSourceMeta.getLastAddedZeros();
		
		String decompressedSource = compressor.decompress(compressedSource, codeMap, lastAddedZero);
		
		return decompressedSource;
	}
}
