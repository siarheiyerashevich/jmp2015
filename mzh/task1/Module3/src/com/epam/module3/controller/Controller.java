package com.epam.module3.controller;

import com.epam.module3.observable.WordsScanner;
import com.epam.module3.observer.CountNumbersObserver;
import com.epam.module3.observer.CountWordsObserver;
import com.epam.module3.observer.MaxWordObserver;
import com.epam.module3.observer.ReverseWordsObserver;

public class Controller {

	private static final String FILE_NAME = "module3.txt";

	public static void main(String[] args) throws Exception {
		
		WordsScanner wordsScanner = new WordsScanner(FILE_NAME);
		wordsScanner.registerObserver(new CountWordsObserver(wordsScanner));
		wordsScanner.registerObserver(new CountNumbersObserver(wordsScanner));
		wordsScanner.registerObserver(new MaxWordObserver(wordsScanner));
		wordsScanner.registerObserver(new ReverseWordsObserver(wordsScanner));
		
		wordsScanner.scanFile();
	}
}
