package com.company2.num2.num3;

import com.company2.num2.num2.Insertion_Sort;
/*
递归版本
* 优化点
* 1.在元素数据量较小的时候，选择插入排序
* 2.当mid>mid+1时，再进行marge操作
*
* */
public class mergeSort {
    public static void marge(int []arr,int l,int mid,int r)
    {
        int []aux=new int[r-l+1];
        for(int i=l;i<=r;i++)
        {
            aux[i-l]=arr[i];
        }
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if (i>mid)
            {
                arr[k]=aux[j-l];
                j++;
            }else if (j>r)
            {
                arr[k]=aux[i-l];
                i++;
            }
            else if(aux[i-l]<aux[j-l])
            {
                arr[k]=aux[i-l];
                i++;
            }else {
            arr[k]=aux[j-l];
            j++;
            }
    }
    }
    private static void sort(int []arr,int l,int r)
    {
        if(r-l<15)
        {
            Insertion_Sort.sort_add2(arr,l,r);
        }
        if(l>=r)
        {
            return;
        }
        int mid=(l+r)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        if(arr[mid]>arr[mid+1]) {
            marge(arr, l, mid, r);
        }
    }
    public static void sort(int []arr,int n)
    {

        sort(arr,0,n-1);
    }
}
