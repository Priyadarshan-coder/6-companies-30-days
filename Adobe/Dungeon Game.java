class Solution {
    private static int helper(int i,int j,int [][]arr,int[][]dp)
    {
        if(i>=arr.length || j>=arr[0].length)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=0)return dp[i][j];
        int h=Math.min(helper(i+1,j,arr,dp),helper(i,j+1,arr,dp));
        if(h==Integer.MAX_VALUE)
        {
            h=1;
        }
        int ans=0;
        if(h-arr[i][j]>0)
        {
            ans=h-arr[i][j];
        }
        else{
            ans=1;
        }
        return dp[i][j]=ans;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int [][]dp=new int [dungeon.length+1][dungeon[0].length+1];
        return helper(0,0,dungeon,dp);
    }
}