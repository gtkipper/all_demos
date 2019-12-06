package com.timer.abstractFactory;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-05 22:23
 * @description 抽象工厂模式实现
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        AbstractFactory xiaomi = new XiaoMiFactory();
        Phone xiaoMiPhone = xiaomi.newPhone();
        Computer xiaoMiComputer = xiaomi.newComputer();
        AbstractFactory apple = new AppleFactory();
        Phone applePhone = apple.newPhone();
        Computer appleComputer = apple.newComputer();
        xiaoMiPhone.show();
        xiaoMiComputer.show();
        applePhone.show();
        appleComputer.show();
    }
}
interface Phone {
    public void show();
}
interface Computer {
    public void show();
}
class ApplePhone implements Phone {

    @Override
    public void show() {
        System.out.println("这是苹果公司的--手机！");
    }
}
class XiaoMiPhone implements Phone {
    @Override
    public void show() {
        System.out.println("这是小米公司的--手机！");
    }
}
class AppleComputer implements Computer {

    @Override
    public void show() {
        System.out.println("这是苹果公司的--电脑");
    }
}
class XiaoMiComputer implements Computer {

    @Override
    public void show() {
        System.out.println("这是小米公司的--电脑");
    }
}
interface AbstractFactory {
    public Phone newPhone();
    public Computer newComputer();
}
class AppleFactory implements AbstractFactory {

    @Override
    public Phone newPhone() {
        return new ApplePhone();
    }

    @Override
    public Computer newComputer() {
        return new AppleComputer();
    }
}
class XiaoMiFactory implements AbstractFactory {

    @Override
    public Phone newPhone() {
        return new XiaoMiPhone();
    }

    @Override
    public Computer newComputer() {
        return new XiaoMiComputer();
    }
}
