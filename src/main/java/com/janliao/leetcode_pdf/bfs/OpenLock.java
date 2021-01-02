/*
 * Copyright (c) 2020
 * User:jan
 * File:OpenLock.java
 * Date:2020/12/27 12:43:27
 */

package com.janliao.leetcode_pdf.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jan
 * @since 2020/12/27 12:43
 */
public class OpenLock {
    private static final int LOCK_LENS = 4;
    public String addOne(String s, int idx) {
        char[] c = s.toCharArray();
        if (c[idx] == '9') {
            c[idx] = '0';
        } else {
            c[idx] += 1;
        }
        return new String(c);
    }

    public String minusOne(String s, int idx) {
        char[] c = s.toCharArray();
        if (c[idx] == '0') {
            c[idx] = '9';
        } else {
            c[idx] -= 1;
        }
        return new String(c);
    }

    public int openLock(String[] deadends, String target) {
        List<String> dead = Stream.of(deadends).collect(Collectors.toList());
        List<String> visit = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visit.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();

                if (dead.contains(s)) {
                    continue;
                }
                if (target.equals(s)) {
                    return step;
                }

                for (int j = 0; j < LOCK_LENS; j++) {
                    // add
                    String addStr = addOne(s, j);
                    if (!visit.contains(addStr)) {
                        queue.add(addStr);
                        visit.add(addStr);
                    }

                    // minus
                    String minusStr = minusOne(s, j);
                    if (!visit.contains(minusStr)) {
                        queue.add(minusStr);
                        visit.add(minusStr);
                    }
                }
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(new OpenLock().openLock(deadends, target));
    }
}
