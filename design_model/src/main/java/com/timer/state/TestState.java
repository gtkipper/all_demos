package com.timer.state;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-06 22:40
 * @description 状态模式
 */
public class TestState {
    public static void main(String[] args) {
        Context context = new Context();
        context.handle();
        context.handle();
    }
}
//环境类
class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public void handle() {
        state.handle(this);
    }
}
//抽象状态类
abstract class State {
    public abstract void handle(Context context);
}
//具体状态类A
class ConcreteStateA extends State{

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是A");
        context.setState(new ConcreteStateB());
    }
}
//具体状态类B
class ConcreteStateB extends State{

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是B");
        context.setState(new ConcreteStateA());
    }
}
