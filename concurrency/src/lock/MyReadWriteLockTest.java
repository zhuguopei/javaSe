package lock;

/**
 * User: 86131
 * Date: 2019/9/24
 * 测试读写锁
 *
 * 读操作是并发的 如：read 操作执行
 */
public class MyReadWriteLockTest {

    public static void main(String[] args) {
        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
        myReadWriteLock.put("a", "宝马X3");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(myReadWriteLock.get("a"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(myReadWriteLock.get("a"));
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
