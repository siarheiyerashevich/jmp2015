package com.epam.module9.collect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CollectList {

	public static void readFile() {
		try {
			List<String> list = new ArrayList<String>();
			File file = new File("module9.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			String elem = null;
			int count = 1;
			while ((line = br.readLine()) != null) {
				System.out.println(count++ + " elemnt in list: " + elem);
				elem = line.substring(0, 3);
				list.add(elem);
			}
			br.close();
		} catch (Exception exception) {
			System.err.println("Exception!!!");
		}
	}
}
