package com.leetcode.num226;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode val=root.left;
        root.left=root.right;
        root.right=val;
        return root;
    }

    public void swap(TreeNode root)
    {

    }
}
