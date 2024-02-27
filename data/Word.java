package sorting.data;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Word implements Sorter {
    private final List<String> words = new ArrayList<>();
    private final LinkedHashMap<String, Integer> countMap = new LinkedHashMap<>();

    @Override
    public void naturalSort() {
        read();
        Collections.sort(words);
        printWords();
    }

    @Override
    public void sortByCount() {
        read();
        sort();
        printWordsAndCount();
    }

    private void read() {
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

    private void printWords() {
        System.out.printf("Total words: %d.%n", words.size());
        System.out.println("Sorted data: ");
        words.forEach(word -> System.out.print(word + " "));
    }

    private void printWordsAndCount() {
        System.out.printf("Total words: %d.%n", words.size());
        countMap.forEach((word, count) -> {
            System.out.print(word + ": ");
            System.out.printf("(%d time(s), %d%%).%n",count , (100 * count)/ words.size());
        });
    }

}
