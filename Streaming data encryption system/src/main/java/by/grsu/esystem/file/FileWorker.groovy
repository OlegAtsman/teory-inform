package by.grsu.esystem.file

import java.security.Key
import java.security.KeyFactory
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.EncodedKeySpec
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec

import org.bouncycastle.openssl.PEMWriter;

class FileWorker {

	def static final String BEGIN_PUBLIC_KEY = "----BEGIN SERTI----\n"
	def static final String END_PUBLIC_KEY = "\n----END PUBLIC KEY----"
	def static final String BEGIN_PRIVATE_KEY = "----BEGIN PRIVATE KEY----\n"
	def static final String END_PRIVATE_KEY = "\n----END PRIVATE KEY----"
	
	def KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	
	def savePublicKey(String fileName, Key key) {
		saveKey(fileName, key, BEGIN_PUBLIC_KEY, END_PUBLIC_KEY)
	}

	def savePrivateKey(String fileName, Key key) {
		saveKey(fileName, key, BEGIN_PRIVATE_KEY, END_PRIVATE_KEY)
	}
	
	def readPublicKey(String fileName) {
		def publicKeyBytes = readKey(fileName, BEGIN_PUBLIC_KEY, END_PUBLIC_KEY)
		EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
		PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
	}
	
	def readPrivateKey(String fileName) {
		def privateKeyBytes = readKey(fileName, BEGIN_PRIVATE_KEY, END_PRIVATE_KEY)
		EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
		
	}
	
	def byte[] readKey(String fileName, String begin, String end) {
		byte[] key;
		new File(fileName).withInputStream { is ->
			key = is.getBytes()
		}
		def from = begin.getBytes().size()
		def to = key.size()-end.getBytes().size()
		key = key[from..to]
		key
	}
	
	def saveKey(String fileName, Key key, String begin, String end) {
		
		new File(fileName).withOutputStream  { os ->
			os << begin.getBytes()
			os << key.getEncoded()
			os << end.getBytes()
		}
	}
}
