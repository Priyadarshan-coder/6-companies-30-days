class Solution {
    private  double helper(int []dr,int []dc,int r,int c,int n,int k,double[][][]dp)
    {
        if(r>=n || r<0 || c>=n || c<0)return 0;
        if(k==0)return 1;
        if(dp[r][c][k]!=0)return dp[r][c][k];
        double prob=0;
        for(int i=0;i<8;i++)
        {
                prob+=helper(dr,dc,r+dr[i],c+dc[i],n,k-1,dp)/8.0;
        }
        return dp[r][c][k]=prob;
    }
    public double knightProbability(int n, int k, int row, int column) {
        int []dr={-1,-2,-2,-1,+1,+2,+2,+1};
        int []dc={-2,-1,+1,+2,+2,+1,-1,-2};
        double [][][]dp=new double [n+1][n+1][k+1];
        return helper(dr,dc,row,column,n,k,dp);
    }
}