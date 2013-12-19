package by.grsu.esystem.rsa.test

import java.security.Key
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import by.grsu.esystem.file.PEMFile

abstract class EncryptorTest {
	
	def encryptor;
	def KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	
	@Before
	void before() {
		encryptor = getEncryptor();
	}
	
	@Test
	void test() {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA")
		KeyPair kp = kpg.generateKeyPair()
		Key publicKey = kp.getPublic()
		Key privateKey = kp.getPrivate()
		
		def message = "HELLO WORLD RSA!!!";
				
		def ciphertext = getEncryptor().encrypt(message, publicKey)
		def decryptMessage = getEncryptor().decrypt(ciphertext, privateKey)
		
		Assert.assertEquals(message, decryptMessage)
	}
	
	@Test
	void testFileKeys() {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA")
		KeyPair kp = kpg.generateKeyPair()
		Key publicKey = kp.getPublic()
		Key privateKey = kp.getPrivate()
		
		
		new PEMFile("publicKey.pem").withWriter { pemWriter ->
			pemWriter.writeObject(publicKey)
		}
		
		new PEMFile("privateKey.pem").withWriter { pemWriter ->
			pemWriter.writeObject(privateKey)
		}
	
		def message = "HELLO WORLD RSA!!!";
		def ciphertext = getEncryptor().encrypt(message, publicKey)
		
		def KeyPair privateKeyFromFile = new PEMFile("privateKey.pem").withReader { pemReader ->
			pemReader.readObject()
		}
		
		def decryptMessage = getEncryptor().decrypt(ciphertext, privateKeyFromFile.getPrivate())
		Assert.assertEquals(message, decryptMessage)
	}
	
	abstract getEncryptor();
}
