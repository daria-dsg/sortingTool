//package sorting.data;
//import java.util.*;
//
//public class Word extends Sorter {
//    private final List<String> words = new ArrayList<>();
//    private String longestWord;
//    private int frequency;
//    void read() {
//        String word;
//        System.out.println("Enter words to proceed (press q to quit)");
//
//        while (scanner.hasNext()) {
//            String input = scanner.next();
//
//            if (input.equalsIgnoreCase("q")) {
//                break;
//            } else {
//                words.add(input);
//            }
//        }
//    }
//
//    @Override
//   void compute() {
//        longestWord = Collections.max(words, Comparator.comparing(String::length));
//        frequency = Collections.frequency(words, longestWord);
//    }
//
//    @Override
//    void print() {
//        System.out.printf("Total word:: %d.%n", words.size());
//        System.out.printf("The longest word: %s (%d time(s), %d%%).%n", longestWord, frequency, (100 * frequency)/ words.size());
//    }
//}
