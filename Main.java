package sorting;

import sorting.data.*;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        DataType dataToSort = ParseArgs.parseArgs(args);
        String sortType = ParseArgs.getSorter();

        switch(sortType) {
            case "natural": dataToSort.naturalSort;
            case "byCount": dataToSort.sortByCount;
        }
    }
}
