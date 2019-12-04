package com.timer.prototype;

import java.io.IOException;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-05 0:35
 */
public class TestPrototype {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Realizetype r = new Realizetype();
        r.setPerson(new Person(10,"Emma",false));
        System.out.println("浅克隆-----");
        Realizetype r1 = (Realizetype)r.clone();
        Realizetype r2 = (Realizetype)r.clone();
        System.out.println("r1的person = "+r1.getPerson());
        System.out.println("r2的person = "+r2.getPerson());
        System.out.println(r1.getPerson() == r2.getPerson());
        System.out.println("深克隆-----");
        Realizetype r3 = (Realizetype)r.deepClone();
        Realizetype r4 = (Realizetype)r.deepClone();
        System.out.println("r3的person = "+r3.getPerson());
        System.out.println("r4的person = "+r4.getPerson());
        System.out.println(r3.getPerson() == r4.getPerson());
        System.out.println("通过流实现深克隆----");
        Realizetype r5 = (Realizetype)r.deepCloneByStream();
        Realizetype r6 = (Realizetype)r.deepCloneByStream();
        System.out.println("r5的person = "+r5.getPerson());
        System.out.println("r6的person = "+r6.getPerson());
        System.out.println(r5.getPerson() == r6.getPerson());
    }

}
