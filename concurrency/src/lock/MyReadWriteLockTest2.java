package lock;

/**
 * User: 86131
 * Date: 2019/9/24
 */
public class MyReadWriteLockTest2 {

    public static void main(String[] args) {
        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();

        // 写写互斥
/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("a", "宝马X3");            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("a", "宝马X3");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("a", "宝马X5");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("a", "宝马X3");
            }
        }).start();

        */

        // 读写互斥
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("a", "宝马X3");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(myReadWriteLock.get("a"));
            }
        }).start();

    }




}
