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
    
    public static Singleton get() {
        if(Singleton.singleton != null) {
            return Singleton.singleton;
        }
        return null;
    }
}
