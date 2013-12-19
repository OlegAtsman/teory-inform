package by.grsu.esystem

import by.grsu.esystem.encryptors.RSAEncryptor
import by.grsu.esystem.file.PEMFile
import java.security.KeyPair

def PUBLIC_KEY_FILE = "public_key_file.pem"
def PRIVATE_KEY_FILE = "private_key_file.pem"

def publicKey = new PEMFile(PUBLIC_KEY_FILE).withReader { reader ->
	reader.readObject()
}

def KeyPair keyPair = new PEMFile(PRIVATE_KEY_FILE).withReader { reader ->
	reader.readObject()
}

def encryptor = new RSAEncryptor()

def byte[] encryptMessage = encryptor.encrypt("HELLO WORLD RSA ALGORITHM", publicKey)

def decryptMessage = encryptor.decrypt(encryptMessage, keyPair.getPrivate())

print decryptMessage
