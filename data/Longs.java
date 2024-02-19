//package sorting.data;
//
//import java.util.List;
//import java.util.Collections;
//import java.util.Scanner;
//import java.util.ArrayList;
//
//public class Longs extends Sorter {
//    private final List<Long> elements = new ArrayList<>();
//    private long maxNum;
//    private int frequency;
//
//    @Override
//    void read() {
//        System.out.println("Enter long numbers to proceed (press q to quit)");
//
//        while(scanner.hasNext()){
//            if (scanner.hasNextLong()) {
//                elements.add(scanner.nextLong());
//            } else {
//                String input = scanner.next();
//                if (input.equalsIgnoreCase("q")) {
//                    break;
//                } else {
//                    System.out.println("Input is not valid. Enter q to quit or number to sort");
//                }
//            }
//        }
//
//        scanner.close();
//    }
//
//    @Override
//    void compute() {
//        maxNum = Collections.max(elements);
//        frequency = Collections.frequency(elements, maxNum);
//    }
//
//    @Override
//    void print() {
//        System.out.printf("Total numbers: %d.%n", elements.size());
//        System.out.printf("The greatest number: %d (%d time(s), %d%%).%n", maxNum, frequency, (100 * frequency)/ elements.size());
//    }
//}
