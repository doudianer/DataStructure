package com.leetcode.num219;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set set=new TreeSet();

         for(int i=0;i<nums.length;i++)
         {
             if(set.contains(nums[i]))
             {
                 return true;
             }
             set.add(nums[i]);
             if(set.size()==k+1)
             {
                 set.remove(nums[i-k]);
             }
         }
        return false;
    }

}
