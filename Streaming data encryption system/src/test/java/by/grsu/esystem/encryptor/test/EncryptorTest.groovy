package by.grsu.esystem.encryptor.test

import org.junit.Assert;
import org.junit.Test

import by.grsu.esystem.encryptor.Encryptor

class EncryptorTest {
	
	@Test
	void test() {
		
		Encryptor encryptor = new Encryptor()
		
		def message = "HELLO WORLD ENCRYPTOR"
		
		def encryptedMessage = encryptor.encrypt(message, Integer.MAX_VALUE)
		
		def decryptedMessage = encryptor.decrypt(encryptedMessage, Integer.MAX_VALUE)
		
		Assert.assertEquals(message, decryptedMessage)
	}
	
}
