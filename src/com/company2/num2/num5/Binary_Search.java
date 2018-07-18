package com.company2.num2.num5;


/*
* 二分查找法的实现
* */
public class Binary_Search {
    public static int BS(int []arr,int n,int targe)
    {
        int l=0,r=n-1;
        while (r>=l)
        {
            int mid=l+(r-l)/2;
            if(targe==arr[mid])
            {
                return mid;
            }
            if(targe>mid)
                l=mid+1;
            else if (targe<mid)
            {
                r=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[]args)
    {
        int []arr={2,3,4,7,9};
      System.out.println(BS(arr,5,7));
    }
}
