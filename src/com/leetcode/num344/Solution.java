package com.leetcode.num344;

public class Solution {
    public String reverseString(String s) {
        int i=0;

        char[] ss=s.toCharArray();
        int j=ss.length-1;
        while (i<j)
        {
            char k=ss[i];
            ss[i]=ss[j];
            ss[j]=k;
            i++;
            j--;

        }
        return new String(ss) ;
    }

    public static void main(String[]args)
    {
        Solution solution=new Solution();
        System.out.println(solution.reverseString("hello"));
    }

}
