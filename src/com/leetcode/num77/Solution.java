package com.leetcode.num77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    ArrayList<List<Integer>> res;

    public void gener(int n, int k, int start, LinkedList<Integer> p)
    {
        if (p.size()==k)
        {
            res.add((List<Integer>)p.clone());
            return;
        }
        for(int i=start;i<=n-(k-p.size())+1;i++)
        {
            p.add(i);
            gener(n,k,i+1,p);
            p.removeLast();

        }
        return;
    }
    public List<List<Integer>> combine(int n, int k) {

        if(n<=0||k<=0||k>n)
        {
            return res;
        }
        res=new ArrayList<List<Integer>>();
        LinkedList<Integer> p = new LinkedList<Integer>();
        gener(n,k,1,p);
        return res;
    }

    public static void main(String[]args)
    {
        Solution solution=new Solution();
        solution.combine(4,2);
    }
}


