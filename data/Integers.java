package sorting.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Integers extends DataType {

    private List<Integer> elements = new ArrayList<>();
    private int amountOfNums;
    @Override
    void read() {
        int number;

        System.out.println("Enter numbers to sort (press q to quit)");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                elements.add(number);
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Input is not valid. Enter q to quit or number to sort");
                }
            }
        }
        scanner.close();
        sort();
    }

    @Override
    void compute() {
        amountOfNums = elements.size();
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
