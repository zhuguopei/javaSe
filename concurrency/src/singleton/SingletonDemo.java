package singleton;

/**
 * 
 * Date: 2019/9/29
 *
 */
public class SingletonDemo {

    static class Singleton {
        private Singleton() {}

        private static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return Singleton.singleton;
    }
}
