package sorting.data;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Line extends DataType {
    private String longestLine;
    private List<String> list = new ArrayList<>();
    private int frequency;

    @Override
    void read() {
        String line;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            list.add(line);
        }
    }

    @Override
    void compute() {
        longestLine = Collections.max(list, Comparator.comparing(String::length));
        frequency = Collections.frequency(list, longestLine);
    }

    @Override
    void print() {
        System.out.printf("Total lines: %d.%n", list.size());
        System.out.println("The longest line: ");
        System.out.println(longestLine);
        System.out.printf("(%d time(s), %d).%n", frequency, (100 * frequency)/ list.size() );
    }
}
