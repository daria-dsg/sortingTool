package sorting.data;

import java.util.*;

public class Word extends Sortable<String> {

    public Word(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    protected void readFromScanner(Scanner scanner ) {
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("q")) {
                break;
            } else {
                elements.add(input);
            }
        }
    }

    @Override
    protected void print(Boolean includeCount) {
        System.out.printf("Total words: %d.%n", elements.size());

        if (includeCount) {
            countMap.forEach((word, count) -> {
                System.out.print(word + ": ");
                System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ elements.size());
            });
        } else {
            System.out.println("Sorted data: ");
            elements.forEach(word -> System.out.print(word + " "));
        }
    }
}
