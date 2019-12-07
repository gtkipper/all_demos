package com.timer.adapter;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-07 3:38
 * @description 类适配模式
 */
public class TestClassAdapter {
    public static void main(String[] args) {
        ThreeHolePlug thp = new Adapter();
        thp.threeHole();
    }
}
//目标接口 三孔插头
interface ThreeHolePlug {
    void threeHole();
}
//适配者类，两孔插头
class TwoHolePlug {
    public void twoHole() {
        System.out.println("这是一个两孔插头。。。");
    }
}
//适配器，将两孔插头转换为三孔插头
class Adapter extends TwoHolePlug implements ThreeHolePlug {
    @Override
    public void threeHole() {
        super.twoHole();
        System.out.println("这是适配器，两孔插头给三孔插头用。。。");
    }
}
