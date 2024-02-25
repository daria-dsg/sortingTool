package sorting;

import sorting.data.*;

public class ParseArgs {

    private static String sorter;
    private static String dataType;

    public static void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++ ) {
            if ("-sortingType".equals(args[i])) {
                sorter = args[i + 1];
            } else if ("-dataType".equals(args[i])) {
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
            default -> throw new IllegalStateException("No data type defined!");
        };
    }
}
