package com.masai;

public interface Stack {
	void push(int element) throws OverflowException;

	int pop() throws UnderflowException;

	int peek() throws UnderflowException;

	static String displayStackElements(int stack[]) {
		String str = "";
		for (int i = 0; i < stack.length; i++) {
			str += stack[i] + " ";
		}
		return str;

	}
}
