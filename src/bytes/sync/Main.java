package bytes.sync;

import bytes.threading.Deadlock;
import bytes.threading.PrintSequentially;

public class Main {

    public static void main(String[] args) {

        PrintSequentially printSequentially = new PrintSequentially();
        printSequentially.start();

    }
}
