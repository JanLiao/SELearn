package com.janliao.singleton;

public class SingletoMain {
    private static volatile SingletoMain single;

    public static SingletoMain getSingleto(){
        if(single == null){
            synchronized (SingletoMain.class){
                if(single == null){
                    single = new SingletoMain();
                }
            }
        }
        return single;
    }
}
