package com.epam.module3.observable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.module3.observer.IObserver;

public class WordsScanner implements IObservable {
	
	private String fileName;
	private List<IObserver> observers;
	private List<String> words;

	public WordsScanner(String fileName) {
		super();
		this.fileName = fileName;
		observers = new ArrayList<>();
		words = new ArrayList<>();
	}

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.update(words);
		}
	}

	public void scanFile() throws Exception {
		String word;
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNext()) {
			word = scanner.next();
			words.add(word);
			notifyObservers();
		}
		scanner.close();
	}
}
