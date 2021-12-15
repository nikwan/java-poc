package com.java.poc.j8.main;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.util.encoders.Hex;

public class DigestTest {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, DigestException {
		
		String st = "{\"hello\": \"world\"}";
		
		byte[] m = st.getBytes();
		
		System.out.println("len:" + m.length);
		
		Blake2bDigest b1 = new Blake2bDigest(512);
		System.out.println(b1.getDigestSize());
		byte[] resBuf = new byte[b1.getDigestSize()];
		b1.update(m, 0, m.length);
		b1.doFinal(resBuf, 0);
		
		System.out.println("Blake2bDigest:\n" + "BLAKE-512=" + Base64.getEncoder().encodeToString(resBuf));
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		//byte[] hash = new byte[32];
		
		
		//md.update(hash);
		//3UbD7rsYhP87UljAovyTmOVgop4HgNS1OGm2JUqkapY=
		byte[] hash = md.digest(m);
		
		System.out.println("===signature_success_private===\n" + new String(Hex.encode(hash)));
		System.out.println("sha256_digest:\n" + "Digest: SHA-256=" + Base64.getEncoder().encodeToString(hash));
	}
	
	

}
