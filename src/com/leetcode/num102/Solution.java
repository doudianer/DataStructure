package com.leetcode.num102;

import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList();
        List<List<Integer>> list=new ArrayList<>();
        if (root==null)
        {
            return list;
        }else {
            List<Integer> tem=new ArrayList();
            tem.add(root.val);
            queue.add(root);
            list.add(tem);
        }
        while (!queue.isEmpty())
        {
            int i=queue.size();
            List<Integer> temp=new ArrayList<>();
            while (i>0)
            {
               TreeNode node= queue.poll();
               if(node.left!=null)
               {
                   temp.add(node.left.val);
                   queue.offer(node.left);
               }
               if (node.right!=null)
               {
                   temp.add(node.right.val);
                   queue.offer(node.right);
               }
               i--;

            }
            if(!temp.isEmpty())
                list.add(temp);
        }
        return list;

    }
}
