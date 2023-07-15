package com.masai.problem4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class A {

	public static void main(String ags[]) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(3);
		Runnable r = () -> {
		};
		Callable<String> c = () -> "A";

		for (int i = 0; i <= 8; i++) {
			Future f = es.submit(r);
			System.out.print(f.get() != null ? "" : "A");
		}

		for (int i = 9; i <= 10; i++) {
			Future<String> f = es.submit(c);
			String result = f.get();
			System.out.print(result != null ? result : "C");
		}

		es.shutdown();
	}

}
