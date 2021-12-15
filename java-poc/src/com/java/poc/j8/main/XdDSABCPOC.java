package com.java.poc.j8.main;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;
import java.util.Base64;

import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import net.i2p.crypto.eddsa.EdDSAEngine;
import net.i2p.crypto.eddsa.EdDSASecurityProvider;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;

public class XdDSABCPOC {

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
	        
			
			//EdDSAParameterSpec spec = EdDSANamedCurveTable.getByName(EdDSANamedCurveTable.ED_25519);
			// example: generate a key pair and sign
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("ED25519", "BC");
			KeyPair kp = kpg.generateKeyPair();
			
			Ed25519PrivateKeyParameters privateKey = new Ed25519PrivateKeyParameters(
		           kp.getPrivate().getEncoded(), 0);
		        Ed25519PublicKeyParameters publicKey = new Ed25519PublicKeyParameters(
		            kp.getPublic().getEncoded(), 0);
			
			
			//System.out.println("provider:" + sig.getProvider().getName());
			//System.out.println("algorithm:" + sig.getAlgorithm());
		        
		        byte[] m = msg.getBytes(); 
		        
		        Blake2bDigest b = new Blake2bDigest(512);
				b.update(m, 0, m.length);
				byte[] hash = new byte[b.getDigestSize()];
	        	b.doFinal(hash, 0);
	        	
	        	System.out.println("Blake2bDigest:\n" + "BLAKE-512=" + Base64.getEncoder().encodeToString(hash));
	        
	        	Signature sig = Signature.getInstance("EdDSA", "BC");
			sig.initSign(kp.getPrivate());
			sig.update(hash);
			byte[] s1 = sig.sign();
			 			
			System.out.println("===signature_success_private===\n" + Base64.getEncoder().encodeToString(s1));
			
			//////////////////////////////////////////////
			//second signing
			
			Blake2bDigest b1 = new Blake2bDigest(512);
			b1.update(m, 0, m.length);
			byte[] hash1 = new byte[b1.getDigestSize()];
        	b1.doFinal(hash1, 0);
			
			Ed25519PrivateKeyParameters p = new Ed25519PrivateKeyParameters(
		            kp.getPublic().getEncoded(), 0);
			Signer signer = new Ed25519Signer();
			 signer.init(true, p);
	        signer.update(hash1, 0, hash1.length);
			byte[] spb = signer.generateSignature();
			
			System.out.println("\n****************************\n");
			
			System.out.println("Blake2bDigest:\n" + "BLAKE-512=" + Base64.getEncoder().encodeToString(hash1)); 
			System.out.println("===signature22222222222222_success_public===\n" + Base64.getEncoder().encodeToString(spb));
			
			System.out.println("==performing verification==");
			Signature sv = Signature.getInstance("ED25519", "BC");
			
			sv.initVerify(kp.getPublic());
			sv.update(hash);
			
			boolean v = sv.verify(s1);
			
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
