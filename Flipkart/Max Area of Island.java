class Solution {
    private static void dfs(int row,int col,int []area,int [][]vis,int[][]grid,int []drow,int []dcol)
    {
        area[0]++;
        vis[row][col]=1;
        for(int i=0;i<4;i++)
        {
            int newr=row+drow[i];
            int newc=col+dcol[i];
            if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && grid[newr][newc]==1 && vis[newr][newc]==0)
            {
                dfs(newr,newc,area,vis,grid,drow,dcol);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int []drow={-1,0,+1,0};
        int []dcol={0,+1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m]; 
        int ans=0;
        int area[]=new int [1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    dfs(i,j,area,vis,grid,drow,dcol);
                    ans=Math.max(ans,area[0]);
                }
                area[0]=0;
            }
        
        }
        return ans;
    }
}