package sorting;

import sorting.data.*;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Set;

public class ParseArgs {

    private static String sorter = "natural";
    private static String inputFilePath ;
    private static String outputFilePath;
    private static Sortable<?> dataType;

    private static final Set<String> KNOWN_ARGUMENTS = Set.of(
            "-sortingType", "-dataType", "line", "word", "integer", "long", "natural", "byCount", "-inputFile", "-outputFile"
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
                    checkAndSetInputFilePath(args, i);
                    i++;
                } else if ("-outputFile".equals(argument)) {
                    checkAndSetOutputFilePath(args, i);
                    i++;
                }
                else if (!KNOWN_ARGUMENTS.contains(argument)) {
                    System.out.println("\"" + argument + "\" is not a valid parameter. It will be skipped.");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        if (dataType == null) {
            dataType = new Word(inputFilePath, outputFilePath);
        }
    }

    public static String getSorter() {
        return sorter;
    }

    public static Sortable<?> getDataType() {
        return dataType;
    }

    private static void  checkAndSetSorter(String[] args, int i){
        checkSorterType(args[i + 1]);
        sorter = args[i + 1];
    }

    private static void checkAndSetInputFilePath(String[] args, int i){
        String pathString = args[i + 1];
        try {
            Paths.get(pathString);
            inputFilePath  = pathString;
        } catch (InvalidPathException e) {
            throw new IllegalStateException("No file path defined");
        }
    }

    private static void checkAndSetOutputFilePath(String[] args, int i){
        String pathString = args[i + 1];
        try {
            Paths.get(pathString);
            outputFilePath  = pathString;
        } catch (InvalidPathException e) {
            throw new IllegalStateException("No file path defined");
        }
    }

    private static void  checkAndSetDataType(String[] args, int i){
        checkDataType(args[i + 1]);
        dataType = switch (args[i + 1]) {
            case "integer" -> new Integers(inputFilePath, outputFilePath);
            case "line" ->  new Line(inputFilePath, outputFilePath);
            case "long" ->  new Longs(inputFilePath, outputFilePath);
            default -> new Word(inputFilePath, outputFilePath);
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
