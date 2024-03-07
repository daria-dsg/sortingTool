package sorting;

import sorting.data.*;

public class Main {
    public static void main(final String[] args) {
        ParseArgs.parseArgs(args);

        Sortable dataToSort = ParseArgs.getDataType();
        String sortType = ParseArgs.getSorter();

        switch(sortType) {
            case "byCount":
                dataToSort.sortByCount();
                break;
            case "natural":
                dataToSort.naturalSort();
                break;
        }
    }
}
