package com.leetcode.num200;

public class Solution {

    int m,n;
    boolean [][]arr;
    int [][]a={{-1,0},{0,1},{1,0},{0,-1}};

    public boolean isArea(int x, int y)
    {
        return x>=0&&x<m&&y>=0&&y<n;
    }

    public void DFS(char[][] grid,int startx,int starty)
    {
        arr[startx][starty]=true;
        for (int i=0;i<4;i++)
        {
            int newx=a[i][0]+startx;
            int newy=a[i][1]+starty;
            if(isArea(newx,newy)&&grid[newx][newy]=='1'&&!arr[newx][newy])
            {
                DFS(grid,newx,newy);
            }
        }
        return;
    }

    public int numIslands(char[][] grid) {

        m=grid.length;
        if(m==0)
        {
            return 0;
        }
        n=grid[0].length;
        int res=0;
        arr=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(!arr[i][j]&&grid[i][j]=='1')
                {
                    res++;
                    DFS(grid,i,j);
                }
            }
        }
        return res;



    }
}
