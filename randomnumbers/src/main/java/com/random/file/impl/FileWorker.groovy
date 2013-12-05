package com.random.file.impl

import java.nio.ByteBuffer

import com.random.randoms.Generator

class FileWorker {
	
	def generateAndWriteToFile(Generator random, fname, n) {
		new File(fname).withOutputStream { os ->
			for (i in 0..n) {
				int x = generate.generate();
				println(x);
				os << ByteBuffer.allocate(4).putInt(x).array();
			}
		}
	}
	
	def readInt(filename) {
		def ints = [];
		new File(filename).eachByte(4) { buffer, nReads ->
			def x = new BigInteger(buffer);		
			ints.add(x);
		}
		ints
	}
}
