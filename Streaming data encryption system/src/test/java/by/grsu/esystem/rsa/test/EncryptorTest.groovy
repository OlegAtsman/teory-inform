package by.grsu.esystem.rsa.test

import java.security.Key
import java.security.KeyFactory;
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.spec.EncodedKeySpec
import java.security.spec.PKCS8EncodedKeySpec

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import by.grsu.esystem.file.FileWorker
import by.grsu.esystem.file.PEMFileWorker;
import by.grsu.esystem.rsa.IEncryptor

abstract class EncryptorTest {
	
	def IEncryptor encryptor;
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
		
		PEMFileWorker pfw = new PEMFileWorker();
		pfw.write("publicKey.pem", publicKey)
		pfw.write("privateKey.pem", privateKey)
				
		def message = "HELLO WORLD RSA!!!";
		def ciphertext = getEncryptor().encrypt(message, publicKey)
		
		def KeyPair privateKeyFromFile = pfw.read("privateKey.pem")
		
		def decryptMessage = getEncryptor().decrypt(ciphertext, privateKeyFromFile.getPrivate())
		Assert.assertEquals(message, decryptMessage)
	}
	
	abstract IEncryptor getEncryptor();
}
