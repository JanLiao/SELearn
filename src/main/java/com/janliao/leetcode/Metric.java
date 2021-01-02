package com.janliao.leetcode;

public class Metric {

    public static int qiejuzhen(int length,int high)
    {
  /*
   result数组大小为1，用来放答案，当然，将result设为static int类型也是可以的
  */
        //初始化时result[0]==0;
        int[]result=new int[1];
        sub(new boolean[length][high],length*high,result,0);
        return result[0];
    }
    /*
    flag[][]用来标志哪些位置已经被分配，哪些位置没有被分配
    left用来指代还有多少位置没有被分配
    本算法为了去重，规定每一行必须分配完才能继续分配下一行
    row代表的就是已经分配到第几行了
    */
    public static void sub(boolean [][]flag,int left,int[]result,int row)
    {
//当未分配的位置为0时，答案加1
        if(left==0)
        {
            result[0]++;
            return;
        }
	/*
	因为前面row-1行已经被分配完毕了，所以从第row行开始分配就
	可以了
	*/
        for(int i=row;i<flag.length;i++)
        {
            for(int j=0;j<flag[0].length;j++)
            {
                if(flag[i][j]==true)continue;
                if(i<flag.length&&j+1<flag[0].length&&flag[i][j+1]==false)
                {
                    flag[i][j]=true;
                    flag[i][j+1]=true;
                    sub(flag,left-2,result,i);
                    flag[i][j]=false;
                    flag[i][j+1]=false;

                }
                if(i+1<flag.length&&j<flag[0].length&&flag[i+1][j]==false)
                {
                    flag[i][j]=true;
                    flag[i+1][j]=true;
                    sub(flag,left-2,result,i);
                    flag[i][j]=false;
                    flag[i+1][j]=false;
                }
			/*
			这里的return解释一下，在此处flag[i][j]==false,不符合每一行必须分配完才能分配下一行的规定，
			因为接下来就算是j++，也不会再次为flag[i][j]进行分配
			*/
                return;
            }
        }
    }

    public static void main(String[] args) {
        int length=3;
        int high=4;
        System.out.println(qiejuzhen(length,high));
    }
}

