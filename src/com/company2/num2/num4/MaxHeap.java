package com.company2.num2.num4;

import com.company2.num2.num2.Selection_Sort;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    int []arr;
    int count;
    public MaxHeap(int n)
    {
        arr=new int[n+1];
        count=0;
    }
    /*
    * Heapify
    * */
    public MaxHeap(int []arr,int n)
    {
        int []data=new int[n+1];
        for(int i=0;i<n;i++)
        {
            data[i+1]=arr[i];
        }
        int count=n;
        for(int i=count/2;i>=0;i--)
        {
            shiftdown(i);

        }
    }

    public int size()
    {
        return count;
    }
    public boolean isEmpty()
    {
        return count==0;
    }
    public void swap(int []arr,int i,int j)
    {
        int k=arr[i];
        arr[i]=arr[j];
        arr[j]=k;
    }


    private void shiftup(int i)
    {
        while (i>1&&arr[i]>arr[i/2])
        {
            Selection_Sort.swap(arr,i,i/2);
            i=i/2;
        }
    }
    /*
    * 添加元素
    * */
    public void  insert(int k)
    {
        if(count+1>arr.length)
        {
            System.out.println("大于数组容量");
            return;
        }
        arr[count+1]=k;
        count++;
        shiftup(count);
    }

    /*
    * 删除元素
    * */
    public int deletemax()
    {
        if(count>0&&count+1>arr.length)
        {
            System.out.println("大于数组容量");

        }
        int k=arr[1];
        swap(arr,1,count);
        count--;
        shiftdown(1);
        return k;

    }
    public void shiftdown(int i)
    {
        while (2*i<count)
        {
            int k=max(arr,2*i,2*i+1);
            if (arr[i]>=arr[k])
            {
                break;
            }
            if(arr[i]<arr[k])
            {
                swap(arr,k,i);
            }
            i=k;

        }
    }
    public int max(int []arr,int i,int j)
    {
        if(arr[i]>arr[j])
        {
            return i;
        }
        else {
         return j;
        }
    }
    public static void main(String[]args)
    {
        MaxHeap maxHeap=new MaxHeap(20);
        int []arr={1,6,2,3,7,5,8};
        for(int a:arr)
        {
            maxHeap.insert(a);
        }
        List<Integer> list=new ArrayList();
        for (int i=0;i<7;i++)
        {
            list.add(maxHeap.deletemax());
        }
        for(int l:list)
        {
            System.out.println(l);
        }

    }



}
