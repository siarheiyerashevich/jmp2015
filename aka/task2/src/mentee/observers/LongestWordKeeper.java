package java.mentee.observers;

import java.mentee.Subject;

/**
 * Created by TheFallen on 08.12.15.
 */
public class LongestWordKeeper extends Observer {

    private String longestWord;
    private int longestWordLength;

    public LongestWordKeeper(Subject subject){
        this.subject = subject;
        this.longestWordLength=0;
    }

    @Override
    public void update() {
        if(this.subject.getCurWord().length()>this.longestWordLength) {
            this.longestWord = this.subject.getCurWord();
            this.longestWordLength = this.longestWord.length();
            System.out.println("Longest word is "+this.longestWord);
        }
    }
}
