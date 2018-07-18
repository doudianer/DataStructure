package com.company2.num2.num3;

import com.company2.num2.num2.Insertion_Sort;
import com.company2.num2.num2.Selection_Sort;

import java.util.Random;

public class Quick_Sort {


    public static int partition2(int[] arr, int l, int r)

    {
        Selection_Sort.swap( arr, l , (int)(Math.random()*(r-l+1))+l );
        int v=arr[l];
        int i=l+1,j=r;
        while (true)
        {

            while (i<=r&&i<v){i++;}
            while (j>=l+1&&j>v){j++;}
            if(i>j)
            {
                 break;
            }
            Selection_Sort.swap(arr,i,j);
            j--;
            i++;
        }
        Selection_Sort.swap(arr,l,j);
        return j;
    }
    public static int partition(int []arr,int l,int r)
    {
        int k=arr[l];
        int j=l;
        for(int i=l+1;i<=r;i++)
        {
            if(arr[i]<k)
            {
                Selection_Sort.swap(arr,j+1,i);
                j++;
            }
        }
        Selection_Sort.swap(arr,j,l);
        return j;
    }
    public static void sort(int []arr,int l,int r)
    {

        if(l>=r)
        {
            return;
        }
        int p=partition2(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);

    }
    public static void sort(int []arr,int n)
    {

        sort(arr,0,n-1);
    }
}
