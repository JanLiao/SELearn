package com.janliao.janproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Target target = new MyTarget();
        Plugins plugins = new Plugins(target);
        Target tar = (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                plugins);
        for (int i = 0; i < 5; i++) {
            //String msg = "msg" + i;
            Plugins plu = new Plugins(tar);
            tar = (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    tar.getClass().getInterfaces(),
                    plu);
        }

        tar.test("jan");
    }
}
