package com.leetcode.num202;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public boolean isHappy(int n) {

        int k=n;
       Set set=new TreeSet();
        while (true) {
            String s = k+"";
            int sum=0;
            for (int i =0;i<s.length();i++)
            {
                sum=(int) Math.pow((int)s.charAt(i)-(int)'0',2)+sum;
            }
            k=sum;
            if(sum==1)
            {
                return true;
            }
            if(!set.contains(sum))
            {
                set.add(sum);
            }else
            {
                return false;
            }

        }
        }
        public static void main(String[]args)
        {
            Solution solution=new Solution();
            System.out.println(solution.isHappy(19));
        }

}
