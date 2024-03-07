package sorting.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public abstract class Sortable<T extends Comparable<T>> {

    protected List<T> elements = new ArrayList<>();
    protected LinkedHashMap<T, Integer> countMap = new LinkedHashMap<>();

    protected Scanner scannerFromTerminal = new Scanner(System.in);
    protected Scanner scannerFromFile;
    protected String inputFilePath;
    protected String outputFilePath;

    protected abstract void print(Boolean includeCount);
    protected abstract void readFromScanner(Scanner scannerFromTerminal);

    public Sortable(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;

        if (inputFilePath != null) {
            scannerFromFile = new Scanner(this.inputFilePath);
        }
    }

    public void naturalSort() {
        readData();
        processNaturalSort();
        outputData(false);
    }

    public void sortByCount() {
        readData();
        processSortByCount();
        outputData(true);
    }

    private void readData() {
        if (inputFilePath == null) {
            readFromTerminal();
        } else {
            readFromFile();
        }
    }

    private void outputData(Boolean includeData) {
        if (outputFilePath == null) {
            print(includeData);
        } else {
            output(includeData);
        }
    }

    private void processNaturalSort() {
        Collections.sort(elements);
    }

    private void processSortByCount() {
        for (T ele : elements) {
            countMap.put(ele, countMap.getOrDefault(ele,0) + 1);
        }

        Comparator<Map.Entry<T, Integer>> sortByCountComparator = (entry1, entry2) -> {
            int count1 = entry1.getValue();
            int count2 = entry2.getValue();

            if (count1 == count2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }

            return count1 - count2;
        };

        List<Map.Entry<T, Integer>> elementsFromMap = new ArrayList<>(countMap.entrySet());
        elementsFromMap.sort(sortByCountComparator);

        countMap.clear();
        for (Map.Entry<T,Integer> entry: elementsFromMap) {
            countMap.put(entry.getKey(), entry.getValue());
        }
    }

    private void readFromTerminal() {
        readFromScanner(scannerFromTerminal);
    }

    private void readFromFile() {
        readFromScanner(scannerFromFile);
    }

    private void output(Boolean includeCount) {
        try {
            // Redirect standard output to the file
            PrintStream printStream = new PrintStream(new FileOutputStream(outputFilePath));
            System.setOut(printStream);
            print(includeCount);
        } catch (IOException e) {
            // Handle IO exception
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
