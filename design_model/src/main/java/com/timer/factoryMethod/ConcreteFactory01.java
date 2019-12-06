package com.timer.factoryMethod;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-05 13:07
 * @description 具体工厂类01
 */
public class ConcreteFactory01 implements IAbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体产品工厂01生成--->具体产品01");
        return new ConcreteProduct01();
    }
}
