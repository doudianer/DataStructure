package com.leetcode.num167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int [] arr=new int[2];
        int j=numbers.length-1;
        while (i!=j)
        {
            if(numbers[i]+numbers[j]>target)
            {
                j--;
            }else if(numbers[i]+numbers[j]<target)
            {
                i++;
            }else {
                arr[0]=i;
                arr[1]=j;
            }

        }
        return arr;
    }

}
