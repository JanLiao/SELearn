package com.janliao.leetcode;

public class ZigZag {
    public static void main(String[] args) {
        String s = new ZigZag().convert("PAYPALISHIRING", 4);
        System.out.println(s);
    }

    public String convert(String s, int numRows) {
        if(numRows == 0 || numRows == 1) return s;
        int lens = s.length();
        if(numRows >= lens) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            appStr(sb, i, numRows, s);
        }
        return sb.toString();
    }

    private void appStr(StringBuilder sb, int i, int numRows, String s) {
        int lens = s.length();
        int offset = numRows - 1;
        int ost = i;
        while(i < lens){
            //System.out.println(ost + ", " + s.charAt(i));
            sb.append(s.charAt(i));
            if(ost == 0 || ost == (numRows - 1)){

            } else{
                int nxt = (offset - ost) * 2 + i;
                if(nxt < lens){
                    //System.out.println("== " + ost + ", " + s.charAt(nxt));
                    sb.append(s.charAt(nxt));
                }
            }
            i = i + 2 * offset;
        }
    }


}
