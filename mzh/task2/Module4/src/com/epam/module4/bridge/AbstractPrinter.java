package com.epam.module4.bridge;

public abstract class AbstractPrinter {

	protected IListView list;

	public AbstractPrinter(IListView list) {
		this.list = list;
	}

	public abstract void printList();
}
