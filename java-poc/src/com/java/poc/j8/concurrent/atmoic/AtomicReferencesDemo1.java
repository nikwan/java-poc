package com.java.poc.j8.concurrent.atmoic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferencesDemo1 {
	
	private Student student;
	private String message;
	private AtomicReference<Student> arStudent;
	private AtomicReference<String> arMessage;
	
	public static void main(String[] args) {
		
		AtomicReferencesDemo1 r = new AtomicReferencesDemo1();
		
		r.test();
		
	}
	
	private void test() {
		ExecutorService s = Executors.newFixedThreadPool(2);
		message = "hello ";
		student = new  Student("Nikhil");
		arStudent = new AtomicReference<AtomicReferencesDemo1.Student>(student);
		arMessage = new AtomicReference<String>(message);
		
		System.out.println("message is " + message + "\n STUDENT is " + student.toString());
		System.out.println("atomic ref mesage is " + arMessage.get() + "\n atomic ref student is " + arStudent.get().toString());
		
		s.execute( () -> {
			arMessage.compareAndSet(message, "Thread 1");
			message = message.concat("-Thread 1");
			student.setName("Thread 1");
			arStudent.getAndSet(new Student("Thread 1"));
			System.out.println("\n" + Thread.currentThread().getName() +" Values "
                    + message + " - " + student.toString());
            System.out.println("\n" + Thread.currentThread().getName() +" Atomic References "
                    + message + " - " + student.toString());
		});
		
		s.execute( () -> {
			arMessage.compareAndSet(message, "Thread 2");
			message = message.concat("-Thread 2");
			student.setName("Thread 2");
			arStudent.getAndSet(new Student("Thread 2"));
			System.out.println("\n" + Thread.currentThread().getName() +" Values "
                    + message + " - " + student.toString());
            System.out.println("\n" + Thread.currentThread().getName() +" Atomic References "
                    + message + " - " + student.toString());
		});
		
		
		
		s.shutdown();
	}

	class Student{
		
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Student(String name) {
			super();
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + "]";
		}
		
		
		
	}

}
