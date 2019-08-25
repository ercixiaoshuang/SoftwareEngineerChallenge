package com.paypay.dataengineer;

import java.util.EmptyStackException;

public class ImmutableStack<T> implements Stack<T> {
	private final T head;
	private final Stack<T> tail;

	public ImmutableStack() {
		this.head = null;
		this.tail = null;
	}

	private ImmutableStack(T head, Stack<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public T peek() {
		return this.head;
	}

	@Override
	public Stack<T> push(T t) {
		// TODO Auto-generated method stub
		return new ImmutableStack<T>(t, this);
	}

	@Override
	public Stack pop() throws EmptyStackException {
		if (this.tail == null)
			throw new EmptyStackException();
		return this.tail;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return peek() == null && this.tail == null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ImmutableStack reverse() {
		ImmutableStack resultStack = new ImmutableStack();
		ImmutableStack currentStack = this;
		while (!currentStack.isEmpty()) {
			resultStack = (ImmutableStack) resultStack.push(currentStack.peek());
			currentStack = (ImmutableStack) currentStack.pop();
		}
		return resultStack;
	}

}
