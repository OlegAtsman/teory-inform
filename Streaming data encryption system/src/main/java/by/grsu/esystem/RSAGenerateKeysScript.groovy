package by.grsu.esystem

import by.grsu.esystem.file.PEMFile
import java.security.Key
import java.security.KeyPair
import java.security.KeyPairGenerator

import org.bouncycastle.openssl.PEMWriter
import org.bouncycastle.util.io.pem.PemWriter

def KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA")
def KeyPair kp = kpg.generateKeyPair()
def Key publicKey = kp.getPublic()
def Key privateKey = kp.getPrivate()

def PUBLIC_KEY_FILE = "public_key_file.pem"
def PRIVATE_KEY_FILE = "private_key_file.pem"

new PEMFile(PUBLIC_KEY_FILE).withWriter { writer ->
	writer.writeObject(publicKey)
}

new PEMFile(PRIVATE_KEY_FILE).withWriter { writer ->
	writer.writeObject(privateKey)
}

