package by.grsu.esystem.rsa.test

import by.grsu.esystem.encryptors.RSAEncryptor


class RSAEncryptorTest extends EncryptorTest {
	
	def getEncryptor() {
		return new RSAEncryptor();
	}
	
}
