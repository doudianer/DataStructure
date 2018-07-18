package com.leetcode.num144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Solution {

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();

            if(root != null) {
                list.add(root.val);
                list.addAll(preorderTraversal(root.left));
                list.addAll(preorderTraversal(root.right));
            }
            return list;
        }
    public List<Integer> preorderTraversals(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        if (root==null)
        {
            return list;
        }
        Stack <TreeNode>stack=new Stack();
        stack.push(root);
        while (!stack.empty())
        {
            TreeNode node= stack.pop();
            list.add(node.val);
            if(node.right!=null)
            {
                stack.push(node.right);
            }
            if(node.left!=null)
            {
                stack.push(node.left);
            }
        }
        return list;
    }
    }
