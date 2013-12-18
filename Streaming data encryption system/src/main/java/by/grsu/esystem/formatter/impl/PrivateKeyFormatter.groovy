package by.grsu.esystem.formatter.impl

import org.bouncycastle.openssl.PEMWriter;

import by.grsu.esystem.formatter.Formatter
import sun.security.provider.*

class PrivateKeyFormatter implements Formatter {
	
	@Override
	def format(byte[] key) {
		X509Factory.BEGIN_CERT
		PEMWriter pemWriter = new PEMWriter(out)
	}
	
}
