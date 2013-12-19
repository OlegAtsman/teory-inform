package by.grsu.esystem

import by.grsu.esystem.rsa.file.PEMFile
import java.security.Key
import java.security.KeyPair
import java.security.KeyPairGenerator

/*def KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA")
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
}*/

def a = 0..3
println a.size()