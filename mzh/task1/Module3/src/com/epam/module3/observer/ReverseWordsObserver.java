package com.epam.module3.observer;

import java.util.ArrayList;
import java.util.List;

import com.epam.module3.observable.WordsScanner;

public class ReverseWordsObserver implements IObserver {

	private WordsScanner wordsScanner;

	public ReverseWordsObserver(WordsScanner wordsScanner) {
		super();
		this.wordsScanner = wordsScanner;
	}

	@Override
	public void update(List<String> words) {
		System.out.println("Reverse words:\n" + reverseWords(words));
	}

	private List<String> reverseWords(List<String> words) {
		List<String> reverseWords = new ArrayList<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder(word);
			sb.reverse();
			reverseWords.add(sb.toString());
		}
		return reverseWords;
	}

}
