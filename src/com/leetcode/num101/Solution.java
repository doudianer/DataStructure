package com.leetcode.num101;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return Node(root.left,root.right);
    }
    public boolean Node(TreeNode node1,TreeNode node2)
    {
        if (node1==null&&node2==null)
        {
            return true;
        }
        if (node1==null||node2==null)
        {
            return false;
        }
        if (node1.val!=node2.val)
            return false;
        else {
            return Node(node1.left,node2.right)&&Node(node1.right,node2.left);
        }
    }
}
