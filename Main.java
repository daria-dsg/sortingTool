package sorting;

import sorting.data.*;

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
        }
    }
}
