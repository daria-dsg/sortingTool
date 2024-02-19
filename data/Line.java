//package sorting.data;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Line implements Sorter {
//    private String longestLine;
//    private final List<String> lines = new ArrayList<>();
//    private int frequency;
//
//    @Override
//    public void naturalSort() {
//        read();
//        Collections.sort(lines);
//        printLines();
//    }
//
//    private void read() {
//        String input;
//
//        System.out.println("Enter lines to proceed (press q to quit)");
//
//        while (scanner.hasNextLine()) {
//            input = scanner.nextLine();
//            if (input.equalsIgnoreCase("q")) {
//                break;
//            } else {
//                lines.add(input);
//            }
//        }
//
//        scanner.close();
//    }
//
//
//    void compute() {
//        longestLine = Collections.max(lines, Comparator.comparing(String::length));
//        frequency = Collections.frequency(lines, longestLine);
//    }
//
//    private void printLines() {
//        System.out.printf("Total lines: %d.%n", lines.size());
//        System.out.println("The longest line: ");
//        System.out.println(longestLine);
//        System.out.printf("(%d time(s), %d%%).%n ", frequency, (100 * frequency)/ list.size() );
//    }
//}
