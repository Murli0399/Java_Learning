package com.masai.problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileRecapDemo {
	public static void main(String[] args) throws IOException {
		File f = new File("myfolder");
		if (f.exists()) {
			System.out.println("No folder named myfolder");
			return;
		}
		if (f.isFile()) {
			System.out.println("myfolder is a file not a folder");
			return;
		}
		String str[] = f.list();

		Reader r = new BufferedReader(new FileReader("A.txt"));
		Writer w = new BufferedWriter(new FileWriter("B.txt", true));

		while (true) {
			int c = r.read();
			if (c == -1)
				break;
			w.write(c);
		}

		w.flush();
		w.close();
		r.close();
	}
}


//(viii) The byte stream process data in the chunk of 8 bits but the character stream process data in the chunk of 16 bits.

//(ix) What is buffer?
//Ans -> A buffer is a temporary storage area used to store data that is being transferred from one place to another.
//In Java, a buffer can be used to optimize input and output operations by reducing the number of calls to the underlying operating system.

//(x) Which class is used to write primitive data type to file?
//Ans -> DataOutputStream












