package sorting.data;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Longs extends DataType {
    private List<Long> elements = new ArrayList<>();
    private long maxNum;
    private int frequency;

    @Override
    void read() {
        Scanner scanner = new Scanner(System.in);
        long number;

        while (scanner.hasNextLong()) {
            number = scanner.nextLong();
            elements.add(number);
        }
    }

    @Override
    void compute() {
        maxNum = Collections.max(elements);
        frequency = Collections.frequency(elements, maxNum);
    }

    @Override
    void print() {
        System.out.printf("Total numbers: %d.%n", elements.size());
        System.out.printf("The greatest number: %d (%d time(s), %d).%n", maxNum, frequency, (100 * frequency)/ elements.size());
    }
}
