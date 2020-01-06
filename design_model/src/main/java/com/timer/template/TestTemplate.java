package com.timer.template;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-05 15:17
 * @description 模板方法模式
 */
public class TestTemplate {
    public static void main(String[] args) {
        AbstractClass a = new ConcreteClass();
        a.templateMethod();
    }
}

/**
 * 抽象类
 */
abstract class AbstractClass {
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用！");
    }
    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}

/**
 * 具体实现类
 */
class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用！");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用！");
    }
}