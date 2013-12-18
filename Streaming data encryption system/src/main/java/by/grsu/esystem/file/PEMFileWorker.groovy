package by.grsu.esystem.file

import java.security.Key
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.util.io.pem.PemWriter;

class PEMFileWorker {

	static {
		// adds the Bouncy castle provider to java security
		Security.addProvider(new BouncyCastleProvider());
	}
	
	def write (String filename, Key key) {
		new File(filename).withWriter { wr -> 		
			PEMWriter p = new PEMWriter(wr)
			p.writeObject(key)
			p.close()
		}
	}
	
	def read (String filename) {		
		new File(filename).withReader { reader -> 
			PEMReader p = new PEMReader(reader)
			def key = p.readObject()
			p.close()
			
			key
		}
	}
	
}
