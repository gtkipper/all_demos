package com.timer.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-08 22:25
 * @description 迭代器模式
 */
public class TestIteratot {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("张三");
        aggregate.add("李四");
        aggregate.add("王五");
        aggregate.add("赵六");
        aggregate.add("田七");
        System.out.println("-----遍历开始：");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
        System.out.println("-----遍历结束：");
        System.out.println("第一个对象为："+iterator.first());
    }
}
//抽象聚合对象
interface Aggregate {
  public void add(Object obj);
  public void remove(Object obj);
  public Iterator getIterator();
}
//具体聚合对象
class ConcreteAggregate implements Aggregate{
    private List<Object> list = new ArrayList<>();
    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}
//抽象迭代器对象
interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
}
//具体迭代器对象
class ConcreteIterator implements Iterator {
    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        return list.get(index);
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        }
        return false;
    }
}