package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number ;
        ArrayList<Long> nums = new ArrayList<>();

        while (scanner.hasNextLong()) {
             number = scanner.nextLong();
             nums.add(number);
        }

        long max = Collections.max(nums);
        long times = Collections.frequency(nums, max);
        System.out.printf("Total numbers: %d.%n", nums.size());
        System.out.printf("The greatest number: %d (%d time(s)).%n", max, times);
    }
}
