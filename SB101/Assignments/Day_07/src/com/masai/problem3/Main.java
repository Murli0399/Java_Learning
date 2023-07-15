package com.masai.problem3;

class A {
	static synchronized void fun() {

	}
}

class B implements Runnable {
	A a = new A();

	public void run() {
		synchronized (a) {
			try {
				a.wait();
			} catch (InterruptedException e) {
			}
		}

		// say wait method is called somewhere for this thread
		notify();
	}
}

public class Main {

}
