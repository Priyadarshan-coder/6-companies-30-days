class Solution {
    private long helper(int s,int e,int k,long [][]dp)
    {
        if(k==0 && s==e)
        return 1;
        if(k==0 && s!=e)
        return 0;
        if(dp[s+2001][k]!=-1)return dp[s+2001][k];
        long count=((helper(s+1,e,k-1,dp))%1000000007+(helper(s-1,e,k-1,dp))%1000000007)%1000000007;
        return dp[s+2001][k]=(count)%1000000007;
    }
    public int numberOfWays(int s, int e, int k) {
        long [][]dp=new long [4001][1001];
        for(long i[]:dp)
            Arrays.fill(i,-1);
        return (int)helper( s,e,k,dp)%1000000007;
    }
}