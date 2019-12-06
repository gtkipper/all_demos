package com.timer.proxy;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-06 22:14
 * @description 代理模式——静态代理
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        ProxySubject ps1 = new ProxySubject(new RealSubject1());
        ps1.request();
        ProxySubject ps2 = new ProxySubject(new RealSubject2());
        ps2.request();
    }
}

//抽象主题接口
interface Subject {
    void request();
}

//真实主题类1
class RealSubject1 implements Subject {
    @Override
    public void request() {
        System.out.println("访问真实主题1方法。。。");
    }
}
//真实主题类2
class RealSubject2 implements Subject {
    @Override
    public void request() {
        System.out.println("访问真实主题2方法。。。");
    }
}


//代理对象类
class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        preRequest();
        subject.request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("代理对象preRequest。。。");
    }
    public void postRequest() {
        System.out.println("代理对象postRequest。。。");
    }
}