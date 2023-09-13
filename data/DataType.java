package sorting.data;

import java.util.Scanner;

public abstract class DataType {
    Scanner scanner = new Scanner(System.in);
    public void proceed() {
        read();
        compute();
        print();
    }

    abstract void read();
    abstract void compute();
    abstract void print();
}



