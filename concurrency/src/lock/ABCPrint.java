package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: 86131
 * Date: 2019/10/25
 * <p>
 * 循环输出ABC10次
 */
public class ABCPrint {

    private static int state = 0;

    public static void main(String[] args) {

        System.out.println(state);
        final Lock lock = new ReentrantLock();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                while(state <= 30) {
                    lock.lock();
                    if (state % 3 == 0) {
                        System.out.println("A");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });


        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    lock.lock();
                    if (state % 3 == 1) {
                        System.out.println("B");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                while(state <= 30) {
                    lock.lock();
                    if (state % 3 == 2) {
                        System.out.println("C");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });

        A.start();
        B.start();
        C.start();

    }

}
