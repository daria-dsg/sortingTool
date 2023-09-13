package sorting;
import sorting.data.*;

public class SortingTool {
    private String dataType;
    SortingTool(String dataType) {
        this.dataType = dataType;
    }

    public void proceedData() {
        switch(dataType) {
            case "long":
                new Longs().proceed();
                break;
            case "line":
                new Line().proceed();
                break;
            case "word":
                new Word().proceed();
                break;
            case "-sortIntegers":
                new Integers().proceed();
                break;
        }
    }
}
