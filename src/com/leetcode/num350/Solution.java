package com.leetcode.num350;

import java.util.ArrayList;
import java.util.TreeMap;
/*
* 时间：Onlogn
* 空间：On
*
* */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums1)
        {
            if(!map.containsKey(num))
            {
                map.put(num,1);
            }
            else {
                map.put(num,map.get(num)+1);
            }
        }
        ArrayList<Integer> arr =new ArrayList<>();
        for(int num:nums2)
        {
            if(map.containsKey(num))
            {
                arr.add(num);
                map.put(num,map.get(num)-1);
                if(map.get(num)==0)
                {
                    map.remove(num);
                }
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
