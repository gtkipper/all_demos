package com.timer.singleton;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-04 20:44
 */
public class TestSingleton {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.timer.singleton.MulitiSingleton");
        System.out.println(MulitiSingleton.getInstance().getNo());
        System.out.println(MulitiSingleton.getInstance().getNo());
        System.out.println(MulitiSingleton.getInstance().getNo());
        System.out.println(MulitiSingleton.getInstance().getNo());
        System.out.println(MulitiSingleton.getInstance().getNo());
    }
}
