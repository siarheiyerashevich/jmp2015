package com.epam.module3.observer;

import java.util.List;

import com.epam.module3.observable.WordsScanner;

public class CountNumbersObserver implements IObserver {

	private static final String PATTERN = "^-?\\d+$";

	private WordsScanner wordsScanner;

	public CountNumbersObserver(WordsScanner wordsScanner) {
		super();
		this.wordsScanner = wordsScanner;
	}

	@Override
	public void update(List<String> words) {
		System.out.println("Count numbers: " + countNumbers(words));
	}

	private int countNumbers(List<String> words) {
		int count = 0;
		for (String word : words) {
			if (word.matches(PATTERN)) {
				count++;
			}
		}
		return count;
	}

}
