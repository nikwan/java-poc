package com.java.poc.j8.encdec.main;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Hex;

public class EncDecTest {
	
	private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		
		   //Creating a Signature object
	      Signature sign = Signature.getInstance("SHA256withRSA");
	      
	      //Creating KeyPair generator object
	      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	      
	      //Initializing the key pair generator
	      keyPairGen.initialize(2048);
	      
	      //Generate the pair of keys
	      KeyPair pair = keyPairGen.generateKeyPair();   
	      
	      //Getting the public key from the key pair
	      PublicKey publicKey = pair.getPublic();
	      
	      System.out.println("publicKey:" + new String (Hex.encode(publicKey.getEncoded())));

	      //Creating a Cipher object
	      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	      
	      String key = "30820122300d06092a864886f70d01010105000382010f003082010a0282010100856c965260cf8a8567139809933407b43b6dfd4ce381f39d4cd4f6ae268ad387aabeadb1aa0c7ab7633e1498bddd696c65ab79011f4698ea0f5db7f9bfe127c06a0e0877d62897949540d40c817f07f61d132487fd1c3dbdeca14462a416df23dffb4acc3c5d511061b11fa812214d016d8affc749bd3d59ccc2aaa50d78b51bebe9eb3c70ea99b2755a3973e1775e30643bc009484401dc775a3da0a292f1ae0a1524e6d3fcb81ed0ad52fc8c57f8ac35e92abba80089edd63dd9928e3de111d3bd459acb2686f78d3a3b6d4f7068555bb30d6b265ae07020e760974e31a6030eceb9f3e551e13287d823ab6fae93c8fe8bd53ef2c82634626560b83de23dd50203010001";
	      
	      Key secretKey = new SecretKeySpec(Hex.decode(key.getBytes()), "RSA/ECB/PKCS1Padding");
          Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
          c.init(Cipher.DECRYPT_MODE, secretKey);

	      //Initializing a Cipher object
	      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		  
	      //Add data to the cipher
	      byte[] input = "Welcome to Tutorialspoint".getBytes();	  
	      cipher.update(input);
		  
	      //encrypting the data
	      byte[] cipherText = cipher.doFinal();	 
	      System.out.println( new String(cipherText, "UTF8"));

	      //Initializing the same cipher for decryption
	      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
	      
	      //Decrypting the text
	      byte[] decipheredText = cipher.doFinal(cipherText);
	      System.out.println(new String(decipheredText));
		
	}

}
