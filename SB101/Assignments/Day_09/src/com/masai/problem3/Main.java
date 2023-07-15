package com.masai.problem3;

class Common {
	boolean isPrinterAvailable = true;
	boolean isDVDWriterAvailable = true;

	synchronized void occupyPrinter(Common c2) {
		if (!isPrinterAvailable) {
			// you are here means printer is not available
			try {
				System.out.println("Waiting for printer");
				wait();
			} catch (InterruptedException ex) {

			}
		}
		// you are here means printer is available
		System.out.println("printer occupied.. using printer for 1000 millisceonds");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {

		}
		// request occupy the DVD writer
		c2.occupyDVDWriter(this);
		// mark the printer available
		isPrinterAvailable = true;
		// call notify() method
		notify();

	}

	synchronized void occupyDVDWriter(Common c1) {
		if (!isDVDWriterAvailable) {
			// you are here means DVD Writer is not available
			try {
				System.out.println("Waiting for DVD Writer");
				wait();
			} catch (InterruptedException ex) {

			}
		}
		// you are here means DVD Writer is available
		System.out.println("DVD Writer occupied.. using DVD Writer for 1000 millisceonds");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {

		}
		// request occupy the printer
		c1.occupyPrinter(this);
		// mark the DVD Writer available
		isDVDWriterAvailable = true;
		// call notify() method
		notify();
	}
}

class ThreadOne implements Runnable {
	Common c1, c2;

	public ThreadOne(Common c1, Common c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public void run() {
		c1.occupyPrinter(c2);
		c2.occupyDVDWriter(c1);
	}
}

class ThreadTwo implements Runnable {
	Common c1, c2;

	public ThreadTwo(Common c1, Common c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public void run() {
		c2.occupyDVDWriter(c1);
		c1.occupyPrinter(c2);
	}
}

public class Main {
	public static void main(String[] args) {
		Common c1 = new Common();
		Common c2 = new Common();

		Runnable rOne = new ThreadOne(c1, c2);
		Runnable rTwo = new ThreadTwo(c1, c2);

		Thread t1 = new Thread(rOne);
		Thread t2 = new Thread(rTwo);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ex) {

		}
		System.out.println("Bye Bye");
	}
}
