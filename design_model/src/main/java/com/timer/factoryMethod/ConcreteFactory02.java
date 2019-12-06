package com.timer.factoryMethod;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-05 13:12
 * @description 具体工厂类02
 */
public class ConcreteFactory02 implements IAbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂02生成--->具体产品02");
        return new ConcreteProduct02();
    }
}
