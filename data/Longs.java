package sorting.data;

import java.util.*;

public class Longs implements Sorter {
    private final List<Long> longs = new ArrayList<>();

    private final Map<Long,Integer> countMap = new LinkedHashMap<>();

    @Override
    public void naturalSort() {
        read();
        Collections.sort(longs);
        printNumbers();
    }

    @Override
    public void sortByCount() {
        read();
        sort();
        printNumbersAndCount();
    }

    private void read() {
//        System.out.println("Enter long numbers to proceed (press q to quit)");

        while(scanner.hasNext()){
            if (scanner.hasNextLong()) {
                longs.add(scanner.nextLong());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Input is not valid. Enter q to quit or number to sort");
                }
            }
        }
    }

    private void sort() {
        for (long num  : longs) {
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }

        Comparator<Map.Entry<Long, Integer>> sortByCountComparator = (entry1, entry2) -> {
            int count1 = entry1.getValue();
            int count2 = entry2.getValue();

            if (count1 == count2) {
                return Math.toIntExact(entry1.getKey() - entry2.getKey());
            }

            return count1 - count2;
        };

        List<Map.Entry<Long, Integer>> numbersFromMap = new ArrayList<>(countMap.entrySet());
        Collections.sort(numbersFromMap, sortByCountComparator);

        countMap.clear();
        for (Map.Entry<Long,Integer> entry: numbersFromMap) {
            countMap.put(entry.getKey(), entry.getValue());
        }
    }

    private void printNumbers() {
        System.out.printf("Total numbers: %d.%n", longs.size());
        System.out.print("Sorted data:");
        longs.forEach(num -> {
            System.out.print(num);
            System.out.print(" ");
        });
        System.out.println();
    }

    private void printNumbersAndCount() {
        System.out.printf("Total numbers: %d.%n", longs.size());
        countMap.forEach((num, count) -> {
            System.out.print(num + ": ");
            System.out.printf("%d time(s), %d%%.%n",count , (100 * count)/ longs.size());
        });
    }
}
