package com.company2.num2.fib;

import java.util.ArrayList;
import java.util.List;

/*
* 改造斐波那契数
* */
public class Solution {


    public static int []arr;
    public static int fib(int n)
    {
        if (n==0)
        {
            return 0;
        }
        if (n==1)
        {
            return 1;
        }
        if (arr[n]==-1)
        {
            arr[n]=fib(n-1)+fib(n-2);
        }
        return arr[n];
    }

    /*

    正规自下向上写法
     */
    public static int fibs(int n)
    {
        int[] arr=new  int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i=2;i<=n;i++)
        {
            arr[i]=fib(i-1)+fib(i-2);
        }
        return arr[n];
    }
    public static void main(String[]args)
    {
        int num=0;
        int n=40;
        arr=new int[n+1];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=-1;
        }
        System.out.println(fibs(n));
    }
}
