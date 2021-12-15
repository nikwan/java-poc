package com.java.poc.j7.crypto;

/**
 * @author nikhil.wankhade
 *
 */
public class CryptoException extends Exception {
 
    public CryptoException(String msg) {
    	super(msg);
    }
 
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}