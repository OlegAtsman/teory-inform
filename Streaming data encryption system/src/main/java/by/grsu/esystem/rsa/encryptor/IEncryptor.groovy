package by.grsu.esystem.rsa.encryptor

import java.security.PrivateKey;
import java.security.PublicKey;

interface IEncryptor {
	
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
	def byte[] encrypt(String text, PublicKey key)
	
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
	def String decrypt(byte[] text, PrivateKey key)
	
}
