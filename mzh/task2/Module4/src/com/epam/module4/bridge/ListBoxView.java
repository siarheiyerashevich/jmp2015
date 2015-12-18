package com.epam.module4.bridge;

import java.util.Random;

public class ListBoxView implements IListView {
	
	private static final int COLUMN_COUNT = 1;

	@Override
	public void print(int count) {
		System.out.println("Use \"list view\" for showing result");
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			System.out.print(i + 1 + " row:    ");
			for (int j = 0; j < COLUMN_COUNT; j++) {
				System.out.print(random.nextInt(100) + "  ");
			}
			System.out.println("");
		}
	}
}
