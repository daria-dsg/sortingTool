package sorting;

import sorting.data.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ParseArgs {

    private static String sorter = "natural";
    private static String dataType = "word";

    private static final Set<String> knownArguments = new HashSet<>(Arrays.asList(
            "-sortingType", "-dataType", "line", "word", "integer", "long", "natural", "byCount"
    ));

    public static void parseArgs(String[] args) {
        int i = 0;

        while (i < args.length) {
            try {
                String argument = args[i];
                if ("-sortingType".equals(argument)) {
                    checkSorterType(args[i+1]);
                    sorter = args[i + 1];
                    i += 2;
                } else if ("-dataType".equals(argument)) {
                    checkDataType(args[i + 1]);
                    dataType = args[i+1];
                    i += 2;
                } else if(!knownArguments.contains(argument)) {
                    System.out.println("\"" + argument + "\" is not a valid parameter. It will be skipped.");
                    i++;
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                break;
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
            default -> new Word();
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
