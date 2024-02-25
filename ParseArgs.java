package sorting;

import sorting.data.*;

public class ParseArgs {

    private static String sorter;
    private static String dataType;

    public static void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++ ) {
            if ("-sortingType".equals(args[i])) {
                checkSorterType(args[i+1]);
                sorter = args[i + 1];
            } else if ("-dataType".equals(args[i])) {
                checkDataType(args[i]);
                dataType = args[i+1];
            }
        }
    }

    public static String getSorter() {
        return sorter;
    }

    public static Sorter getDataType() {
        return switch (dataType) {
            case "long" -> new Longs();
            case "line" -> new Line();
            case "integer" -> new Integers();
            case "word" -> new Word();
            default -> null;
        };
    }

    private static void checkDataType(String str) {
        if(!str.equals("line") && !str.equals("word") && !str.equals("integer") && !str.equals("long")) {
            throw new IllegalStateException("No data type defined!");
        }
    }

    private static void checkSorterType(String str) {
        if(!str.equals("natural") && !str.equals("byCount") ) {
            throw new IllegalStateException("No sorting type defined!");
        }
    }
}
