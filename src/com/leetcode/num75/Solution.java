package com.leetcode.num75;

public class Solution {
    public void sortColors(int[] nums) {
        int k=-1;//num[0..k]=0
        int m=nums.length;//num[two..n-1]=2
        int i=0;
        while (i<m)
        {
            if(nums[i]>=0&&nums[i]<=2)
            {

            if(nums[i]==1)
            {
                i++;
            }else if(nums[i]==0)
            {
                swap(nums,i,k+1);
                i++;
                k++;
            }else if (nums[i]==2)
            {
                swap(nums,m-1,i);
                m--;
            }
        }
        }
    }
    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
