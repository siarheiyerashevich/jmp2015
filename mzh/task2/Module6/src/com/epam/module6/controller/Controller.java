package com.epam.module6.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.epam.module6.part1.OutOfMemoryHeapPart;
import com.epam.module6.part3.StackOberFlowErrowPart;

import javassist.ClassPool;

public class Controller {

	static ClassPool cp = ClassPool.getDefault();

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите 1, 2 или 3: ");
		int num = scanner.nextInt();
		switch (num) {
		case 1: {
			Map<OutOfMemoryHeapPart, String> map = new HashMap<>();
			int i = 0;
			while (true) {
				if (!map.containsKey(new OutOfMemoryHeapPart(i))) {
					map.put(new OutOfMemoryHeapPart(i), "Value " + i);
					System.out.println("Put value: " + i++);
				}
			}
		}
		case 2: {
			for (int i = 0;; i++) {
				Class c = cp.makeClass("com.epam.module6.part2.OutOfMemoryMetaspacePart" + i).toClass();
				System.out.println("Class is loaded " + c);
			}
		}
		case 3: {
			System.out.println(new StackOberFlowErrowPart());
		}
		}
		scanner.close();
	}
}
