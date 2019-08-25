package com.paypay.dataengineer;

import java.util.EmptyStackException;

public interface Stack<T> {

	public T peek();

	public boolean isEmpty();

	public Stack<T> push(T t);

	public Stack<T> pop() throws EmptyStackException;

	public Stack<T> reverse();
}
