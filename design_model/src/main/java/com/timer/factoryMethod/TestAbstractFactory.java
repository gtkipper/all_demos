package com.timer.factoryMethod;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-05 13:20
 * @description
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        IAbstractFactory f1 = new ConcreteFactory01();
        Product p1 = f1.newProduct();
        p1.show();
        IAbstractFactory f2 = new ConcreteFactory02();
        Product p2 = f2.newProduct();
        p2.show();

    }
    
    
}
