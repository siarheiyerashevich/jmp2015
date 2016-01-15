package com.epam.module6.part1;

public class OutOfMemoryHeapPart {
	private Integer key;

	public OutOfMemoryHeapPart(Integer key) {
		super();
		this.key = key;
	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

	// @Override
	// public boolean equals(Object o) {
	// boolean result = false;
	// if (o instanceof OutOfMemoryHeapPart) {
	// result = ((OutOfMemoryHeapPart) o).key.equals(this.key);
	// }
	// return result;
	// }

}
