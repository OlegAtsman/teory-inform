package by.grsu.esystem.rsa.encryptor.impl

import by.grsu.esystem.rsa.encryptor.IEncryptor
import java.security.PrivateKey
import java.security.PublicKey

import javax.crypto.Cipher

class RSAEncryptor implements IEncryptor {
	
	def static ALGORITHM = "RSA"
	
	def byte[] encrypt(String text, PublicKey key) {
	  def byte[] cipherText
	  try {
		final Cipher cipher = Cipher.getInstance(ALGORITHM)
		cipher.init(Cipher.ENCRYPT_MODE, key)
		cipherText = cipher.doFinal(text.getBytes())
	  } catch (Exception e) {
		e.printStackTrace()
	  }
	  cipherText
	}
	
	def String decrypt(byte[] text, PrivateKey key) {
	  def byte[] dectyptedText
	  try {
		final Cipher cipher = Cipher.getInstance(ALGORITHM)
		cipher.init(Cipher.DECRYPT_MODE, key)
		dectyptedText = cipher.doFinal(text)
  
	  } catch (Exception ex) {
		ex.printStackTrace()
	  }
	  new String(dectyptedText)
	}
	
}
