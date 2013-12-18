package by.grsu.esystem.file

import java.security.Key;

class FileWorker2 {
	
	def byte[] readKey(String fileName, String begin, String end) {
		byte[] key;
		new File(fileName).withInputStream { is ->
			key = is.getBytes()
		}
		def from = begin.getBytes().size()
		def to = key.size()-end.getBytes().size()
		key = key[from..to]
		key
	}
	
	def saveKey(String fileName, Key key, String begin, String end) {
		new File(fileName).withOutputStream  { os ->
			os << begin.getBytes()
			os << key.getEncoded()
			os << end.getBytes()
		}
	}
	
}
