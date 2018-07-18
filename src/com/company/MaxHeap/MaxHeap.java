package com.company.MaxHeap;

import com.company.MyArray.Array;

/*
* 以数组为底层，实现最大堆
* */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity)
    {
        data =new Array<>(capacity);
    }
    public MaxHeap()
    {
        data=new Array<>();
    }
    //将数组转化为最大堆,O(n)
    public MaxHeap(E[] arr)
    {
        data=new Array<>(arr);
        for(int i=parent(arr.length-1);i==0;i--)
        {
            siftDown(i);
        }
    }
    public int size()
    {
        return data.getSize();
    }

    public boolean isEmpty()
    {
        return data.isEmpty();
    }
    /*
    * 返回父子节点的索引
    * */
    private int parent(int index)
    {
        if(index==0)
        {
            throw new IllegalArgumentException("index==0,为根节点");
        }
        return (index-1)/2;

    }
    //返回二叉树的数组表示中，一个索引的左孩子的索引
    private int leftchild(int index)
    {
        return index*2+1;
    }

    //返回二叉树的数组表示中，一个索引的右孩子的索引
    private int rightchild(int index)
    {
        return index*2+2;
    }

    //添加元素
    public void add(E e){
        data.addlast(e);
        siftUp(data.getSize()-1,e);
    }
    //元素上移
    private void siftUp(int k,E e)
    {
        while (k>0&& data.get(parent(k)).compareTo(data.get(k))<0)
        {
            data.swap(k,parent(k));
            k=parent(k);
        }

    }

    public E findMax()
    {
        if(data.getSize()==0)
        {
            throw new IllegalArgumentException("null");
        }
        return data.get(0);

    }
    public E extractMax()
    {
        E ret=findMax();
        data.swap(0,data.getSize()-1);
        data.removelast();
        siftDown(0);
        return ret;
    }
    private void siftDown(int k)
    {
        while (leftchild(k)<data.getSize())
        {
            int j=leftchild(k);
            //取出左右孩子最大值
            if(j+1<data.getSize()&&data.get(j).compareTo(data.get(rightchild(k)))<0)
            {
                j=rightchild(k);
            }
            if(data.get(k).compareTo(data.get(j))>=0)
            {
                break;
            }
            data.swap(k,j);
            k=j;

        }
    }
    //取出最大元素，并添加一个元素
    public E replace(E e)
    {
        E ret=findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
}
