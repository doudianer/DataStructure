package com.leetcode.num349;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
/*
* 时间：Onlogn
* 空间：On
* */
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            set.add(nums1[i]);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums2.length;i++)
        {
            if(set.contains(nums2[i]))
            {
                arr.add(nums2[i]);
                set.remove(nums2[i]);
            }

        }
        int []a=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            a[i]=arr.get(i);
        }
        return a;
    }
}
