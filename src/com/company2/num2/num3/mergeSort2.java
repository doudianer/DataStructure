package com.company2.num2.num3;
/*
* 自底向上，迭代版本
*
* */
public class mergeSort2 {

    public void  sortBU(int []arr,int n)
    {
        for (int sz=1;sz<=n;sz+=sz)
        {
            for (int i=0;i+sz<n;i=i+2*sz)
            {
                mergeSort.marge(arr,i,i+sz-1,Math.min(i+2*sz-1,n-1));
            }
        }
    }

}
