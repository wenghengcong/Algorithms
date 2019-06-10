package sword.chap2;

/**
 * @author wenghengcong
 * @className: SingleInstance
 * @description:
 * @date 2019-05-2406:33
 */
public class SingleInstance {
    public static  SingleInstance instance = null;

    public static SingleInstance getInstance() {
        if (instance == null) {
            instance = new SingleInstance();
        }
        return instance;
    }

    /**
     * 线程安全的方式
     * */
    public static SingleInstance getInstanceThreadSafety() {
        synchronized (SingleInstance.class) {
            if (instance == null) {
                instance = new SingleInstance();
            }
        }
        return instance;
    }

    /**
     * 线程安全的方式2
     * */
    private final static Object lock = new Object();
    public static SingleInstance getInstanceThreadSafety2() {
        if (instance == null) {
            synchronized (lock) {
                instance = new SingleInstance();
            }
        }
        return instance;
    }


}
