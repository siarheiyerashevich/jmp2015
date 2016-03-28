package com.epam.jpamodule.model;

public enum EmployeeStatus {

	FULL_TIME_EMPLOYEE(1, "Полная занятость"), PART_TIME_EMPLOYEE(2, "Частичная занятость");

	private final int value;
	private String text;

	private EmployeeStatus(int value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getValue() {
		return value;
	}
}
