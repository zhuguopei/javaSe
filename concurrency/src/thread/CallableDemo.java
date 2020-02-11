package thread;

import java.util.concurrent.*;

/**
 * User: 86131
 * Date: 2019/11/20
 */
public class CallableDemo  {


    static class MyThread implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "Hello Callable";
        }
    }static class MyThread2 implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "Hello Callable2";
        }
    }static class MyThread3 implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "Hello Callable3";
        }
    }

    public static void main(String[] args)  {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future future = threadPool.submit(new MyThread());
        Future future2 = threadPool.submit(new MyThread2());
        Future future3 = threadPool.submit(new MyThread3());


        try {
            System.out.println(future.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
