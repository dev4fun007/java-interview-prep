package bytes.sync;

import bytes.threading.ProducerConsumer;


public class Main {

    public static void main(String[] args) {

        ProducerConsumer pc = new ProducerConsumer();
        pc.start();

    }
}
