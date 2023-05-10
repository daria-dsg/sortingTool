package sorting.data;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;


public class Line extends DataType {
    private List<String> elements = new ArrayList<>();
    private String longestLine;

    private int frequency;
    @Override
    void read() {
        String line;
        while (scanner.hasNextLine()) {
            line= scanner.nextLine();
            elements.add(line);
        }
    }

    @Override
    void compute() {
        longestLine = Collections.max(elements, Comparator.comparing(String::length));
        frequency = Collections.frequency(elements, longestLine);
    }

    @Override
    void print() {
        System.out.printf("Total lines: %d.%n", elements.size());
        System.out.println("The longest line: ");
        System.out.println(longestLine);
        System.out.printf("(%d time(s), %d).%n", frequency, (100 * frequency)/ elements.size() );
    }
}
