package by.grsu.esystem

import java.security.Key
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.spec.RSAPrivateKeySpec
import java.security.spec.RSAPublicKeySpec

import by.grsu.esystem.file.FileWorker

import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.util.io.pem.PemWriter;

def FileWorker fw = new FileWorker();

def KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA")
def KeyPair kp = kpg.generateKeyPair()
def Key publicKey = kp.getPublic()
def Key privateKey = kp.getPrivate()

def encodedPublicKey = publicKey.getEncoded()
def encodedPrivateKey = privateKey.getEncoded()

new File("public.pem").withOutputStream  { os -> 
	os.write("----BEGIN PUBLIC KEY----\n".bytes)
	os.write(encodedPublicKey)
	os.write("\n----END PUBLIC KEY----".bytes)
}


new File("private.pem").withOutputStream  { os ->
	os.write("----BEGIN PRIVATE KEY----\n".bytes)
	os.write(encodedPrivateKey)
	os.write("\n----END PRIVATE KEY----".bytes)
}

PEMWriter pw = new PemWriter();

pw.writeObject(kpg);

