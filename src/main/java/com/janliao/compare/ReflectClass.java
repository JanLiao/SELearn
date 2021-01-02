package com.janliao.compare;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;

class IIPerson{

}
public class ReflectClass {
    public void test(){
        System.out.println("=================");
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 其中com.test.ReflectClass为ReflectClass类的全限定名
        Class<?> c = Class.forName("com.janliao.compare.ReflectClass");
        Class<?> c1 = ReflectClass.class;
        ReflectClass rc = new ReflectClass();
        Class<?> c2 = rc.getClass();
        System.out.println(c.equals(c1));
        try {
            ReflectClass rr = (ReflectClass) c.newInstance();
            Object o = c.newInstance();
            rr.test();
            Method m = c.getDeclaredMethod("test");
            m.invoke(rr);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Integer i = new Integer(5);
        Object oo = new Object();
        oo.equals(c);
        i.equals(2);
        i.hashCode();
        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(null, 1);
        TreeSet<IIPerson> set = new TreeSet<>();
        set.add(null);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
    }
}
