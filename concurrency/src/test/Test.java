package test;

import com.sun.management.ThreadMXBean;
import lock.PessimisticLock;
import singleton.SingletonDemo;

import java.lang.management.ThreadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: 86131
 * Date: 2019/9/29
 */
public class Test {


    public static String str = "hello";
    public char[] ch =  new char[]{'a','b'};

    public String exchange(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'c';
        return str;
    }


    public static void main(String[] args) {

        Test test = new Test();
        String s = test.exchange(str,test.ch);

        System.out.println(str + " and " + test.ch);

        System.out.println(s);

        

       /* ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 200; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    //Thread.currentThread().getName() + " : " +
                    System.out.println( PessimisticLock.getInstance());

                }
            });
        }
        executorService.shutdown();
*/


        /*ExecutorService executorService1 = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20 ; i++) {
            executorService1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : " + SingletonDemo.getSingleton());
                }
            });
        }

        executorService1.shutdown();*/
    }
}
