package bytes.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {

    public void start() {

        Buffer buffer = new Buffer();

        Thread p = new Thread(new Producer(buffer));
        Thread c = new Thread(new Consumer(buffer));

        p.start();
        c.start();

    }

}


class Producer implements Runnable {

    private Random random;
    private Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
        this.random = new Random();
    }

    @Override
    public void run() {
        while(true) {
            int n = this.random.nextInt(100);
            buffer.add(n);
            System.out.println("Adding " + n);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable {

    private Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Got from buffer: " + this.buffer.get());
        }
    }

}

class Buffer {

    private List<Integer> list = new ArrayList<>(5);
    private int MAX_SIZE = 5;

    synchronized int get() {
        if(list.isEmpty()) {
            try {
                System.out.println("List is empty, waiting on producer");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        return list.remove(list.size()-1);
    }

    synchronized void add(int n) {
        if(list.size() >= MAX_SIZE) {
            try {
                System.out.println("List is full, waiting on consumer");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        list.add(n);
    }

}

