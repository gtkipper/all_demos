package com.timer.composite;

import java.util.ArrayList;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-05 13:35
 * @description 安全式组合模式
 */
public class TestSafeComposite {
    public static void main(String[] args) {
        SafeComposite c0 = new SafeComposite();
        SafeComposite c1 = new SafeComposite();
        SafeLeaf leaf1 = new SafeLeaf("树叶1");
        SafeLeaf leaf2 = new SafeLeaf("树叶2");
        SafeLeaf leaf3 = new SafeLeaf("树叶3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operate();
    }
}

/**
 * 抽象构件角色(安全式)
 */
interface SafeComponent {
    public void operate();
}

/**
 * 树叶构件角色(安全式)
 */
class SafeLeaf implements SafeComponent {
    /**
     * name
     */
    private String name;

    public SafeLeaf(String name) {
        this.name = name;
    }
    @Override
    public void operate() {
        System.out.println("树叶"+name+"节点,被访问！");
    }
}

/**
 * 树枝构件角色(安全式)
 */
class SafeComposite implements SafeComponent {
    private ArrayList<SafeComponent> children = new ArrayList<>();
    public void add(SafeComponent c) {
        children.add(c);
    }

    public void remove(SafeComponent c) {
        children.remove(c);
    }

    public SafeComponent getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operate() {
        for (SafeComponent c : children) {
            c.operate();
        }
    }
}