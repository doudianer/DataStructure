package com.company.List;
/*
* 2018.5.7
* 链表实现
* */


import java.awt.font.TextHitInfo;

public class LinkList<E>{
    private class Node{
        public E e;
        Node next;
        public Node(E e,Node next)
        {
            this.e=e;
            this.next=next;
        }

        public Node(E e)
        {
            this(e,null);
        }
        public Node()
        {
            this(null,null);
        }
        @Override
        public String toString()
        {
            return e.toString();
        }
    }
    private Node head;
    private int size;
    public LinkList()
    {
         head=new Node(null,null);
         size=0;
    }
    /*
    * 获取链表元素个数
    * */
    public int getSize()
    {
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty()
    {
        return size==0;
    }
    //在链表头添加元素
    public void addfirst(E e)
    {
        // Node node=new Node(e);
        // node.next=head;
        //head=node;
       add(e,0);
    }
    //指定位置插入
    public void add(E e,int index)
    {
       /* Node node=new Node(e);
        int i=0;
        while (true)
        {
            head=head.next;
            if (i==index-1)
            {
                node.next=head.next;
                head.next=node;
                size++;
                break;
            }
        }*/
       if(index<0||index>size)
       {
           throw new IllegalArgumentException("Add failed");
       }
       Node prev=head;
       for (int i=0;i<index;i++)
       {
           prev=prev.next;
       }
           //Node node=new Node(e);
           //node.next=prev.next;
           //prev.next=node;
           prev.next=new Node(e,prev.next);
           size++;
       }

    //在链表的末尾添加新的元素e
    public void addLast(E e)
    {
        add(e,size);
    }
    /*
    * 获取索引位置元素
    * */
    public E get(int index)
    {
        if(index<0||index>size)
        {
            throw new IllegalArgumentException("get failed");
        }
        Node cur=head.next;
        for (int i=0;i<index;i++)
        {
            cur=cur.next;

        }
        return cur.e;
    }
    /*
    * 获取第一个索引位置
    *
    * */
    public E getFirst()
    {
        return get(0);
    }
    /*
    * 获得最后一个元素
    * */
    public E getLast()
    {
        return get(size-1);
    }
    /*
    * 修改链表的一个元素
    * */
    public void set(int index,E e)
    {
        if(index<0||index>size)
        {
            throw new IllegalArgumentException("get failed");
        }
        Node cur=head.next;
        for (int i=0;i<index;i++)
        {
            cur=cur.next;
        }
        cur.e=e;
    }
    //产科链表是否有元素e
    public boolean contain(E e)
    {
        Node cur=head.next;
        while (cur.next!=null)
        {
            if(cur.e.equals(e))
            {
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除元素
    public E remove(int index)
    {
        if(index<0||index>size)
        {
            throw new IllegalArgumentException("remove failed");
        }
        Node prev=head;
        for(int i=0;i<index;i++)
        {
            prev=prev.next;
        }
        Node retNode=prev.next;
        prev.next=retNode.next;
        size--;
        return retNode.e;
    }
    public E removeFirst()
    {
        return remove(0);
    }
    public E removeLast()
    {
        return remove(size-1);
    }
    //删除指定位置元素
    public void removeElement(E e)
    {
        Node prev=head;
        while (prev.next!=null)
        {
            if(prev.next.e.equals(e))
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
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;h
//        }
        for(Node cur = head.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
    public static void main(String[]args)
    {
       /* LinkList<Integer> list=new LinkList<>();
        for (int i=0;i<10;i++)
        {
            ;list.addfirst(i);
            System.out.println("大小为："+list.getSize());
        }
        System.out.println("-------------------------------------------------------");
        for(int i=0;i<5;i++)
        {
            list.remove(i);
            System.out.println("大小为："+list.getSize());
            System.out.println(list);

        }*/
    }

}
