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

import net.i2p.crypto.eddsa.EdDSAEngine;
import net.i2p.crypto.eddsa.EdDSASecurityProvider;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = new String[3];
		s[0] = "BCA";
		s[1] = "CCA";
		s[2] = "ABC";
		
		Arrays.sort(s);
		
		System.out.println(s[2]);
		//https://openjdk.java.net/jeps/339
		
		try {
			Security.addProvider(new EdDSASecurityProvider());
			
			EdDSAParameterSpec spec = EdDSANamedCurveTable.getByName(EdDSANamedCurveTable.ED_25519);
			// example: generate a key pair and sign
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("EdDSA");
			KeyPair kp = kpg.generateKeyPair();
			
			System.out.println(spec.getHashAlgorithm());
			
			Signature sig = new EdDSAEngine(MessageDigest.getInstance(spec.getHashAlgorithm()));
			
			// algorithm is pure Ed25519
			//sig = Signature.getInstance("NONEwithEdDSA");
			
			//System.out.println("provider:" + sig.getProvider().getName());
			System.out.println("algorithm:" + sig.getAlgorithm());
			
			sig.initSign(kp.getPrivate());
			sig.update("test".getBytes());
			byte[] s1 = sig.sign();
			
			System.out.println("===signature_success===\n" + Base64.getEncoder().encodeToString(s1));
			
			Signature sv = new EdDSAEngine(MessageDigest.getInstance(spec.getHashAlgorithm()));
			
			sv.initVerify(kp.getPublic());
			sv.update("test".getBytes());
			
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
