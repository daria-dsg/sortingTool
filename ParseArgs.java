package sorting;

import sorting.data.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ParseArgs {

    private static String sorter = "natural";
    private static Sorter dataType = new Word();

    private static final Set<String> knownArguments = new HashSet<>(Arrays.asList(
            "-sortingType", "-dataType", "line", "word", "integer", "long", "natural", "byCount"
    ));

    public static void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String argument = args[i];
            try {
                if ("-sortingType".equals(argument)) {
                    checkAndSetSorter(args, i);
                    i++;
                } else if ("-dataType".equals(argument)) {
                    checkAndSetDataType(args, i);
                    i++;
                } else if (!knownArguments.contains(argument)) {
                    System.out.println("\"" + argument + "\" is not a valid parameter. It will be skipped.");
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
        return dataType;
    }

    private static void  checkAndSetSorter(String[] args, int i){
        checkSorterType(args[i + 1]);
        sorter = args[i + 1];
    }

    private static void  checkAndSetDataType(String[] args, int i){
        checkDataType(args[i + 1]);
        dataType = switch (args[i + 1]) {
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
