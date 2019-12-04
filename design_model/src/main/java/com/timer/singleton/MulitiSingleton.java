package com.timer.singleton;

import java.util.ArrayList;

/**
 * @author kipper_yuhaibo
 * @create 2019-12-04 21:10
 */
public class MulitiSingleton {
    private static final int N = 10;
    private static ArrayList<MulitiSingleton> list = new ArrayList<>(N);
    private int no;

    private MulitiSingleton(int no) {
        this.no = no;
        System.out.println("这是第" + no + "个对象");
    }

    static {
        for (int i = 0; i < N; i++) {
            list.add(new MulitiSingleton(i));
        }
    }
    public static MulitiSingleton getInstance() {
        int num = (int)(Math.random()*N);
        return list.get(num);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
