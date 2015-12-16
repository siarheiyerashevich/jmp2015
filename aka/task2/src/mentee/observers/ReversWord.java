package java.mentee.observers;

import java.mentee.Subject;

/**
 * Created by TheFallen on 08.12.15.
 */
public class ReversWord extends Observer {

    public ReversWord(Subject subject){
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("Revers word is: "+new StringBuffer(this.subject.getCurWord()).reverse().toString());
    }
}
