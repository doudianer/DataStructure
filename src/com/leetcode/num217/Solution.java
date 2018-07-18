package com.leetcode.num217;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set set = new TreeSet();
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
            {
                return true;
            }
            set.add(nums[i]);
        }
        return false;

    }
}
