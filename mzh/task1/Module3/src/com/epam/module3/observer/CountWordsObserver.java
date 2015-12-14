package com.epam.module3.observer;

import java.util.List;

import com.epam.module3.observable.WordsScanner;

public class CountWordsObserver implements IObserver {

	private WordsScanner wordsScanner;

	public CountWordsObserver(WordsScanner wordsScanner) {
		super();
		this.wordsScanner = wordsScanner;
	}

	@Override
	public void update(List<String> words) {
		System.out.println("Count words: " + countWords(words));

	}

	private int countWords(List<String> words) {
		return words.size();
	}

}
