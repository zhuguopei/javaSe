package lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * User: 86131
 * Date: 2019/9/24
 * 悲观锁
 */
public class PessimisticLock {


    private volatile static PessimisticLock pessimisticLock;


    public static PessimisticLock getInstance() {
        if (pessimisticLock == null) {
//            synchronized (PessimisticLock.class) {
                if (pessimisticLock == null) {
                    pessimisticLock = new PessimisticLock();
                }
//            }
        }
        return pessimisticLock;
    }


}
