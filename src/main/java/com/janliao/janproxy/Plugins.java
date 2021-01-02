package com.janliao.janproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Plugins implements InvocationHandler {
    private Target target;

    public Plugins(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre===============>");
        Object obj = method.invoke(target, args);
        System.out.println("after=============>");
        return obj;
    }
}
