package com.masai.problem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCenter {
	private File file;
	private String contentToWrite;
	private String contentToAppend;

	public ReadWriteCenter(String filename, String contentToWrite, String contentToAppend) {
		super();
		this.file = new File(filename);
		this.contentToWrite = contentToWrite;
		this.contentToAppend = contentToAppend;
	}

	public void writeToFile() throws IOException {
		FileWriter writer = new FileWriter(file);
		writer.write(contentToWrite);
		writer.close();
	}

	public void appendToFile() throws IOException {
		FileWriter writer = new FileWriter(file, true);
		writer.append(contentToAppend);
		writer.close();
	}

	public List<Integer> getAnalysis() throws IOException {
		List<Integer> list = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(file));

		String str = br.readLine();
		str += br.readLine();
		br.close();
		char[] arr = str.toCharArray();
		int digits = 0;
		int letters = 0;
		int symbols = 0;

		for (char c : arr) {
			if (Character.isDigit(c)) {
				digits++;
			} else if (Character.isLetter(c)) {
				letters++;
			} else {
				symbols++;
			}
		}
		list.add(digits);
		list.add(letters);
		list.add(symbols);

		return list;
	}

}
