package com.timer.memento;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-09 22:49
 * @description 备忘录模式
 */
public class TestMemento {
    public static void main(String[] args) {
        Originator or = new Originator();
        CareTaker cr = new CareTaker();
        or.setState("S0");
        System.out.println("当前的状态："+or.getState());
        //将备忘录保存到管理者中
        cr.setMemento(or.createMemento());
        or.setState("S1");
        System.out.println("新的状态为："+or.getState());
        or.restoreMemento(cr.getMemento());
        System.out.println("恢复到的状态为："+or.getState());
    }
}
//备忘录角色
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
//发起人角色
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
//管理者模式
class CareTaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}