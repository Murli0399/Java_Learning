package com.masai.problem2;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileOperationDemo {
	public static void main(String[] args) throws InterruptedException {
		ReadWriteCenter r = new ReadWriteCenter("A.txt",
				"Originally formed in 1600 purely to trade with the Mughal Empire, the Company needed to secure its commercial posts at Calcutta, Bombay and Madras. It purchased land from Indian rulers to build its settlements on, and recruited native armed forces to protect them. Eventually, these evolved into the Bengal, Bombay and Madras Armies.",
				"After successfully battling the French for trading supremacy, and simultaneously involving itself in local politics, the Company became India’s leading power following Robert Clive’s victory at Plassey in 1757. In the years that followed, it expanded its Indian domains.");


		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					r.writeToFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t1.join();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					r.appendToFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t2.start();
		t2.join();
		
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Callable<List<Integer>> list = () -> r.getAnalysis();
		Future<List<Integer>> future = ex.submit(list);
		ex.shutdown();
		try {
			List<Integer> ans = future.get();
			
			System.out.println(ans.get(0));
			System.out.println(ans.get(1));
			System.out.println(ans.get(2));
			
		}  catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
