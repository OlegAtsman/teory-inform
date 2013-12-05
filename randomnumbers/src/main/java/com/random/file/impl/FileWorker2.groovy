package com.random.file.impl

import java.nio.ByteBuffer

import com.random.file.FileService;
import com.random.randoms.Generator

class FileWorker2 implements FileService {
	
	def writeInts(filename, ints) {
		new File(filename).withOutputStream { os ->
			for(int i : ints) {
				os << packInt(i)
			}
		}
	}
	
	def readInts(filename) {
		def ints = []
		new File(filename).eachByte(4) { buffer, nReads ->
			ints.add(new BigInteger(buffer) as int)
		}
		ints
	}
	
	def packInt(x) {
		ByteBuffer.allocate(4).putInt(x).array()
	}

}
