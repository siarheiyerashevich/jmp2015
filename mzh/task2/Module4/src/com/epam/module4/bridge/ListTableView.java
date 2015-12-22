package com.epam.module4.bridge;

import java.util.Random;

public class ListTableView implements IListView {
	
	private static final int COLUMN_COUNT = 5;

	@Override
	public void print(int count) {
		System.out.println("Use \"list table\" for showing result");
		Random random = new Random();
		int rowCount = count / COLUMN_COUNT;
		int residue = count % COLUMN_COUNT;
		for (int i = 0; i < rowCount; i++) {
			System.out.print(i + 1 + " row:    ");
			for (int j = 0; j < COLUMN_COUNT; j++) {
				System.out.print(random.nextInt(100) + "  ");
			}
			System.out.println("");
		}
		System.out.print("Last row: ");
		for (int i = 0; i < residue; i++) {
			System.out.print(random.nextInt(100) + "  ");
		}
		System.out.println("");
	}
}
