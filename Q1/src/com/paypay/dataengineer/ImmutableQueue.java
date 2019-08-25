package com.paypay.dataengineer;

public class ImmutableQueue<T> implements Queue<T> {

	private final Stack<T> front;
	private final Stack<T> back;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ImmutableQueue() {
		this.front = new ImmutableStack();
		this.back = new ImmutableStack();
	}

	@SuppressWarnings("unchecked")
	public ImmutableQueue(@SuppressWarnings("rawtypes") Stack front, @SuppressWarnings("rawtypes") Stack back) {
		this.front = front;
		this.back = back;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Queue<T> enQueue(T t) {
		// TODO Auto-generated method stub
		if (this.front.isEmpty())
			return new ImmutableQueue<T>(this.back.reverse().push(t), new ImmutableStack());
		return new ImmutableQueue<T>(this.front, this.back.push(t));
	}

	@SuppressWarnings({ "rawtypes" })
	public Queue<T> deQueue() {
		// TODO Auto-generated method stub
		if (this.front.isEmpty()) {
			return new ImmutableQueue<T>(this.back.reverse().pop(), new ImmutableStack<>());
		} else {
			Stack resultFront = this.front.pop();
			if (resultFront.isEmpty()) {
				return new ImmutableQueue<T>(this.back.reverse(), new ImmutableStack());
			}
			return new ImmutableQueue<T>(resultFront, this.back);
		}
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		return this.front.peek();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.front.isEmpty() && this.back.isEmpty();
	}

}
