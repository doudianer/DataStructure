package com.leetcode.num88;

public class Solution {
/*
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n-1;
        int mi=m-1;
        int ni=n-1;
        while (len>=0)
        {
            if(ni==-1)
            {
                break;
            }
            if(mi==0||mi==-1)
            {
                for(int i=ni;i>=0;i--)
                {
                    nums1[len]=nums2[i];
                    len--;
                }
                break;
            }
            if(nums1[mi]>nums2[ni])
            {
                nums1[len]=nums1[mi];
                mi--;
                len--;
            }else {
                nums1[len]=nums2[ni];
                ni--;
                len--;
            }

        }
    }*/
public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int len=m+n-1;
    int mi=m-1;
    int ni=n-1;
    for (int i=len;mi>=0&&ni>=0&&i>mi;i--)
    {
        if(nums1[mi]>nums2[ni])
        {
            nums1[i]=nums1[mi];
            mi--;
        }else
        {
            nums1[i]=nums2[ni];
            ni--;
        }
    }
    while (ni>=0)
    {
        nums1[ni]=nums2[ni];
        ni--;
    }

}
    public static void main(String[]args)
    {
        int [] num1={0};
        int [] num2={1};
        merge(num1,0,num2,1);

    }
}
