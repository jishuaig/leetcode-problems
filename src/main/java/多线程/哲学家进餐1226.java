package 多线程;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class 哲学家进餐1226 {

    public 哲学家进餐1226() {

    }

    private ReentrantLock[] locks = new ReentrantLock[5]; // 表示五根筷子
    private Semaphore semaphore = new Semaphore(3); // 同一时间只允许三个人去抢筷子，可保证不会出现死锁

    // call the run() method of any runnable to execute its code
    public void wantsToEat1(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;    //左边的叉子 的编号
        int rightFork = philosopher;    //右边的叉子 的编号
        semaphore.acquire();    //限制的人数 -1
        locks[leftFork].lock();    //拿起左边的叉子
        locks[rightFork].lock();    //拿起右边的叉子
        pickLeftFork.run();    //拿起左边的叉子 的具体执行
        pickRightFork.run();    //拿起右边的叉子 的具体执行
        eat.run();    //吃意大利面 的具体执行
        putLeftFork.run();    //放下左边的叉子 的具体执行
        putRightFork.run();    //放下右边的叉子 的具体执行
        locks[leftFork].unlock();    //放下左边的叉子
        locks[rightFork].unlock();    //放下右边的叉子
        semaphore.release();//限制的人数 +1
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat2(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;    //左边的叉子 的编号
        int rightFork = philosopher;    //右边的叉子 的编号

        //编号为偶数的哲学家，优先拿起左边的叉子，再拿起右边的叉子
        if (philosopher % 2 == 0) {
            locks[leftFork].lock();    //拿起左边的叉子
            locks[rightFork].lock();    //拿起右边的叉子
        }
        //编号为奇数的哲学家，优先拿起右边的叉子，再拿起左边的叉子
        else {
            locks[rightFork].lock();    //拿起右边的叉子
            locks[leftFork].lock();    //拿起左边的叉子
        }
        pickLeftFork.run();    //拿起左边的叉子 的具体执行
        pickRightFork.run();    //拿起右边的叉子 的具体执行
        eat.run();    //吃意大利面 的具体执行
        putLeftFork.run();    //放下左边的叉子 的具体执行
        putRightFork.run();    //放下右边的叉子 的具体执行
        locks[leftFork].unlock();    //放下左边的叉子
        locks[rightFork].unlock();    //放下右边的叉子
    }

}
