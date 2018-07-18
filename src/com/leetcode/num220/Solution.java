package com.leetcode.num220;

import java.util.TreeSet;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length==0||k<=0) return false;

        TreeSet<Long> treeSet = new TreeSet<Long>();
        for(int i=0;i<nums.length;i++){

            final Long floor = treeSet.floor((long)nums[i]+t);
            final Long ceil = treeSet.ceiling((long)nums[i]-t);

            if((floor!=null&&floor>=(long)nums[i])||
                    (ceil!=null&&ceil<=(long)nums[i])){
                return true;
            }

            treeSet.add((long)nums[i]);
            if(i>=k){        //因为元素的坐标差不能超过k，所以在treeSet中最多只能有k个元素
                treeSet.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
