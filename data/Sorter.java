package sorting.data;

import java.util.Scanner;

public abstract class  Sorter {
    Scanner scannerFromTerminal = new Scanner(System.in);
    Scanner scannerFromFile;
    Boolean isFile;

    public Sorter() {
        isFile = false;
    }

    public Sorter(String filePath) {
        scannerFromFile = new Scanner(filePath);
        isFile = true;
    }

    public abstract void naturalSort();

    public abstract void sortByCount();

    abstract void readFromTerminal();
    abstract void readFromFile();

    void read() {
        if (isFile) {
            readFromFile();
        } else {
            readFromTerminal();
        }
    }
}
