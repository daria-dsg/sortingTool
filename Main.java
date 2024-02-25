package sorting;

import sorting.data.*;

import java.lang.reflect.Parameter;

public class Main {
    public static void main(final String[] args) {
        ParseArgs.parseArgs(args);

        Sorter dataToSort = ParseArgs.getDataType();
        String sortType = ParseArgs.getSorter();

        switch(sortType) {
            case "natural":
                dataToSort.naturalSort();
                break;
            case "byCount":
                dataToSort.sortByCount();
                break;
            default: throw new IllegalArgumentException("No sorting type defined!");
        }
    }
}
