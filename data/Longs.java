package sorting.data;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Longs implements Sorter {
    private final List<Long> longs = new ArrayList<>();

    private final Map<Long,Integer> countMap = new LinkedHashMap<>();

    @Override
    public void naturalSort() {
        read();
        Collections.sort(longs);
        printLongs();
    }

    @Override
    public void sortByCount() {
        read();
        sort();
        printLongsAndCount();
    }

    private void read() {
        while(scanner.hasNext()){
            if (scanner.hasNextLong()) {
                longs.add(scanner.nextLong());
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

        List<Map.Entry<Long, Integer>> longsFromMap = new ArrayList<>(countMap.entrySet());
        longsFromMap.sort(sortByCountComparator);

        countMap.clear();
        for (Map.Entry<Long,Integer> entry: longsFromMap) {
            countMap.put(entry.getKey(), entry.getValue());
        }
    }

    private void printLongs() {
        System.out.printf("Total numbers: %d.%n", longs.size());
        System.out.print("Sorted data:");
        longs.forEach(num -> System.out.print(num + " "));
    }

    private void printLongsAndCount() {
        System.out.printf("Total numbers: %d.%n", longs.size());
        countMap.forEach((num, count) -> {
            System.out.print(num + ": ");
            System.out.printf("%d time(s), %d%%.%n",count , (100 * count)/ longs.size());
        });
    }
}
