package com.epam.module4.bridge;

public class Printer extends AbstractPrinter {
	
	private int count;

	public Printer(int count, IListView list) {
		super(list);
		this.count = count;
	}

	@Override
	public void printList() {
		list.print(count);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
