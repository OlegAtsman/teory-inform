package by.grsu.esystem.rsa.test

import by.grsu.esystem.rsa.IEncryptor;
import by.grsu.esystem.rsa.impl.RSAEncryptor

class RSAEncryptorTest extends EncryptorTest {
	
	def IEncryptor getEncryptor() {
		return new RSAEncryptor();
	}
	
}
