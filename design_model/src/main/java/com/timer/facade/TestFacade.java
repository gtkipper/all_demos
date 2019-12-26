package com.timer.facade;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-12 13:10
 * @description 外观角色
 */
public class TestFacade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
//外观角色
class Facade {
    SubSystem1 s1 = new SubSystem1();
    SubSystem2 s2 = new SubSystem2();
    SubSystem3 s3 = new SubSystem3();
    //集中处理所有步骤
    public void method() {
        s1.method1();
        s2.method2();
        s3.method3();
    }
}

//子系统角色 步骤一
class SubSystem1 {
    public void method1() {
        System.out.println("步骤一");
    }
}

//子系统角色 步骤二
class SubSystem2 {
    public void method2() {
        System.out.println("步骤二");
    }
}

//子系统角色 步骤三
class SubSystem3 {
    public void method3() {
        System.out.println("步骤三");
    }
}
