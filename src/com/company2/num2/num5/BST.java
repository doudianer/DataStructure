package com.company2.num2.num5;


import java.util.LinkedList;

public class BST <Key extends Comparable<Key>,Value>{
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }
        private Node root;
        private int count;
    public BST(){
        root=null;
        count=0;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty()
    {
        return count==0;
    }
/*------------------------------------------插入操作---------------------------------------------------*/
    /*
    * 插入数据
    * 递归实现
    * */
    public Node insert(Node node,Key key,Value value)
    {
        if(node==null)
        {
            count++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)==0)
        {
            node.value=value;
        }
        else if(key.compareTo(node.key)<0)
        {
            node.left=insert(node.left,key,value);
        }
        else if(key.compareTo(node.key)>0)
        {
            node.right=insert(node.right,key,value);
        }
        return node;
    }
    public void insert(Key key,Value value)
    {
        root=insert(root,key,value);
    }
    /*
    * 插入操作非递归实现
    * */
    public void insert2(Node node,Key key,Value value)
    {
        while (true)
        {
            if(node==null)
            {
                count++;
                node=new Node(key,value);
                break;
            }
            if(key.compareTo(node.key)==0)
            {
                node.value=value;
                break;
            }
            else if(key.compareTo(node.key)<0)
            {
                node=node.left;
            }
            else if(key.compareTo(node.key)>0)
            {
                node=node.right;
            }
        }
    }
    /*-------------------------------------查找操作---------------------------------------------------------------------------------------*/

    public boolean cartain(Key key)
    {
        return cartain(root,key);
    }
    public boolean cartain(Node node,Key key)
    {
        if(node==null)
        {
            return false;
        }
        if(key.compareTo(node.key)==0)
        {
            return true;
        }else if (key.compareTo(node.key)>0)
        {
            return cartain(node.left,key);
        }else
        {
            return cartain(node.right,key);
        }
    }

    public Value Search(Key key)
    {
        return Search(root,key);
    }
    public Value Search(Node node,Key key)
    {
        if (node==null)
        {
            return null;
        }
        if(key.compareTo(node.key)==0)
        {
            return node.value;
        }
        else if(key.compareTo(node.key)>0)
        {
            return Search(node.right,key);
        }else {
            return Search(node.left,key);
        }
    }
    /*---------------------------------遍历--------------------------------------------------------------------------------------*/
    /*
    * 前序遍历
    * */
    public void preorder()
    {
        preorder(root);
    }
    public void preorder(Node node)
    {
        if(node!=null)
        {
            System.out.println("key:"+node.key);
            preorder(node.left);
            preorder(node.right);
        }
    }
    /*
    * 中序遍历
    * */
    public void inorder()
    {
        inorder(root);
    }
    public void inorder(Node node)
    {
        if(node!=null)
        {

            inorder(node.left);
            System.out.println("key:"+node.key);
            inorder(node.right);
        }
    }
    /*
    * 后序遍历
    * */
    public void postorder()
    {
        postorder(root);
    }
    public void postorder(Node node)
    {
        if(node!=null)
        {

            postorder(node.left);
            System.out.println("key:"+node.key);
            postorder(node.right);
        }
    }
    /*
    *层序遍历
    * */

    public void levelorder()
    {
        // 我们使用LinkedList来作为我们的队列
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while( !q.isEmpty() ){

            Node node = q.remove();

            System.out.println(node.key);

            if( node.left != null )
                q.add( node.left );
            if( node.right != null )
                q.add( node.right );
        }
    }
    /*--------------------------------删除------------------------------------------------------------------------*/
    // 返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node node){
        if( node.left == null )
            return node;

        return minimum(node.left);
    }

    // 返回以node为根的二分搜索树的最大键值所在的节点
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }
    /*
   * 删除最大节点
   * */
    public void removeMax()
    {
        if(root!=null)
        {
            root=removeMax(root);
        }
    }
    public Node removeMax(Node node)
    {
        if(node.right==null)
        {
            Node rnode=node.left;
            count--;
            return rnode;
        }
        node.right=removeMax(node.right);
        return node;
    }
    /*
    * 删除最小节点
    * */
    public void removeMin()
    {
        if(root!=null)
        {
            root=removeMin(root);
        }
    }
    public Node removeMin(Node node)
    {
        if(node.left==null)
        {
           Node lnode=node.right;
            count--;
            return lnode;
        }
        node.left=removeMin(node.left);
        return node;
    }
    /*
    * 删除节点
    * */
    public void remove(Key key)
    {
        root=remove(root,key);
    }
    public Node remove(Node node,Key key)
    {
        if(node==null)
        {
            return node;
        }
        if(key.compareTo(node.key)>0)
        {
            node.right=remove(node.right,key);
        }else if(key.compareTo(node.key)<0)
        {
            node.left=remove(node.left,key);
        }else
        {
            if(node.left==null)
            {
                Node rnode= node.right;
                count--;
                return rnode;
            }else if(node.right==null)
            {
                Node lnode=node.left;
                count--;
                return lnode;
            }else
            {
                Node s=minimum(node.right);
                count++;
                s.right=removeMin(node.right);
                s.left=node.left;
                count--;
                return s;
            }
        }
        return node;
    }


    public static void main(String[]args)
    {
        BST bst=new BST();
        int [] arr={28,16,30,13,22,29,42};
        for(int a:arr)
        {
            bst.insert(a,1);
        }
        bst.remove(42);
        bst.levelorder();
 }



}
