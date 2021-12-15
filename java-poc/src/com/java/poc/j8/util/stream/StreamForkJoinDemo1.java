package com.java.poc.j8.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinTask;

public class StreamForkJoinDemo1 {
	
		
	public static void main(String[] args) {
		
		System.out.println("avail processores:" + Runtime.getRuntime().availableProcessors());
		
		System.out.println("f and j pool:" + ForkJoinPool.getCommonPoolParallelism());
		
		//ForkJoinPool.commonPool().execute(new FJTest().adapt(() -> System.out.println("test fork")));
		
		List<Integer> list = Arrays.asList(1,3,46,43,53,32,35,34,5334);
		
		//list.stream().forEach( a -> System.out.println("from thread:" + Thread.currentThread().getName() + ",list val:" + a));
		
		list.parallelStream().forEach( a -> System.out.println("from thread:" + Thread.currentThread().getName() + ",list val:" + a));
		
		//Executors
	}
	
	static class FJTest extends ForkJoinTask<Integer> {

		@Override
		public Integer getRawResult() {
			// TODO Auto-generated method stub
			
			
			return null;
		}

		@Override
		protected void setRawResult(Integer value) {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected boolean exec() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

}
