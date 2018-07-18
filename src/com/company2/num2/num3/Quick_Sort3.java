package com.company2.num2.num3;

import com.company2.num2.num2.Selection_Sort;

public class Quick_Sort3 {


    public static void sort(int []arr,int l,int r)
    {
          //partition
        int v=arr[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while (i<gt)
        {
            if(arr[i]<v)
            {
                swap(arr,lt+1,i);
                i++;
                lt++;
            }
            else if (arr[i]==v)
            {
                i++;
            }
            else {
                swap(arr,gt-1,i);
                gt--;
            }
        }
        swap(arr,l,lt);

        sort(arr,l,lt-1);
        sort(arr,gt,r);
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void sort(int []arr,int n)
    {
        sort(arr,0,n-1);
    }
    public static void main(String[]args)
    {
        int[]a={2,3,64,18,6};
        sort(a,5);
        for(int as:a)
        {
            System.out.println(as);
        }
    }
}
