package sorting.data;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Integers implements Sorter {

    private final List<Integer> numbers = new ArrayList<>();
    private final  LinkedHashMap<Integer,Integer> countMap = new LinkedHashMap<>();

    @Override
    public void naturalSort() {
        read();
        Collections.sort(numbers);
        printNumbers();
    }

    @Override
    public void sortByCount() {
        read();
        sort();
        printNumbersAndCount();
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

    private void read() {
        System.out.println("Enter numbers to sort (press q to quit)");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
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

    private void printNumbers() {
        System.out.printf("Total numbers: %d.%n", numbers.size());
        System.out.print("Sorted data:");
        numbers.forEach(num -> {
            System.out.print(num);
            System.out.print(" ");
        });
    }

    private void printNumbersAndCount() {
        System.out.printf("Total numbers: %d.%n", numbers.size());
        countMap.forEach((num, count) -> {
            System.out.print(num + ": ");
            System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ numbers.size());
        });
    }
}
