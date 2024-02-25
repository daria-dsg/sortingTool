package sorting.data;

import java.util.*;

public class Line implements Sorter {
    private String longestLine;
    private final List<String> lines = new ArrayList<>();
    private int frequency;

    private final LinkedHashMap<String, Integer>  countMap= new LinkedHashMap<>();

    @Override
    public void naturalSort() {
        read();
        Collections.sort(lines);
        printLines();
    }

    @Override
    public void sortByCount() {
        read();
        sortingByCount();
    }

    private void read() {
        String input;

        System.out.println("Enter lines to proceed (press q to quit)");

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

    private void sortingByCount() {
        for (String line : lines) {
            countMap.put(line, countMap.getOrDefault(line, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> sortByCountComparator = (entry1, entry2) -> {
            int count1 = entry1.getValue();
            int count2 = entry2.getValue();

            if (count1 == count2) {
                return 0;
            }

            return count1 - count2;
        };

        List<Map.Entry<String,Integer>> linesFromMap = new ArrayList<>(countMap.entrySet());
        Collections.sort(linesFromMap, sortByCountComparator);

        countMap.clear();
        for (Map.Entry<String,Integer> entry : linesFromMap) {
            countMap.put(entry.getKey(), entry.getValue());
        }
    }

    private void compute() {
        longestLine = Collections.max(lines, Comparator.comparing(String::length));
        frequency = Collections.frequency(lines, longestLine);
    }

//    private void printLines() {
//        System.out.printf("Total lines: %d.%n", lines.size());
//        System.out.println("The longest line: ");
//        System.out.println(longestLine);
//        System.out.printf("(%d time(s), %d%%).%n ", frequency, (100 * frequency)/ lines.size() );
//    }

    private void printLines() {
        System.out.printf("Total lines: %d.%n", lines.size());
        lines.forEach(line -> System.out.println(line));
    }
}
