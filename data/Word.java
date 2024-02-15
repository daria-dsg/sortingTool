package sorting.data;
import java.util.*;

public class Word extends DataType {
    private final List<String> elements = new ArrayList<>();
    private String longestWord;
    private int frequency;
    void read() {
        Scanner scanner = new Scanner(System.in);
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
