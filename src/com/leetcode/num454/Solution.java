package com.leetcode.num454;

import java.util.HashMap;
import java.util.Map;


/*
* On2
* On2
* */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map map =new HashMap();
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<B.length;j++)
            {
                if(!map.containsKey(A[i]+B[j]))
                {
                    map.put((A[i]+B[j]),1);
                }else {
                    map.put((A[i]+B[j]),(int)map.get(A[i]+B[j])+1);
                }
            }
        }
        int sum=0;
        for(int i=0;i<C.length;i++)
        {
            for(int j=0;j<D.length;j++)
            {
                int k=0-D[j]-C[i];
                if(map.containsKey(k))
                {
                    sum+=(int)map.get(k);
                }
            }
        }
        return sum;
    }
}
