package com.java.poc.j8.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializationDemo1 implements Serializable{
	
	private static SerializationDemo1 instance =  new SerializationDemo1();
	
	// implement readResolve method
    protected Object readResolve() throws Exception
    {
    	throw new Exception("not serializable!");
        //return instance;
    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("ins.data")); 
		oo.writeObject(instance);
		oo.close();
		
		ObjectInput oi = new ObjectInputStream(new FileInputStream("ins.data"));
		SerializationDemo1 o = (SerializationDemo1) oi.readObject();
		oi.close();
		
		System.out.println("instance hashCode:- "
                + instance.hashCode());
System.out.println("o hashCode:- "
                + o.hashCode());
	}

}
