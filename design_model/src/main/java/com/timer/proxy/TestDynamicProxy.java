package com.timer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-06 22:47
 * @description 代理模式——动态代理
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        Singer1 singer1 = new Singer1();
        ISinger singer1Proxy = (ISinger)Proxy.newProxyInstance(singer1.getClass().getClassLoader(),
                singer1.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("歌手向观众问好！！！");
                        Object value = method.invoke(singer1, args);
                        System.out.println("歌手感谢现场的所有支持者！！！");
                        return value;
                    }
                });
        singer1Proxy.sing();
    }
}
//抽象主题接口
interface ISinger {
    void sing();
}
//歌手1
class Singer1 implements ISinger {
    @Override
    public void sing() {
        System.out.println("歌手1正在唱歌。。。");
    }
}
//歌手2
class Singer2 implements ISinger {
    @Override
    public void sing() {
        System.out.println("歌手2正在唱歌。。。");
    }
}