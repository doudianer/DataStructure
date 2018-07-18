package com.leetcode.num1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map map=new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            int k=target-nums[i];
            if(map.containsKey(k))
            {
                int []a=new int[2];
                a[0]=(int)map.get(k);
                a[1]=i;
                return a;
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
    public static void main(String[]args)
    {
        Solution solution=new Solution();
        int []a={2,7,11,15};
        solution.twoSum(a,9);
    }
}
