package com.company.BSt;

import java.util.LinkedList;
import java.util.Queue;
/*
* 二分搜索树
* 2018.5.3
*
* */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;
        public Node(E e)
        {
            this.e=e;
            left=null;
            right=null;
        }

    }
    private Node root=null;
    private int size=0;
    public BST()
    {
        root=null;

        size=0;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    //向二分搜索树中添加新元素
    public void add(E e)
    {
           root= add(root,e);
    }

    //向以node为根的二分搜索树中插入元素e，递归算法
    //返回插入新节点的根
    private Node add(Node node,E e)
    {
        /*if(e.equals(node.e))
        {
            return;
        }
        else if(e.compareTo(node.e)<0&&node.left==null)
        {
            node.left=new Node(e);
            size++;
            return;
        }
        else if(e.compareTo(node.e)>0&&node.right==null)
        {
            node.right=new Node(e);
            size++;
            return;
        }*/
        if(node==null)
        {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0)
        {
            node.left=add(node.left,e);
        }
        else if(e.compareTo(node.e)>0)
        {
            node.right=add(node.right,e);
        }
        return node;
    }

    public boolean contains(E e)
    {
        return contains(root,e);
    }
    private boolean contains(Node node,E e)
    {
        if (node==null)
        {
            return false;
        }
        if(e.compareTo(node.e)==0)
        {
            return true;
        }
         else if(e.compareTo(node.e)<0)
        {
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }

    //前序遍历
    public void preOrder()
    {
        preOeder_undigui(root);
    }
    private void preOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //前序遍历非递归实现
    private void preOeder_undigui(Node node)
    {
        if(node==null)
        {
            return;
        }
        java.util.Stack<Node> stack=new java.util.Stack<>();
        stack.push(node);
        while (!stack.isEmpty())
        {
            Node tmpnode=(Node) stack.pop();
            System.out.print(tmpnode.e);
            if(tmpnode.right!=null)
                stack.push(tmpnode.right);
            if(tmpnode.left!=null)
                stack.push(tmpnode.left);

        }
    }

    //中序遍历
    public void inOrder()
    {
        inOrder(root);
    }
    private void inOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder()
    {
        postOrder(root);
    }
    private void postOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    //二分搜索树的层序遍历，使用队列实现
    public void levelorder()
    {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node cur=queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null)
            {
                queue.add(cur.left);
            }
            if(cur.right!=null)
            {
                queue.add(cur.right);
            }
        }
    }
    //寻找最小元素
    public E minnum(){
        if(size==0)
        {
            throw new IllegalArgumentException("树为空");
        }
        Node cur=minnum(root);
        return cur.e;
    }
    public Node minnum(Node node)
    {
        if(node.left==null)
        {
            return node;
        }
        return minnum(node.left);
    }
    //删除最小元素
    public E minremove()
    {
       E ret=minnum();
        minremove(root);
        return ret;
    }
    //删除以node为根的二分搜索树的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node minremove(Node node)
    {
        if(node.left==null)
        {
             Node rightNode=node.right;
             node.right=null;
             size--;
             return rightNode;
        }
        node.left=minremove(node.left);
        return node;
    }

    // 寻找二分搜索树的最大元素
    public E maxnum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maxnum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maxnum(Node node){
        if( node.right == null )
            return node;

        return maxnum(node.right);
    }

    // 从二分搜索树中删除最大值所在节点
    public E maxremove(){
        E ret = maxnum();
        root = maxremove(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node maxremove(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = maxremove(node.right);
        return node;
    }
    //从二分搜索树中删除元素为e的节点
    public void remove(E e)
    {
        remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的节点
    //返回删除节点
    //以节点右子树的最小值替换删除节点
    public Node remove(Node node,E e)
    {
        if(node==null)
        {
            return null;
        }
        if(e.compareTo(node.e)<0)
        {
            node.left=remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e)>0)
        {
            node.right=remove(node.right,e);
            return node;
        }else //e.compareTo(node.e)==0
        {
            if(node.left==null)
            {
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }else if (node.right==null)
            {
                Node leftNode=node.right;
                node.left=null;
                size--;
                return leftNode;
            }
            Node sue=minnum(node.right);
            sue.right=minremove(node.right);
            sue.left=node.left;
            node.left=node.right=null;
            return sue;
        }

    }
    //删除以node为根的二分搜索树中值为e的节点
    //返回删除节点
    //以节点右子树的最大值替换删除节点
    public Node removegai(Node node,E e)
    {
        if(node==null)
        {
            return null;
        }
        if(e.compareTo(node.e)<0)
        {
            node.left=remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e)>0)
        {
            node.right=remove(node.right,e);
            return node;
        }else //e.compareTo(node.e)==0
        {
            if(node.left==null)
            {
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }else if (node.right==null)
            {
                Node leftNode=node.right;
                node.left=null;
                size--;
                return leftNode;
            }
            Node sue=maxnum(node.left);
            sue.left=maxremove(node.right);
            sue.right=node.right;
            node.left=node.right=null;
            return sue;
        }

    }
    @Override
    public String toString()
    {
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res)
    {
        if(node==null)
        {
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);

    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }


    public static void main(String[]args)
    {
        int [] arr={5,3,6,8,4,2};
        BST<Integer> bst=new BST();
        for(int i=0;i<arr.length;i++)
        {
            bst.add(arr[i]);

        }
        System.out.println(bst);
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bst.levelorder();
        System.out.println("----------------");
            bst.remove(3);
        System.out.println("----------------");
        bst.levelorder();
       // System.out.println(bst);
    }
}
