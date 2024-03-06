package sorting.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class  Sorter {
    Scanner scannerFromTerminal = new Scanner(System.in);
    Scanner scannerFromFile;
    String inputFilePath;
    String outputFilePath;

    public Sorter(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;

        if (outputFilePath != null) {
            scannerFromFile = new Scanner(this.inputFilePath);
        }
    }

    public abstract void naturalSort();

    public abstract void sortByCount();

    abstract void readFromScanner(Scanner scannerFromTerminal);

    abstract void print(Boolean includeCount);

    void readData() {
        if (inputFilePath == null) {
            readFromTerminal();
        } else {
            readFromFile();
        }
    }

    void outputData(Boolean includeData) {
        if (outputFilePath == null) {
            print(includeData);
        } else {
            output(includeData);
        }
    }

    private void readFromTerminal() {
        readFromScanner(scannerFromTerminal);
    }

    private void readFromFile() {
        readFromScanner(scannerFromFile);
    }

    private void output(Boolean includeCount) {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(outputFilePath))) {
            // Redirect standard output to the file
            System.setOut(printStream);
            print(includeCount);
        } catch (IOException e) {
            // Handle IO exception
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
