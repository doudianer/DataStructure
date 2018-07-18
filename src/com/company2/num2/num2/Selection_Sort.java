package com.company2.num2.num2;

public class Selection_Sort {

    public static void swap(int arr[],int i,int j)
    {
        int k;
        k=arr[i];
        arr[i]=arr[j];
        arr[j]=k;
    }
    public static void sort(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[i])
                {
                    swap(arr,i,j);
                }
            }
        }
    }
    public static void main(String[]args)
    {
        int [] arr={5,1,3,2,9,1,6};
        sort(arr,7);
        for(int a:arr)
        {
            System.out.println(a);
        }
    }

}
