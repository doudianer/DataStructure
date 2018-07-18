package com.leetcode.num27;

class Solution {
  /*
  * 我自己写的对特殊情况调不出来
  * */
   /* public static   int removeElement(int[] nums, int val) {
        int k=nums.length-1;
        int w=0;
        //{1};
        for (int i=0;i<k;i++)
        {
            if(k==0)
            {
                w++;
                nums[k]=0;
            }

            else if(nums[k]==val&&k!=0.)
            {
                k--;
                w++;
            }
            if(nums[i]==val)
            {
                swap(nums,k,i);
                w++;
                k--;
            }
        }
        return nums.length-w;
    }*/
    public static  int removeElement(int[] nums, int val) {

        int index=0 ,res=0;

            while (index<nums.length)
            {
                if(nums[index]!=val)
                {
                    nums[res]=nums[index];
                    res++;
                }
                index++;

            }
        return res;
    }
    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static void main(String[]args)
    {
        int []a={1};
        System.out.println(removeElement(a,1));
    }
}