package com.java.poc.j7.blockingq;

import java.util.concurrent.BlockingQueue;

public class QProducer implements Runnable{
	
	private BlockingQueue<Message> queue;
	
	public QProducer(BlockingQueue<Message> q) {
		this.queue = q;
	}
	
	@Override
	public void run() {
		//spawn messages
		
		for(int i=0; i<20; i++) {
			Message m = new Message("" + i);
			
			try {
				Thread.sleep(i);
				queue.put(m);
				System.out.println("Produced Msg:" + m.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
		//exit message
		Message mm = new Message("Exit");
		try {
			queue.put(mm);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
