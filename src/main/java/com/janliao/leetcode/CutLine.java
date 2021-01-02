package com.janliao.leetcode;

public class CutLine {
    public static void main(String[] args) {
        int res = new CutLine().cut(10);
        System.out.println(res);
    }

    // 递归算法  f(n) = max{f(i) * f(n - i)}
    public int cut(int line){
        if(line < 4) return line;
        int max = Integer.MIN_VALUE;
        for(int i = 1, lens = line / 2; i <= lens; i++){
            max = Math.max(max, cut(i) * cut(line - i));
        }
        return max;
    }

    // 贪心算法
    public int cut1(int line){
        // 就看剪不剪
        if(line < 4) return line;
        int offset = line % 3;
        if(offset == 0){
            return (int)Math.pow(3, line / 3);
        } else if(offset == 1){
            return 4 * (int)Math.pow(3, line / 3 - 1);
        } else {
            return 2 * (int)Math.pow(3, line / 3);
        }
    }
}
