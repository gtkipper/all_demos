package com.timer.flyweight;

import java.util.HashMap;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-28 14:52
 * @description 享元模式
 */
public class TestFlyWeight {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        UnsharedConcreteFlyweight unsharedConcreteFlyweight1 = new UnsharedConcreteFlyweight("非享元角色1、info");
        UnsharedConcreteFlyweight unsharedConcreteFlyweight2 = new UnsharedConcreteFlyweight("非享元角色2、info");
        UnsharedConcreteFlyweight unsharedConcreteFlyweight3 = new UnsharedConcreteFlyweight("非享元角色3、info");
        Flyweight flyweight1 = factory.getFlyweight("a");
        flyweight1.operation(unsharedConcreteFlyweight1);
        Flyweight flyweight2 = factory.getFlyweight("a");
        flyweight2.operation(unsharedConcreteFlyweight2);
        Flyweight flyweight3 = factory.getFlyweight("b");
        flyweight3.operation(unsharedConcreteFlyweight3);
    }
}
//抽象的享元角色
interface Flyweight {
    public void operation(UnsharedConcreteFlyweight state);
}
//具体的享元角色
class ConcreteFlyweight implements Flyweight {
    /**
    * 享元角色的共享key
    */
    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元"+key+"被创建");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.println("具体享元"+key+"被调用");
        System.out.println("非享元信息是："+state.getInfo());
    }
}
//享元工厂角色
class FlyweightFactory {
    private HashMap<String,Flyweight> flyweights = new HashMap<>();
    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if(flyweight == null){
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }else {
            System.out.println("具体享元"+key+"已经存在，获取成功");
        }
        return flyweight;
    }
}
//非享元角色
class UnsharedConcreteFlyweight {
    /**
    * 非享元角色的信息
    */
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

