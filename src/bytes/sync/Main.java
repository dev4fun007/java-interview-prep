package bytes.sync;

import bytes.threading.Deadlock;
import bytes.threading.PrintSequentially;
import bytes.threading.ProducerConsumer;

public class Main {

    public static void main(String[] args) {

        ProducerConsumer pc = new ProducerConsumer();
        pc.start();

    }
}
