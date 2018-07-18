package com.company.Map;

import com.company.MyArray.Array;

import java.util.ArrayList;

public class LinkedListMap<K,V> implements Map<K,V>{

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next)
        {
            this.key=key;
            this.value=value;
            this.next=next;
        }
        public Node()
        {
            this(null,null,null);

        }
        public Node(K key)
        {
            this(key,null,null);
        }
        @Override
        public String toString(){
            return key.toString()+":"+value.toString();
        }

    }

    private Node dummyHead;
    private int size;
    public LinkedListMap()
    {
        dummyHead=new Node();
        size=0;
    }

    private Node getNode(K key)
    {
        Node cur=dummyHead.next;
        while (cur!=null)
        {
            if(cur.key.equals(key)) {
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node=getNode(key);
        if(node==null)
        {
            dummyHead.next=new Node(key,value,dummyHead.next);
            size++;
        }
        else {
            node.value=value;
        }
    }

    @Override
    public V remove(K key) {

          Node prev=dummyHead;
          while (prev.next!=null)
          {
              if(prev.next.key.equals(key))
              {
                  break;
              }
              prev=prev.next;
          }
          if(prev.next!=null)
          {
              Node delnode=prev.next;
              prev.next=delnode.next;
              delnode.next=null;
              size--;
              return delnode.value;
          }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {

        Node node=getNode(key);
        if(node!=null)
        {
            return node.value;
        }
        return null;

    }

    @Override
    public void set(K key, V value) {
        Node node=getNode(key);
        if(node==null)
        {
            throw new IllegalArgumentException("不存在该key："+key);
        }
        node.value=value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[]args)
    {

         LinkedListMap<String,Integer> map=new LinkedListMap<>();
        String str="st";
        for(int i=0;i<100;i++)
        {
            String ste=str+i;
            map.add(ste,i);
        }
         System.out.println(map.get("st9"));
    }

}
