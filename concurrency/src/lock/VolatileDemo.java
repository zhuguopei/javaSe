package lock;

/**
 * User: 86131
 * Date: 2019/9/29
 */
public class VolatileDemo {

    public volatile boolean flag = false;

    public static void main(String[] args) {
        VolatileDemo v = new VolatileDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "执行了第 " + i + " 次");
                }
                v.flag = true;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!v.flag) {
                    System.out.println("不执行行程");
                }
                System.out.println(Thread.currentThread().getName() + "执行线程2");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!v.flag) {

                }
                System.out.println(Thread.currentThread().getName() + "执行线程2");
            }
        }).start();
    }

}
