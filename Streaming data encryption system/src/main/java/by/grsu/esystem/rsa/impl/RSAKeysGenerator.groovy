package by.grsu.esystem.rsa.impl

import java.security.Key
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PublicKey

class RSAKeysGenerator {
	
	def KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA")
	
	def initialize(n) {
		kpg.initialize(n)
	}
	
	def generate() {
		KeyPair kp = kpg.generateKeyPair()
		Key publicKey = kp.getPublic()
		Key privateKey = kp.getPrivate()
	}	
	
}
