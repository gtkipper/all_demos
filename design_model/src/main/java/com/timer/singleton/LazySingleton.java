package com.timer.singleton;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-04 20:39
 */
public class LazySingleton {
    // 保证instance在所有线程中同步
    private static volatile LazySingleton instance = null;
    //private 避免类在外部被实例化
    private LazySingleton() {
    }
    //getInstance 方法前加同步
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
