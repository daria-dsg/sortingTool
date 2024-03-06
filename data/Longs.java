package sorting.data;

import java.util.*;

public class Longs extends Sorter {

    private final List<Long> longs = new ArrayList<>();

    private final Map<Long,Integer> countMap = new LinkedHashMap<>();

    public Longs(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public void naturalSort() {
        readData();
        Collections.sort(longs);
        outputData(false);
    }

    @Override
    public void sortByCount() {
        readData();
        sort();
        outputData(true);
    }

    @Override
    void readFromScanner(Scanner scanner) {
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


    @Override
    void print(Boolean includeCount) {
        System.out.printf("Total numbers: %d.%n", longs.size());
        if (includeCount) {
            countMap.forEach((num, count) -> {
                System.out.print(num + ": ");
                System.out.printf("%d time(s), %d%%.%n",count , (100 * count)/ longs.size());
            });
        } else {
            System.out.print("Sorted data:");
            longs.forEach(num -> System.out.print(num + " "));
        }
    }
}
