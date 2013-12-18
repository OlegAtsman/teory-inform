package by.grsu.esystem.rsa.impl

import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher

import by.grsu.esystem.rsa.IEncryptor;

class RSAEncryptor implements IEncryptor {
	
	/**
	 * String to hold name of the encryption algorithm.
	 */
	def static ALGORITHM = "RSA"
	
	/**
	 * Encrypt the plain text using public key.
	 *
	 * @param text
	 *          : original plain text
	 * @param key
	 *          :The public key
	 * @return Encrypted text
	 * @throws java.lang.Exception
	 */
	def byte[] encrypt(String text, PublicKey key) {
	  byte[] cipherText = null;
	  try {
		// get an RSA cipher object and print the provider
		final Cipher cipher = Cipher.getInstance(ALGORITHM);
		// encrypt the plain text using the public key
		cipher.init(Cipher.ENCRYPT_MODE, key);
		cipherText = cipher.doFinal(text.getBytes());
	  } catch (Exception e) {
		e.printStackTrace();
	  }
	  return cipherText;
	}
	
	/**
	 * Decrypt text using private key.
	 *
	 * @param text
	 *          :encrypted text
	 * @param key
	 *          :The private key
	 * @return plain text
	 * @throws java.lang.Exception
	 */
	def String decrypt(byte[] text, PrivateKey key) {
	  byte[] dectyptedText = null;
	  try {
		// get an RSA cipher object and print the provider
		final Cipher cipher = Cipher.getInstance(ALGORITHM);
  
		// decrypt the text using the private key
		cipher.init(Cipher.DECRYPT_MODE, key);
		dectyptedText = cipher.doFinal(text);
  
	  } catch (Exception ex) {
		ex.printStackTrace();
	  }
  
	  return new String(dectyptedText);
	}
	
}
