package task2.src.mentee;

import task2.src.mentee.observers.LongestWordKeeper;
import task2.src.mentee.observers.NumberCounter;
import task2.src.mentee.observers.ReversWord;
import task2.src.mentee.observers.WordCounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Reader {
    public static void main(String[] args) {
        Subject subject = new Subject();

        subject.attach(new LongestWordKeeper(subject));
        subject.attach(new NumberCounter(subject));
        subject.attach(new ReversWord(subject));
        subject.attach(new WordCounter(subject));

        try {
            // change / for win to \
            Path filePath = Paths.get("./aka/task2/src/resources", "text.txt");
            String wordsFromFile = new String(Files.readAllBytes(filePath));
            String[] wordsArray = wordsFromFile.split(" ");
            for (int i = 0; i < wordsArray.length; i++) {
                subject.setCurWord(wordsArray[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}