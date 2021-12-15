package com.java.poc.j7.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
 
/**
 * A utility class that encrypts or decrypts a file.
 * @author www.codejava.net
 *
 */
public class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    
    //private static Logger log = Logger.getLogger(CryptoUtils.class);
 
    public static void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
 
    public static void decrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
    
    //TODO data encrypt
    public static byte[] encrypt(String key, byte[] inputBytes)
            throws CryptoException {
        return doCrypto(Cipher.ENCRYPT_MODE, key, inputBytes);
    }
    
    public static byte[] decrypt(String key, byte[] inputBytes)
            throws CryptoException {
    	return doCrypto(Cipher.DECRYPT_MODE, key, inputBytes);
    }
 
    private static void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
            System.out.println("success");
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
        	System.out.println(ex);
            //throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
    
    private static byte[] doCrypto(int cipherMode, String key, byte[] inputBytes) throws CryptoException {
    	System.out.println("@@inside doCrypto");
    	byte[] outputBytes = null;
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
                         
            outputBytes = cipher.doFinal(inputBytes);
            
            
            System.out.println("enc_success");
            
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException ex) {
        	throw new CryptoException("Error encrypting/decrypting", ex);
        }
        
        return outputBytes;
    }

	public static void main(String[] args) {
		String key = "Nikhil@123456789"; //password IamGroot
		//System.out.println(UUID.randomUUID().toString().replace("-", ""));
		File inputFile = new File("C:\\Users\\nikhil.wankhade\\Desktop\\Nikhil\\esign-bkup\\zwq837jsbs.sec");
		File encryptedFile = new File("C:\\Users\\nikhil.wankhade\\Desktop\\Nikhil\\esign-bkup\\zwq837jsbs");
		File decryptedFile = new File("C:\\Users\\nikhil.wankhade\\Desktop\\Nikhil\\esign-bkup\\zwq837jsbs-new.7z");

		try {
			
			//encrypt
			//String[] arg = {"enc", "1234567890123456", "F:\\source-bkup\\NEGIL\\esign-13-Jan21-poc.7z", "F:\\source-bkup\\NEGIL\\esign-13-Jan21-poc.enc"};
			
			//decrypt
			//String[] arg = {"dec", "1234567890123456", "F:\\source-bkup\\NEGIL\\esign-13-Jan21-poc.enc", "F:\\source-bkup\\NEGIL\\esign-13-Jan21-poc-dec.7z"};
			
			//args = arg;
			
			if(args.length == 0 || args.length < 4) {
				throw new CryptoException("please provide operation type [enc or dec], password, inputfile and outputfile");
			}
			
			String op = args[0];
			
			key = args[1];
			
			System.out.println("key:" + key);
			
			if(op == null || op.isEmpty()) {
				throw new CryptoException("please provide operation type encrypt or decrypt [enc or dec]");
			}
			
			switch (op) {
			
			case "enc":
				inputFile = new File(args[2]);
				encryptedFile = new File (args[3]);
				
				CryptoUtils.encrypt(key, inputFile, encryptedFile);
				break;
				
			case "dec":
				encryptedFile = new File(args[2]);
				decryptedFile = new File (args[3]);
				
				CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
				break;

			default:
				System.out.println("e.g. encrypt [enc pass \\inputFile.zip \\decryptedFile.ec]\n");
				System.out.println("e.g. decrypt [dec pass \\decryptedFile.ec \\decryptedFile.zip]\n");
				System.out.println("*******************************\n");
				System.out.println("please provide operation type encrypt or decrypt [enc or dec]\n");
				break;
			}
			
			
		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

}
