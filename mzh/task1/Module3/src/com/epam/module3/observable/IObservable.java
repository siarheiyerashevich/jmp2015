package com.epam.module3.observable;

import com.epam.module3.observer.IObserver;

public interface IObservable {
	
	public void registerObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyObservers();
}
