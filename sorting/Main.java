package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String dataType = args.length == 0 ? "word" : args[1];
        SortingTool sortingTool = new SortingTool(dataType);
        sortingTool.proceedData();
    }
}
