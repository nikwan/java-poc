package com.java.poc.j8.main;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;
import java.util.Base64;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.generators.Ed25519KeyPairGenerator;
import org.bouncycastle.crypto.params.Ed25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import net.i2p.crypto.eddsa.EdDSAEngine;
import net.i2p.crypto.eddsa.EdDSASecurityProvider;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;

public class EdDSAPOCSymKeyOpenSSL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = new String[3];
		s[0] = "BCA";
		s[1] = "CCA";
		s[2] = "ABC";
		
		Arrays.sort(s);
		
		System.out.println(s[2]);
		//https://openjdk.java.net/jeps/339
		
		String msg = "test";
		
		try {
			//Security.addProvider(new EdDSASecurityProvider());
			
			Security.addProvider(new BouncyCastleProvider());
	        //Signature sig = Signature.getInstance("EdDSA", "BC");
			
			//EdDSAParameterSpec spec = EdDSANamedCurveTable.getByName(EdDSANamedCurveTable.ED_25519);
			// example: generate a key pair and sign
	        
			SecureRandom RANDOM = new SecureRandom();
	        Ed25519KeyPairGenerator keyPairGenerator = new Ed25519KeyPairGenerator();
	        keyPairGenerator.init(new Ed25519KeyGenerationParameters(RANDOM));
	        AsymmetricCipherKeyPair asymmetricCipherKeyPair = keyPairGenerator.generateKeyPair();
	        //Ed25519PrivateKeyParameters privateKey1 = (Ed25519PrivateKeyParameters) asymmetricCipherKeyPair.getPrivate();
	        //Ed25519PublicKeyParameters publicKey1 = (Ed25519PublicKeyParameters) asymmetricCipherKeyPair.getPublic();
	        
	        
			
			Ed25519PrivateKeyParameters privateKey = new Ed25519PrivateKeyParameters(
		            Base64.getDecoder().decode("MC4CAQAwBQYDK2VwBCIEIDHOUV25UE/fP3oeC4baT85JD9q2fYCMvOkBACYmBPBv"), 0);
		        Ed25519PublicKeyParameters publicKey = new Ed25519PublicKeyParameters(
		            Base64.getDecoder().decode("MCowBQYDK2VwAyEAc/DvDaSFRIMPo9JSof66pneScfXMxktYRW9YQDq1Q6Y="), 0);
			//j5iwJkIn9h8Ja3jd47DwDRkB7P4QUF5BRzkGkHpSNWvpUxrXbU0B2wdDTUiTXvVR3lBULDNm0/t1DY8GBoxfCA==
		        
		        System.out.println("hex_pr_k:" + new String (Hex.encode(privateKey.getEncoded())));
		        System.out.println("hex_pub_k:" + new String (Hex.encode(publicKey.getEncoded())));
			
			//System.out.println("provider:" + sig.getProvider().getName());
			
			
			Signer sig = new Ed25519Signer();
	        sig.init(true, privateKey);
	        sig.update(msg.getBytes(), 0, msg.length());
	        
	        
	        byte[] s1 = sig.generateSignature();
			
			//sig.initSign(privateKey1);
			//sig.update("test".getBytes());
			//byte[] s1 = sig.sign();
			
			System.out.println("===signature_success===\n" + Base64.getEncoder().encodeToString(s1));
			
			System.out.println("==performing verification==");
			Signer sv = new Ed25519Signer();
			
			sv.init(false, publicKey);
	        sv.update(msg.getBytes(), 0, msg.length());
	        
			
			boolean v = sv.verifySignature(s1);
			
			System.out.println("sign verification:" + v);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// example: use KeyFactory to contruct a public key
		/*
		 * KeyFactory kf = KeyFactory.getInstance("EdDSA"); //boolean xOdd = ...
		 * //BigInteger y = ... NamedParameterSpec paramSpec = new
		 * NamedParameterSpec("Ed25519"); EdECPublicKeySpec pubSpec = new
		 * EdECPublicKeySpec(paramSpec, new EdPoint(xOdd, y)); PublicKey pubKey =
		 * kf.generatePublic(pubSpec);
		 */
	}

}
