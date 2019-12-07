package com.timer.bridge;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-07 13:31
 * @description 桥接模式
 */
public class TestBridge {
    public static void main(String[] args) {
        Implementor im1 = new ConcreteImplementor1();
        Implementor im2 = new ConcreteImplementor2();
        Abstraction a1 = new RefinedAbstraction(im1);
        a1.operation();
        Abstraction a2 = new RefinedAbstraction(im2);
        a2.operation();
        Implementor im3 = new ConcteteImplementor3();
        Abstraction a3 = new RefinedAbstraction(im3);
        a3.operation();
    }


}
//实现化角色接口
interface Implementor {
    void operationImpl();
}
//具体实现化角色
class ConcreteImplementor1 implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现化--1--的角色被访问！");
    }
}
class ConcreteImplementor2 implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现化--2--的角色被访问！");
    }
}
class ConcteteImplementor3 implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("新增加的具体实现化。。。");
    }
}
//抽象化角色
abstract class Abstraction {
    Implementor imple;
    public Abstraction(Implementor imple) {
        this.imple = imple;
    }
    public abstract void operation();
}
//扩展抽象化角色
class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化角色被访问！！！");
        imple.operationImpl();
    }
}
