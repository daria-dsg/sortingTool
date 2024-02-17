package sorting.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Integers implements Sorter {

    private final List<Integer> elements = new ArrayList<Integer>();

    public void naturalSort() {
        read();
        Collections.sort(elements);
        print();
    }

    private void read() {
        System.out.println("Enter numbers to sort (press q to quit)");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                elements.add(scanner.nextInt());
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
    }

    private void print() {
        System.out.printf("Total numbers: %d.%n", elements.size());
        System.out.print("Sorted data:");
        elements.forEach(ele -> {
            System.out.print(ele);
            System.out.print(" ");
        });
    }


}
