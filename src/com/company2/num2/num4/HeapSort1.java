package com.company2.num2.num4;

public class HeapSort1 {

    public void sort(int []arr,int n)
    {
        MaxHeap maxHeap=new MaxHeap(20);
        for(int i=0;i<n;i++)
        {
            maxHeap.insert(arr[i]);
        }
        for(int i=n-1;i>=0;i--)
        {
            arr[i]=maxHeap.deletemax();
        }
    }

}
