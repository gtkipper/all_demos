package com.timer.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-08 20:50
 * @description 观察者模式
 */
public class TestObserver {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        Observer observer3 = new ConcreteObserver3();
        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);
        subject.notifyObserver();
    }
}
//抽象目标
abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();
    public void add(Observer observer) {
        observers.add(observer);
    }
    public void remove(Observer observer) {
        observers.remove(observer);
    }
    public abstract void notifyObserver();
}
//具体目标
class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变。。");
        System.out.println("--------------");
        for (Observer observer : observers) {
            observer.response();
        }
    }
}
//抽象观察者
interface Observer {
    void response();
}
//具体观察者1
class ConcreteObserver1 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者1做出相应。");
    }
}
//具体观察者2
class ConcreteObserver2 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者2做出相应。");
    }
}
//具体观察者3
class ConcreteObserver3 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者3做出相应。");
    }
}

