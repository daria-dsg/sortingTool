package sorting.data;

import java.util.*;

public class Word extends Sorter {

    private final List<String> words = new ArrayList<>();

    private final LinkedHashMap<String, Integer> countMap = new LinkedHashMap<>();

    public Word(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public void naturalSort() {
        readData();
        Collections.sort(words);
        outputData(false);
    }

    @Override
    public void sortByCount() {
        readData();
        sort();
        outputData(true);
    }

    @Override
    void readFromScanner(Scanner scanner ) {
        while (scanner.hasNext()) {
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                break;
            } else {
                words.add(input);
            }
        }
    }

    private void sort() {
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> sortByCountComparator = (entry1, entry2) -> {
            int count1 = entry1.getValue();
            int count2 = entry2.getValue();

            if (count1 == count2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }

            return count1 - count2;
        };

        List<Map.Entry<String,Integer>> wordsFromMap = new ArrayList<>(countMap.entrySet());
        wordsFromMap.sort(sortByCountComparator);

        countMap.clear();
        for (Map.Entry<String,Integer> entry : wordsFromMap) {
            countMap.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    void print(Boolean includeCount) {
        System.out.printf("Total words: %d.%n", words.size());

        if (includeCount) {
            countMap.forEach((word, count) -> {
                System.out.print(word + ": ");
                System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ words.size());
            });
        } else {
            System.out.println("Sorted data: ");
            words.forEach(word -> System.out.print(word + " "));
        }
    }
}
