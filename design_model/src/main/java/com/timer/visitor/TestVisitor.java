package com.timer.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-09 21:40
 * @description 访问者模式
 */
public class TestVisitor {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElement1());
        os.add(new ConcreteElement2());
        os.accept(new ConcteteVisitor2());
    }
}

//抽象元素类
interface Element {
    void accept(Visitor visitor);
}

//具体元素类1
class ConcreteElement1 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operation1() {
        return "具体元素类1的操作！";
    }
}

//具体元素类2
class ConcreteElement2 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operation2() {
        return "具体元素类2的操作！";
    }
}

//抽象访问者
interface Visitor {
    void visit(ConcreteElement1 c1);

    void visit(ConcreteElement2 c2);
}

//具体访问者1
class ConcteteVisitor1 implements Visitor {

    @Override
    public void visit(ConcreteElement1 c1) {
        System.out.println("具体访问者1访问元素1：" + c1.operation1());
    }

    @Override
    public void visit(ConcreteElement2 c2) {
        System.out.println("具体访问者1访问元素2：" + c2.operation2());
    }
}

//具体访问者2
class ConcteteVisitor2 implements Visitor {

    @Override
    public void visit(ConcreteElement1 c1) {
        System.out.println("具体访问者2访问元素1：" + c1.operation1());
    }

    @Override
    public void visit(ConcreteElement2 c2) {
        System.out.println("具体访问者2访问元素2：" + c2.operation2());
    }
}

//对象结构角色
class ObjectStructure {
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        Iterator<Element> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}