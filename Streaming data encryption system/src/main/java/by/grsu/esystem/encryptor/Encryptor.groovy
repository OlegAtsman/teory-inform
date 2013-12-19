package by.grsu.esystem.encryptor

import by.grsu.esystem.encryptor.generator.Generator
import by.grsu.esystem.encryptor.generator.impl.LKM;
import java.nio.ByteBuffer

class Encryptor {
	
	def generator = new LKM();
	
	def encrypt(String message, Integer randomSequence) {
		def messageBytes = message.getBytes()
		xor(messageBytes, intToByteArray(randomSequence))
	}
	
	def String decrypt(ciphertext, Integer randomSequence) {		
		def encryptBytes = xor(ciphertext, intToByteArray(randomSequence))
		new String(encryptBytes as byte[])
	}
	
	def xor (message, gamma) {
		def xoredElements = []
		def gammaNumber = 0
		message.each { e -> 
			def encryptedByte = e^gamma[gammaNumber]
			xoredElements.add(encryptedByte)
			if(gammaNumber == 3) {gammaNumber = 0} else {gammaNumber += 1}
		}
		xoredElements
	}
	
	def intToByteArray(Integer x) {
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(x);
		b.array();
	}
	
}
