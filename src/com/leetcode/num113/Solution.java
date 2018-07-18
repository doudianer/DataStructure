package com.leetcode.num113;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List list=new ArrayList();
        if(root==null)
        {
            return list;
        }
        if(root.right==null&&root.left==null)
        {
            list.add(sum);
            return list;
        }
        return list;
    }
}
