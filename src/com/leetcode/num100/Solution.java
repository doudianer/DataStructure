package com.leetcode.num100;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
        {
            return true;
        }
        if(q!=null&&p!=null)
        {
            if (p.val!=q.val)
            {
                return false;
            }else {
                return isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);
            }
        }else {
            return false;
        }

    }
}
