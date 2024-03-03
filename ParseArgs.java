package sorting;

import sorting.data.*;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Set;

public class ParseArgs {

    private static String sorter = "natural";
    private static Sorter dataType;

    private static String filePath;
    private static boolean isFile = false;

    private static final Set<String> KNOWN_ARGUMENTS = Set.of(
            "-sortingType", "-dataType", "line", "word", "integer", "long", "natural", "byCount", "-inputFile"
    );

    private static final Set<String> VALID_SORTER_TYPES = Set.of("natural", "byCount");
    private static final Set<String> VALID_DATA_TYPES = Set.of("line", "word", "integer", "long");

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
                } else if ("-inputFile".equals(argument)) {
                    checkAndSetFilePath(args, i);
                    i++;
                } else if (!KNOWN_ARGUMENTS.contains(argument)) {
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

    private static void checkAndSetFilePath(String[] args, int i){
        String pathString = args[i + 1];
        try {
            Paths.get(pathString);
            filePath  = pathString;
            isFile = true;
        } catch (InvalidPathException e) {
            throw new IllegalStateException("No file path defined");
        }
    }

    private static void  checkAndSetDataType(String[] args, int i){
        checkDataType(args[i + 1]);
        dataType = switch (args[i + 1]) {
            case "integer" ->
                    isFile ? new Integers(filePath) : new Integers();
            case "line" ->
                    isFile ? new Line(filePath) : new Line();
            case "long" ->
                    isFile ? new Longs(filePath) : new Longs();
            case "word" ->
                    isFile ? new Word(filePath) : new Word();
            default -> new Word();
        };
    }

    private static void checkDataType(String str) {
        if(!VALID_DATA_TYPES.contains(str)) {
            throw new IllegalStateException("No data type defined!");
        }
    }

    private static void checkSorterType(String str) {
        if(!VALID_SORTER_TYPES.contains(str)) {
            throw new IllegalStateException("No sorting type defined!");
        }
    }
}
