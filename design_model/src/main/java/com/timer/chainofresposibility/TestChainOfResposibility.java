package com.timer.chainofresposibility;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-06 21:34
 * @description 责任链模式
 */
public class TestChainOfResposibility {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.setNext(h2);
        h2.setNext(h3);
        h1.handlerRequest("three");
    }
}

//抽象处理着角色
abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    //处理请求的方法
    public abstract void handlerRequest(String request);
}

//具体处理着角色1
class ConcreteHandler1 extends Handler {
    @Override
    public void handlerRequest(String request) {
        if (request.equals("one")) {
            System.out.println("责任链1进行处理。。。");
        } else {
            if (this.getNext() != null) {
                this.getNext().handlerRequest(request);
            } else {
                System.out.println("无法处理此请求。。。");
            }
        }
    }
}

//具体处理着角色2
class ConcreteHandler2 extends Handler {
    @Override
    public void handlerRequest(String request) {
        if (request.equals("two")) {
            System.out.println("责任链2进行处理。。。");
        } else {
            if (this.getNext() != null) {
                this.getNext().handlerRequest(request);
            } else {
                System.out.println("无法处理此请求。。。");
            }
        }
    }
}

//具体处理着角色3
class ConcreteHandler3 extends Handler {
    @Override
    public void handlerRequest(String request) {
        if (request.equals("three")) {
            System.out.println("责任链3进行处理。。。");
        } else {
            if (this.getNext() != null) {
                this.getNext().handlerRequest(request);
            } else {
                System.out.println("无法处理此请求。。。");
            }
        }
    }
}
