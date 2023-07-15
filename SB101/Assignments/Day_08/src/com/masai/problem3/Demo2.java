package com.masai.problem3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(("studentdata.ser")));

		List<Student> list = (List<Student>) ois.readObject();
		ois.close();
		list.forEach(s -> {
			System.out.println("Roll = " + s.getRoll() + ", Name = " + s.getName() + ", Marks = " + s.getMarks()
					+ ", City = " + s.getAddress().getCity() + ", State = " + s.getAddress().getState() + ", PinCode = "
					+ s.getAddress().getPincode());
		});
	}
}
