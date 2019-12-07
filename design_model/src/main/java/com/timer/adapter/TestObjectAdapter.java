package com.timer.adapter;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-07 3:49
 * @description 对象适配模式
 */
public class TestObjectAdapter {
    public static void main(String[] args) {
        Usb u = new AdapterTypeCToUsb(new TypeC());
        u.usbShow();
    }
}
//目标接口 usb接口
interface Usb {
    void usbShow();
}
//适配者 type-C接口
class TypeC {
    void typeCShow() {
        System.out.println("这是type-C接口。。。");
    }
}
//适配器
class AdapterTypeCToUsb implements Usb {
    TypeC typec;

    public AdapterTypeCToUsb(TypeC typec) {
        this.typec = typec;
    }

    @Override
    public void usbShow() {
        typec.typeCShow();
        System.out.println("适配器将type-c接口转化为usb接口。。。");
    }
}
