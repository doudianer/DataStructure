package com.leetcode.num26;


/*
* 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。
* */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int res=0;
        int index=0;
        //[1,1,2],
        while (index<nums.length)
        {
            if(nums[res]!=nums[index])
            {
                res++;
                nums[res]=nums[index];
            }
            index++;
        }
        return res+1;
    }
    public static void main(String[]args)
    {
        int []a={1,1,2};
        System.out.println();
    }
}
