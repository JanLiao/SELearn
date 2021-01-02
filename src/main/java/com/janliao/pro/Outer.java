package com.janliao.pro;

interface AnnoInner{
    public int addXYZ();
}
public class Outer {
    public AnnoInner getAnnoInner(final int x){
        int y=100;
        return new AnnoInner(){
            int z=100;
            public int addXYZ(){
                return x+y+z;
            }
        };
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        AnnoInner an = out.getAnnoInner(5);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(an.addXYZ());
    }
}
