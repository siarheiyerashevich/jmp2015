package task2.src.mentee.observers;

import task2.src.mentee.Subject;

/**
 * Created by TheFallen on 08.12.15.
 */
public class WordCounter extends Observer {

    private int totalCount;

    public WordCounter(Subject subject){
        this.subject = subject;
        this.totalCount = 0;
    }

    @Override
    public void update() {
        this.totalCount++;
        System.out.println("Total count of words: "+this.totalCount);
    }
}
