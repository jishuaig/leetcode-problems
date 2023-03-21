package 多线程;
import java.util.function.IntConsumer;

public class 交替打印字符串1195 {

    private int n;

    private volatile int index = 1;

    public 交替打印字符串1195(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (index <= n) {
            synchronized (this) {
                if (index % 3 == 0 && index % 5 != 0) {
                    printFizz.run();
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (index <= n) {
            synchronized (this) {
                if (index % 5 == 0 && index % 3 != 0) {
                    printBuzz.run();
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (index <= n) {
            synchronized (this) {
                if (index % 3 == 0 && index % 5 == 0) {
                    printFizzBuzz.run();
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            synchronized (this) {
                if (index % 3 != 0 && index % 5 != 0) {
                    printNumber.accept(index);
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

}
