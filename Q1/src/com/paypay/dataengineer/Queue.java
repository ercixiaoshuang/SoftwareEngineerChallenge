package com.paypay.dataengineer;

import java.util.EmptyStackException;

public interface Queue<T> {
	public Queue<T> enQueue(T t);

	// Removes the element at the beginning of the immutable queue, and returns the
	// new queue.
	public Queue<T> deQueue() throws EmptyStackException;

	public T head();

	public boolean isEmpty();
}
