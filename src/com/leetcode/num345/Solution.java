package com.leetcode.num345;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String reverseString(String s) {
        int i=0;
        char[] ss=s.toCharArray();
        List<Character> list=new ArrayList<Character>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');

        int j=ss.length-1;
        while (i<j)
        {
            while (i<j&&!list.contains(ss[i]+"")) {
                i++;
            }
            while (i<j&&!list.contains(ss[j]+""))
            {
                j--;
            }
             if(i<j)
             {
                char k = ss[i];
                ss[i] = ss[j];
                ss[j] = k;
                i++;
                j--;
            }
        }
        return new String(ss) ;
    }
    public static void main(String[]args)
    {
        com.leetcode.num345.Solution solution=new com.leetcode.num345.Solution();
        System.out.println(solution.reverseString("leetcode"));
    }

}
