package com.leetcode.num3;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int l=0,r=-1;
        int res=0;
        int [] arr=new int[256];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=0;
        }
        while (l<s.length())
        {
            if(r+1<s.length()&&arr[s.charAt(r+1)]==0)
            {
                r++;
                arr[s.charAt(r)]=1;
            }else {
                arr[s.charAt(l)]=0;
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
    public static void main(String[]args)
    {
        String s="hello";
        System.out.println((int)s.charAt(2));
    }
}
