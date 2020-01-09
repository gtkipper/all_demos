package com.timer.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-08 21:34
 * @description 中介者模式
 */
public class TestMediator {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        Colleague c3 = new ConcreteColleague3();
        mediator.register(c1);
        mediator.register(c2);
        mediator.register(c3);
        c2.send();
    }
}
//抽象中介者
abstract class Mediator {
    public abstract void register(Colleague colleague); //注册
    public abstract void relay(Colleague colleague); //转发
}
//具体中介者
class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<>();
    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague c : colleagues) {
            if (!colleague.equals(c)) {
                c.receive();
            }
        }
    }
}
//抽象同事类
abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void send();
    public abstract void receive();
}
//具体同事类1
class ConcreteColleague1 extends Colleague{
    @Override
    public void send() {
        System.out.println("具体同事类1发出请求。。");
        mediator.relay(this);
    }

    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。。");
    }
}
//具体同事类2
class ConcreteColleague2 extends Colleague{
    @Override
    public void send() {
        System.out.println("具体同事类2发出请求。。");
        mediator.relay(this);
    }

    @Override
    public void receive() {
        System.out.println("具体同事类2收到请求。。");
    }
}
//具体同事类3
class ConcreteColleague3 extends Colleague{
    @Override
    public void send() {
        System.out.println("具体同事类3发出请求。。");
        mediator.relay(this);
    }

    @Override
    public void receive() {
        System.out.println("具体同事类3收到请求。。");
    }
}



