package bytes.threading;

public class Deadlock {

    private String res1 = "Resource 1";
    private String res2 = "Resource 2";


    public void testDeadlock() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Acquire res1
                synchronized (res1) {
                    System.out.println("Thread 1 acquired res1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Acquire res2
                    synchronized (res2) {
                        System.out.println("Thread 1 acquired res2");
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Acquire res1
                synchronized (res2) {
                    System.out.println("Thread 2 acquired res2");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Acquire res2
                    synchronized (res1) {
                        System.out.println("Thread 2 acquired res1");
                    }
                }
            }
        });


        t1.start();
        t2.start();

    }


}
