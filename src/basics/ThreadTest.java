package basics;

import basics.model.Olive;

public class ThreadTest extends Thread {

    int threadId;
    Olive o = new Olive();

    public ThreadTest(int threadId, Olive ol) {
        this.threadId = threadId;
        this.o = ol;
    }

    @Override
    public void run() {

        synchronized (o) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread is functional");
                    sleep(2000);
                    o.call(threadId);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
