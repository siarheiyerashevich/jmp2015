package mentee;


import mentee.observers.LongestWordKeeper;
import mentee.observers.NumberCounter;
import mentee.observers.ReversWord;
import mentee.observers.WordCounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Reader {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new LongestWordKeeper(subject);
        new NumberCounter(subject);
        new ReversWord(subject);
        new WordCounter(subject);

        try {
            // change / for win to \
            Path filePath = Paths.get("./src/resources", "text.txt");
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