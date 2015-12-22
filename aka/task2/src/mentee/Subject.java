package java.mentee;

import java.mentee.observers.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheFallen on 08.12.15.
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private String curWord;

    public String getCurWord() {
        return this.curWord;
    }

    public void setCurWord(String curWord) {
        this.curWord = curWord;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        observers.forEach(Observer::update);
    }
}
