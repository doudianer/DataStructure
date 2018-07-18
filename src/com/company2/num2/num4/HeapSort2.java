package com.company2.num2.num4;

import com.company2.num2.num2.Selection_Sort;

/*
* 最好的堆排序：原地堆排序
* */
public class HeapSort2 {

    public void shiftdown(int []arr,int n,int i)
    {
        while (2*i+1<n)
        {
            int j=2*i+1;
            if(j+1<n&&arr[j]>arr[j+1])
            {
                j++;
            }
            if(arr[i]<arr[j])
            {
                Selection_Sort.swap(arr,i,j);
            }else {
                break;
            }
            i=j;//自增

        }
    }
    public void sort(int[] arr, int n)
    {
        //heapfily
        for(int i=(n-1)/2;i>=0;i--)
        {
            shiftdown(arr,n,i);
        }
        for (int i=n-1;i>0;i--)
        {
            Selection_Sort.swap(arr,i,0);
            shiftdown(arr,i,0);
        }
    }
}
