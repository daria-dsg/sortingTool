package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String dataType = "word";

        for (String str : args) {
            if (str == "-sortIntegers") {
                dataType = "-sortIntegers";
                break;
            } else {
                dataType = str;
            }
        }

        SortingTool sortingTool = new SortingTool(dataType);
        sortingTool.proceedData();
    }
}
