package sorting.data;

import java.util.*;

public class Longs extends Sortable<Long>{

    public Longs(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    protected void readFromScanner(Scanner scanner) {
        while(scanner.hasNext()){
            if (scanner.hasNextLong()) {
                elements.add(scanner.nextLong());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.printf("\"%s\" is not a long. It will be skipped.%n", input);
                }
            }
        }
    }

    @Override
    protected void print(Boolean includeCount) {
        System.out.printf("Total numbers: %d.%n", elements.size());
        if (includeCount) {
            countMap.forEach((num, count) -> {
                System.out.print(num + ": ");
                System.out.printf("%d time(s), %d%%.%n",count , (100 * count)/ elements.size());
            });
        } else {
            System.out.print("Sorted data:");
            elements.forEach(num -> System.out.print(num + " "));
        }
    }
}
