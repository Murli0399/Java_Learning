package com.masai;

public class MyStack implements Stack {
	private int stack[];
	private int top;
	final static int MAX_SIZE = 5;

	MyStack() {
		stack = new int[MAX_SIZE];
		top = -1;
	}

	@Override
	public void push(int element) throws OverflowException {
		if (top == MAX_SIZE - 1) {
			throw new OverflowException("No space in stack to add element");
		}
		top++;
		stack[top] = element;
	}

	@Override
	public int pop() throws UnderflowException {
		if (top == -1) {
			throw new UnderflowException("No elements in stack to pop");
		}
		int element = stack[top];
		top--;
		return element;
	}

	@Override
	public int peek() throws UnderflowException {
		if (top == -1) {
			throw new UnderflowException("No elements in stack to peek");
		}
		return stack[top];
	}

	public String toString() {
		return Stack.displayStackElements(stack);
	}
}
