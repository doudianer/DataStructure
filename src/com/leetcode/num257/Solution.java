package com.leetcode.num257;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List list=new ArrayList();
        if(root==null)
        {
            return list;
        }
        if(root.left==null&&root.right==null)
        {
            list.add(root.val+"");
            return list;
        }

        List <String>listnode=binaryTreePaths(root.left);
        for(String i:listnode)
        {
            list.add(root.val+"->"+i);
        }
        List <String> listnode2=binaryTreePaths(root.right);
        for (String i:listnode2)
        {
            list.add(root.val+"->"+i);
        }
        return list;

    }
}
