package lock;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static sun.swing.SwingUtilities2.submit;

/**
 * User: 86131
 * Date: 2019/9/24
 * <p>
 * 不公平锁
 * zhuguopei
 */
public class NonFairLockDemo {

    private ReentrantLock nonFairLock = new ReentrantLock(false);

    public static void main(String[] args) {


        final NonFairLockDemo nonFairLockDemo = new NonFairLockDemo();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 6; i++) {

            executorService.execute(() -> {
                System.out.println("线程id " + Thread.currentThread().getName() + " 我进入线程了！");
//                nonFairLockDemo.testNonFairLock();
            });

        }



        try {
            if (executorService.isTerminated()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testNonFairLock() {
        try {
            nonFairLock.lock();
            Thread.sleep(1000);
            System.out.println("线程 id " + Thread.currentThread().getName() + " 获取锁！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            nonFairLock.unlock();
        }

    }
}
