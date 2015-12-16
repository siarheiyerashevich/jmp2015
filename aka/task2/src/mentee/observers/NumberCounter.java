package java.mentee.observers;

import java.mentee.Subject;

/**
 * Created by TheFallen on 08.12.15.
 */
public class NumberCounter extends Observer {

    private int stringWithNumCount;

    public NumberCounter(Subject subject){
        this.subject = subject;
        this.stringWithNumCount = 0;
    }

    @Override
    public void update() {
        if(this.subject.getCurWord().matches(".*\\d+.*")) {
            this.stringWithNumCount++;
        }
        System.out.println("Total count of strings with numbers: "+this.stringWithNumCount);
    }
}
