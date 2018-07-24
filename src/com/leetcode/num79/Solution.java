package com.leetcode.num79;

import java.util.List;

public class Solution {
    int m,n;
    boolean [][]visit;
    int [][]arr={{-1,0},{0,1},{1,0},{0,-1}};

    public boolean inArea(int x,int y)
    {
        return x>=0&&x<m&&y>=0&&y<n;
    }

    public boolean searchword(char[][] board,String word,int index,int startx,int starty)
    {
        if (index==word.length()-1)
        {
            return board[startx][starty]==word.charAt(index);
        }
        if(board[startx][starty]==word.charAt(index)) {
            visit[startx][starty]=true;
            for (int i = 0; i < 4; i++)
            {
                int newx=startx+arr[i][0];
                int newy=starty+arr[i][1];
                if(inArea(newx,newy)&&!visit[newx][newy]&&searchword(board,word,index+1,newx,newy))
                {
                    return true;
                }
            }
            visit[startx][starty]=false;
        }
        return false;
        }




    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        visit=new boolean[m][n];
        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                if (searchword(board,word,0,i,j))
                {
                    return true;
                }

            }
        }
        return false;


    }
}
