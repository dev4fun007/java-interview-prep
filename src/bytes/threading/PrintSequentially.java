package bytes.threading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class PrintSequentially {

    private final Object lock = new Object();
    private AtomicInteger count = new AtomicInteger(0);

    public void start() {
        Thread t0 = new Thread(new T(0, 3));
        Thread t1 = new Thread(new T(1, 3));
        Thread t2 = new Thread(new T(2, 3));

        t0.start();
        t1.start();
        t2.start();
    }


    class T implements Runnable {

        int id;
        int totalThread;

        T(int id, int totalThread) {
            this.id = id;
            this.totalThread = totalThread;
        }

        @Override
        public void run() {
            while(count.get() < 20) {
                try{
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    if (count.get() % this.totalThread != this.id) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : " + count.getAndIncrement());
                        lock.notifyAll();
                    }
                }
            }
        }
    }

}

