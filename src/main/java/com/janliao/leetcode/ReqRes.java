package com.janliao.leetcode;

import java.util.*;

public class ReqRes {
    private static final double MAX_POOL_SIZE = 100;

    private static final String REQUEST = "REQUEST";

    private static final String RELEASE = "RELEASE";

    // 存储初始位置及其大小
    private static Map<Double, Double> map = new LinkedHashMap<>();
    // 存储空闲列表的初始位置及其大小
    private static Map<Double, Double> nullMap = new LinkedHashMap<>();
    static{
        nullMap.put(0.0, 100.0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String le = in.nextLine();
        int n = Integer.parseInt(le);
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = in.nextLine();
        }
        List<String> res = process(str);
        for(String s : res){
            System.out.println(s);
        }
    }

    private static List<String> process(String[] str) {
        List<String> list = new ArrayList<>();
        for(String s : str){
            String[] shell = s.split("=");
            if(REQUEST.equals(shell[0])){
                list.add(checkReqMem(shell[1]));
            } else if(RELEASE.equals(shell[0])){
                String res = checkRelMem(shell[1]);
                if(!"".equals(res)){
                    list.add(res);
                }
            }
        }
        return list;
    }

    // 释放内存
    private static String checkRelMem(String s) {
        // 移除map中包含的元素
        double key = Double.parseDouble(s);
        if(map.containsKey(key)){
            map.remove(key);
            // 移除成功,需要增加空闲nullMap内存(合并)
            mergeNullMap(key, key + map.get(key));
            return "";
        } else{
            return "error";
        }
    }

    private static void mergeNullMap(double end, double start) {
        boolean sf = false;
        double sv = 0;
        boolean ef = false;
        for(Map.Entry<Double, Double> entry : nullMap.entrySet()){
            double s = entry.getKey();
            double v = entry.getValue();
            double e = s + v;
            if(e == end){
                sv = s;
                sf = true;
            }
            if(s == start){
                ef = true;
            }
        }
        if(sf){
            if(ef){
                double value1 = nullMap.get(sv);
                double value2 = start - end;
                double value3 = nullMap.get(start);
                //nullMap.remove(sv);
                nullMap.remove(start);
                nullMap.put(sv, value1 + value2 + value3);
            } else{
                double value1 = nullMap.get(sv);
                double value2 = start - end;
                nullMap.put(sv, value1 + value2);
            }
        } else {
            if(ef){
                double value2 = start - end;
                double value3 = nullMap.get(start);
                nullMap.remove(start);
                nullMap.put(end, value2 + value3);
            } else{
                nullMap.put(end, start - end);
            }
        }
    }

    // 申请内存
    private static String checkReqMem(String s) {
        String res = "";
        double cal = Double.parseDouble(s);
        // double是否可以比较0
        if(cal > 100 || cal == 0) return "error";
        boolean flag = false;
        double ok = 0.0;
        double k = 0.0;
        double v = 0.0;
        for(Map.Entry<Double, Double> entry : nullMap.entrySet()){
            double value = entry.getValue();
            if(value >= cal){
                flag = true;
                ok = entry.getKey();
                k = entry.getKey() + cal;
                v = value - cal;
                break;
            }
        }
        if(flag){
            nullMap.remove(ok);
            nullMap.put(k, v);
            map.put(ok, cal);
            // 保持两个map有序
            sortMap();
        }
        return flag ? "0" : "error";
    }

    private static void sortMap() {
        Map<Double, Double> m1 = new LinkedHashMap<>();
        Set<Double> s1 = map.keySet();
        List<Double> l1 = new ArrayList<Double>(s1);
        Collections.sort(l1);
        for(double d : l1){
            m1.put(d, map.get(d));
        }
        map = m1;
        Map<Double, Double> m2 = new LinkedHashMap<>();
        Set<Double> s2 = nullMap.keySet();
        List<Double> l2 = new ArrayList<Double>(s2);
        Collections.sort(l2);
        for(double d : l2){
            m2.put(d, nullMap.get(d));
        }
        nullMap = m2;
    }
}
