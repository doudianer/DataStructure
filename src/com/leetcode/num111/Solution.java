package com.leetcode.num111;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int minDepth(TreeNode root) {


        if(root==null)
        {
            return 0;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(root.right==null||root.left==null)
        {
            return Math.max(left,right)+1;
        }else{
            return Math.min(left,right)+1;
        }
    }
    }

