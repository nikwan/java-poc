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

import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import net.i2p.crypto.eddsa.EdDSAEngine;
import net.i2p.crypto.eddsa.EdDSASecurityProvider;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;

public class EdDSAPOC {

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
			//Security.addProvider(new EdDSASecurityProvider());
			
			Security.addProvider(new BouncyCastleProvider());
	        Signature sig = Signature.getInstance("EdDSA", "BC");
			
			//EdDSAParameterSpec spec = EdDSANamedCurveTable.getByName(EdDSANamedCurveTable.ED_25519);
			// example: generate a key pair and sign
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("ED25519", "BC");
			KeyPair kp = kpg.generateKeyPair();
			
			Ed25519PrivateKeyParameters privateKey = new Ed25519PrivateKeyParameters(
		            Hex.decode("9d61b19deffd5a60ba844af492ec2cc44449c5697b326919703bac031cae7f60"), 0);
		        Ed25519PublicKeyParameters publicKey = new Ed25519PublicKeyParameters(
		            Hex.decode("d75a980182b10ab7d54bfed3c964073a0ee172f3daa62325af021a68f707511a"), 0);
			
			
			//System.out.println("provider:" + sig.getProvider().getName());
			System.out.println("algorithm:" + sig.getAlgorithm());
			
			sig.initSign(kp.getPrivate());
			sig.update("test".getBytes());
			byte[] s1 = sig.sign();
			
			System.out.println("===signature_success===\n" + Base64.getEncoder().encodeToString(s1));
			
			System.out.println("==performing verification==");
			Signature sv = Signature.getInstance("ED25519", "BC");
			
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
