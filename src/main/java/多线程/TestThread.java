package 多线程;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    public static void testCountDownLatch() throws Exception {
        final CountDownLatch latch = new CountDownLatch(10);
        new Thread(() -> {
            try {
                System.out.println("main blocked!");
                latch.await();
                System.out.println("main blocked!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                latch.countDown();
                System.out.println("sub thread executed!");
            }).start();
        }

        System.out.println("all executed!");
    }

    public static void testSemaphore() throws Exception {
        final Semaphore semaphore = new Semaphore(-8);
        new Thread(() -> {
            try {
                System.out.println("main blocked!");
                System.out.println(semaphore.availablePermits());
                semaphore.acquire();
                System.out.println("main blocked!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                semaphore.release();
                System.out.println("sub thread executed!");
            }).start();
        }
        System.out.println("all executed!");
    }

    public static void main(String[] args) throws Exception {
        testCountDownLatch();
    }
}
