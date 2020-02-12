package singleton;

/**
 * 
 * Date: 2019/9/29
 * zhugp auth
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
        if(singleton != null) {
            return singleton;
    }
}
