package com.janliao;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ForkJoinPool;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(forkJoinPool.getClass().getClassLoader());
        System.out.println(ForkJoinPool.defaultForkJoinWorkerThreadFactory.getClass().getClassLoader());
        Thread.currentThread().getContextClassLoader();
//        ResourceBundle bundle = ResourceBundle.getBundle("my", new Locale("zh", "CN"));
        List<String> string = new ArrayList<>();
        string .add("jan");
        string.add("liaot");
        string.add("ttt");
        string.add(2, "jan1");
        System.out.println(string.size());
    }
}
