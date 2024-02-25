package sorting;

import sorting.data.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ParseArgs {

    private static String sorter;
    private static String dataType;

    private static Set<String> knownArguments = new HashSet<>(Arrays.asList(
            "-sortingType", "-dataType", "line", "word", "integer", "long", "natural", "byCount"
    ));

    public static void parseArgs(String[] args) {
        checkUnknownArguments(args);

        for (int i = 0; i < args.length; i++ ) {
            String argument = args[i];
            if ("-sortingType".equals(argument)) {
                checkSorterType(args[i+1]);
                sorter = args[i + 1];
            } else if ("-dataType".equals(argument)) {
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

    private static void checkUnknownArguments(String[] args) {
        for (int i = 0; i < args.length; i++ ) {
            if (!knownArguments.contains(args[i])) {
                throw new IllegalArgumentException("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
            }
        }
    }
}
