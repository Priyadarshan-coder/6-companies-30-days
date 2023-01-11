class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {        
        int[] dp = new int[1001];
        int ans =  helper(1,n,delay,forget,dp);
        return ans;
        
    }
    int mod = (int)1e9+7;
    public int helper(int day,int n,int delay,int forget,int[]dp){
        if(dp[day]!=0){
            return dp[day];
        }
        int ans = 0;
        int i = delay;
        for( ; i<forget && day+i<=n ; i++){
            ans = (ans + helper(day+i,n,delay,forget,dp))%mod;
        }
        dp[day]=ans+1;
        if(day+i<=n){
            dp[day]-=1;
        }
        return dp[day];
    }
}
