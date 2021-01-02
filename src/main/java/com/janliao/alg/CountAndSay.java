package com.janliao.alg;

public class CountAndSay {
    public String countAndSay(int n) {
        String s = recursiveCount("1", 1, n);
        return s;
    }

    public String recursiveCount(String s, int start, int end) {
        System.out.println(s);
        if (start == end) return s;
        char[] c = s.toCharArray();
        int count = 0;
        char tmp = c[0];
        String ss = "";
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            if (tmp == c[i]) {
                count++;
            } else {
                ss += "" + count + tmp;
                count = 1;
                tmp = c[i];
            }
        }
        if (tmp == c[len - 1]) {
            count++;
            ss += "" + count + tmp;
        } else {
            ss += "" + count + tmp;
            ss += "1" + c[len - 1];
        }
        start++;
        System.out.println(ss);
        return recursiveCount(ss, start, end);
    }

    public void test(String s) {
        char[] c = s.toCharArray();
        String ss = "";
        char tmp = c[0];
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            if (tmp == c[i]) {
                count++;
            } else {
                ss += "" + count + tmp;
                count = 1;
                tmp = c[i];
            }
        }
        if (tmp == c[len - 1]) {
            count++;
            ss += "" + count + tmp;
        } else {
            ss += "" + count + tmp;
            ss += "1" + c[len - 1];
        }
        //System.out.println(ss);
    }

    public static void main(String[] args) {
        int n = 5;
        CountAndSay cas = new CountAndSay();
        String s = cas.countAndSay(n);
        //System.out.println(s);
        cas.test("21");
    }
}
