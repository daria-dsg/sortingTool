package sorting.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Integers extends DataType {

    private List<Integer> elements = new ArrayList<>();
    private int totalNums;
    @Override
    void read() {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (scanner.hasNextInt()) {
            number = scanner.nextInt();
            elements.add(number);
        }

        sort();
    }

    @Override
    void compute() {
        totalNums = elements.size();
    }

    @Override
    void print() {
        System.out.printf("Total numbers: %d.%n", elements.size());
        System.out.printf("Sorted data:");
        elements.forEach(ele -> {
            System.out.print(ele);
            System.out.print(" ");
        });
    }

    private void sort() {
        Collections.sort(elements);
    }
}
