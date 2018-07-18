package com.leetcode.num11;

public class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length;
        int max=0;
        while (r>l)
        {
            max=Math.max(Math.min(height[l],height[r])*(r-l),max);
            if(height[l]>height[r])
            {
                r--;
            }else {
                l++;
            }
        }
        return max;
    }

}
