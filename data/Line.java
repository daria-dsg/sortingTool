package sorting.data;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Line extends Sorter {

    private final List<String> lines = new ArrayList<>();

    private final LinkedHashMap<String, Integer>  countMap= new LinkedHashMap<>();

    public Line(String filePath) { super(filePath); }

    public Line() { super();}

    @Override
    public void naturalSort() {
        read();
        Collections.sort(lines);
        printLines();
    }

    @Override
    public void sortByCount() {
        read();
        sort();
        printLinesAndCount();
    }

    void readFromTerminal() {
        String input;

        while (scannerFromTerminal.hasNextLine()) {
            input = scannerFromTerminal.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            } else {
                lines.add(input);
            }
        }

        scannerFromTerminal.close();
    }

    void readFromFile() {
        String input;

        while (scannerFromFile.hasNextLine()) {
            input = scannerFromFile.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            } else {
                lines.add(input);
            }
        }

        scannerFromFile.close();
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

    private void printLinesAndCount() {
        System.out.printf("Total lines: %d.%n", lines.size());
        countMap.forEach((line, count) -> {
            System.out.print(line + ": ");
            System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ lines.size());
        });
    }

    private void printLines() {
        System.out.printf("Total lines: %d.%n", lines.size());
        lines.forEach(System.out::println);
    }
}
