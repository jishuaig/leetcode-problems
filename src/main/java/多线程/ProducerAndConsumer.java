package 多线程;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {

    private static final Lock lock = new ReentrantLock(true);
    private static Condition empty = lock.newCondition();
    private static Condition full = lock.newCondition();

    static class ProducerTask2 implements Runnable {
        private volatile int count = 0;
        private LinkedList<Integer> list;


        public ProducerTask2(LinkedList<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (list.size() >= 10) {
                        System.out.println(Thread.currentThread().getName() +
                                " Producer : list is full!");
                        full.await();
                    }
                    list.add(count);
                    System.out.println(Thread.currentThread().getName() +
                            " producer produce " + count++);
                    empty.signalAll();
                } catch (Exception e) {
                    lock.unlock();
                }
            }
        }

    }

    static class ConsumerTask2 implements Runnable {
        private LinkedList<Integer> list;


        public ConsumerTask2(LinkedList<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (list.size() == 0) {
                        System.out.println(Thread.currentThread().getName() + " Consumer : list is empty!");
                        empty.await();
                    }
                    int c = list.remove(0);
                    System.out.println(Thread.currentThread().getName() +
                            " Consumer consume " + c);
                    full.signalAll();
                } catch (Exception e) {
                    lock.unlock();
                }
            }
        }

    }

    static class ProducerTask implements Runnable {

        private volatile int count = 0;
        private LinkedList<Integer> list;

        public ProducerTask(LinkedList<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            synchronized (list) {
                for (int i = 0; i < 100; i++) {
                    while (list.size() >= 10) {
                        try {
                            System.out.println("Producer : list is full!");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(count);
                    System.out.println("producer produce " + count++);
                    list.notifyAll();
                }
            }
        }
    }

    static class ConsumerTask implements Runnable {
        private LinkedList<Integer> list;

        public ConsumerTask(LinkedList<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            synchronized (list) {
                for (int i = 0; i < 100; i++) {
                    while (list.size() == 0) {
                        try {
                            System.out.println("Consumer : list is empty!");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int c = list.poll();
                    System.out.println("Consumer consume " + c);
                    list.notifyAll();
                }
            }
        }
    }


    public static void main(String[] args) {
        final LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            new Thread(new ProducerTask2(list)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new ConsumerTask2(list)).start();
        }
    }

}
