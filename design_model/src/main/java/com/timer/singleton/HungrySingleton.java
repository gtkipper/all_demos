package com.timer.singleton;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-04 20:50
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {
        System.out.println("执行了构造器！！");
    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}
