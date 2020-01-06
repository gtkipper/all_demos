package com.timer.composite;

import java.util.ArrayList;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-05 13:35
 * @description 透明式组合模式
 */
public class TestTransparencyComposite {
    public static void main(String[] args) {
        Component c0 = new Composite();
        Component c1 = new Composite();
        Component leaf1 = new Leaf("树叶1");
        Component leaf2 = new Leaf("树叶2");
        Component leaf3 = new Leaf("树叶3");
        c0.add(leaf1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.add(c1);
        c0.operate();
    }
}

/**
 * 抽象构件角色(透明式)
 */
interface Component {
    public void add(Component c);
    public void remove(Component c);
    public Component getChild(int i);
    public void operate();
}

/**
 * 树叶构件角色(透明式)
 */
class Leaf implements Component {
    /**
    * name
    */
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {
    }

    @Override
    public void remove(Component c) {
    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operate() {
        System.out.println("树叶"+name+"节点,被访问！");
    }
}

/**
 * 树枝构件角色(透明式)
 */
class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<>();
    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operate() {
        for (Component c : children) {
            c.operate();
        }
    }
}