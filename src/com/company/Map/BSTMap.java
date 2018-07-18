package com.company.Map;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K key,V value)
        {
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }


    }
    private Node root ;
    private int size ;
    public BSTMap(){
        root=null;
        size=0;
    }

    public Node getNode(Node node,K key)
    {
        if(node==null)
        {
            return null;
        }
        if(key.compareTo(node.key)==0)
        {
            return node;
        }else if(key.compareTo(key)<0){
            return getNode(node.left,key);
        }
        else {
            return getNode(node.right,key);
        }

    }

    @Override
    public void add(K key, V value) {
        root=add(root,key,value);
    }

    private Node add(Node node,K key,V value)
    {
        if(node==null)
        {
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0)
        {
            node.left=add(node.left,key,value);
        }
        else if(key.compareTo(node.key)>0)
        {
            node.right=add(node.right,key,value);
        }else {
            node.value=value;
        }
        return node;
    }
    //寻找最小元素
    public K minnum(){
        if(size==0)
        {
            throw new IllegalArgumentException("树为空");
        }
        Node cur=minnum(root);
        return cur.key;
    }
    public Node minnum(Node node)
    {
        if(node.left==null)
        {
            return node;
        }
        return minnum(node.left);
    }
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
    public K minremove()
    {
        K ret=minnum();
        minremove(root);
        return ret;
    }
    @Override
    public V remove(K key) {
        Node node=getNode(root,key);
        if(node!=null)
        {
            root=remove(root,key);
            return node.value;
        }
        return null;
    }
    public Node remove(Node node,K key)
    {
        if(node==null)
        {
            return null;
        }
        if(key.compareTo(node.key)<0)
        {
            node.left=remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key)>0)
        {
            node.right=remove(node.right,key);
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

    @Override
    public boolean contains(K key) {

        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
       Node node= getNode(root,key);

        return node==null?null:node.value;
    }



    @Override
    public void set(K key, V value) {
        Node node=getNode(root,key);
        if(node==null)
        {
            throw new IllegalArgumentException("key不存在");
        }else {
            node.value=value;
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
