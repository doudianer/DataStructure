package com.leetcode.num15;

import java.util.*;

public class Solution {

    public static List<List<Integer>> threeSum(int []nums)
    {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(nums==null||nums.length<3)//当整数数组为空，或者整数数组长度不到3时，输出为list
        {
            return list;
        }
        Arrays.sort(nums);  //对整数数组进行排序，从小到大排序

        for(int i=0;i<nums.length-2;i++) //对整数数组下标从0开始，一直到length-2,
        {
            if(i!=0&&nums[i]==nums[i-1])  //当扫描当前的数字和之前数字相同的时候，则移动到下一位去比较。
            {
                continue;
            }
            int left=i+1;               //从数组当前位置i的下一位开始标记为left ，然后向右移动
            int right=nums.length-1;   //从数组最后一位开始标记标记为right，然后向左移动
            while (left<right)         //判断条件。就是left不能大于right
            {
                int temp=nums[i]+nums[left]+nums[right];
                if(temp==0)
                {
                    List<Integer> listtemp=new ArrayList<Integer>();//这里建立了一个临时的类型为List的listtemp
                    listtemp.add(nums[i]);
                    listtemp.add(nums[left]);
                    listtemp.add(nums[right]);
                    left++;
                    right--;
                    list.add(listtemp);  //把符合条件的三个元素放入list中
                    while(left<right&&nums[left]==nums[left-1])
                    {
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right+1]) {
                        right--;
                    }

                }
                else if(temp<0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }

        return list;

    }
    public  static void main(String[]args)
    {
        Solution solution=new Solution();
        int []a={-1, 0, 1, 2, -1, -4};
        solution.threeSum(a);

    }
}