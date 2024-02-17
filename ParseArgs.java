package sorting;

import sorting.data.Integers;
import sorting.data.Line;
import sorting.data.Longs;
import sorting.data.Word;
import sorting.data.DataType;

public class ParseArgs {

    private static String sorter;

    public static DataType parseArgs(String[] args) {
        String dataTypeInput = "";
        String sorter;

        for (int i = 0; i < args.length; i++ ) {
            if ("-sortingType".equals(args[i])) {
                sorter = args[i + 1];
            } else if ("-dataType".equals(args[i])) {
                dataTypeInput = args[i + 1];
            } else {
                sorter = "natural";
            }
        }

        return parseDataType(dataTypeInput);
    }

    public static String getSorter() {
        return sorter;
    }

    private static DataType parseDataType(String input) {
        switch(input) {
            case "long": return new Longs();
            case "line": return new Line();
            case "integer": return new Integers();
            default: return new Word();
        }
    }
}
