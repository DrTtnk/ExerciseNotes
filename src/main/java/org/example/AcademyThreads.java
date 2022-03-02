package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;

    ReentrantLock lock = new ReentrantLock();

    int getCount() {
        return count;
    }

    void add(int value) {
        lock.lock();
        try {
            count += value;
        } finally {
            lock.unlock();
        }
    }
}

public class AcademyThreads {

    public static void main(String[] args) throws InterruptedException {
        var queue = new ArrayBlockingQueue<>(10);

        Runnable producer = () -> {
            while(true){
                try {
                    var value = Math.random();
                    System.out.println("I'm producing: " + value);
                    queue.put(value);
                } catch (InterruptedException e) { }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("I'm consuming: " + queue.take());
                } catch (InterruptedException e) {}
            }
        };

        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
