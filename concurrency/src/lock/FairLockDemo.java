package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: 86131
 * Date: 2019/9/24
 * 公平锁
 */
public class FairLockDemo {

    private ReentrantLock fairLock = new ReentrantLock(true);


    public static void main(String[] args) {
        final FairLockDemo fairLockDemo = new FairLockDemo();

        // 缓存线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println("线程ID " + Thread.currentThread().getName() + " 进入线程");
                fairLockDemo.testDemo();

            });
        }

        executorService.shutdown();
    }

    public void testDemo() {
        fairLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("线程ID " + Thread.currentThread().getName() + " 获取锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fairLock.unlock();
        }

    }
}