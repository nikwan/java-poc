package com.java.poc.j7.blockingq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {
		
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);//shared object for both thread
		
		QProducer p = new QProducer(queue);
		QConsumer c = new QConsumer(queue);
		
		new Thread(p).start();
		new Thread(c).start();

		System.out.println("producer and consumer started!!");
		

	}

}
