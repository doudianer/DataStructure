package com.company.MyArray;

/*
* 2018.5.5
* 对数组的二次开发，实现动态数组
* */

public class Array<E> {

    private E [] data;//创建数组
    private int size;//数组大小
    /*
    * 构造函数，传入初始数组大小
    * */
    public Array(int capacity)
    {
        data=(E[])new Object[capacity];//泛型创建数组
        size=0;
    }
    public Array()
    {
        this(10);

    }
    //传入数组创建
    public  Array(E[] arr)
    {
        data=(E[])new Object[arr.length];
        for (int i=0;i<arr.length;i++)
        {
            data[i]=arr[i];
        }
        size=arr.length;

    }
    public int getSize()
    {
        return size;
    }
    public int getcapacity(){
        return data.length;
    }
    public boolean isEmpty()
    {
        return size==0;
    }

    public void addlast(E num)//尾部添加
    {
        /*if(size==data.length){
            throw new IllegalArgumentException("Addlast failed");
        }
        data[size]=num;
        size++;
        */
       add(size,num);//复用add()函数
    }
    /*
    * 在index位置插入一个元素
    * */
    public void add(int index,E num)
    {
        if(size==data.length){
             resize(2*data.length);
    }
        if(index<0||index>size)
        {
            throw new IllegalArgumentException("Addlast failed");
        }
        for(int i=size-1;i>=index;i--)
        {
             data[i+1]=data[i];
        }
        data[index]=num;
        size++;
    }
    //交换元素
    public void swap(int i,int j)
    {
        if(i<0&&j<0&&i>=data.length&&j>=data.length)
        {
            throw new IllegalArgumentException("数组越界");
        }
        E e;
        e=data[i];
        data[i]=data[j];
        data[j]=e;
    }
    public E get(int index)
    {
        if(index<0||index>=size)
        {
            throw new IllegalArgumentException("Get fail");
        }
        return data[index];
    }
    public E getlast()
    {
        return get(size-1);
    }
    public E getfirst()
    {
        return get(0);
    }
    /*
    * 修改index索引位置元素
    * */

    public void set(int index,E num)
    {
        if(index<0||index>=size)
        {
            throw new IllegalArgumentException("Set fail");
        }
        data[index]=num;
    }

    /*
    * 查找数据中是否有元素num
    * */
    public boolean contains(int num)
    {
        for(int i=0;i<size;i++)
        {
            if(data[i].equals(num))
            {
                return true;
            }
        }
        return false;
    }
    /*
    * 找到该元素，返回索引
    * */
    public int find(E num)
    {
        for(int i=0;i<size;i++)
        {
            if(data[i].equals(num))
            {
                 return i;
            }
        }
        return -1;
    }
    /*
    * 删除索引位置
    * */
    public E remove(int index)
    {
        if(index<0||index>=size)
        {
            throw new IllegalArgumentException("delete out");
        }
        E a=data[index];
        for(int i=index;i<size;i++)
        {
            data[i]=data[i+1];
        }
        size--;
        data[size]=null;//快速回收
        if(size==data.length/4&&data.length/2!=0)//均摊复杂度问题，详情2-9
        {
            resize(data.length/2);
        }
        return a;
    }
    /*
     * 删除第一个元素
     * */
    public E removefrist()
    {
        return remove(0);
    }
    /*
    * 删除最后一个元素
    * */
    public E removelast()
    {
        return remove(size-1);
    }

    /*
    * 判断是否有，如果有就删除
    * */
    public boolean removeElement(E num)
    {
        int index=find(num);
        if(index!=-1)
        {
            remove(index);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++)
        {
            res.append(data[i]);
            if(i!=size-1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
    /*
    * 数组扩容
    * */
    private void resize(int newCapacity)
    {
        E[] newdata=(E[])new Object[newCapacity];
        for(int i=0;i<size;i++)
        {
            newdata[i]=data[i];
        }
        data=newdata;

    }

    public static void main(String[]args)
    {

    }
}
