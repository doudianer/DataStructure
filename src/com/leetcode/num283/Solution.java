package com.leetcode.num283;

import com.company2.num2.num2.Selection_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
*
* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
*
* */
public class Solution {
    public void moveZeroes(int[] nums) {
        List <Integer>list=new LinkedList();
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                list.add(nums[i]);
            }
        }
        for(int i=0;i<list.size();i++)
        {
            nums[i]=list.get(i);
        }
        for(int i=list.size();i<nums.length;i++)
        {
            nums[i]=0;
        }

    }
    public static void moveZeroes2(int[] nums) {
        int k=0;
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                if(i!=k)
                    swap(nums,i,k);
                else
                    k++;
            }
        }
        System.out.println(k);
    }

    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void main(String[]args)
    {
        int []a={1,2,3,4};
        moveZeroes2(a);
    }
}

