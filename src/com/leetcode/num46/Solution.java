package com.leetcode.num46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    ArrayList<List<Integer>> res;
    boolean []used;
    public void gener(int[] nums,int index,LinkedList<Integer>  p)
    {
        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone() );
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
            if(!used[i]){
                used[i] = true;
                p.addLast(nums[i]);
                gener(nums, index + 1, p );
                p.removeLast();
                used[i] = false;
            }

        return;
    }

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length==0)
        {
            return res;
        }
      used=new boolean[nums.length];
        res = new ArrayList<List<Integer>>();
        LinkedList<Integer> p=new LinkedList<>();
        gener(nums,0,p);
        return res;
    }

    public static void main(String[]args)
    {
        int[]num={1,2,3};
        Solution solution=new Solution();
        solution.permute(num);
    }

}

