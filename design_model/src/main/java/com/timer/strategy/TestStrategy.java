package com.timer.strategy;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-05 21:12
 * @description 策略模式
 */
public class TestStrategy {
    public static void main(String[] args) {
        Context c1 = new Context();
        Strategy a = new ConcreteStrategyA();
        Strategy b = new ConcreteStrategyA();
        c1.setStrategy(a);
        c1.strateMethod();
        c1.setStrategy(b);
        c1.strateMethod();
    }
}

/**
 * 抽象策略类
 */
interface Strategy {
    public void strategyMethod();
}

/**
 * 具体策略类A
 */
class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被调用。。。");
    }
}

/**
 * 具体策略类B
 */
class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被调用。。。");
    }
}

/**
 * 环境类
 */
class  Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strateMethod() {
        strategy.strategyMethod();
    }
}

