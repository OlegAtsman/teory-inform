package by.grsu.esystem;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.util.Strings;
import org.bouncycastle.x509.X509V1CertificateGenerator;

public class TEST {

	static {
		// adds the Bouncy castle provider to java security
		Security.addProvider(new BouncyCastleProvider());
	}

	
	public static void main(String[] args) throws Exception {
		TEST t = new TEST();
		t.generateSelfSignedX509Certificate();
	}
	
	/**
	 * Generate a self signed X509 certificate with Bouncy Castle.
	 */
	static void generateSelfSignedX509Certificate() throws Exception {

		// yesterday
		Date validityBeginDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		// in 2 years
		Date validityEndDate = new Date(System.currentTimeMillis() + 2 * 365 * 24 * 60 * 60 * 1000);

		// GENERATE THE PUBLIC/PRIVATE RSA KEY PAIR
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
		keyPairGenerator.initialize(1024, new SecureRandom());

		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// GENERATE THE X509 CERTIFICATE
		X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();
		X500Principal dnName = new X500Principal("CN=John Doe");

		certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
		certGen.setSubjectDN(dnName);
		certGen.setIssuerDN(dnName); // use the same
		certGen.setNotBefore(validityBeginDate);
		certGen.setNotAfter(validityEndDate);
		certGen.setPublicKey(keyPair.getPublic());
		certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

		X509Certificate cert = certGen.generate(keyPair.getPrivate(), "BC");

		// DUMP CERTIFICATE AND KEY PAIR

		System.out.println("CERTIFICATE TO_STRING");
		System.out.println();
		System.out.println(cert);
		System.out.println();

		System.out.println("CERTIFICATE PEM (to store in a cert-johndoe.pem file)");
		System.out.println();
		PEMWriter pemWriter = new PEMWriter(new PrintWriter(System.out));
		pemWriter.writeObject(cert);
		pemWriter.flush();
		System.out.println();

		System.out.println("PRIVATE KEY PEM (to store in a priv-johndoe.pem file)");
		System.out.println();
		pemWriter.writeObject(keyPair.getPrivate());
		pemWriter.flush();
		System.out.println();
	}
}