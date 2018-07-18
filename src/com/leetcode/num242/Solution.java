package com.leetcode.num242;


import java.util.HashMap;
import java.util.Map;

/*
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
* */
public class Solution {

    public boolean isAnagram(String s, String t) {
        Map map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);

            } else {
                map.put(s.charAt(i), (int) map.get(s.charAt(i)) + 1);
            }
        }

        for (int j=0;j<t.length();j++)
        {
            if (map.containsKey(t.charAt(j))){

                if((int)map.get(t.charAt(j))==1)
                {
                    map.remove(t.charAt(j));
                }
                else if((int)map.get(t.charAt(j))>1)
                {
                    map.put(t.charAt(j),(int)map.get(t.charAt(j))-1);
                }
            }
            else {
                return false;
            }
        }
        if(map.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[]args)

    {
        Solution solution=new Solution();
        System.out.println(solution.isAnagram("ab","a"));

    }
}
