package com.timer.builder;

import lombok.Data;
import lombok.ToString;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-06 10:14
 * @description 建造者模式
 */
public class TestBuilder {
    public static void main(String[] args) {
        Director director = new Director(new AppleBuilder());
        Product product = director.constructor();
        product.toString();
    }
}
@Data
@ToString
//产品
class Product {
    /**
    * 产品cpu
    */
    private String cpu;
    /**
    * memory
    */
    private String memory;
    /**
    * disk
    */
    private String disk;
        
    
}
//抽象建造者
abstract class AbstractBuilder {
    public Product product = new Product();
    public abstract void builderCpu();
    public abstract void builderMemory();
    public abstract void builderDisk();
    public Product newProduct() {
        return product;
    }
}
//具体建造者（苹果）
class AppleBuilder extends AbstractBuilder {
    @Override
    public void builderCpu() {
        System.out.println("苹果工厂生产cpu。。");
        product.setCpu("苹果工厂生产完成cpu---");
    }

    @Override
    public void builderMemory() {
        System.out.println("苹果工厂生产memory。。");
        product.setCpu("苹果工厂生产完成memory---");
    }

    @Override
    public void builderDisk() {
        System.out.println("苹果工厂生产disk。。");
        product.setCpu("苹果工厂生产完成disk---");
    }
}
//具体建造者（小米）
class XiaoMiBuilder extends AbstractBuilder {
    @Override
    public void builderCpu() {
        System.out.println("小米工厂生产cpu。。");
        product.setCpu("小米工厂生产完成cpu---");
    }

    @Override
    public void builderMemory() {
        System.out.println("小米工厂生产memory。。");
        product.setCpu("小米工厂生产完成memory---");
    }

    @Override
    public void builderDisk() {
        System.out.println("小米工厂生产disk。。");
        product.setCpu("小米工厂生产完成disk---");
    }
}
//指挥者
class Director {
    private AbstractBuilder builder;

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }
    public Product constructor() {
        builder.builderCpu();
        builder.builderMemory();
        builder.builderDisk();
        return builder.newProduct();
    }
}

