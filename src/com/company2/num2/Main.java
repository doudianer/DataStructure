package com.company2.num2;

import com.company2.num2.num2.Insertion_Sort;
import com.company2.num2.num3.QuickSort3Ways;
import com.company2.num2.num3.Quick_Sort;
import com.company2.num2.num3.Quick_Sort3;
import com.company2.num2.num3.mergeSort;

public class Main {

    public static void main(String[]args)
    {
        int [] arr={5,1,3,2,9,7,6};
        QuickSort3Ways.sort(arr);
        for(int a:arr)
        {
            System.out.println(a);
        }
    }
}
