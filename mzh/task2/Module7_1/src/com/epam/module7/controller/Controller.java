package com.epam.module7.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

	private static List objects = new ArrayList();
	private static boolean cont = true;
	private static int num;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		while (cont) {
			System.out.println(
					"\n\nI have " + objects.size() + " objects in use, about " + (objects.size()) + " MB.");
			System.out.println(
					"\nWhat would you like me to do?\n1. Create some objects\n2. Remove some objects\n" + "0. Quit");
			num = scanner.nextInt();
			switch (num) {
				case 1: {
					createObjects();
					break;
				}
				case 2: {
					removeObjects();
					break;
				}
				case 0: {
					cont = false;
				}
			}
		}
		System.out.println("End!");
	}

	private static void createObjects() {
		System.out.println("Creating objects...");
		for (int i = 0; i < 2; i++) {
			objects.add(new byte[10 * 1024]);
		}
	}

	private static void removeObjects() {
		System.out.println("Removing objects...");
		int start = objects.size() - 1;
		int end = start - 2;
		for (int i = start; ((i >= 0) && (i > end)); i--) {
			objects.remove(i);
		}
	}
}
