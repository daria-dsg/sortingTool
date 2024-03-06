package sorting.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Integers extends Sorter {

    private final List<Integer> numbers = new ArrayList<>();

    private final LinkedHashMap<Integer,Integer> countMap = new LinkedHashMap<>();

    public Integers(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public void naturalSort() {
        readData();
        Collections.sort(numbers);
        if (outputFilePath == null) {
            print(false);
        } else {
            outputNumbersToFile();
        }
    }

    @Override
    public void sortByCount() {
        readData();
        sort();
        if (outputFilePath == null) {
            print(true);
        } else {
            outputNumbersAndCountToFile();
        }
    }

    @Override
    void readFromScanner(Scanner scanner) {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.printf("\"%s\" is not an integer. It will be skipped.%n", input);
                }
            }
        }
        scanner.close();
    }

    private void sort() {
        for (int num : numbers) {
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> sortByCountComparator = (entry1, entry2) -> {
            int count1 = entry1.getValue();
            int count2 = entry2.getValue();

            if (count1 == count2) {
                return entry1.getKey() - entry2.getKey();
            }

            return count1 - count2;
        };

        List<Map.Entry<Integer, Integer>> numbersFromMap = new ArrayList<>(countMap.entrySet());
        numbersFromMap.sort(sortByCountComparator);

        countMap.clear();
        for (Map.Entry<Integer,Integer> entry: numbersFromMap) {
            countMap.put(entry.getKey(), entry.getValue());
        }
    }

    private void print(Boolean includeCount) {
        System.out.printf("Total numbers: %d.%n", numbers.size());

        if (includeCount) {
            countMap.forEach((num, count) -> {
                System.out.print(num + ": ");
                System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ numbers.size());
            });
        } else {
            System.out.print("Sorted data:");
            numbers.forEach(num -> System.out.print(num + " "));
        }
    }

    private void outputNumbersToFile() {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(outputFilePath))) {
            // Redirect standard output to the file
            System.setOut(printStream);
            System.out.printf("Total numbers: %d.%n", numbers.size());
            System.out.print("Sorted data:");
            numbers.forEach(num -> System.out.print(num + " "));

        } catch (IOException e) {
            // Handle IO exception
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private void outputNumbersAndCountToFile() {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(outputFilePath))) {
            System.setOut(printStream);

            System.out.printf("Total numbers: %d.%n", numbers.size());
            countMap.forEach((num, count) -> {
                System.out.print(num + ": ");
                System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ numbers.size());
            });
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
