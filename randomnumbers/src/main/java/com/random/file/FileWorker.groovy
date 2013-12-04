package com.random.file

import java.nio.ByteBuffer

import com.random.randoms.Random

class FileWorker {
	
	def generateAndWriteToFile(Random random, fname, n) {
		new File(fname).withOutputStream { os ->
			for (i in 0..n) {
				int x = random.random();
				os << ByteBuffer.allocate(4).putInt(x).array();
			}
			
		}
	}
}
