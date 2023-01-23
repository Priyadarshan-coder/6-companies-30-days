class Solution {
    boolean dfs(int [][]grid,int row,int col)
    {
        if(row>=grid.length || row<0 || col<0 || col>=grid[0].length)
        {
            return false;
        }
        if(grid[row][col]==1 || grid[row][col]==-1)
        {
            return  true;
        }
        else if(row==grid.length-1 || row==0 || col==grid[0].length || col==0)
        {
            return false;
        }
        grid[row][col]=-1;
        boolean left=dfs(grid,row,col-1);
        boolean right=dfs(grid,row,col+1);
        boolean up=dfs(grid,row-1,col);
        boolean down=dfs(grid,row+1,col);
        return left && right && up && down;
    }
    public int closedIsland(int[][] grid) {
        int ans=0;
        for(int i=1;i<grid.length-1;i++)
        {
            for(int j=1;j<grid[0].length-1;j++)
            {
                if(grid[i][j]==0){
                if(dfs(grid,i,j))
                {
                    ans++;
                }
                }
            }
        }
        return ans;
    }
}