package sorting.data;

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

    void readData() {
        if (inputFilePath == null) {
            readFromTerminal();
        } else {
            readFromFile();
        }
    }

    private void readFromTerminal() {
        readFromScanner(scannerFromTerminal);
    }

    private void readFromFile() {
        readFromScanner(scannerFromFile);
    }
}
