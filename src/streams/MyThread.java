package streams;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread {

    String text;

    public MyThread(String text) {
        this.text = text;
    }

    boolean ready = false;

    ReentrantLock lock = new ReentrantLock();


    public synchronized void foo() {
        lock.lock();
        while(!ready) {
            System.out.println("hi");
            System.out.println("---------------");
        }
        lock.unlock();
    }

    public synchronized void foo2() {

        System.out.println("hello");
    }
}
