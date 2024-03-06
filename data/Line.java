package sorting.data;

import java.util.*;

public class Line extends Sorter {

    private final List<String> lines = new ArrayList<>();

    private final LinkedHashMap<String, Integer>  countMap= new LinkedHashMap<>();

    public Line(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public void naturalSort() {
        readData();
        Collections.sort(lines);
        print(false);
    }

    @Override
    public void sortByCount() {
        readData();
        sort();
        print(true);
    }

    void readFromScanner(Scanner scanner) {
        String input;

        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            } else {
                lines.add(input);
            }
        }

        scanner.close();
    }

    private void sort() {
        for (String line : lines) {
            countMap.put(line, countMap.getOrDefault(line, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> sortByCountComparator = (entry1, entry2) -> {
            int count1 = entry1.getValue();
            int count2 = entry2.getValue();

            if (count1 == count2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }

            return count1 - count2;
        };

        List<Map.Entry<String,Integer>> linesFromMap = new ArrayList<>(countMap.entrySet());
        linesFromMap.sort(sortByCountComparator);

        countMap.clear();
        for (Map.Entry<String,Integer> entry : linesFromMap) {
            countMap.put(entry.getKey(), entry.getValue());
        }
    }

    private void print(Boolean includeCount) {
        System.out.printf("Total lines: %d.%n", lines.size());
        if (includeCount) {
            countMap.forEach((line, count) -> {
                System.out.print(line + ": ");
                System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ lines.size());
            });
        } else {
            lines.forEach(System.out::println);
        }
    }
}
