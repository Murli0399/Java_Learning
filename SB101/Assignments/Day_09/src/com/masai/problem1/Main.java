package com.masai.problem1;

class Fibonacci implements Runnable {

	@Override
	public void run() {
		int n1 = 0;
		int n2 = 1;
		int n3;
		int count = 10;
		System.out.print(n1 + " " + n2 + " ");
		for (int i = 2; i < count; i++) {
			n3 = n1 + n2;
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
		}
		System.out.println();
	}

}

class ReverseNum implements Runnable {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.print(i + " ");
		}
	}

}

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Thread fb = new Thread(new Fibonacci());
		Thread rn = new Thread(new ReverseNum());
		fb.start();
		fb.join();
		rn.start();
		rn.join();
	}
}
