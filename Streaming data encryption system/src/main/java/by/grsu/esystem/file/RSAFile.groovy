package by.grsu.esystem.file

import by.grsu.esystem.encryptors.RSAEncryptor

import java.security.PrivateKey
import java.security.PublicKey

class RSAFile {
	
	def RSAEncryptor rsaEncryptor = new RSAEncryptor()	
	
	def String filename
	
	def RSAFile(String filename) {
		this.filename = filename
	}
	
	def read(PrivateKey privateKey) {
		
		byte[] lkmBytes = new File(filename).readBytes()
		
		def lkmString = rsaEncryptor.decrypt(lkmBytes, privateKey)
		
		lkmString
		/*def params = lkmString.tokenize()
		
		params.each { e ->
			e = Integer.parseInt(e)
		}
		
		['x':params[0], 'm':params[1], 'a':params[2], 'c':params[3]]*/		
	}
	
	def write(String message, PublicKey publicKey) {
		def byte[] encryptedMessage = rsaEncryptor.encrypt(message, publicKey)
		new File(filename).withOutputStream { os ->
			os.write(encryptedMessage)
		}
	}
}
