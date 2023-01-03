class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>ans=new ArrayList<>();
        int []dp=new int [nums.length];
        for(int i=0;i<nums.length;i++)
       {
           dp[i]=1;
       }
        int []hash=new int [nums.length];
         
        int maxi=1;
        int lastind=0;
        for(int i=0;i<nums.length;i++)
        {
            hash[i]=i;
            for(int prev=0;prev<i;prev++)
            {
                if(nums[i]%nums[prev]==0 && dp[i]<1+dp[prev])
                {
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi)
            {
                maxi=dp[i];
                lastind=i;
            }
        }
        ans.add(nums[lastind]);
        while(hash[lastind]!=lastind)
        {
            lastind=hash[lastind];
            ans.add(nums[lastind]);
        }
        return ans;
    }
}