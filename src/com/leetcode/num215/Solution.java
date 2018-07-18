package com.leetcode.num215;

public class Solution {

    public int partition(int[]nums,int l,int r)
    {
        int val=nums[l];
        int left=l;
        int right=r+1;
        int i=l+1;
        while (i<right)
        {
            if(nums[i]==val)
            {
                i++;
            }
            else if(nums[i]>val)
            {
                right--;
                swap(nums,right,i);
            }else {
                left++;
                swap(nums,left,i);
                i++;
            }
        }
        swap(nums,l,left);
        return left;
    }
    public int findKthLargest(int[] nums, int k) {

        int n=nums.length;
        int i=partition(nums,0,n-1);
        while (n-k!=i)
        {
            if(n-k>i)
            {
                i=partition(nums,i+1,n-1);
            }
            if (n-k<i)
            {
                i=partition(nums,0,i-1);
            }
        }
        return nums[i];
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[]args)
    {
        Solution solution=new Solution();
        int []arr={3,2,1,5,6,4};
       System.out.print( solution.findKthLargest(arr,2));

    }
}
