package sorting;

import sorting.data.*;

public class ParseArgs {

    private static String sorter = "natural";

    public static Sorter parseArgs(String[] args) {
        String dataTypeInput = "";

        for (int i = 0; i < args.length; i++ ) {
            if ("-sortingType".equals(args[i])) {
                checkSortingType(args[i+1]);
                sorter = args[i + 1];
            } else if ("-dataType".equals(args[i])) {
                dataTypeInput = args[i + 1];
            }
        }

        return parseDataType(dataTypeInput);
    }

    public static String getSorter() {
        return sorter;
    }

    private static Sorter parseDataType(String input) {
        return switch (input) {
            case "long" -> new Longs();
            case "line" -> new Line();
            case "integer" -> new Integers();
            case "word" -> new Word();
            default -> throw new IllegalStateException("No data type defined!");
        };
    }

    private static void checkSortingType(String str) {
        if (!str.equals("natural") || !str.equals("sortByCount")) {
            throw new IllegalArgumentException("No sorting type defined!");
        }
    }
}
