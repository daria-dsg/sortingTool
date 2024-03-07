package sorting.data;

import java.util.*;

public class Line extends Sortable<String> {

    public Line(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    protected void readFromScanner(Scanner scanner) {
        String input;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            } else {
                elements.add(input);
            }
        }
        scanner.close();
    }

    @Override
    protected void print(Boolean includeCount) {
        System.out.printf("Total lines: %d.%n", elements.size());
        if (includeCount) {
            countMap.forEach((line, count) -> {
                System.out.print(line + ": ");
                System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ elements.size());
            });
        } else {
            elements.forEach(System.out::println);
        }
    }
}
