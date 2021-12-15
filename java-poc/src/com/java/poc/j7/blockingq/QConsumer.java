package com.java.poc.j7.blockingq;

import java.util.concurrent.BlockingQueue;

public class QConsumer implements Runnable{
	
	BlockingQueue<Message> queue;
	
	public QConsumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			Message m;
			
			while((m = queue.take()).getMsg() != "Exit") {
				Thread.sleep(500);
				System.out.println("Consumed:" + m.getMsg());
			}
		} catch (InterruptedException e) {
			//
			e.printStackTrace();
		}
		
	}

}
