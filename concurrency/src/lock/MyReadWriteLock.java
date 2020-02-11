package lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: 86131
 * Date: 2019/9/24
 *
 * 读写锁
 */
public class MyReadWriteLock {

    private Map<String, Object> map = new ConcurrentHashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    Lock read = readWriteLock.readLock();

    Lock write = readWriteLock.writeLock();


    public Object get(String key) {
        read.lock();
        System.out.println(Thread.currentThread().getName()+ " read 操作执行");
        try {
            Thread.sleep(500);
            return map.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            read.unlock();
            System.out.println(Thread.currentThread().getName()+ " read 操作结束");
        }

    }



    public void put(String key, Object value) {
        write.lock();
        System.out.println(Thread.currentThread().getName()+ " write 操作执行");
        try {
            Thread.sleep(1000);
            map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            write.unlock();
            System.out.println(Thread.currentThread().getName() + " write 操作结束");
        }

    }


    public static void main(String[] args) {

    }

}
