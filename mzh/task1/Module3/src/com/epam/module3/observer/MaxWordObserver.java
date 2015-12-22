package com.epam.module3.observer;

import java.util.List;

import com.epam.module3.observable.WordsScanner;

public class MaxWordObserver implements IObserver {

	private WordsScanner wordsScanner;

	public MaxWordObserver(WordsScanner wordsScanner) {
		super();
		this.wordsScanner = wordsScanner;
	}

	@Override
	public void update(List<String> words) {
		System.out.println("The longest word: " + maxWord(words));
	}

	private String maxWord(List<String> words) {
		int index = 0;
		int length = words.get(index).length();
		for (int i = 1; i < words.size(); i++) {
			if (words.get(i).length() > length) {
				length = words.get(i).length();
				index = i;
			}
		}
		return words.get(index);
	}

}
