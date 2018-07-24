package com.leetcode.num17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    String [] letter={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list=new ArrayList<>();



    public void Find(String digits,int index,String p)
    {
        System.out.println(index+" : "+p);
        if(index == digits.length())
        {
            list.add(p);
            System.out.println("get "+p+", return");
            return;
        }

        char c=digits.charAt(index);
        String letters=letter[c-'0'];
        for (int i=0;i<letters.length();i++)
        {
            Find(digits,index+1,p+letters.charAt(i));
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
        {
            return list;
        }

        Find(digits,0,"");
        return list;
    }

    public static void main(String[]args)
    {
        Solution solution=new Solution();
        solution.letterCombinations("23");

    }

}
