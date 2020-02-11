package lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: 86131
 * Date: 2019/11/7
 */
public class JoinDemo {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final Lock lock = new ReentrantLock();

        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("one " + Thread.currentThread().getName());
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("two " + Thread.currentThread().getName());
            }
        });
        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("three " +Thread.currentThread().getName());
            }
        });
        Thread four = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("four " + Thread.currentThread().getName());
            }
        });

        two.start();
        four.start();
        three.start();
        one.start();
//        one.join();


        String string = "hello FutureTask";

        FutureTask result = new FutureTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(string);
            }
        },  string);

        System.out.println(result.get());


        result.run();
    }


}
