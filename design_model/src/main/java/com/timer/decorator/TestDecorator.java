package com.timer.decorator;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-07 17:04
 * @description 装饰模式
 */
public class TestDecorator {
    public static void main(String[] args) {
        Component component = new ConcreteCOmponent();
        component.operation();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
//抽象构件角色接口
interface Component {
    void operation();
}
//具体构件角色
class ConcreteCOmponent implements Component {
    public ConcreteCOmponent() {
        System.out.println("具体构件角色正在创建。。。");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法。。。");
    }
}
//抽象装饰角色
class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
//具体装饰角色
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addOperation();
    }
    public void addOperation() {
        System.out.println("增加修饰。。。");
    }
}
