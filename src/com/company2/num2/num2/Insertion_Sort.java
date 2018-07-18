package com.company2.num2.num2;

public class Insertion_Sort {
    public static void sort(int[] arr,int n)
    {
        for(int i=1;i<n;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(arr[j]>arr[j-1])
                {
                    Selection_Sort.swap(arr,j-1,j);
                }else {
                    break;
                }
            }
        }
    }
    public static void sort_add(int[] arr,int n)
    {
        for(int i=1;i<n;i++)
        {
            int k=arr[i];
            int j;
            for( j=i;j>0;j--)
            {
                if(k<arr[j-1])
                {
                    arr[j]=arr[j-1];
                }else {
                    break;
                }
            }
            arr[j]=k;
        }
    }
    public static void sort_add2(int []arr,int l,int r)
    {
        for(int i=l+1;i<=r;i++)
        {
            int e=arr[i];
            int j;
            for(j=i;j>l;j--)
            {
                if(arr[j-1]>e)
                {
                    arr[j-1]=arr[j];
                }
            }
            arr[j]=e;
        }
    }
}
