package sorting.data;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class Word extends DataType {
    private List<String> elements = new ArrayList<>();
    private String longestWord;
    private int frequency;
    void read() {
        String word;

        while (scanner.hasNext()) {
            word = scanner.next();
            elements.add(word);
        }
    }

    @Override
   void compute() {
        longestWord = Collections.max(elements, Comparator.comparing(String::length));
        frequency = Collections.frequency(elements, longestWord);
    }

    @Override
    void print() {
        System.out.printf("Total word:: %d.%n", elements.size());
        System.out.printf("The longest word: %s (%d time(s), %d).%n", longestWord, frequency, (100 * frequency)/ elements.size());
    }
}
